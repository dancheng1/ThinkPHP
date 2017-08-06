package com.ky.workover.common.utils;


import com.alibaba.fastjson.JSONObject;

import javax.net.ssl.*;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class HttpsUtil {
    private static class TrustAnyTrustManager implements X509TrustManager {

        //解决证书验证报错的问题，忽略证书验证
        static {
            //for localhost testing only
            HttpsURLConnection.setDefaultHostnameVerifier(
                    new HostnameVerifier(){

                        public boolean verify(String hostname,
                                              SSLSession sslSession) {
                            if (hostname.equals("localhost")) {
                                return true;
                            }else  if (hostname.equals("58.251.166.219")) {
                                return true;
                            }
                            return false;
                        }
                    });
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static JSONObject post(String requestUrl, String requestMethod, String outputStr,String contentType) {
        StringBuffer buffer = new StringBuffer();
        JSONObject jsonObject;
        try {
            KeyStore clientStore = KeyStore.getInstance("PKCS12");
            clientStore.load(new FileInputStream("D:\\keys\\huawei\\ca.p12"), "Huawei@123".toCharArray());
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(clientStore, "Huawei@123".toCharArray());
            KeyManager[] kms = kmf.getKeyManagers();
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream("D:/openssl/client.jks"), "fawfleet".toCharArray());
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);
            TrustManager[] tms = tmf.getTrustManagers();
            SSLContext sslContext = null;
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kms,new TrustManager[]{new TrustAnyTrustManager()}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
            URL url = new URL(requestUrl);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            con.setRequestMethod(requestMethod);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", contentType);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(outputStr);
            con.connect();

            // 将返回的输入流转换成字符串
            InputStream inputStream = con.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            con.disconnect();
            jsonObject = JSONObject.parseObject(buffer.toString());
            System.out.println(buffer.toString());
        } catch (ConnectException ce) {
            return null;
        } catch (Exception e) {
            return null;
        }
        return jsonObject;
    }

    public static void main(String[] args) {
        //new HttpsUtil().post("https://58.251.166.219:8743/iocm/app/sec/v1.1.0/login", "POST", "appId=xdjwp8X_UhxMXbiEJFO7B1TRxGwa&secret=r1jagIKONnCsWDqYOKZNq2Z6fvoa","application/x-www-form-urlencoded");
        String str="{\"header\":{\"mode\":\"ACK\",\"from\": \"\",\"method\": \"J808.getCarAttr\"},\"body\": {}}";
        new HttpsUtil().post("https://58.251.166.219:8743/iocm/app/sec/v1.1.0/login", "POST", str,"application/json");
        //JSONObject json=JSONObject.parseObject(str);
    }
}

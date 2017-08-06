package com.ky.workover.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class HttpXmlClient {

	private static String charset = "utf-8";

	public static String post(String url, String body) {

		HttpPost httppost = makePost(url);

		if (body != null) {
			httppost.setEntity(new StringEntity(body, charset));
		}

		return execute(httppost);
	}

	private static HttpPost makePost(String url) {

		HttpPost httppost = new HttpPost(url);
		return httppost;
	}

	private static String execute(HttpUriRequest request) {

		HttpClient httpclient = HttpClients.createDefault();
		try {
			request.addHeader("Content-Type", "application/json");
			request.addHeader("Connection", "close");

			HttpResponse response = httpclient.execute(request);
			StatusLine status = response.getStatusLine();

			System.out.println(status.getStatusCode());

			// if (status.getStatusCode() != 200) {
			// return Result.neterr(new Exception(status.getReasonPhrase()));
			// }

			HttpEntity responseEntity = response.getEntity();
			String result = "";
			InputStreamReader reader = new InputStreamReader(responseEntity.getContent(), charset);
			char[] buff = new char[1024];
			int length = 0;
			while ((length = reader.read(buff)) != -1) {
				result += new String(buff, 0, length);
			}
			/*JSONObject ret = JSONObject.fromObject(result);
			if (!ret.containsKey("isSuccess")) {
				return Result.success(JSONObject.fromObject(result));
			}

			if (ret.getInt("isSuccess") == 0) {
				return Result.success(JSONObject.fromObject(result));
			} else {
				return Result.fail(ret.get("isSuccess") + ":" + ret.get("msg"));
			}*/
			return result;
		} catch (UnsupportedEncodingException e) {
			return Result.err(e).toString();
		} catch (ClientProtocolException e) {
			return Result.neterr(e).toString();
		} catch (IOException e) {
			return Result.neterr(e).toString();
		} catch (Exception e) {
			return Result.err(e).toString();
		} finally {
			request.abort();
		}
	}
}
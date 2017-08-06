package com.ky.workover.common.utils;

import java.util.Stack;

/**
 * Created by Thinkpad on 2016/5/25.
 */
public class BytesUtils {

    /**
     * Convert byte[] to hex string. 把字节数组转化为字符串
     * 这里我们可以将byte转换成int，然后利用Integer.toHexString(int)来转换成16进制字符串。
     * @param src byte[] data
     * @return hex string
     */
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv+" ");
        }
        return stringBuilder.toString();
    }
    /**
     * Convert hex string to byte[]   把为字符串转化为字节数组
     * @param hexString the hex string
     * @return byte[]
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }


    /**
     * Convert char to byte
     * @param c char
     * @return byte
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }



    //16进制转10进制
    public static String covertString16To10(String hexStr){
        String myStr[]={"a","b","c","d","e","f"};
        int result=0;
        int n=1;
        for(int i=hexStr.length()-1;i>=0;i--){
            String param=hexStr.substring(i,i+1);
            for(int j=0;j<myStr.length;j++){
                if(param.equalsIgnoreCase(myStr[j])){
                    param="1"+String.valueOf(j);
                }
            }
            result+=Integer.parseInt(param)*n;
            n*=16;
        }
//        System.out.println(result);
//        System.out.println(Integer.parseInt(hexStr, 16));
        return String.valueOf(result);
    }


    /**
     * 16进制内任意进制转换
     * @param num
     * @param srcBase 源进制
     * @param destBase 目标进制
     * @return
     */
    public String baseNum(String num,int srcBase,int destBase){
        if(srcBase == destBase){
            return num;
        }
        String digths = "0123456789ABCDEF";
        char[] chars = num.toCharArray();
        int len = chars.length;
        if(destBase != 10){//目标进制不是十进制 先转化为十进制
            num = baseNum(num,srcBase,10);
        }else{
            int n = 0;
            for(int i = len - 1; i >=0; i--){
                n+=digths.indexOf(chars[i])*Math.pow(srcBase, len - i - 1);
            }
            return n + "";
        }
        return baseString(Integer.valueOf(num), destBase);
    }

    /**
     * 将数转为任意进制
     * @param num
     * @param base
     * @return
     */
    public String baseString(int num,int base){
        if(base > 16){
            throw new RuntimeException("进制数超出范围，base<=16");
        }
        StringBuffer str = new StringBuffer("");
        String digths = "0123456789ABCDEF";
        Stack<Character> s = new Stack<Character>();
        while(num != 0){
            s.push(digths.charAt(num%base));
            num/=base;
        }
        while(!s.isEmpty()){
            str.append(s.pop());
        }
        return str.toString();
    }





    /**
     * 字节转bit
     * @param b
     * @return
     */
    public static String byte2bits(byte b) {
        int z = b;
        z |= 256;
        String str = Integer.toBinaryString(z);
        int len = str.length();
        return str.substring(len - 8, len);
    }

    public String baseNum1(String num,int srcBase,int destBase){
        if(srcBase == destBase){
            return num;
        }
        String digths = "0123456789ABCDEF";
        char[] chars = num.toCharArray();
        int len = chars.length;
        if(destBase != 10){//目标进制不是十进制 先转化为十进制
            num = baseNum1(num, srcBase, 10);
        }else{
            int n = 0;
            for(int i = len - 1; i >=0; i--){
                n+=digths.indexOf(chars[i])*Math.pow(srcBase, len - i - 1);
            }
            return n + "";
        }
        return baseString1(Integer.valueOf(num), destBase);
    }

    public String baseString1(int num,int base){
        if(base > 16){
            throw new RuntimeException("进制数超出范围，base<=16");
        }
        StringBuffer str = new StringBuffer("");
        String digths = "0123456789ABCDEF";
        Stack<Character> s = new Stack<Character>();
        while(num != 0){
            s.push(digths.charAt(num%base));
            num/=base;
        }
        while(!s.isEmpty()){
            str.append(s.pop());

        }
        int num1 = str.length();
        for(int i = 8;i>num1;i--){
            str.insert(0,"0");
        }

        return str.toString();
    }

    //将字符串转换为字符数组，再将16进制数组转换成10进制数组 --事故疑点 llx
    public static String[] conversion16To10(String hexSingleData){
        int num = hexSingleData.length() / 2;
        String str[] = new String[num];
        for(int i= 0;i<num;i++){
            int n = i*2;
            str[i] = BytesUtils.covertString16To10(hexSingleData.substring(n, n + 2));
        }
        return str;
    }

    //将字符数组转换成16进制字符串 --事故疑点 llx
    public static String conversion10To16(String[] hexSingleData){
        int num = hexSingleData.length;
        StringBuffer stringBuffer = new StringBuffer();
        for(int i= 0;i<num;i++){
            BytesUtils bytesUtils = new BytesUtils();
            stringBuffer.append(bytesUtils.baseNum(hexSingleData[i], 10, 16));
        }
        return stringBuffer.toString();
    }


    public static void main(String[] args) {
        String hexStr="7fffffff";
        System.out.println(BytesUtils.covertString16To10(hexStr));
    }



}

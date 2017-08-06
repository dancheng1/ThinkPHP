package com.ky.workover.common.utils;

/**
 * Created by llx on 2016/2/3.
 * 随机数
 */

import java.util.Random;

public class CharaterUtils {

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();

        StringBuffer sb=new StringBuffer();

        for(int i=0;i<length;i++){

            int number =random.nextInt(62);

            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //System.out.println(getRandomString(17));
    }
}

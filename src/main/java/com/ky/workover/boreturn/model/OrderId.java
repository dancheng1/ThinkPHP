package com.ky.workover.boreturn.model;

import com.ky.workover.boreturn.service.BoreturnService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */
public class OrderId {
    public static void main(String []args){
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        Date date = new Date();
        String s = format.format(date);
        String s1 = "J";
        String s2 = s1 + s;
        s2 = s2;
        System.out.println(s2);
        String s4 = "J1702230002";
        String s3 = s4.substring(7, s4.length());
        System.out.println(s3);
        int i;
        if(s3 != null && s3.isEmpty() == false){
            i = Integer.parseInt(s3);
        } else {
            i = 0;
        }

        System.out.println(i);


    }
}

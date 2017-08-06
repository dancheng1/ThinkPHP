package com.ky.workover.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldx on 2016/5/5.
 * 去掉经纬度为零的数据
 */


public class LonLatUtils {

    public static List getLonLat(String Lon,String Lat) {
        Double longitude = StringUtils.toDouble(Lon);
        Double latitude = StringUtils.toDouble(Lat);
        List list = new ArrayList();
        list.add(longitude);
        list.add(latitude);
        if(longitude!=0D && latitude!=0D){
          return list;
        }else{
            return null;
        }
    }

}

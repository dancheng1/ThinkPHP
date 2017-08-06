package com.ky.workover.common.json;


import com.alibaba.fastjson.serializer.ValueFilter;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/*import org.codehaus.jackson.xml.XmlMapper;*/


/**
 * @author Created by anliang
 * @escription 车辆实时监控
 * @date 2016年1月28日 13:21:25
 * @Version V1.0
 * @copyright  faw.com.cn
 */
public class JsonUtils {

    private static ObjectMapper objectMapper = null;

     static  {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
    }

    public static ValueFilter isNullFilter = new ValueFilter() {
        @Override
        public Object process(Object obj, String s, Object v) {
            if(v==null)
                return "";
            return v;
        }
    };

    public static void destory() {
            objectMapper = null;
            System.gc();
    }


    public static <T> Object readJson2Object(String jsonStr,Class<T> valueTypes) {

        Object obj = null;
        try {
            obj = objectMapper.readValue(jsonStr, valueTypes);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }


    public static String readObject2JSON(Object obj) {

        String json = null;
        try {
            json = objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;

    }



    public static String getJsonNodeValue(String jsonStr, String nodekey){
        String nodeValue = null;
        try {
            JsonNode node = objectMapper.readTree(jsonStr);
            nodeValue =  node.get(nodekey).asText();
        } catch (IOException e) {
        }
        return nodeValue;
    }


    @Test
    public void test01(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "zhang");
        map.put("sex", "1");
        map.put("login", "Jack");
        map.put("password", "123abc");

        AccountBean bean = new AccountBean();
        bean.setId(1);
        bean.setName("xxxxx");
        bean.setEmail("772738@qq.com");
        bean.setAddress("长春市");

        String json = "{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}";

        Map acc = (Map) JsonUtils.readJson2Object(json, Map.class);
        System.out.println("----------------------------------------------");
        System.out.println(acc.get("name"));
        System.out.println(acc);

    }


}

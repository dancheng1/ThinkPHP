package com.ky.workover.common.json;


import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*import org.codehaus.jackson.xml.XmlMapper;*/


/**
 * Created by Thinkpad on 2016/2/1.
 */
public class JacksonTest {

    private JsonGenerator jsonGenerator = null;
    private ObjectMapper objectMapper = null;
    private AccountBean bean = null;

    @Before
    public void init() {
        bean = new AccountBean();
        bean.setAddress("china-Guangzhou");
        bean.setEmail("hoojo_@126.com");
        bean.setId(1);
        bean.setName("hoojo");

        objectMapper = new ObjectMapper();
        try {
            jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destory() {
        try {
            if (jsonGenerator != null) {
                jsonGenerator.flush();
            }
            if (!jsonGenerator.isClosed()) {
                jsonGenerator.close();
            }
            jsonGenerator = null;
            objectMapper = null;
            bean = null;
            System.gc();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writeEntityJSON() {

        try {
            System.out.println("jsonGenerator");
            //writeObject可以转换java对象，eg:JavaBean/Map/List/Array等
            jsonGenerator.writeObject(bean);
            System.out.println();

            System.out.println("ObjectMapper");
            //writeValue具有和writeObject相同的功能
            objectMapper.writeValue(System.out, bean);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void readJson2Entity() {
        String json = "{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}";
        try {
            AccountBean acc = objectMapper.readValue(json, AccountBean.class);
            System.out.println("----------------------------------------------");
            System.out.println(acc.getName());
            System.out.println(acc);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void MyTest01() {
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name", "zhang");
        hashMap.put("sex", "1");
        hashMap.put("login", "Jack");
        hashMap.put("password", "123abc");

        try {
            String userMapJson = objectMapper.writeValueAsString(hashMap);
            System.out.println("------------"+userMapJson);
            JsonNode node = objectMapper.readTree(userMapJson);

            // 输出结果转意，输出正确的信息
            System.out.println(node.get("password").asText());
            // 输出不转意,输出结果会包含""，这是不正确的，除非作为json传递，如果是输出结果值，必须如上一行的操作
            System.out.println(node.get("name"));
        } catch (IOException e) {
        }

    }


    }

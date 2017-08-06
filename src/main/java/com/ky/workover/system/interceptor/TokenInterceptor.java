package com.ky.workover.system.interceptor;/*
package com.lp.bigboss.system.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.lp.bigboss.common.utils.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

*/
/**
 * @author Created by ly
 * @escription token验证拦截器
 * @date：2016-01-15 09:55:48
 * @Version 1.0
 * @copyright QM
 *//*

public class TokenInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String tokenId = request.getHeader("tokenId");
        if (StringUtils.isNullOrBlank(tokenId)) {
            JSONObject json = JSONObject.parseObject(getRequestPayload(request));
            tokenId = (String.valueOf(json.get("tokenId")));
        }
        JSONObject jsonObject = tokenVerify(tokenId);
        if ((int) jsonObject.get("isSuccess") == 0) {
            return true;
        } else {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.append(jsonObject.toString());
            return false;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

    public JSONObject tokenVerify(String tokenId) {
        Jedis jedis=null;
        JSONObject jsonObject = new JSONObject();
        try {
            jedis=RedisAPI.getPool().getResource();
            if (tokenTimeout(tokenId)) {
                //验证token是否有效
                if (tokenId.equals(jedis.hget(tokenId, "sessionId"))) {
                    //重新对失效时间进行赋值
                    jedis.hset(tokenId, "tokenTimeout", String.valueOf(new Date().getTime() + 2 * 60 * 1000));
                    jsonObject.put("isSuccess", MessageConstant.NUMBER_ZERO);
                } else {
                    jsonObject.put("isSuccess", MessageConstant.NUMBER_ONE);
                    jsonObject.put("msg", "Token无效");
                }
            } else {
                jsonObject.put("isSuccess", MessageConstant.NUMBER_EIGHT);
                jsonObject.put("msg", MessageConstant.NUMBER_EIGHT_MSG);
            }
        }finally {
            jedis.close();
        }
        return jsonObject;
    }

    public boolean tokenTimeout(String tokenId) {
        Jedis jedis= null;
        boolean flag = false;
        try {
            jedis= RedisAPI.getPool().getResource();
            if (jedis.hlen(tokenId) > 0) {
                Long timeout = Long.parseLong(jedis.hget(tokenId, "tokenTimeout"));
                if (null != timeout) {
                    if (new Date().getTime() <= timeout) {
                        flag = true;
                    }
                }
            }
        }finally {
            jedis.close();
        }
        return flag;
    }

    private String getRequestPayload(HttpServletRequest req) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
*/

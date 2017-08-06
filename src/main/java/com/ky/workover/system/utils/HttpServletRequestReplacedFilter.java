package com.ky.workover.system.utils;

import com.alibaba.fastjson.JSONObject;
import com.ky.workover.common.utils.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/4.
 */
public class HttpServletRequestReplacedFilter implements Filter {
    private String[] excludedPageArray;
    private String excludedPages;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        boolean isExcludedPage = false;
        for (String page : excludedPageArray) {//判断是否在过滤url之外
            if (((HttpServletRequest) request).getServletPath().equals(page)) {
                isExcludedPage = true;
                break;
            }
        }
        if (isExcludedPage) {//在过滤url之外
            chain.doFilter(request, response);
        } else {
            ServletRequest requestWrapper = null;
            if (request instanceof HttpServletRequest) {
                HttpServletRequest httpServletRequest = (HttpServletRequest) request;
                if ("POST".equals(httpServletRequest.getMethod().toUpperCase())
                        && (httpServletRequest.getContentType().equalsIgnoreCase(
                        "application/json; charset=utf-8") || (httpServletRequest.getContentType().equalsIgnoreCase(
                        "application/json")))) {
                    requestWrapper = new BodyReaderHttpServletRequestWrapper(
                            (HttpServletRequest) request);
                }
            }
            if (requestWrapper == null) {
                chain.doFilter(request, response);
            } else {
                //验证tokenId
                String tokenId = BodyReaderHttpServletRequestWrapper.getTokenId();
                    JSONObject json = JSONObject.parseObject(tokenId);
                    tokenId = (String.valueOf(json.get("tokenId")));
//                JSONObject jsonObject = tokenVerify(tokenId);
//                if ((int) jsonObject.get("isSuccess") == 0) {
//                    chain.doFilter(requestWrapper, response);
//                } else {
//                    response.setCharacterEncoding("UTF-8");
//                    response.setContentType("application/json; charset=utf-8");
//                    PrintWriter out = response.getWriter();
//                    out.append(jsonObject.toString());
//                    return;
//                }
            }
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        excludedPages = arg0.getInitParameter("loginApi");
        if (StringUtils.isNotEmpty(excludedPages)) {
            excludedPageArray = excludedPages.split(",");
        }
    }

    /*public JSONObject tokenVerify(String tokenId) {
        Jedis jedis=null;
        JSONObject jsonObject = new JSONObject();
        try {
            jedis= RedisAPI.getPool().getResource();
            //if (tokenTimeout(tokenId)) {
                //验证token是否有效
                if (tokenId.equals(jedis.hget(tokenId, "sessionId"))) {
                    //重新对失效时间进行赋值
                    jedis.hset(tokenId, "tokenTimeout", String.valueOf(new Date().getTime() + 2 * 60 * 1000));
                    jsonObject.put("isSuccess", MessageConstant.NUMBER_ZERO);
                } else {
                    jsonObject.put("isSuccess", MessageConstant.NUMBER_ONE);
                    jsonObject.put("msg", "Token无效");
                }
            //} else {
                //jsonObject.put("isSuccess", MessageConstant.NUMBER_EIGHT);
                //jsonObject.put("msg", MessageConstant.NUMBER_EIGHT_MSG);
            //}
        }finally {
            jedis.close();
        }
        return jsonObject;
    }*/

    /*public boolean tokenTimeout(String tokenId) {
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
    }*/
}

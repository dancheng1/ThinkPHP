package com.ky.workover.common.log.basic;

import java.util.Map;

/**
 * @author ：anliang
 * @Description ：基本日志记录器接口
 * @date：2016-01-04
 * @company：QM
 * @History:
 */
public interface Log {

    public String[] getLogArray(Integer size);


    /**
     * 记录debug级别的日志
     *
     * @param messages
     */
    public void debug(String messages);

    /**
     * 记录debug级别的日志
     *
     * @param messages
     */
    public void debug(String tid, String messages);

    /**
     * 记录debug级别的日志
     *
     * @param messages
     * @param e
     */
    public void debug(String tid, String messages, Exception e);

    /**
     * 记录debug级别的日志
     *
     * @param messages
     */
    public void debug(String tid, String[] messages);


    /**
     * 记录debug级别的日志
     *
     * @param messages
     * @param e
     */
    public void debug(String tid, String[] messages, Exception e);


    /**
     * 记录debug级别的日志
     *
     * @param tid
     * @param ip
     * @param msg
     * @param e
     */
    public void debug(String cmd, String tid, String ip, String msg, Exception e);


    /**
     * 记录debug级别的日志
     *
     * @param tid
     * @param ip
     * @param msg
     */
    public void debug(String cmd, String tid, String ip, String msg);

    /**
     * 记录debug级别的日志
     *
     * @param tid
     * @param cmd
     * @param corpId
     * @param orgId
     * @param userId
     * @param bean
     */
    public void debug(String tid, String cmd, Integer corpId, Integer orgId, Integer userId, Object bean);


    /**
     * 记录debug级别的日志
     *
     * @param cmd
     * @param corpId
     * @param orgId
     * @param userId
     * @param paraMap
     */
    public void debug(String tid, String cmd, Integer corpId, Integer orgId, Integer userId, Map<String, String> paraMap);


    /**
     * 记录info级别的日志
     *
     * @param messages 日志信息
     */
    public void info(String messages);

    /**
     * 记录info级别的日志
     *
     * @param cmd
     * @param ip
     * @param msg
     */
    public void info(String cmd, String gradeLevel, Integer subjectId, String userId, String ip, String msg);

    /**
     * 记录info级别的日志
     *
     * @param cmd
     * @param ip
     * @param msg
     * @param e
     */
    public void info(String cmd, String gradeLevel, Integer subjectId, String userId, String ip, String msg, Exception e);

    /**
     * 记录info级别的日志,及入库操作
     *
     * @param cmd
     * @param ip
     * @param msg
     * @param type
     * @param domain
     */
    public void infoStock(String cmd, String gradeLevel, Integer subjectId, String userId, String ip, String msg, Integer type, String domain);

    /**
     * 记录info级别的日志,及入库操作
     *
     * @param messages
     */
    public void infoStock(String messages);

    /**
     * 记录info级别的日志
     *
     * @param messages
     * @param e
     */
    public void info(String messages, Exception e);

    /**
     * 记录info级别的日志,及入库操作
     *
     * @param messages
     * @param e
     */
    public void infoStock(String messages, Exception e);

    /**
     * 记录info级别的日志
     *
     * @param messages
     */
    public void info(String[] messages);

    /**
     * 记录info级别的日志
     *
     * @param messages
     * @param e
     */
    public void info(String[] messages, Exception e);

    /**
     * 记录warn级别的日志
     *
     * @param messages
     */
    public void warn(String messages);

    /**
     * 记录warn级别的日志
     *
     * @param messages
     * @param e
     */
    public void warn(String messages, Exception e);

    /**
     * 记录warn级别的日志
     *
     * @param messages
     */
    public void warn(String[] messages);

    /**
     * 记录warn级别的日志
     *
     * @param messages
     * @param e
     */
    public void warn(String[] messages, Exception e);

    /**
     * 记录error级别的日志
     *
     * @param messages
     */
    public void error(String messages);

    /**
     * 记录error级别的日志,及入库操作
     *
     * @param cmd
     * @param ip
     * @param msg
     * @param type
     * @param domain
     */
    public void errorStock(String cmd, String gradeLevel, Integer subjectId, String userId, String ip, String msg, Integer type, String domain);

    /**
     * 记录error级别的日志,及入库操作
     *
     * @param cmd
     * @param ip
     * @param msg
     * @param type
     * @param domain
     * @param e
     */
    public void errorStock(String cmd, String gradeLevel, Integer subjectId, String userId, String ip, String msg, Integer type, String domain, Exception e);

    /**
     * 记录error级别的日志
     *
     * @param cmd
     * @param ip
     * @param msg
     */
    public void error(String cmd, String gradeLevel, Integer subjectId, String userId, String ip, String msg);

    /**
     * 记录error级别的日志
     *
     * @param cmd
     * @param ip
     * @param msg
     * @param e
     */
    public void error(String cmd, String gradeLevel, Integer subjectId, String userId, String ip, String msg, Exception e);

    /**
     * 记录error级别的日志,及入库操作
     *
     * @param messages
     */
    public void errorStock(String messages);

    /**
     * 记录error级别的日志
     *
     * @param messages
     * @param e
     */
    public void error(String messages, Exception e);

    /**
     * 记录error级别的日志,及入库操作
     *
     * @param messages
     * @param e
     */
    public void errorStock(String messages, Exception e);

    /**
     * 记录error级别的日志
     *
     * @param messages
     */
    public void error(String[] messages);

    /**
     * 记录error级别的日志
     *
     * @param messages
     * @param e
     */
    public void error(String[] messages, Exception e);


}
package com.ky.workover.common.log.basic;

import org.apache.log4j.Logger;

import java.util.Map;

/**
 * @author ：anliang
 * @Description ：基本日志记录器 用于被其它各个模块的记录器所继承
 * @date：2016-01-04
 * @company：QM
 * @History:
 */
public abstract class BaseLogger implements Log {

    /**
     * 日志级别：调试
     */
    private static final int debug = 1;
    /**
     * 日志级别：调试 另加打印异常信息
     */
    private static final int debugException = 11;

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * 日志级别：普通
     */
    private static final int info = 2;
    /**
     * 日志级别：普通 另加打印异常信息
     */
    private static final int infoException = 22;
    /**
     * 日志级别：警告
     */
    private static final int warn = 3;
    /**
     * 日志级别：警告 另加打印异常信息
     */
    private static final int warnException = 33;
    /**
     * 日志级别：错误
     */
    private static final int error = 4;
    /**
     * 日志级别：错误 另加打印异常信息
     */
    private static final int errorException = 44;
    /**
     * 消息所属和消息内容的分隔符
     */
    private static final String msgSplit = " - ";
    /**
     * 消息对的分隔符
     */
    private static final String propertiesSplit = " | ";

    /**
     * 日志的key  操作
     */
    private static final String T_ID = "tid=";

    /**
     * 日志的key  操作
     */
    private static final String CMD = "cmd=";
    /**
     * 日志企业KEY
     */
    private static final String CORP_ID = "corpId=";
    /**
     * 日志组织KEY
     */
    private static final String ORG_ID = "orgId=";
    /**
     * 日志组织KEY
     */
    private static final String USER_ID = "userId=";
    /**
     * 日志IP的key
     */
    private static final String IP = "ip=";
    /**
     * 日志MSG的key
     */
    private static final String MSG = "msg=";
    /**
     * 日志的key
     */

    private static final String className = BaseLogger.class.getName();
//    private static BaseLogger baseLogger = null;
    private Logger logger = null;


    /**
     * 返回基本日志记录实例
     *
     * @return
     */
/*    protected static BaseLogger getInstance() {
        return baseLogger;
    }*/

    /**
     * 获取日志模块名称(子类实现)
     *
     * @return
     */
    protected abstract String getLogName();

    /**
     * 实际日志模块实例
     *
     * @return Logger
     */
    protected Logger getLogger() {
        String logName = getLogName();
        if (logger == null) {
            if (LogUtil.isEmptyStr(logName)) {
                logger = Logger.getLogger(logName);
            } else {
                logger = Logger.getRootLogger();
            }
        }
        return logger;
    }




    /**
     *  打印日志主方法
     *
     * @param level
     * @param message
     * @param ste
     * @param e
     */
    private void log(int level, String message, StackTraceElement[] ste, Exception e, boolean isStock) {
        if (isStock) {
            LogRecorder.record(message);
        }
        if (ste != null) {
            // 加入源代码定位
            message = getStackMsg(ste) + msgSplit + message;
        }
        // 转入具体实现，此处为log4j，可以改为其他不同的日志实现。
        switch (level) {
            case debug:
                getLogger().debug(message);
                break;
            case debugException:
                getLogger().debug(message, e);
                break;
            case info:
                getLogger().info(message);
                break;
            case infoException:
                getLogger().info(message, e);
                break;
            case warn:
                getLogger().warn(message);
                break;
            case warnException:
                getLogger().warn(message, e);
                break;
            case error:
                getLogger().error(message);
                break;
            case errorException:
                getLogger().error(message, e);
                break;
            default:
                getLogger().debug(message);
        }
    }

    /**
     * 返回实际打印日志的类名和行号
     *
     * @param ste
     * @return
     */
    protected String getStackMsg(StackTraceElement[] ste) {
        if (ste == null)
            return null;

        for (int i = 0; i < ste.length; i++) {
            StackTraceElement s = ste[i];
            // 定位本类的堆栈
            if (className.equals(s.getClassName())) {
                String result = ste[i + 1].toString();
               //return result.substring(result.indexOf("("));
                return result;
            }
        }
        return null;
    }


    /**
     * 把 String array 转换成按 "|"分隔的字符串
     *
     * @param messages 日志信息
     * @return
     */
    private String changeArrayToString(String[] messages) {
        if (messages == null || messages.length == 0) {
            return null;
        }
        StringBuilder message = new StringBuilder();
        for (String msg : messages) {
            message.append(msg + " | ");
        }
        return message.subSequence(0, message.length() - 3).toString();
    }

    /**
     * 把 String array 转换成按 "|"分隔的字符串
     *
     * @param size 日志信息
     * @return
     */
    public String[] getLogArray(Integer size) {
        return new String[size];
    }



    /* (non-Javadoc)
    * @see debug(java.lang.String)
    */
    @Override
    public void debug(String messages) {
        log(debug, messages, Thread.currentThread().getStackTrace(), null, false);
    }

    /* (non-Javadoc)
     * @see debug(java.lang.String)
     */
    @Override
    public void debug(String tid, String messages) {
        log(debug, messages, Thread.currentThread().getStackTrace(), null, false);
    }

    /* (non-Javadoc)
     * @see debug(java.lang.String, java.lang.Exception)
     */
    @Override
    public void debug(String tid, String messages, Exception e) {
        log(debugException, messages, Thread.currentThread().getStackTrace(), e, false);
    }

    /* (non-Javadoc)
     * @see debug(java.lang.String[])
     */
    @Override
    public void debug(String tid, String[] messages) {
        log(debug, changeArrayToString(messages), Thread.currentThread().getStackTrace(), null, false);
    }

    /* (non-Javadoc)
     * @see debug(java.lang.String[], java.lang.Exception)
     */
    @Override
    public void debug(String tid, String[] messages, Exception e) {
        log(debugException, changeArrayToString(messages), Thread.currentThread().getStackTrace(), e, false);
    }

    /* (non-Javadoc)
     * @see info(java.lang.String)
     */
    @Override
    public void info(String messages) {
        log(info, messages, Thread.currentThread().getStackTrace(), null, false);
    }

    /* (non-Javadoc)
     * @see info(java.lang.String, java.lang.Exception)
     */
    @Override
    public void info(String messages, Exception e) {
        log(infoException, messages, Thread.currentThread().getStackTrace(), e, false);
    }

    /* (non-Javadoc)
     * @see info(java.lang.String[])
     */
    @Override
    public void info(String[] messages) {
        log(info, changeArrayToString(messages), Thread.currentThread().getStackTrace(), null, false);
    }

    /* (non-Javadoc)
     * @see info(java.lang.String[], java.lang.Exception)
     */
    @Override
    public void info(String[] messages, Exception e) {
        log(infoException, changeArrayToString(messages), Thread.currentThread().getStackTrace(), e, false);
    }

    /* (non-Javadoc)
     * @see warn(java.lang.String)
     */
    @Override
    public void warn(String messages) {
        log(warn, messages, Thread.currentThread().getStackTrace(), null, false);
    }

    /* (non-Javadoc)
     * @see warn(java.lang.String, java.lang.Exception)
     */
    @Override
    public void warn(String messages, Exception e) {
        log(warnException, messages, Thread.currentThread().getStackTrace(), e, false);
    }

    /* (non-Javadoc)
     * @see warn(java.lang.String[])
     */
    @Override
    public void warn(String[] messages) {
        log(warn, changeArrayToString(messages),
                Thread.currentThread().getStackTrace(), null, false);
    }

    /* (non-Javadoc)
     * @see warn(java.lang.String[], java.lang.Exception)
     */
    @Override
    public void warn(String[] messages, Exception e) {
        log(warnException, changeArrayToString(messages), Thread.currentThread().getStackTrace(), e, false);
    }

    /* (non-Javadoc)
     * @see error(java.lang.String)
     */
    @Override
    public void error(String messages) {
        log(error, messages, Thread.currentThread().getStackTrace(), null, false);
    }

    /* (non-Javadoc)
     * @see error(java.lang.String, java.lang.Exception)
     */
    @Override
    public void error(String messages, Exception e) {
        log(errorException, messages, Thread.currentThread().getStackTrace(), e, false);
    }

    /* (non-Javadoc)
     * @see error(java.lang.String[])
     */
    @Override
    public void error(String[] messages) {
        log(error, changeArrayToString(messages), Thread.currentThread().getStackTrace(), null, false);
    }

    /* (non-Javadoc)
     * @see error(java.lang.String[], java.lang.Exception)
     */
    @Override
    public void error(String[] messages, Exception e) {
        log(errorException, changeArrayToString(messages), Thread.currentThread().getStackTrace(), e, false);
    }

    /* (non-Javadoc)
     * @see info(java.lang.String, boolean)
     */
    @Override
    public void infoStock(String messages) {
        log(info, messages, Thread.currentThread().getStackTrace(), null, true);
    }

    /* (non-Javadoc)
     * @see info(java.lang.String, java.lang.Exception, boolean)
     */
    @Override
    public void infoStock(String messages, Exception e) {
        log(infoException, messages, Thread.currentThread().getStackTrace(), e, true);
    }

    /* (non-Javadoc)
     * @see error(java.lang.String, boolean)
     */
    @Override
    public void errorStock(String messages) {
        log(error, messages, Thread.currentThread().getStackTrace(), null, true);
    }

    /* (non-Javadoc)
     * @see error(java.lang.String, java.lang.Exception,boolean)
     */
    @Override
    public void errorStock(String messages, Exception e) {
        log(errorException, messages, Thread.currentThread().getStackTrace(), e, true);
    }











    /**
     * 转换map数据为logStr
     *
     * @param cmd
     * @param corpId
     * @param orgId
     * @param userId
     * @param map
     * @return logStr
     */
	private String getStringByMap(String tid, String cmd, Integer corpId, Integer orgId, Integer userId, Map<String, String> paraMap) {
        StringBuilder b = new StringBuilder();
        if (LogUtil.isEmptyStr(cmd)) b.append(CMD).append(cmd).append(propertiesSplit);
        if (LogUtil.isNotEmptyObject(corpId)) b.append(CORP_ID).append(corpId).append(propertiesSplit);
        if (LogUtil.isEmptyStr(String.valueOf(orgId))) b.append(ORG_ID).append(orgId).append(propertiesSplit);
        if (LogUtil.isEmptyStr(String.valueOf(userId))) b.append(USER_ID).append(userId).append(propertiesSplit);
        if(null != paraMap && !paraMap.isEmpty()){
        	for(Map.Entry<String, String> entry : paraMap.entrySet())
        	{
        	    b.append("{"+entry.getKey()+" = "+entry.getValue()+"}").append(propertiesSplit);
        	}
        }
        return b.append(T_ID).append(tid).append(propertiesSplit).toString();
    }



    /**
     * 转换bean数据为logStr
     *
     * @param cmd
     * @param corpId
     * @param orgId
     * @param userId
     * @param bean 重写toString()
     * @return
     */
	private String getStringByBean(String tid, String cmd, Integer corpId, Integer orgId, Integer userId, Object bean) {
        StringBuilder b = new StringBuilder();
        if (LogUtil.isEmptyStr(cmd)) b.append(CMD).append(cmd).append(propertiesSplit);
        if (LogUtil.isNotEmptyObject(corpId)) b.append(CORP_ID).append(corpId).append(propertiesSplit);
        if (LogUtil.isEmptyStr(String.valueOf(orgId))) b.append(ORG_ID).append(orgId).append(propertiesSplit);
        if (LogUtil.isEmptyStr(String.valueOf(userId))) b.append(USER_ID).append(userId).append(propertiesSplit);
        if(null != bean ){
        	    b.append(bean.getClass().getName()+" = "+bean).append(propertiesSplit);
        }
        return b.append(T_ID).append(tid).append(propertiesSplit).toString();
    }



    /**
     * 把参数转成String
     *
     * @param cmd
     * @param gradeLevel
     * @param subjectId
     * @param userId
     * @param ip
     * @param msg
     * @return
     */
    private String getStringByParam(String tid, String cmd, String gradeLevel, Integer subjectId, String userId, String ip, String msg) {
        StringBuilder b = new StringBuilder();
        if (LogUtil.isEmptyStr(cmd)) b.append(CMD).append(cmd).append(propertiesSplit);
        if (LogUtil.isEmptyStr(gradeLevel)) b.append(CORP_ID).append(gradeLevel).append(propertiesSplit);
        if (LogUtil.isEmptyStr(String.valueOf(subjectId))) b.append(ORG_ID).append(subjectId).append(propertiesSplit);
        if (LogUtil.isEmptyStr(ip)) b.append(IP).append(ip).append(propertiesSplit);
        if (LogUtil.isEmptyStr(msg)) b.append(MSG).append(msg).append(propertiesSplit);
        return b.append(T_ID).append(tid).append(propertiesSplit).toString();
    }


    /**
     * 把参数转成String (api)
     *
     * @param cmd
     * @param tid
     * @param ip
     * @param msg
     * @return
     */
    private String getStringByParam(String cmd, String tid, String ip, String msg) {
        StringBuilder b = new StringBuilder();
        if (LogUtil.isEmptyStr(cmd)) b.append(CMD).append(cmd).append(propertiesSplit);
        if (LogUtil.isEmptyStr(ip)) b.append(IP).append(ip).append(propertiesSplit);
        if (LogUtil.isEmptyStr(msg)) b.append(MSG).append(msg).append(propertiesSplit);
        return b.append(T_ID).append(tid).append(propertiesSplit).toString();
    }


    /**
     * 把参数转成String (api)
     *
     * @param cmd
     * @param tid
     * @param ip
     * @param msg
     * @param e
     * @return
     */
    private String getStringByParam(String cmd, String tid, String ip, String msg, Exception e) {
        StringBuilder b = new StringBuilder();
        if (LogUtil.isEmptyStr(cmd)) b.append(CMD).append(cmd).append(propertiesSplit);
        if (LogUtil.isEmptyStr(ip)) b.append(IP).append(ip).append(propertiesSplit);
        if (LogUtil.isEmptyStr(msg)) b.append(MSG).append(msg).append(propertiesSplit);
        return b.append(T_ID).append(tid).append(propertiesSplit).toString();
    }





    
    /* debug method */
    @Override
    public void debug(String tid, String cmd, Integer corpId, Integer orgId, Integer userId, Object bean) {
        String message = getStringByBean(tid, cmd, corpId, orgId, userId, bean);
        log(debug, message, Thread.currentThread().getStackTrace(), null, false);
    }
    
   
    @Override
    public void debug(String tid, String cmd, Integer corpId, Integer orgId, Integer userId, Map<String, String> paraMap) {
        String message = getStringByMap(tid, cmd, corpId, orgId, userId, paraMap);
        log(debug, message, Thread.currentThread().getStackTrace(), null, false);
    }

    @Override
    public void debug(String tid, String cmd, String ip, String msg) {
        String message = getStringByParam(tid, cmd, ip, msg);
        log(debugException, message, Thread.currentThread().getStackTrace(),null, false);
    }

    @Override
    public void debug(String tid, String cmd, String ip, String msg, Exception e) {
        String message = getStringByParam(tid, cmd, ip, msg, e);
        log(debugException, message, Thread.currentThread().getStackTrace(), e, false);
    }






    
    
    /* info method */
    @Override
    public void info(String cmd, String gradeLevel, Integer subjectId, String userId, String ip, String msg) {
//        String log = getStringByParam(cmd, gradeLevel, subjectId, userId, ip, msg);
//        log(info, log, Thread.currentThread().getStackTrace(), null, false);
    }

    @Override
    public void info(String cmd, String gradeLevel, Integer subjectId, String userId, String ip, String msg, Exception e) {
//        String command = getStringByParam(cmd, gradeLevel, subjectId, userId, ip, msg);
//        log(info, command, Thread.currentThread().getStackTrace(), e, false);
    }

    @Override
    public void infoStock(String cmd, String gradeLevel, Integer subjectId, String userId, String ip, String msg, Integer type, String domain) {
//        String command = getStringByParam(cmd, gradeLevel, subjectId, userId, ip, msg);
//        log(info, command, Thread.currentThread().getStackTrace(), null, false);
        LogRecorder.record(cmd, gradeLevel, subjectId, userId, ip, msg, type, domain);
    }

    
    
    /* error method */
    @Override
    public void errorStock(String cmd, String gradeLevel, Integer subjectId, String userId, String ip, String msg, Integer type, String domain) {
//        String command = getStringByParam(cmd, gradeLevel, subjectId, userId, ip, msg);
//        log(error, command, Thread.currentThread().getStackTrace(), null, false);
        LogRecorder.record(cmd, gradeLevel, subjectId, userId, ip, msg, type, domain);
    }

    @Override
    public void errorStock(String cmd, String gradeLevel, Integer subjectId, String userId, String ip, String msg, Integer type, String domain, Exception e) {
//        String command = getStringByParam(cmd, gradeLevel, subjectId, userId, ip, msg);
//        log(errorException, command, Thread.currentThread().getStackTrace(), e, false);
        LogRecorder.record(cmd, gradeLevel, subjectId, userId, ip, msg, type, domain);
    }

    @Override
    public void error(String cmd, String gradeLevel, Integer subjectId, String userId, String ip, String msg) {
//        String command = getStringByParam(cmd, gradeLevel, subjectId, userId, ip, msg);
//        log(error, command, Thread.currentThread().getStackTrace(), null, false);
    }

    @Override
    public void error(String cmd, String gradeLevel, Integer subjectId, String userId, String ip, String msg, Exception e) {
//        String command = getStringByParam(cmd, gradeLevel, subjectId, userId, ip, msg);
//        log(errorException, command, Thread.currentThread().getStackTrace(), e, false);
    }

}

package com.ky.workover.common.log.basic;

/**
 * Created by Thinkpad on 2016/1/11.
 */
public class LogUtil {

    /**
     * 判断空字符
     *
     * @param param
     * @return boolean
     */
    public static boolean isEmptyStr(String param)
    {
        return  (null == param || "".equals(param) || "".equals(param.trim()) || "null".equalsIgnoreCase(param));
    }


    /**
     * 判断对象
     *
     * @param object
     * @return boolean
     */
    public static boolean isNotEmptyObject(Object object)
    {
        return object != null;
    }



    /**
     * 生成日志事务随机序列ID
     *
     * @return String
     */
    public String getThreadTranTid() {
        return RandomUtils.generateString(28);
    }

}

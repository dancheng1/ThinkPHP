package com.ky.workover.common.log.basic;


/**
 * @Description ：日志记录器
 * @author ：anliang
 * @date：2015-01-06
 * @company：QM
 * 
 * @History:
 */
public class LogRecorder {

	private static final String IP = "ip";
	private static final String CMD = "cmd";
	private static final String RESULT = "result";
	private static final String TYPE = "type";
	private static final String MSG = "msg";
	private static final String DOMAIN = "domain";
	private static final String OK = "OK";
	private static LogRecorder lr;

	/**
	 * 记录行为日志
	 * @param log
	 */
	public static void record(String log){

	}

	/**
	 * 记录行为日志
	 * @param cmd
	 * @param result
	 * @param corpId
	 * @param userId
	 * @param ip
	 * @param msg
	 * @param type
	 * @param domain
	 */
	public static void record(String cmd, String result, Integer corpId,String userId, String ip, String msg, Integer type, String domain){

	}
}

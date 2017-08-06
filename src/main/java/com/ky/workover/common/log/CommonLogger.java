package com.ky.workover.common.log;

import com.ky.workover.common.log.basic.BaseLogger;

/**
 * @Description ：公共日志模块
 * @author ：anliang
 * @date：2016-01-06
 * @History:
 */
public class CommonLogger extends BaseLogger {
	private static CommonLogger commonLogger = null;

	/**
	 * 私有构造函数
	 */
	private CommonLogger() {
    }

    /**
	 * 返回公共模块的日志记录器实例
	 * 
	 * @return
	 */
	public static CommonLogger getInstance() {
		if (commonLogger == null) {
			commonLogger = new CommonLogger();
		}
		return commonLogger;
	}
	
	/**
	 * 返回公共模块的日志记录器名称
	 */
	@Override
	protected String getLogName() {
		return "common";
	}

}

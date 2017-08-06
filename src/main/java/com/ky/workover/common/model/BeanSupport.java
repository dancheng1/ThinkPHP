package com.ky.workover.common.model;

import com.ky.workover.common.utils.DateUtils;
import com.ky.workover.common.utils.StringUtil;
import com.ky.workover.common.utils.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class BeanSupport implements Serializable, Cloneable {
	private int page;//当前页
	private int rows;//每页显示数量
	private  String tokenId;//tokenId
	private  String userid;//userid
	private String sortBy;//排序依据 前台传递字段对应的实体类属性 stationName updateDate...
	private String order;//升序 asc 降序 desc
	private String clientId;//客户端唯一码

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getSortBy() {
		return sortBy;
	}


    public void setSortBy(String sortBy) {
        this.sortBy =sortBy.replaceAll("[A-Z]", "_$0");
    }
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * app初始化系统字段
	 * @param userId
	 */
	public void  initToMap(String userId) {
		Map<String, String> sysFieldMap = setSysField();
		Map<String, Object> sysFieldValueMap = setSysFieldValue(userId);
		Class<?> cla = getClass();
		Field[] beanFields = cla.getDeclaredFields();
		for (Field beanField : beanFields) {
			String fieldName = beanField.getName();
			if (null != sysFieldMap.get(fieldName)) {
				String setMethodName = "set" + StringUtils.upperFirst(fieldName);
				String getMethodName = "get" + StringUtils.upperFirst(fieldName);
				try {
					Method getMethod = this.getClass().getMethod(getMethodName);
					Object obj = getMethod.invoke(this, new Object[] {});
					if (null == obj) {
						Method setMethod = this.getClass().getMethod(setMethodName, beanField.getType());
						setMethod.invoke(this, new Object[] { sysFieldValueMap.get(fieldName) });
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 系统字段的初始化
	 */
	/*public void  init() {
		Map<String, String> sysFieldMap = setSysField();
		Map<String, Object> sysFieldValueMap = setSysFieldValue();
		Class<?> cla = getClass();
		Field[] beanFields = cla.getDeclaredFields();
		for (Field beanField : beanFields) {
			String fieldName = beanField.getName();
			if (null != sysFieldMap.get(fieldName)) {
				String setMethodName = "set" + StringUtils.upperFirst(fieldName);
				String getMethodName = "get" + StringUtils.upperFirst(fieldName);
				try {
					Method getMethod = this.getClass().getMethod(getMethodName);
					Object obj = getMethod.invoke(this, new Object[] {});
					if (null == obj) {
						Method setMethod = this.getClass().getMethod(setMethodName, beanField.getType());
						setMethod.invoke(this, new Object[] { sysFieldValueMap.get(fieldName) });
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}*/

	/**
	 * 添加系统字段到Map
	 * @return
	 */
	private Map<String, String> setSysField() {
		Map<String, String> sysFieldMap = new HashMap<String, String>();
		sysFieldMap.put("createUserId", "createUserId");
		sysFieldMap.put("createDate", "createUserDate");
		sysFieldMap.put("updateUserId", "updateUserId");
		sysFieldMap.put("updateDate", "updateDate");
		return sysFieldMap;
	}

	/**
	 * 为系统字段赋值
	 * @return
	 */
	/*private Map<String, Object> setSysFieldValue() {
		Map<String, Object> sysFieldValueMap = new HashMap<String, Object>();
		Session session = SecurityUtils.getSubject().getSession();
		com.qm.fawfleet.sys.model.User loginUser = (com.qm.fawfleet.sys.model.User) session.getAttribute("user");
		int operID = loginUser.getId();
		Date currentDate = DateUtils.getSysTimestamp();// DateUtil.getDateString(DateUtil.YMD_DASH_WITH_SECONED);
		sysFieldValueMap.put("createUserId", operID);
		sysFieldValueMap.put("createDate", currentDate);
		sysFieldValueMap.put("updateUserId", operID);
		sysFieldValueMap.put("updateDate", currentDate);
		return sysFieldValueMap;
	}*/
	/**
	 * app为系统字段赋值
	 * @return
	 */
	private Map<String, Object> setSysFieldValue(String userId) {
		Map<String, Object> sysFieldValueMap = new HashMap<String, Object>();
		int operID = Integer.parseInt(userId);
		Date currentDate = DateUtils.getSysTimestamp();// DateUtil.getDateString(DateUtil.YMD_DASH_WITH_SECONED);
		sysFieldValueMap.put("createUserId", operID);
		sysFieldValueMap.put("createDate", currentDate);
		sysFieldValueMap.put("updateUserId", operID);
		sysFieldValueMap.put("updateDate", currentDate);
		return sysFieldValueMap;
	}


	/**
	 *app 修改记录初始化系统字段
	 * @param userId
	 */
	public  void updateInitToMap( String userId) {
		Map<String, String> sysFieldMap = setUpdateSysField();
		Map<String, Object> sysFieldValueMap = setUpdateSysFieldValue(userId);
		Class<?> cla = getClass();
		Field[] beanFields = cla.getDeclaredFields();
		for (Field beanField : beanFields) {
			String fieldName = beanField.getName();
			if (null != sysFieldMap.get(fieldName)) {
				String setMethod = "set" + StringUtils.upperFirst(fieldName);
				try {
					Method method = this.getClass().getMethod(setMethod, beanField.getType());
					method.invoke(this, new Object[] { sysFieldValueMap.get(fieldName) });
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * app修改记录初始化系统字段操作
	 */
	/*public  void updateInit( ) {
		Map<String, String> sysFieldMap = setUpdateSysField();
		Map<String, Object> sysFieldValueMap = setUpdateSysFieldValue();
		Class<?> cla = getClass();
		Field[] beanFields = cla.getDeclaredFields();
		for (Field beanField : beanFields) {
			String fieldName = beanField.getName();
			if (null != sysFieldMap.get(fieldName)) {
				String setMethod = "set" + StringUtils.upperFirst(fieldName);
				try {
					Method method = this.getClass().getMethod(setMethod, beanField.getType());
					method.invoke(this, new Object[] { sysFieldValueMap.get(fieldName) });
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}*/

	/**
	 * 修改记录初始化的系统字段
	 * @return
	 */
	private Map<String, String> setUpdateSysField() {
		Map<String, String> sysFieldMap = new HashMap<String, String>();
		sysFieldMap.put("updateUserId", "updateUserId");
		sysFieldMap.put("updateDate", "updateDate");
		return sysFieldMap;
	}

	/**
	 * 修改记录初始化的系统字段
	 * @return
	 */
	/*private Map<String, Object> setUpdateSysFieldValue() {
		Map<String, Object> sysFieldValueMap = new HashMap<String, Object>();
		Session session = SecurityUtils.getSubject().getSession();
		com.qm.fawfleet.sys.model.User loginUser = (com.qm.fawfleet.sys.model.User) session.getAttribute("user");
		int operID = loginUser.getId();
		Date currentDate = DateUtils.getSysTimestamp();// DateUtil.getDateString(DateUtil.YMD_DASH_WITH_SECONED);
		sysFieldValueMap.put("updateUserId", operID);
		sysFieldValueMap.put("updateDate", currentDate);
		return sysFieldValueMap;
	}*/
	/**
	 *app 修改记录初始化的系统字段
	 * @return
	 */
	private Map<String, Object> setUpdateSysFieldValue(String userId) {
		Map<String, Object> sysFieldValueMap = new HashMap<String, Object>();
		int operID = Integer.parseInt(userId);
		Date currentDate = DateUtils.getSysTimestamp();// DateUtil.getDateString(DateUtil.YMD_DASH_WITH_SECONED);
		sysFieldValueMap.put("updateUserId", operID);
		sysFieldValueMap.put("updateDate", currentDate);
		return sysFieldValueMap;
	}
	/**
	 * @description 复制字段
	 * @param from
	 * @param to
	 * @param excepts
	 * @return Object
	 * @history
	 *
	 */
	public static Object copyBean(Object from, Object to, HashMap<String, Object> excepts) {
		//除去系统字段
		if(excepts!=null){
			excepts.put("id","id");
			excepts.put("createDate","createDate");
			excepts.put("createUserId","createUserId");
			excepts.put("updateDate","updateDate");
			excepts.put("updateUserId","updateUserId");
		}
		Field[] tofields = to.getClass().getDeclaredFields();
		for (Field tofield : tofields) {
			boolean ifExcept = false;// 是否例外
			if (excepts != null) {// 如果集合不空
				if (excepts.get(tofield.getName()) != null) {// 并且可以取到该字段名
					ifExcept = true;// 例外
				}
			}
			if (!ifExcept) {// 如果不例外
				String upperFieldName = StringUtil.firstCharToUpCase(tofield.getName());
				try {
					Method fromMethod = from.getClass().getDeclaredMethod("get" + upperFieldName);
					Object fromValue = fromMethod.invoke(from);
					if (!tofield.getType().isInstance(fromValue)) {
						System.out.println(tofield.getName() + " need type:" + tofield.getType() + ",but now type is :"
								+ fromValue.getClass());
					}
					Method toMethod = to.getClass().getDeclaredMethod("set" + upperFieldName, tofield.getType());
					toMethod.invoke(to, fromValue);
				} catch (Exception e) {
					continue;
				}
			}
		}

		return to;
	}
}

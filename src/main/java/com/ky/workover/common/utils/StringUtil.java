package com.ky.workover.common.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author zhawk
 * 
 */
public class StringUtil {
	/**
	 * 判断字符串是否为null及空�?
	 *
	 * @param str
	 * @return 如果字符串为null或�?空白,返回true,反之返回false
	 */
	public static boolean isNullOrBlank(String str) {
		if (null == str)
			return true;
		else if ("".equals(str.trim()))
			return true;
		else if("null".equals(str.trim()))
			return true;
		else
			return false;
	}

	public static boolean isNOtNullAndBlank(String str) {
		return !isNullOrBlank(str);
	}

	/**
	 * 首字母大�?
	 * 
	 * @param s
	 * @return
	 */
	public static String firstCharToUpCase(String s) {
		// s = s.toLowerCase();
		s = s.substring(0, 1).toUpperCase() + s.substring(1);
		return s;
	}

	/**
	 * 首字母小�?
	 * 
	 * @param s
	 * @return
	 */
	public static String firstCharToLowerCase(String s) {
		// s = s.toLowerCase();
		s = s.substring(0, 1).toLowerCase() + s.substring(1);
		return s;
	}

	/**
	 * 判断输入的字符串参数是否为空�?
	 * 
	 * @param args
	 *            输入的字�?
	 * @return true/false
	 */
	public static boolean validateNull(String args) {
		if (args == null || args.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断输入的字符串参数是否为空或�?�?null"字符,如果�?就返回target参数,如果不是,就返回source参数�?
	 */
	public static String chanageNull(String source, String target) {
		if (source == null || source.length() == 0 || source.equalsIgnoreCase("null")) {
			return target;
		} else {
			return source;
		}
	}

	/**
	 * 过滤<, >,\n 字符的方法�?
	 * 
	 * @param input
	 *            �?��过滤的字�?
	 * @return 完成过滤以后的字符串
	 */
	public static String filterHtml(String input) {
		if (input == null) {
			return null;
		}
		if (input.length() == 0) {
			return input;
		}
		input = input.replaceAll("&", "&amp;");
		input = input.replaceAll("<", "&lt;");
		input = input.replaceAll(">", "&gt;");
		input = input.replaceAll(" ", "&nbsp;");
		input = input.replaceAll("'", "&#39;");
		input = input.replaceAll("\"", "&quot;");
		return input.replaceAll("\n", "<br>");
	}

	/**
	 * Object的toString方法
	 * @param object
	 * @return
	 */
	public static String toString(Object object) {
		String s = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (null != object) {
			if (object instanceof java.util.Date) {
				s = sdf.format(((java.util.Date) object).getTime());
			} else if (object instanceof java.sql.Date) {
				s = sdf.format(((java.sql.Date) object).getTime());
			} else if (object instanceof java.sql.Time) {
				s = sdf.format(((java.sql.Time) object).getTime());
			} else if (object instanceof java.sql.Timestamp) {
				s = sdf.format(((java.sql.Timestamp) object).getTime());
			} else if (object instanceof String) {
				s = object.toString();
			} else {
				s = object.toString() == "" ? "0" : object.toString();
			}
		} else {
			if (object instanceof java.util.Date) {
				s = sdf.format(new java.util.Date().getTime());
			} else if (object instanceof java.sql.Date) {
				s = sdf.format(new java.sql.Date(System.currentTimeMillis()).getTime());
			} else if (object instanceof java.sql.Time) {
				s = sdf.format(new java.sql.Time(System.currentTimeMillis()).getTime());
			} else if (object instanceof java.sql.Timestamp) {
				s = sdf.format(new java.sql.Timestamp(System.currentTimeMillis()).getTime());
			} else if (object instanceof String) {
				s = "";
			} else if (object instanceof Boolean) {
				s = "false";
			} else {
				s = "0";
			}
		}
		return s;
	}

	/**
	 * 处理ojbect对象，当为空是返回自定义参数
	 * @param object
	 * @param defaultStr
	 * @return
	 */
	public static String toString(Object object,String defaultStr) {
		String s = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (null != object) {
			if (object instanceof java.util.Date) {
				s = sdf.format(((java.util.Date) object).getTime());
			} else if (object instanceof java.sql.Date) {
				s = sdf.format(((java.sql.Date) object).getTime());
			} else if (object instanceof java.sql.Time) {
				s = sdf.format(((java.sql.Time) object).getTime());
			} else if (object instanceof java.sql.Timestamp) {
				s = sdf.format(((java.sql.Timestamp) object).getTime());
			} else if (object instanceof String) {
				s = object.toString();
			} else {
				s = object.toString() == "" ? "0" : object.toString();
			}
		} else {
			return defaultStr;
		}
		return s;
	}
	public static String valueOf(Object object) {
		return toString(object);
	}

	/**
	 * 获取字符串中 split 字符之前(不包split)的内
	 * 
	 */
	public static String getSplitBefore(String sourceStr, int split) {
		return sourceStr.substring(0, sourceStr.lastIndexOf(split));
	}

	/**
	 * 获取字符串中split 字符 及其后面的内�?通常用于获取文件后缀"
	 * 
	 */
	public static String getSplitWithAfter(String sourceStr, int split) {
		return sourceStr.substring(sourceStr.lastIndexOf(split));
	}

	/**
	 * 获取两个字符之间的内�?
	 * 
	 */
	public static String getSplitsBetween(String sourceStr, int fSplit,
			int sSplit) {
		return sourceStr.substring(sourceStr.lastIndexOf(fSplit) + 1, sourceStr
				.lastIndexOf(sSplit));
	}

	public static String getSelString(String s) {
		s = s.trim();
		String returnString = "%";
		for (int i = 0; i < s.length(); i++) {
			returnString = returnString + s.substring(i, i + 1) + "%";
		}
		return returnString;
	}

	public static String[] split(String s, String regex) {
		if (s.endsWith(regex))
			s = s.substring(0, s.length() - regex.length());
		if (s.startsWith(regex))
			s = s.substring(regex.length());
		return s.split(regex);
	}

	/**
	 * 从一个JSON对象取得Map
	 */
	@SuppressWarnings("unchecked")
	/*public static Map<String, Object> getMap4Json(String jsonString) {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		Iterator<String> keyIter = jsonObject.keys();

		String key;

		Object value;

		Map<String, Object> valueMap = new HashMap<String, Object>();

		while (keyIter.hasNext()) {

			key = (String) keyIter.next();

			value = jsonObject.get(key);

			valueMap.put(key, value);

		}

		return valueMap;
	}*/

	public static String regEnter(String s) {
		String reg = "[\n-\r]+";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(s);

		return m.replaceAll("<br>");
	}

	public static String urlForAndroid(String url) {
		if (isNOtNullAndBlank(url)) {
			String action = url.substring(0, url.indexOf("!"));
			String method = url.substring(url.indexOf("!") + 1, url.indexOf("."));
			return action + "!andr" + firstCharToUpCase(method) + ".action";
		} else {
			return "";
		}
	}

	public static String urlAddAndr(String url) {
		if (isNOtNullAndBlank(url)) {
			if (url.indexOf("?") > 0) {
				return url + "&andr=1";
			} else {
				return url + "?andr=1";
			}
		} else {
			return "";
		}
	}
	//格式字符串为long
	public static Long parseLong(Object lo) {
		if (null==lo) {
			return new Long(0);
		} else {
			return Long.parseLong(String.format("%s", lo));
		}
	}
	//格式字符串为Double
	public static double parseDouble(Object dou) {
		if (null==dou) {
			return Double.parseDouble(String.format("%.2f",0.00));
		} else {
			return Double.parseDouble(String.format("%.2f",dou));
		}
	}
    public static double parseDoubleUp(Object dou){
        if (null==dou) {
            return Double.parseDouble(String.format("%.2f",0.00));
        } else {
            return new BigDecimal(toString(dou)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        }

    }
	//格式字符串为int
	public static int parseInt(Object inter) {
		if (null==inter) {
			return new Integer(0);
		} else {
			return Integer.parseInt(String.format("%s", inter));
		}
	}

	public static void main(String[] args) {
		Double s =88.666;
		System.out.println(parseDoubleUp(s/1000));
	}
}

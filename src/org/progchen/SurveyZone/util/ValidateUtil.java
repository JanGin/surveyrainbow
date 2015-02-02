package org.progchen.SurveyZone.util;

import java.util.Collection;

/*
 * 注册校验工具类
 */
public class ValidateUtil {

	//验证字符串是否有效
	public static boolean isValid(String str){
		if (str == null || "".equals(str.trim())){
			return false;
		}
		return true;
	}
	
	//判断集合的有效性
	public static boolean isValid(Collection<?> coll){
		if (coll == null || coll.isEmpty()){
			return false;
		}
		return true;
		
	}
}

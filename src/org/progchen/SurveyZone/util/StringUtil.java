package org.progchen.SurveyZone.util;

public class StringUtil {

	public static String[] splitOptions(String str, String tag){
		if (ValidateUtil.isValid(str)){
			return str.split(tag);
		}
		return null;
	}
}

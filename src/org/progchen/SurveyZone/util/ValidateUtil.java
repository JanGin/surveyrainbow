package org.progchen.SurveyZone.util;

import java.util.Collection;

/*
 * ע��У�鹤����
 */
public class ValidateUtil {

	//��֤�ַ����Ƿ���Ч
	public static boolean isValid(String str){
		if (str == null || "".equals(str.trim())){
			return false;
		}
		return true;
	}
	
	//�жϼ��ϵ���Ч��
	public static boolean isValid(Collection<?> coll){
		if (coll == null || coll.isEmpty()){
			return false;
		}
		return true;
		
	}
}

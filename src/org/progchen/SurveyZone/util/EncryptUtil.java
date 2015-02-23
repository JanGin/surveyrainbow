package org.progchen.SurveyZone.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

	public static String encrypt(String src) throws NoSuchAlgorithmException{
		StringBuilder sb = new StringBuilder();
		MessageDigest digest = MessageDigest.getInstance("MD5");
		char[] character = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		byte[] destination = digest.digest(src.getBytes());
		for (byte b : destination){
				sb.append(character[(b >> 4) & 0x0f]);
				sb.append(character[b & 0x0f]);
		}
		return sb.toString();
	}
}

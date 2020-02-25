package io.utility.letter;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodingUtility {

	public static String decodingEucjp(String strEn) throws UnsupportedEncodingException{

		String strDe = null;

		// Exchange decoding
		strDe = URLDecoder.decode (strEn, "8859_1");
		strDe = new String (strEn.getBytes("8859_1"), "EUC-JP");

		return strDe;
	}

	public static String encodingEucjp(String strEn) throws UnsupportedEncodingException{

		String strDe = null;

		// Exchange encoding
		strDe = URLEncoder.encode(strEn, "EUC-JP");

		return strDe;
	}

	public static String encodingUtf(String strEn) throws UnsupportedEncodingException{

		String strDe = null;

		// Exchange encoding
		strDe = URLEncoder.encode(strEn, "UTF-8");

		return strDe;
	}

}

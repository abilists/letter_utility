package io.utility.letter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigitalUtility {

	public static final String createDigestByIdentity(String identity) 
			throws NoSuchAlgorithmException { 
		String result = null;

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(identity.getBytes());
		byte[] digest = md.digest();
		result = toHexString(digest, false);

		return result;

	}

	private static final String toHexString(byte[] data, boolean upper) {
		StringBuffer result = new StringBuffer();

		for(int index = 0 ; data.length > index ; index++) {
			int n = data[index] & 0xff;
			String digest = upper ? Integer.toHexString(n).toUpperCase() : Integer.toHexString(n).toLowerCase();
			if(digest.length() == 1)
				digest = "0" + digest;
			result.append(digest);
		}

		return result.toString();
	}

}
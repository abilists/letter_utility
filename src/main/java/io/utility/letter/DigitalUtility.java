package io.utility.letter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class DigitalUtility {

	// Reuse one SecureRandom instance to avoid re-seeding delay
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static int SECURE_RANDOM_BYTE_SIZE512 = 512;
    public static int SECURE_RANDOM_BYTE_SIZE256 = 256;
    public static int SECURE_RANDOM_BYTE_SIZE128 = 128;
    public static int SECURE_RANDOM_BYTE_SIZE64 = 64;
	public static String HASH_ALGORITHM_MD5 = "MD5";
	public static String HASH_ALGORITHM_SHA256 = "SHA-256";

    /**
     * Convert byte array to HEX string.
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

	public static final String createDigestByIdentity(final String identity) 
			throws NoSuchAlgorithmException {
		return DigitalUtility.createDigestByIdentity(identity, HASH_ALGORITHM_MD5);
	}

	public static final String createDigestByIdentity(final String identity, String algorithm) 
			throws NoSuchAlgorithmException { 
		String result = null;

		MessageDigest md = MessageDigest.getInstance(algorithm);
		md.update(identity.getBytes(StandardCharsets.UTF_8));
		byte[] digest = md.digest();
		result = toHexString(digest, false);

		return result;
	}

	public static final String toHexString(byte[] data, boolean upper) {
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

	public static String encodeByBase64(final String identity) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM_SHA256);
		md.update(identity.getBytes(StandardCharsets.UTF_8));
		byte[] digest = md.digest();
        return Base64.getEncoder().encodeToString(digest);
	}

    public static String hashBySha256(String input) {
        try {
            // Get a SHA-256 digest instance
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM_SHA256);

            // Hash the input
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Convert the byte array to a hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found!", e);
        }
    }

    // Generate a 1024-bit(128) cryptographically secure token
    public static String generateToken(int intByte) throws NoSuchAlgorithmException {
        byte[] randomBytes = new byte[intByte];
        SECURE_RANDOM.nextBytes(randomBytes);

        return bytesToHex(randomBytes);
    }

}
package io.utility.letter;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.SecretKey;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.jsonwebtoken.Jwts;

public class DigitalUtilityTest {
	private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

	@BeforeClass
	public static void beforeClass() {
		System.out.println("This is the first excuted");
	}

	@Before
	public void before() {
		System.out.println("Before");
	}
	public static String generateNewToken() {
	    byte[] randomBytes = new byte[64];
	    secureRandom.nextBytes(randomBytes);
	    return base64Encoder.encodeToString(randomBytes);
	}
	// @Test
	public void testCreateDigestByIdentity() {
		
		try {
			String diges = DigitalUtility.createDigestByIdentity("admin");
			System.out.println("diges => " + diges);
			
			System.out.println(">>>>" + System.currentTimeMillis());

			String sha256 = DigitalUtility.hashBySha256("admin");
			System.out.println("sha256 >>>>" + sha256);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void testCreateDigestByIdentity2() {

		String strTime = String.valueOf(System.currentTimeMillis());
		
		try {
			String diges = DigitalUtility.createDigestByIdentity("admin", DigitalUtility.HASH_ALGORITHM_SHA256);
			System.out.println("SHA256 => " + diges);
			System.out.println("SHA256 size=> " + diges.length());

			String strBase64 = DigitalUtility.encodeByBase64("admin");
			System.out.println("strBase64 => " + strBase64);

			SecretKey key = Jwts.SIG.HS256.key().build();
			System.out.println("key = " + key.getEncoded().toString());

			String jws = Jwts.builder().subject("Joe").signWith(key).compact();
			System.out.println("jws = " + jws);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void generateTokenTest() {

		String diges;
		try {

			diges = DigitalUtility.generateToken(DigitalUtility.SECURE_RANDOM_BYTE_SIZE128);
			System.out.println("diges => " + diges);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@After
	public void after() {
		System.out.println("Before");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("This is the end excuted");
	}

}

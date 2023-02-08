package main.java.org.social.oop.hashing;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class PBKDF2Salt {
	
	public PBKDF2Salt() {
		
	}
	
	public static String hashing(String password, String salt) {
		
    	String securePassword = null;
		try {
			securePassword = getSecurePassword(password,salt);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return securePassword;
    }
	
	
	public static String getSalt() {
		
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		Base64.Encoder encoder = Base64.getEncoder();
		
		return encoder.encodeToString(salt);
	}
	
	
    private static String getSecurePassword(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {

    	Base64.Decoder decode = Base64.getDecoder();
    	KeySpec keySpec = new PBEKeySpec(password.toCharArray(), decode.decode(salt), 65536, 128);
    	SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); 
    	byte[] hash = factory.generateSecret(keySpec).getEncoded();
    	Base64.Encoder encoder = Base64.getEncoder();
    	
    	return encoder.encodeToString(hash);
    }
}

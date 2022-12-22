package org.social.oop.hashing;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class PBKDF2Salt 
{
	
	public String hash(String password, String salt) {
    	String securePassword = getSecurePassword(password,salt) ;
    	return securePassword;
    }
	
	
	public static String getSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		String s = new String(salt);
		return s;
	}
	
	
    private static String getSecurePassword(String password, String salt) {
    	
    	KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 128);
    	SecretKeyFactory factory = null;
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	byte[] hash = null;
		try {
			hash = factory.generateSecret(spec).getEncoded();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Base64.Encoder enc = Base64.getEncoder();
    	return enc.encodeToString(hash);
    }
}
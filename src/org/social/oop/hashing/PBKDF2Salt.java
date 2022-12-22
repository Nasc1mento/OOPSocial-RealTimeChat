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
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < salt.length; i++ ) {
			sb.append(Integer.toString((salt[i] & 0xff) + 0x100, 16 ).substring(1));
		}
		
		return sb.toString();
	}
	
	
    private static String getSecurePassword(String password, String salt) {
    	
    	byte[] ans = new byte[salt.length()/2];
		
		for(int i = 0; i < ans.length; i++) {
			int index = i*2;
			int val = Integer.parseInt(salt.substring(index,index+2),16);
			ans[i] = (byte)val;
		}
    	
    	
    	
    	KeySpec spec = new PBEKeySpec(password.toCharArray(), ans, 65536, 128);
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

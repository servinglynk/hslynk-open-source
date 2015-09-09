package com.servinglynk.hmis.warehouse.common.security;


import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;


@SuppressWarnings("restriction")
public final class HMISCryptographer
{
	public static String Encrypt(String plaintext) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} //step 1
		
		try {
			md.update(plaintext.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} //step 2
		
		byte raw[] = md.digest(); //step 3
	    String hash = (new BASE64Encoder()).encode(raw); //step 4
	    return hash; //step 5
  
	}
	
	 
	public static String EncryptTwonkyUrl(String mediaUrl,String strkey) throws Exception {
        String salt = "openssl.";
        //String strkey = "this_is_a_passphrase";
        
        String newVal = strkey+salt;
        
        MessageDigest digester = MessageDigest.getInstance("MD5");    
        char[] password = newVal.toCharArray();
        for (int i = 0; i < password.length; i++) {
        	digester.update((byte) password[i]);
        }
        byte[] passwordData = digester.digest();
        byte[] key = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.arraycopy(passwordData, 0, key, 0, 16);
        //KEY -END
       
        MessageDigest digester2 = MessageDigest.getInstance("MD5");
        char[] password2 =  newVal.toCharArray();
       
        for (int i = 0; i < key.length; i++) {
    	   digester2.update(key[i]);
        }
       
        for (int i = 0; i < password2.length; i++) {
    	   digester2.update((byte) password2[i]);
        }
      
        byte[] passwordData2 = digester2.digest();
        byte[] iv2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
      
        System.arraycopy(passwordData2, 0, iv2, 0, 16);
        // IV -END
        
        Key secretkey = new SecretKeySpec(key, "AES");
        IvParameterSpec ivspec = new IvParameterSpec(iv2);
        // initialize the cipher for encrypt mode
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, secretkey, ivspec);
        // encrypt the message        
        
        byte[] encrypted = cipher.update(mediaUrl.getBytes());
        int nElen = encrypted.length;
        
        byte[] encrypted1 = cipher.update("\n".getBytes());       
        int nElen1 = encrypted1.length;
        
        byte[] encrypted2 = cipher.doFinal();      
        int nElen2 = encrypted2.length;
        
        byte [] result = new byte[nElen+nElen1+nElen2];
        
        System.arraycopy(encrypted, 0, result, 0, encrypted.length);
       
        System.arraycopy(encrypted1, 0, result, encrypted.length, encrypted1.length);
     
        System.arraycopy(encrypted2, 0, result, nElen+nElen1, encrypted2.length);
        
        BASE64Encoder base64Encoder =  new BASE64Encoder(){
        	protected void encodeBufferSuffix(OutputStream aStream) throws IOException {}
        	protected void encodeLineSuffix(OutputStream aStream){}
        };
        String hash = base64Encoder.encode(result);
        return hash;
	}
}

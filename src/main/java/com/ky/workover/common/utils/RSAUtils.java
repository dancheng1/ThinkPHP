package com.ky.workover.common.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.HashMap;
import java.util.Map;

public class RSAUtils {

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.err.println("Usage: java PublicExample text");
			System.exit(1);
		}
		byte[] plainText = args[0].getBytes("UTF8");
		Map<String, Object> keyMap = getRSAKeyPair();
		PublicKey publicKey = (PublicKey)keyMap.get("publicKey");
		PrivateKey privateKey = (PrivateKey)keyMap.get("privateKey");
		
		Cipher cipher = getCipher();
		
		byte[] cipherText = RSAEncrypt(plainText, publicKey, cipher);
		
		RSADecrypt(privateKey, cipher, cipherText);
	}

	// 使用私钥对加密密文进行解密
	public static void RSADecrypt(PrivateKey privateKey, Cipher cipher,
			byte[] cipherText) throws InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException,
			UnsupportedEncodingException {
		System.out.println("\nStart decryption");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] newPlainText = cipher.doFinal(cipherText);
		System.out.println("Finish decryption: ");
		System.out.println(new String(newPlainText, "UTF8"));
	}

	// 使用公钥对明文进行加密
	public static byte[] RSAEncrypt(byte[] plainText, PublicKey publicKey,
			Cipher cipher) throws InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException,
			UnsupportedEncodingException {
		System.out.println("\nStart encryption");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] cipherText = cipher.doFinal(plainText);
		System.out.println("Finish encryption: ");
		System.out.println(new String(cipherText, "UTF8"));
		return cipherText;
	}

	// 获取RSA cipher 对象，同时打印输出算法的提供者
	public static Cipher getCipher() throws NoSuchAlgorithmException,
			NoSuchPaddingException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		System.out.println("\n" + cipher.getProvider().getInfo());
		return cipher;
	}
	
	
	public static Map<String, Object> getRSAKeyPair()
			throws NoSuchAlgorithmException {
		Map<String, Object> keyMap = new HashMap<String, Object>();
		// 生成RAS密钥
		System.out.println("\nStart generating RSA key");
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(1024);
		KeyPair key = keyGen.generateKeyPair();
		PublicKey publicKey = key.getPublic();
		PrivateKey privateKey = key.getPrivate();
		System.out.println("公钥 : " + publicKey.toString());
		System.out.println("私钥: " + privateKey.toString());
		System.out.println("Finish generating RSA key");
		keyMap.put("publicKey", publicKey);
		keyMap.put("privateKey", privateKey);
		return keyMap;
	}
}

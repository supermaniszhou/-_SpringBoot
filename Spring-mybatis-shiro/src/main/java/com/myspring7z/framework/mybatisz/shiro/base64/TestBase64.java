package com.myspring7z.framework.mybatisz.shiro.base64;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class TestBase64 {
	public static void main(String[] args) {
		String str="hello";
		//加密
		String base64Encoded=Base64.encodeToString(str.getBytes());
		System.out.println("base64Encoded:"+base64Encoded);
		//解码
		String str2=Base64.decodeToString(base64Encoded);
		System.out.println("str2:"+str2);
		
		String str16="hello";
		String base64Encoded16=Hex.encodeToString(str.getBytes());
		System.out.println("base64Encoded16:"+base64Encoded16);
		String str16_2=new String(Hex.decode(base64Encoded16.getBytes()));
		System.out.println("str16_2:"+str16_2);
		System.out.println();
		
		String strMd5 = "hello";  
		String salt = "123";  
		//md5
		String md5 = new Md5Hash(strMd5, salt).toString();//还可以转换为 toBase64()/toHex()  
		System.out.println("md5:"+md5);
		System.out.println();
		
		//SHA256
		String strSha1 = "hello";  
		String saltSha1 = "123";  
		String sha256 = new Sha256Hash(strSha1, saltSha1).toString();   
		System.out.println("sha1:"+sha256);
		
		//另外还有如SHA1、SHA512算法
		System.out.println();
		
		//Shiro还提供了通用的散列支持
		String strSimple = "a96507389";  
		String saltSimple = "123";  
		//内部使用MessageDigest  
		//SHA-1 MD5
		//[C@d455f0c
		String simpleHash = new SimpleHash("SHA-1", strSimple, saltSimple).toString(); 
		System.out.println("simpleHash:"+simpleHash);
	}
}

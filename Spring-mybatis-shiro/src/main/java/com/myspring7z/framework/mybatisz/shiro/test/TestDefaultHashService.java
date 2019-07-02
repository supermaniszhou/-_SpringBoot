package com.myspring7z.framework.mybatisz.shiro.test;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

public class TestDefaultHashService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultHashService hashService = new DefaultHashService(); //默认算法SHA-512  
		//hashService.setHashAlgorithmName("SHA-512");  
		hashService.setPrivateSalt(new SimpleByteSource("123")); //私盐，默认无  
		hashService.setGeneratePublicSalt(true);//是否生成公盐，默认false  
		hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());//用于生成公盐。默认就这个  
		//hashService.setHashIterations(1); //生成Hash值的迭代次数  
		  
		HashRequest request = new HashRequest.Builder()  
		            .setAlgorithmName("MD5").setSource(ByteSource.Util.bytes("hello"))  
		            .setSalt(ByteSource.Util.bytes("123")).setIterations(2).build();  
		String hex = hashService.computeHash(request).toHex();
		
		System.out.println("hex:"+hex);
	}

}

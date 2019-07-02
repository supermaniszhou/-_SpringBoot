package com.myspring7z.framework.designpattern.duck;

public class MuteQuack implements QuackBehavior{
	public void quack(){
		System.out.println("<<Silence>>");
	}
}

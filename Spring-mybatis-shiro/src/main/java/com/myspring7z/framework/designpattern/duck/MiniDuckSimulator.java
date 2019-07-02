package com.myspring7z.framework.designpattern.duck;

public class MiniDuckSimulator {
	public static void main(String[] args) {
		Duck modelDuck=new ModelDuck();
		modelDuck.performQuack();
		modelDuck.performFly();
	}
}

package com.dmitrydrobysh.app;

public class Horse implements IAction{
	String name;
	boolean normalFlag;

	public Horse(String name, boolean normalFlag){
		this.name = name;
		this.normalFlag = normalFlag;
	}

	public String getName(){
		return this.name;
	}

	public boolean isNormal(){
		return this.normalFlag;
	}

	@Override
	public String doAction(){
		return this.name + " Is transporting goods across the sky";
	}
}
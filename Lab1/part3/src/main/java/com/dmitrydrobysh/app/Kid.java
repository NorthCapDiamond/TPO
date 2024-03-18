package com.dmitrydrobysh.app;

public class Kid implements IAction{
	String name;
	boolean normalFlag;

	public Kid(String name, boolean normalFlag){
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
		return this.name + " Is jumping on the sand";
	}
}
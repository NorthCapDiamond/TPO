package com.dmitrydrobysh.app;

public class Watcher{
	String name;
	int counter = 0;
	int limit;


	public Watcher(String name, int limit){
		if (limit < 0){
			limit = 0;
		}
		this.name = name;
		this.limit = limit;
	}

	public void watchFor(String something, boolean isNormal){
		if(isNormal){
			System.out.println(this.name + " Is watching for the * " + something + " ");
			return;
		}
		counter++;

		if(counter > limit){
			System.out.println(this.name + " Is NERVOUS, but watching for the * " + something + " ");
			return;
		}

		System.out.println(this.name + " Is watching for the * " + something + " ");
	}

	public int getLimit(){
		return limit;
	}

	public String getName(){
		return this.name;
	}
}
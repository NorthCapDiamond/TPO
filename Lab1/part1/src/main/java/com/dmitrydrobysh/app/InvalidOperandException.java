package com.dmitrydrobysh.app;

public class InvalidOperandException extends Exception{
	public InvalidOperandException(String errorMessage){
		super(errorMessage);
	}
}
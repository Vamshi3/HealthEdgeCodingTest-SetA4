package com.teksys.poc.testj4;

public class NegativeNumException extends Exception {
	
	public NegativeNumException(int arg){
		super("Negative number exception for "+arg);
	}

}

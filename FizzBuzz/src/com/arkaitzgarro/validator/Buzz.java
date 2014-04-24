package com.arkaitzgarro.validator;

public class Buzz {
	private final String output = "Buzz";
	
	public boolean validate(int num) {
		return num % 5 == 0;
	}
	
	public String getOutput() {
		return this.output;
	}
}

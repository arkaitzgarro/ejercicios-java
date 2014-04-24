package com.arkaitzgarro.validator;

public class Fizz {
	private final String output = "Fizz";
	
	public boolean validate(int num) {
		return num % 3 == 0;
	}
	
	public String getOutput() {
		return this.output;
	}
}

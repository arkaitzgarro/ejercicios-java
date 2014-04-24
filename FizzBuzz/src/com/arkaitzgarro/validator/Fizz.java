package com.arkaitzgarro.validator;

import com.arkaitzgarro.interfaces.IValidator;

public class Fizz extends BaseValidator implements IValidator {
	private final String output = "Fizz";
	
	public boolean validate(int num) {
		return num % 3 == 0;
	}
	
	public String getOutput() {
		return this.output;
	}
}

package com.arkaitzgarro.validator;

import com.arkaitzgarro.interfaces.IValidator;

public class Buzz extends BaseValidator implements IValidator {
	private final String output = "Buzz";
	
	public boolean validate(int num) {
		return num % 5 == 0;
	}
	
	public String getOutput() {
		return this.output;
	}
}

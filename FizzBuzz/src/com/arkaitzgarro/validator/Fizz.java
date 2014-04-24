package com.arkaitzgarro.validator;

import com.arkaitzgarro.interfaces.IValidator;

public class Fizz extends BaseValidator implements IValidator {
	
	/*public Fizz() {
		this.setOutput("Fizz");
	}*/
	
	public boolean validate(int num) {
		return num % 3 == 0;
	}
}

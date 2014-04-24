package com.arkaitzgarro.validator;

import com.arkaitzgarro.interfaces.IValidator;

public class Buzz extends BaseValidator implements IValidator {
	
	/*public Buzz() {
		this.setOutput("Buzz");
	}*/
	
	public boolean validate(int num) {
		return num % 5 == 0;
	}
}

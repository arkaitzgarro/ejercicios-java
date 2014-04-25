package com.arkaitzgarro.validator;

import com.arkaitzgarro.exception.NumberNotValidException;
import com.arkaitzgarro.interfaces.IValidator;

public class Mozz extends BaseValidator implements IValidator {
	
	/*public Buzz() {
		this.setOutput("Buzz");
	}*/
	
	public boolean validate(int num) throws NumberNotValidException {
		this.validateException(num);
		
		return num % 7 == 0;
	}
}

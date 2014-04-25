package com.arkaitzgarro.validator;

import com.arkaitzgarro.exception.NumberNotValidException;
import com.arkaitzgarro.interfaces.IValidator;

public class Fizz extends BaseValidator implements IValidator {
	
	/*public Fizz() {
		this.setOutput("Fizz");
	}*/
	
	public boolean validate(int num) throws NumberNotValidException {
		this.validateException(num);
		
		return num % 3 == 0;
	}
}

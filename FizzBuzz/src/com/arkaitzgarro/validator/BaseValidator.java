package com.arkaitzgarro.validator;

import com.arkaitzgarro.exception.NumberNotValidException;
import com.arkaitzgarro.interfaces.IValidator;

public abstract class BaseValidator implements IValidator {

	protected String output;
	
	@Override
	public abstract boolean validate(int num) throws NumberNotValidException;
	
	protected void validateException(int num) throws NumberNotValidException {
		if(num < 1) {
			throw new NumberNotValidException("Nœmero no v‡lido: es menor que 1.");
		}
	}

	@Override
	public String getOutput() {
		return this.output;
	}
	
	@Override
	public void setOutput(String output) {
		this.output = output;
	}
}

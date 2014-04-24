package com.arkaitzgarro.validator;

import com.arkaitzgarro.interfaces.IValidator;

public abstract class BaseValidator implements IValidator {

	protected String output;
	
	@Override
	public abstract boolean validate(int num);

	@Override
	public String getOutput() {
		return this.output;
	}
	
	@Override
	public void setOutput(String output) {
		this.output = output;
	}
}

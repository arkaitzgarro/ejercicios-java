package com.arkaitzgarro.factories;

import com.arkaitzgarro.validator.Buzz;
import com.arkaitzgarro.validator.Fizz;
import com.arkaitzgarro.validator.Mozz;

public abstract class ValidatorFactory {

	public static final Fizz getFizzValidator() {
		Fizz f = new Fizz();
		f.setOutput("Fizz");
		
		return f;
	}
	
	public static final Buzz getBuzzValidator() {
		Buzz b = new Buzz();
		b.setOutput("Buzz");
		
		return b;
	}
	
	public static final Mozz getMozzValidator() {
		Mozz m = new Mozz();
		m.setOutput("Mozz");
		
		return m;
	}
}

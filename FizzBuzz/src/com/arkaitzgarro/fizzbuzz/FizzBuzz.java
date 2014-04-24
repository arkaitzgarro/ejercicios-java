package com.arkaitzgarro.fizzbuzz;

import com.arkaitzgarro.validator.Buzz;
import com.arkaitzgarro.validator.Fizz;

public class FizzBuzz {
	
	Fizz f = new Fizz();
	Buzz b = new Buzz();
	
	public String print(int num) {
		StringBuffer str = new StringBuffer();
		
		for(int i=1; i<=num; i++) {
			str.append(this.testNumber(i));
			if(i != num) {
				str.append(" ");
			}
		}
		
		return str.toString();
	}
	
	public String testNumber(int num) {
		StringBuffer str = new StringBuffer();
		
		if(f.validate(num)) {
			str.append(f.getOutput());
		}
		
		if(b.validate(num)) {
			str.append(b.getOutput());
		}
		
		if(str.length() == 0) {
			str.append(String.valueOf(num));
		}
		
		return str.toString();
	}
}

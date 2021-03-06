package com.arkaitzgarro.fizzbuzz;

import java.util.ArrayList;

import com.arkaitzgarro.exception.NumberNotValidException;
import com.arkaitzgarro.interfaces.IValidator;
import com.arkaitzgarro.validator.Fizz;

public class FizzBuzz {
	
	ArrayList<IValidator> validators = new ArrayList<IValidator>();
	
	/**
	 * Print FizzBuzz complete list
	 * @param num
	 * @param params
	 * @return
	 */
	public String print(int num, String... params) {
		StringBuffer str = new StringBuffer();
		String glue = (params.length > 0) ? params[0] : " ";
		
		for(int i=1; i<=num; i++) {
			str.append(this.testNumber(i));
			if(i != num) {
				str.append(glue);
			}
		}
		
		return str.toString();
	}
	
	/**
	 * Test if the number pass a validator
	 * @param num
	 * @return
	 */
	public String testNumber(int num) {
		StringBuffer str = new StringBuffer();
		
		for(IValidator v : this.validators) {
			try {
				if(v.validate(num)) {
					str.append(v.getOutput());
				}
			} catch (NumberNotValidException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(str.length() == 0) {
			str.append(String.valueOf(num));
		}
		
		return str.toString();
	}
	
	/**
	 * Add a new validator
	 */
	public void addValidator(IValidator v) {
		if(!this.validators.contains(v)) {
			this.validators.add(v);
		}
	}
}

package com.arkaitzgarro.fizzbuzz;

public class FizzBuzz {
	
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
		if((num % 3 == 0) && (num % 5 == 0)) {
			return "FizzBuzz";
		} else if(num % 3 == 0) {
			return "Fizz";
		} else if(num % 5 == 0) {
			return "Buzz";
		} else {
			return String.valueOf(num);
		}
	}
}

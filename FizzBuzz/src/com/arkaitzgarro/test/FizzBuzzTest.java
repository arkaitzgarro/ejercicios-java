package com.arkaitzgarro.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.arkaitzgarro.fizzbuzz.FizzBuzz;

public class FizzBuzzTest {

	FizzBuzz fb;
	
	@Before
	public void setUp() throws Exception {
		fb = new FizzBuzz();
	}

	@Test
	public void testNumber() {
		assertEquals("FizzBuzz 1", "1", fb.testNumber(1));
		assertEquals("FizzBuzz 2", "2", fb.testNumber(2));
		assertEquals("FizzBuzz 3", "Fizz", fb.testNumber(3));
		assertEquals("FizzBuzz 4", "4", fb.testNumber(4));
		assertEquals("FizzBuzz 5", "Buzz", fb.testNumber(5));
		assertEquals("FizzBuzz 7", "7", fb.testNumber(7));
		assertEquals("FizzBuzz 9", "Fizz", fb.testNumber(9));
		assertEquals("FizzBuzz 10", "Buzz", fb.testNumber(10));
		assertEquals("FizzBuzz 15", "FizzBuzz", fb.testNumber(15));
	}
	
	@Test
	public void testPrint() {
		assertEquals("FizzBuzz 1", "1", fb.print(1));
		assertEquals("FizzBuzz 2", "1 2", fb.print(2));
		assertEquals("FizzBuzz 3", "1 2 Fizz", fb.print(3));
		assertEquals("FizzBuzz 4", "1 2 Fizz 4", fb.print(4));
		assertEquals("FizzBuzz 5", "1 2 Fizz 4 Buzz", fb.print(5));
		assertEquals("FizzBuzz 7", "1 2 Fizz 4 Buzz Fizz 7", fb.print(7));
		assertEquals("FizzBuzz 15", "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz", fb.print(15));
	}

}

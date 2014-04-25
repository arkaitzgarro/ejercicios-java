package com.arkaitzgarro.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.arkaitzgarro.exception.NumberNotValidException;
import com.arkaitzgarro.factories.ValidatorFactory;
import com.arkaitzgarro.fizzbuzz.FizzBuzz;
import com.arkaitzgarro.interfaces.IValidator;
import com.arkaitzgarro.validator.Buzz;
import com.arkaitzgarro.validator.Fizz;
import com.arkaitzgarro.validator.Mozz;

public class FizzBuzzTest {

	FizzBuzz fb;
	Fizz f;
	Buzz b;
	Mozz m;
	
	@Before
	public void setUp() throws Exception {
		f = ValidatorFactory.getFizzValidator();
		b = ValidatorFactory.getBuzzValidator();
		m = ValidatorFactory.getMozzValidator();
		
		fb = new FizzBuzz();
		fb.addValidator(f);
		fb.addValidator(b);
		fb.addValidator(m);
	}
	
	@Test
	public void testFizz() {
		assertTrue(f instanceof IValidator);
		assertEquals("Fizz", "Fizz", f.getOutput());
		
		try {
			assertTrue(f.validate(3));
			assertTrue(f.validate(6));
			assertTrue(f.validate(9));
			assertTrue(f.validate(15));
			assertFalse(f.validate(1));
			assertFalse(f.validate(2));
			assertFalse(f.validate(5));
			assertFalse(f.validate(7));
		} catch (NumberNotValidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertTrue(f.validate(0));
		} catch(NumberNotValidException e) {
			assertTrue(e instanceof NumberNotValidException);
		}
	}
	
	@Test
	public void testBuzz() {
		assertTrue(b instanceof IValidator);
		assertEquals("Buzz", "Buzz", b.getOutput());
		
		try {
			assertTrue(b.validate(5));
			assertTrue(b.validate(10));
			assertTrue(b.validate(15));
			assertTrue(b.validate(30));
			assertFalse(b.validate(1));
			assertFalse(b.validate(2));
			assertFalse(b.validate(3));
			assertFalse(b.validate(7));
		} catch (NumberNotValidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertTrue(b.validate(0));
		} catch(NumberNotValidException e) {
			assertTrue(e instanceof NumberNotValidException);
		}
	}
	
	@Test
	public void testMozz() {
		assertTrue(m instanceof IValidator);
		assertEquals("Mozz", "Mozz", m.getOutput());
		
		try {
			assertTrue(m.validate(7));
			assertTrue(m.validate(14));
			assertTrue(m.validate(21));
			assertFalse(m.validate(1));
			assertFalse(m.validate(2));
			assertFalse(m.validate(3));
			assertFalse(m.validate(5));
		} catch (NumberNotValidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertTrue(m.validate(0));
		} catch(NumberNotValidException e) {
			assertTrue(e instanceof NumberNotValidException);
		}
	}

	@Test
	public void testNumber() {
		assertEquals("FizzBuzz 1", "1", fb.testNumber(1));
		assertEquals("FizzBuzz 2", "2", fb.testNumber(2));
		assertEquals("FizzBuzz 3", "Fizz", fb.testNumber(3));
		assertEquals("FizzBuzz 4", "4", fb.testNumber(4));
		assertEquals("FizzBuzz 5", "Buzz", fb.testNumber(5));
		assertEquals("FizzBuzz 7", "Mozz", fb.testNumber(7));
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
		assertEquals("FizzBuzz 7", "1 2 Fizz 4 Buzz Fizz Mozz", fb.print(7));
		assertEquals("FizzBuzz 15", "1 2 Fizz 4 Buzz Fizz Mozz 8 Fizz Buzz 11 Fizz 13 Mozz FizzBuzz", fb.print(15));
	}

}

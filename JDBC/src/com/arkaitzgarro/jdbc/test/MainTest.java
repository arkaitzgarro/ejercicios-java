package com.arkaitzgarro.jdbc.test;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import com.arkaitzgarro.jdbc.main.Main;

public class MainTest {
	
	private static Main main;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		main = new Main();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

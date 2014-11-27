package com.arkaitzgarro.ecommerce.catalog.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.arkaitzgarro.ecommerce.catalog.model.Currency;
import com.arkaitzgarro.ecommerce.catalog.model.Money;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.ICurrency;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IMoney;

public class MoneyTest {

	static IMoney price;
	static ICurrency euro;

	@BeforeClass
	public static void setUpClass() {
		euro = new Currency("Euro", "€");
		price = new Money(0, euro);
	}

	@Before
	public void setUp() throws Exception {
		price.setAmmount(0);
		;
	}

	@Test
	public void testPrecioNegativo() {
		price = new Money(-100, euro);
		assertEquals(0, price.getAmmount(), 0);

		price.setAmmount(-100);
		assertEquals(0, price.getAmmount(), 0);

		price.setAmmount(10);
		assertEquals(10, price.getAmmount(), 0);
	}
}

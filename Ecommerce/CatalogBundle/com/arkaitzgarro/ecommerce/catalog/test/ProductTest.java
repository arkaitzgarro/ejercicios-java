package com.arkaitzgarro.ecommerce.catalog.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.arkaitzgarro.ecommerce.catalog.model.Brand;
import com.arkaitzgarro.ecommerce.catalog.model.Currency;
import com.arkaitzgarro.ecommerce.catalog.model.Money;
import com.arkaitzgarro.ecommerce.catalog.model.Product;

public class ProductTest {

	Product p;
	Money precio;
	Currency euro;
	Brand apple;

	@Before
	public void setUp() {
		euro = new Currency("Euro", "€");
		precio = new Money(-100, euro);
		apple = new Brand("Apple");
		p = new Product("Apple", apple);
	}

	@Test
	public void testPrecioNegativo() {

		p.setPrice(-100);
		assertEquals(0, p.getPrice().getAmmount(), 0);

		p.setPrice(0);
		assertEquals(0, p.getPrice().getAmmount(), 0);

		p.setPrice(10);
		assertEquals(10, p.getPrice().getAmmount(), 0);

		p.setPrice(precio);
		assertEquals(0, p.getPrice().getAmmount(), 0);
	}

}

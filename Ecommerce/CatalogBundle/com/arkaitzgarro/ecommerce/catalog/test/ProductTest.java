package com.arkaitzgarro.ecommerce.catalog.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.arkaitzgarro.ecommerce.catalog.model.Brand;
import com.arkaitzgarro.ecommerce.catalog.model.Currency;
import com.arkaitzgarro.ecommerce.catalog.model.Money;
import com.arkaitzgarro.ecommerce.catalog.model.Product;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IBrand;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.ICurrency;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IMoney;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IPurchasable;

public class ProductTest {

	IPurchasable p;
	IMoney precio;
	ICurrency euro;
	IBrand apple;

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

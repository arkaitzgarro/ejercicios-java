package com.arkaitzgarro.ecommerce.cart.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.arkaitzgarro.ecommerce.cart.model.CartLine;
import com.arkaitzgarro.ecommerce.catalog.model.Brand;
import com.arkaitzgarro.ecommerce.catalog.model.Currency;
import com.arkaitzgarro.ecommerce.catalog.model.Money;
import com.arkaitzgarro.ecommerce.catalog.model.Product;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IBrand;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.ICurrency;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IMoney;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IPurchasable;

public class CartLineTest {

	static IPurchasable iphone;
	static IMoney price;
	static ICurrency euro;
	static IBrand apple;

	CartLine cl;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		euro = new Currency("Euro", "€");
		price = new Money(600, euro);
		apple = new Brand("Apple");
		iphone = new Product("Apple", apple);

		iphone.setPrice(price);
	}

	@Before
	public void setUp() throws Exception {
		cl = new CartLine(iphone, 5, null);
	}

	@Test
	public void tesGetTotals() {
		assertEquals(3000, cl.getTotalWithoutVAT(), 0);
		assertEquals(3630, cl.getTotalWithVAT(), 0);
	}

}

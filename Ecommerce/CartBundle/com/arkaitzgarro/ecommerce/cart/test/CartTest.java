package com.arkaitzgarro.ecommerce.cart.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.arkaitzgarro.ecommerce.cart.model.Cart;
import com.arkaitzgarro.ecommerce.catalog.model.Brand;
import com.arkaitzgarro.ecommerce.catalog.model.Currency;
import com.arkaitzgarro.ecommerce.catalog.model.Money;
import com.arkaitzgarro.ecommerce.catalog.model.Product;

public class CartTest {

	static Product iphone;
	static Money price;
	static Currency euro;
	static Brand apple;

	Cart cart;

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
		cart = new Cart();
	}

	@Test
	public void testAddProduct() {
		cart.addProduct(iphone, 5);
		assertEquals(3000, cart.getTotalWithoutVAT(), 0);
		assertEquals(3630, cart.getTotalWithVAT(), 0);

		cart.addProduct(iphone, 1);
		assertEquals(600, cart.getTotalWithoutVAT(), 0);
		assertEquals(726, cart.getTotalWithVAT(), 0);
	}

	@Test
	public void testRemoveProduct() {
		cart.addProduct(iphone, 5);

		assertEquals(1, cart.getNumLines());
		assertEquals(5, cart.getNumProducts());

		cart.removeProduct(iphone);

		assertEquals(0, cart.getNumLines());
		assertEquals(0, cart.getNumProducts());

		assertEquals(0, cart.getTotalWithoutVAT(), 0);
		assertEquals(0, cart.getTotalWithVAT(), 0);
	}

	@Test
	public void testUpdateQuantity() {
		cart.updateQuantity(iphone, 1);

		assertEquals(0, cart.getNumLines());
		assertEquals(0, cart.getNumProducts());

		assertEquals(0, cart.getTotalWithoutVAT(), 0);
		assertEquals(0, cart.getTotalWithVAT(), 0);

		cart.addProduct(iphone, 5);
		cart.updateQuantity(iphone, 1);

		assertEquals(1, cart.getNumLines());
		assertEquals(1, cart.getNumProducts());

		assertEquals(600, cart.getTotalWithoutVAT(), 0);
		assertEquals(726, cart.getTotalWithVAT(), 0);

		cart.updateQuantity(iphone, -5);

		assertEquals(1, cart.getNumLines());
		assertEquals(1, cart.getNumProducts());

		assertEquals(600, cart.getTotalWithoutVAT(), 0);
		assertEquals(726, cart.getTotalWithVAT(), 0);
	}

	@Test
	public void testEmptyCart() {
		cart.addProduct(iphone, 5);
		cart.empty();

		assertEquals(0, cart.getNumLines());
		assertEquals(0, cart.getNumProducts());

		assertEquals(0, cart.getTotalWithoutVAT(), 0);
		assertEquals(0, cart.getTotalWithVAT(), 0);
	}

}

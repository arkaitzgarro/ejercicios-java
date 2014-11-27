package com.arkaitzgarro.ecommerce.cart.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.arkaitzgarro.ecommerce.cart.model.Cart;
import com.arkaitzgarro.ecommerce.cart.model.Order;
import com.arkaitzgarro.ecommerce.cart.transformer.CartToOrderTransformer;
import com.arkaitzgarro.ecommerce.catalog.model.Brand;
import com.arkaitzgarro.ecommerce.catalog.model.Currency;
import com.arkaitzgarro.ecommerce.catalog.model.Money;
import com.arkaitzgarro.ecommerce.catalog.model.Product;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IBrand;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.ICurrency;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IMoney;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IProduct;

public class CartTest {

	static IProduct iphone, nexus;
	static IMoney price;
	static ICurrency euro;
	static IBrand apple, google;

	Cart cart;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		euro = new Currency("Euro", "€");

		price = new Money(600, euro);

		apple = new Brand("Apple");
		google = new Brand("Google");

		iphone = new Product("Apple", apple);
		nexus = new Product("Nexus S", google);

		iphone.setPrice(price);
		nexus.setPrice(price);
	}

	@Before
	public void setUp() throws Exception {
		cart = new Cart();
	}

	@Test
	public void testAddProduct() {
		iphone.setPrice(600);
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

		iphone.setPrice(600);

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

	@Test
	public void testTransformCartToOrder() {
		cart.addProduct(iphone, 1);
		cart.addProduct(nexus, 2);

		Order order = CartToOrderTransformer.transform(cart);

		assertEquals(2, order.getNumLines());
		assertEquals(3, order.getNumProducts());

		assertEquals(1800, order.getTotalWithoutVAT(), 0);

		cart.updateQuantity(iphone, 2);

		assertEquals(2, order.getNumLines());
		assertEquals(3, order.getNumProducts());

		assertEquals(1800, order.getTotalWithoutVAT(), 0);

		iphone.setPrice(500);

		assertEquals(1800, order.getTotalWithoutVAT(), 0);
	}

}

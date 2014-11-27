package com.arkaitzgarro.ecommerce.cart.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.arkaitzgarro.ecommerce.cart.model.Order;
import com.arkaitzgarro.ecommerce.cart.model.OrderLine;

public class OrderTest {

	Order order;
	OrderLine ol;

	@Before
	public void setUp() throws Exception {
		order = new Order();
	}

	@Test
	public void testCreate() {
		assertEquals(Order.Status.CREATED, order.getStatus());
	}
}

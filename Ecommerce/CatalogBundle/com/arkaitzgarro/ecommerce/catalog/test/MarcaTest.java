package com.arkaitzgarro.ecommerce.catalog.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.arkaitzgarro.ecommerce.catalog.model.Brand;
import com.arkaitzgarro.ecommerce.catalog.model.Product;
import com.arkaitzgarro.ecommerce.catalog.model.interfaces.IBrand;

public class MarcaTest {

	static IBrand brand;
	static Product p1, p2;

	@BeforeClass
	public static void setUpClass() {
		brand = new Brand("Google");
		p1 = new Product("Nexus 5", brand);
		p2 = new Product("Nexus 5", brand);
	}

	@Test
	public void testAddProducto() {
		brand.insertProduct(p1);
		assertEquals(1, brand.getProductCount());

		brand.insertProduct(p2);
		assertEquals(1, brand.getProductCount());
	}

}

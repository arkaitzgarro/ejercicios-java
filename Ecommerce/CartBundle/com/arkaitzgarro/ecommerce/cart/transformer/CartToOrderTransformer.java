package com.arkaitzgarro.ecommerce.cart.transformer;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.arkaitzgarro.ecommerce.cart.model.Cart;
import com.arkaitzgarro.ecommerce.cart.model.Order;
import com.arkaitzgarro.ecommerce.cart.model.OrderLine;
import com.arkaitzgarro.ecommerce.cart.model.interfaces.ILine;

public abstract class CartToOrderTransformer {

	public static Order transform(Cart cart) {

		Order order = new Order();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddSSS");
		order.setReference("WEB/" + sdf.format(new Date()));

		for (ILine line : cart.getLines()) {
			OrderLine ol = new OrderLine(line.getProduct(), line.getQuantity(),
					order);

			order.addOrderLine(ol);
		}

		return order;
	}
}

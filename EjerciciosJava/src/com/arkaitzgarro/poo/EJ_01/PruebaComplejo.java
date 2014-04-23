package com.arkaitzgarro.poo.EJ_01;

public class PruebaComplejo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Complejo c1, c2, c3;

		c1 = new Complejo();
		c1.asignar(3.0, 5.0);
		System.out.println(c1.toString());

		c2 = new Complejo(1.0, 2.0);
		System.out.println(c2.toString());

		c1.sumar(c2);
		System.out.println(c1.toString());
		
		c3 = Complejo.sumar(c1, c2);
		System.out.println(c3.toString());

	}

}

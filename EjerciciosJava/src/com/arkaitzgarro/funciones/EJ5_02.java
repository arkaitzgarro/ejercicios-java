package com.arkaitzgarro.funciones;

public class EJ5_02 {

	/**
	 * Crear una función que tome como parámetro un número e indique si es
	 * primo o no.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("4 es primo: " + esPrimo(4));
		System.out.println("5 es primo: " + esPrimo(5));
		System.out.println("7 es primo: " + esPrimo(7));
		System.out.println("9 es primo: " + esPrimo(9));
	}

	/**
	 * Indica si un número es primo
	 * 
	 * @param n
	 * @return
	 */
	public static boolean esPrimo(int n) {
		int cont = 2;
		boolean primo = true;

		while ((primo) && (cont != n)) {
			if (n % cont == 0)
				primo = false;
			cont++;
		}

		return primo;
	}

}

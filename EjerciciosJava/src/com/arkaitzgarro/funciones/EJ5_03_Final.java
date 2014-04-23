package com.arkaitzgarro.funciones;

import java.util.ArrayList;

public final class EJ5_03_Final {
	
	/**
	 * Devuelve un array con nœmeros divisores primos de n
	 * @param n
	 * @return
	 */
	public static Integer[] divisoresPrimos(int n) {
		Integer[] array;
		ArrayList<Integer> primos = new ArrayList<Integer>();
		
		for (int i = 1; i <= n; i++) {
			if(esPrimo(i))
				primos.add(new Integer(i));
		}
		
		array = new Integer[primos.size()];
		return primos.toArray(array);
	}
	
	/**
	 * Indica si un nœmero es primo
	 * 
	 * @param n
	 * @return
	 */
	private static boolean esPrimo(int n) {
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

package com.arkaitzgarro.funciones;

import java.util.ArrayList;

public class EJ5_03 {

	/**
	 * Crear una función que tome como parámetro un número y devuelve un array
	 * con el número de divisores primos que tiene. Recomendación: crear una nueva
	 * función o utilizar la anterior que indique si un número es primo o no.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] primos;

		primos = divisoresPrimos(10);
		for (Integer num : primos) {
			System.out.println(num + " ");
		}
	}
	
	/**
	 * Devuelve un array con números divisores primos de n
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

package com.arkaitzgarro.funciones;

import java.util.ArrayList;

public class EJ5_03_Class {

	private int num;
	
	public EJ5_03_Class(int num) {
		this.num = num;
	}
	
	/**
	 * Devuelve un array con nœmeros divisores primos de n
	 * @param n
	 * @return
	 */
	public Integer[] divisoresPrimos() {
		Integer[] array;
		ArrayList<Integer> primos = new ArrayList<Integer>();
		
		for (int i = 1; i <= this.num; i++) {
			if(this.esPrimo(i))
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
	public boolean esPrimo(int n) {
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

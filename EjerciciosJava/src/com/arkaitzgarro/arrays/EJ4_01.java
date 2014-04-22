package com.arkaitzgarro.arrays;

import java.util.Arrays;

public class EJ4_01 {

	/**
	 * Construir un programa que pida al usuario una serie de nœmeros enteros,
	 * los almacene en un array, y obtenga el m‡ximo y el m’nimo de los valores almacenados.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numeros;
		int max;
		
		numeros = new int[10];
		// Inicializar el array de nœmeros
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (100*Math.random()+1);
		}
		
		// System.out.println(Arrays.toString(numeros));
		
		max = Integer.MIN_VALUE;
		// Calcular el m‡ximo
		for (int i = 0; i < numeros.length; i++) {
			if(numeros[i] > max) 
				max = numeros[i];
		}
		
		System.out.println("El m‡ximo es: " + max);
	}

}

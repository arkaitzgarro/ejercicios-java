package com.arkaitzgarro.arrays;

public class EJ4_02 {

	/**
	 * Construir un programa que pida al usuario una serie de números enteros,
	 * los almacene en un array, e indique en pantalla si dicho array es capicúa,
	 * es decir, si la secuencia de sus elementos es igual vista de delante hacia atrás y de detrás hacia delante.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numeros;
		int ini, fin;
		boolean capicua = true;
		
		numeros = new int[10];
		// Inicializar el array de números
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (10*Math.random()+1);
		}
		
		// System.out.println(Arrays.toString(numeros));

		ini = 0;
		fin = numeros.length - 1;
		while(ini <= fin && capicua) {
			capicua = (numeros[ini++] == numeros[fin--]);
		}
		
		if(capicua)
			System.out.println("El array es capicua");
		else
			System.out.println("El array NO es capicua");
	}

}

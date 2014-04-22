package com.arkaitzgarro.arrays;

public class EJ4_03 {

	/**
	 * Construir un programa que pida al usuario dos vectores de números enteros v1 y v2,
	 * y que construya un nuevo vector del resultado de “concatenar” los vectores v1 y v2.
	 * Es decir, colocar los elementos de v2 a continuación de los de v1 y,
	 * finalmente, mostrar el resultado de la concatenación por pantalla.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] v1, v2, v3;
		
		v1 = new int[10];
		v2 = new int[10];
		// Inicializar el array de números
		for (int i = 0; i < v1.length; i++) {
			v1[i] = (int) (10*Math.random()+1);
			v2[i] = (int) (10*Math.random()+1);
		}
		
		// Concatenar los arrays
		v3 = new int[v1.length + v2.length];
		for (int i = 0; i < v1.length; i++) {
			v3[i] = v1[i];
			v3[v1.length + i] = v2[i];
		}
	
		// Imprimir el array resultante
		for (int i = 0; i < v3.length; i++) {
			System.out.print(v3[i] + " ");
		}
		
		// System.out.println(Arrays.toString(v3));

	}

}

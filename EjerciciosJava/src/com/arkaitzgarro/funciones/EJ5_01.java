package com.arkaitzgarro.funciones;

public class EJ5_01 {

	/**
	 * Crear una función que tome dos parámetros numéricos y calcule el máximo de los dos números.
	 * Crear una nueva función con el mismo nombre, que tome tres parámetros,
	 * y calcule el máximo de los tres números. Esta segunda función debe hacer uso de la primera.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("El máximo de 10, 30 es: " + maximo2(10, 30));
		System.out.println("El máximo de 10, 30, 20 es: " + maximo3(10, 20, 30));

	}
	
	/**
	 * Calcula el máximo de dos números
	 * @param x
	 * @param y
	 * @return
	 */
	public static int maximo2(int x, int y) {
		return (x > y)? x : y;
	}
	
	/**
	 * Calcula el máximo de tres números
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public static int maximo3(int x, int y, int z) {
		return maximo2(maximo2(x, y), z);
	}

}

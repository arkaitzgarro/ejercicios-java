package com.arkaitzgarro.bucles;

public class EJ3_03 {

	/**
	 * Construir un programa en el que, utilizando un bucle for, se escriba por pantalla una tabla de
	 * conversión de grados Fahrenheit a Celsius, para los valores de 0 hasta 300 grados, en intervalos de 20.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		double celsius;
		
		for (int f = 0; f <= 300; f+=20) {
			celsius = (5.0/9.0)*(f - 32);
			System.out.println(f + "º Fahrenheit = " + celsius + "º celsius");
		}

	}

}

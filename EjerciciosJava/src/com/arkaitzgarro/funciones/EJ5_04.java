package com.arkaitzgarro.funciones;


public class EJ5_04 {

	/**
	 * Crear una función que convierte de grados Fahrenheit a Celsius.
	 * @param args
	 */
	public static void main(String[] args) {		
		System.out.println("50º grados Fahrenheit a Celsius: " + calculaCelsius(50.0));
		System.out.println("10º grados Celsius a Fahrenheit: " + calculaFahrenheit(10.0));
	}
	
	/**
	 * Convierte de Celsius a Fahrenheit
	 * 
	 * @param celsius
	 * @return Fahrenheit
	 */
	public static double calculaFahrenheit(double celsius) {
		double fahrenheit;
		
		fahrenheit = celsius * 9 / 5 + 32;
		
		return fahrenheit;
	}
	
	/**
	 * Convierte de Fahrenheit a Celsius
	 * 
	 * @param fahrenheit
	 * @return Celsius
	 */
	public static double calculaCelsius(double fahrenheit) {		
		return (fahrenheit - 32) * 5 / 9;
	}

}

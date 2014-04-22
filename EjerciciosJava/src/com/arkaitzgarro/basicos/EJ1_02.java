package com.arkaitzgarro.basicos;

public class EJ1_02 {

	/**
	 * A partir de una variable num1 con valor inicial 12 y una variable num2 con valor inicial 4,
	 * crear nuevas variables que almacenen el resultado de realizar la suma,
	 * resta, multiplicación, división y resto de num1 y num2.
	 * Mostrar el valor de las nuevas variables por pantalla.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int num1 = 12;
		int num2 = 4;
		int suma, resta, div, mul, mod;
		
		suma  = num1 + num2;
		resta = num1 - num2;
		div   = num1 / num2;
		mul   = num1 * num2;
		mod   = num1 % num2;
		
		System.out.println("Suma = " + suma);
		System.out.println("Resta = " + resta);
		System.out.println("División = " + div);
		System.out.println("Multiplicación = " + mul);
		System.out.println("Resto = " + mod);

	}

}

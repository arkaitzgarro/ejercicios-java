package com.arkaitzgarro.bucles;

import java.util.Scanner;

public class EJ3_07 {

	/**
	 * Construir un programa en el que se pida al usuario un número entero positivo n (validar que lo sea),
	 * y usando un bucle while, escriba por pantalla el valor del factorial de n.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int n, factorial = 1;
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.print("Introduce un número mayor que 0: ");
			n = entrada.nextInt();
		} while(n <= 0);
		
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}
		
		System.out.println("El factorial de " + n +  " es: " + factorial);
	}

}

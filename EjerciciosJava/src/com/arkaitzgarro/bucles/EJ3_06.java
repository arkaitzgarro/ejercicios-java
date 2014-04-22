package com.arkaitzgarro.bucles;

import java.util.Scanner;

public class EJ3_06 {

	/**
	 * Construir un programa en el que se pida al usuario dos números enteros positivos, n y m,
	 * y usando un bucle for, escriba el valor de n elevado a m.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int base, exp, res = 1;
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Introduce la base: ");
		base = entrada.nextInt();
		
		System.out.print("Introduce el exponente: ");
		exp = entrada.nextInt();

		for (int i = 0; i < exp; i++) {
			res *= base;
		}
		
		System.out.print(base + " elevado a " + exp + " = " + res);
	}

}

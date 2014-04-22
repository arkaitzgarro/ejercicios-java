package com.arkaitzgarro.condicionales;

import java.util.Scanner;

public class EJ2_01 {

	/**
	 * Definir dos variables num1 y num2 e implementar un programa que asigne un valor a cada una,
	 * y obtenga el mayor de los dos, mostrando el resultado por pantalla.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int num1, num2;
		Scanner entrada = new Scanner(System.in);
		
		// Leer un numero de teclado
		System.out.print("Introduce un numero: ");
		num1 = entrada.nextInt();
		
		// Leer un numero de teclado
		System.out.print("Introduce un numero: ");
		num2 = entrada.nextInt();
		
		if(num1 > num2)
			System.out.print("El nœmero " + num1 + " es mayor que " + num2);
		else
			System.out.print("El nœmero " + num2 + " es mayor que " + num1);

	}

}

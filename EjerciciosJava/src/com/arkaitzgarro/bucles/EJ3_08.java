package com.arkaitzgarro.bucles;

import java.util.Scanner;

public class EJ3_08 {

	/**
	 * Construir un programa que simule el juego de la adivinanza de un número.
	 * El ordenador debe generar un número aleatorio entre 1 y 100 y el usuario tiene
	 * cinco oportunidades para acertarlo. Después de cada intento el programa debe indicarle
	 * al usuario si el número introducido por él es mayor, menor o igual al número a adivinar,
	 * y el número de intentos restantes.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		boolean acertado = false;
		int intentos = 5;
		int x  = (int) (100*Math.random()+1);
		
		// Declarar punto de entrada
		Scanner entrada = new Scanner(System.in);

		do {
			System.out.println("Te quedan "+intentos+" intentos");
			System.out.print("Introduce el numero a adivinar: ");
			
			int num = entrada.nextInt();
			
			intentos--;
			
			if(num == x) {
				acertado = true;
			} else if(x > num ){
				System.out.println("El numero a adivinar es mayor.");
			} else {
				System.out.println("El numero a adivinar es menor.");
			}
		} while(intentos > 0 && !acertado);
		
		if(acertado)
			System.out.println("Enhorabuena! Has acertado al " + (intentos-1) + " intento.");
		else
			System.out.println("Lo siento, no has acertado. El número era: " + x);

	}

}

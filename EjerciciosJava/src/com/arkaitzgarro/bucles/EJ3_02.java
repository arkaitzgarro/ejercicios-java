package com.arkaitzgarro.bucles;

import java.util.Scanner;

public class EJ3_02 {

	/**
	 * Construir un programa que calcule el factorial de un valor numérico
	 * introducido como parámetro o argumento en la línea de comandos.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int num, factorial = 1;
		
		if(args.length > 0) {
			num = Integer.parseInt(args[0]);
		} else {
			Scanner entrada = new Scanner(System.in);
			
			System.out.print("Introduce un número: ");
			num = entrada.nextInt();
		}

		for (int i = 2; i <= num; i++) {
			factorial *= i;
		}
		
		System.out.println("El factorial de " + num +  " es: " + factorial);
	}

}

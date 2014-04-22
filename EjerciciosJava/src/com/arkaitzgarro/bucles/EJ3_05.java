package com.arkaitzgarro.bucles;

public class EJ3_05 {

	/**
	 * Implementar un programa en el que, utilizando un bucle while,
	 * se escriban por pantalla los 51 primeros números de la sucesión de Fibonacci
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int fib1 = 0, fib2 = 1, cont = 0;
		
		System.out.print(fib1 + " " + fib2 + " "); 

		do{ 
			int cur = fib1 + fib2; 
			fib1 = fib2; 
			fib2 = cur; 
			System.out.print(cur + " ");
			
			cont++;
		}while(cont < 50); 

	}

}

package com.arkaitzgarro.basicos;

public class EJ1_01 {

	/**
	 * Crear dos variables de cualquiera de los tipos básicos, dar un valor a la primera
	 * y a continuación asigne la segunda a la primera. Imprimir por pantalla las dos variables.
	 * Cambiar el valor de la segunda variable y volver a imprimir las variables por pantalla.
	 * ¿Qué es lo que ocurre?
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int var1, var2;

		var1 = 5;
		var2 = var1;
		
		System.out.println("var1 = " + var1);
		System.out.println("var2 = " + var2);
		
		var2 = 7;
		System.out.println("var1 = " + var1);
		System.out.println("var2 = " + var2);
	}

}

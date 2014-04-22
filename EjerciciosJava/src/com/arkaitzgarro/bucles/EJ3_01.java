package com.arkaitzgarro.bucles;

public class EJ3_01 {

	/**
	 * Construir un programa que visualice por pantalla todos los caracteres correspondientes a letras minúsculas
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int ini = (int)'a', fin = (int)'z';
		
		for (int i = ini; i <= fin; i++) {
			System.out.println((char)i);
		}

	}

}

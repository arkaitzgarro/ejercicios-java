package com.arkaitzgarro.clases;

public abstract class EJ6_01 {

	private static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	public static boolean validar(String dni) {		
		return comprobarFormato(dni) && comprobarLetra(dni);
	}
	
	/**
	 * Comprobar si la longitud y el formato corresponde con un DNI
	 * @return
	 */
	private static boolean comprobarFormato(String dni) {
		boolean valido = true;
		
		valido = (dni.length() == 9);
		
		if(valido) {
			char c = dni.charAt(dni.length()-1);
			valido = Character.isLetter(c);
		}
		
		if(valido) {
			int i = 0;
			while(valido && i<dni.length()-2) {
				char n = dni.charAt(i);
				valido = Character.isDigit(n);
				i++;
			}
		}
		
		return valido;
	}
	
	
	/**
	 * Comprobar si la letra corresponde con el nœmero de DNI
	 * @return
	 */
	private static boolean comprobarLetra(String dni) {
		char letra = dni.charAt(dni.length()-1);
		int num = Integer.valueOf(dni.substring(0, dni.length()-1));
		
		return NIF_STRING_ASOCIATION.charAt(num % 23) == letra;
	}
}

package com.arkaitzgarro.basicos;

public class EJ1_03 {

	/**
	 * Construir un programa que, dado el radio de una esfera, calcule y devuelva por pantalla
	 * el valor de la superficie y el volumen de la esfera correspondiente.
	 * Para obtener el valor de PI, utilizar la variable estática Math.PI.
	 * @param args
	 */
	public static void main(String[] args) {
		double r, s, v;
		
		r = 5;	// Radio de la esfera
		// Calcular la superficie
		s = 4 * Math.PI * Math.pow(r, 2);
		// Calcular el volumen
		v = (4/3) * Math.PI * Math.pow(r, 3);
		
		// Mostrar los resultados
		System.out.println("Radio de la esfera: " + r + " metros");
		System.out.println("Area de la esfera: " + s + " metros cuadrados");
		System.out.println("Volumen de la esfera: " + v + " metros cubicos");

	}

}

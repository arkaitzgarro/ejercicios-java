package com.arkaitzgarro.basicos;

import java.util.Scanner;

public class EJ1_04 {

	/**
	 * Construir un programa que dado el peso (en kilogramos) y la altura de una persona (en metros)
	 * calcule y muestre por pantalla su Indice de Masa Corporal (IMS) o índice de Quetelet.
	 * Este índice pretende determinar el intervalo de peso más saludable que puede tener una persona.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		double peso, altura, ims;
		Scanner entrada = new Scanner(System.in);
		
		// Leer la altura de teclado
		System.out.print("Introduce tu altura en metros: ");
		altura = entrada.nextDouble();
		
		// Leer el peso de teclado
		System.out.print("Introduce tu peso en kg: ");
		peso = entrada.nextDouble();
		
		// Calcular el IMS
		ims = peso / Math.pow(altura, 2);
		System.out.println("Su IMS es: " + ims);
		
	}

}

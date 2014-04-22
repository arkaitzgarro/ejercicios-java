package com.arkaitzgarro.condicionales;

import java.util.Scanner;

public class EJ2_02 {

	/**
	 * Construir un programa que calcule el índice de masa corporal de una persona (IMC = peso [kg] / altura2[m])
	 * e indique el estado en el que se encuentra esa persona en función del valor de IMC.
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
				
		if(ims < 16) {
			System.out.print("Criterio de ingreso en hospital");
		} else if (ims >= 16 && ims < 17) {
			System.out.print("Infrapeso");
		} else if (ims >= 17 && ims < 18) {
			System.out.print("Bajo peso");
		} else if (ims >= 18 && ims < 25) {
			System.out.print("Peso normal (saludable)");
		} else if (ims >= 25 && ims < 30) {
			System.out.print("Sobrepeso");
		} else if (ims >= 30 && ims < 35) {
			System.out.print("Sobrepeso crónico");
		} else if (ims >= 35 && ims < 40) {
			System.out.print("Obesidad premórbida");
		} else {
			System.out.print("Obesidad mórbida");
		}

	}

}

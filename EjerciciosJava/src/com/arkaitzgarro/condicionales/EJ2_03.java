package com.arkaitzgarro.condicionales;

public class EJ2_03 {

	/**
	 * Construir un programa que simule el funcionamiento de una calculadora que puede realizar
	 * las cuatro operaciones aritméticas básicas (suma, resta, producto y división)
	 * con valores numéricos enteros. El usuario debe especificar la operación con el primer carácter
	 * del primer parámetro de la línea de comandos: S o s para la suma, R o r para la resta, P, p, M o m para el producto y D o d para la división.
	 * Los valores de los operandos se deben indicar en el segundo y tercer parámetros.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		char op;
		double op1, op2;
		
		if(args.length != 3) {
			System.out.print("Debes indicar la operación y los operandos.");
		} else {
			op  = args[0].charAt(0);
			op1 = Double.parseDouble(args[1]);
			op2 = Double.parseDouble(args[2]);
			
			switch(op) {
				case 'S':
				case 's': System.out.println("La suma de " + op1 + " y " + op2 + " es: " + (op1 + op2)); break;
				case 'R':
				case 'r': System.out.println("La resta de " + op1 + " y " + op2 + " es: " + (op1 - op2)); break;
				case 'P':
				case 'p':
				case 'M': 
				case 'm': System.out.println("El producto de " + op1 + " y " + op2 + " es: " + (op1 * op2)); break;
				case 'D':
				case 'd': System.out.println("La división de " + op1 + " y " + op2 + " es: " + (op1 / op2)); break;
				default: System.out.println("Operación no reconocida."); break;
			}
		}

	}

}

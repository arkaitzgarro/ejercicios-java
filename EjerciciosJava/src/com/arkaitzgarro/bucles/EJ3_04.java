package com.arkaitzgarro.bucles;

public class EJ3_04 {

	/**
	 * Definir un array bidimensional para representar una agenda semanal,
	 * donde se contemplen los 7 días de la semana y las 24 horas de cada día.
	 * Utilizar bucles for anidados para inicializar la agenda a: “No tengo planes.”.
	 * Añadir “planes” a la agenda y mostrar el resultado por pantalla.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[][] agenda = new String[7][24];

		// Inicializar la agenda
		for (int i = 0; i < agenda.length; i++) {
			for (int j = 0; j < agenda[i].length; j++) {
				agenda[i][j] = "No tengo planes.";
			}
		}
		
		// Añadir eventos a la agenda
		agenda[0][9] = "Curso de JAVA";
		agenda[0][15] = "Curso de HTML5";
		agenda[1][9] = "Curso de JAVA";
		agenda[1][15] = "Curso de CSS3";
		
		// Mostrar la agenda
		for (int i = 0; i < agenda.length; i++) {
			for (int j = 0; j < agenda[i].length; j++) {
				System.out.print(agenda[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}

}

package com.arkaitzgarro.funciones;

public class EJ5_03_Main {

	public static void main(String[] args) {
		EJ5_03_Class p = new EJ5_03_Class(10);
		
		Integer[] primos;

		primos = p.divisoresPrimos();
		for (Integer num : primos) {
			System.out.println(num + " ");
		}
		
//		primos = EJ5_03_Abstract.divisoresPrimos(10);
//		for (Integer num : primos) {
//			System.out.println(num + " ");
//		}
	}

}

package com.arkaitzgarro.poo.EJ_01;

public class Complejo {

	// Parte real del numero imaginario
	private double pReal;
	
	// Parte imaginaria
	private double pImag;
	
	// Nœmero de instancias
	private static int instancias = 0;

	public Complejo() {
		this.pReal = 1.0;
		this.pImag = 1.0;
		
		instancias++;
	}

	public Complejo(double pReal, double pImag) {
		this();
		
		this.pReal = pReal;
		this.pImag = pImag;
	}

	public Complejo asignar(double pReal, double pImag) {
		this.pReal = pReal;
		this.pImag = pImag;

		return this;
	}

	public void sumar(Complejo c) {
		this.pReal += c.getPReal();
		this.pImag += c.getPImag();
	}
	
	public static Complejo sumar(Complejo c1, Complejo c2) {
		Complejo c3 = new Complejo(c1.getPReal(), c1.getPImag());
		
		c3.sumar(c2);
		
		return c3;
	}

	public double getPReal() {
		return pReal;
	}

	public void setPReal(double pReal) {
		this.pReal = pReal;
	}

	public double getPImag() {
		return pImag;
	}

	public void setPImag(double pImag) {
		this.pImag = pImag;
	}
	
	public static int getNumInstancias() {
		return instancias;
	}
	
	@Override
	public String toString() {
		return "(" + this.pReal + "," + this.pImag + ")";
	}
	
	public boolean equals(Complejo c) {
		return this.pReal == c.getPReal() && this.pImag == c.getPImag();
	}

}

package com.anahuac.calidad.tarea;

public class Calculadora {
	private double ultimoResultado;
	//Cambio
	public double suma(double primerSumando, double segundoSumando){
		return ultimoResultado = primerSumando + segundoSumando;
	}

	public double resta(double minuendo, double sustraendo){
		return ultimoResultado = minuendo - sustraendo;
	}

	public double multiplicacion(double primerFactor, double segundoFactor){
		return ultimoResultado = primerFactor * segundoFactor;
	}

	public String division(double dividendo, double divisor){
		 if (divisor == 0)
			 return "No existe la división entre cero";
		 ultimoResultado = dividendo / divisor;
		 return Double.toString(divisor);
	}
	public double getUltimaResultado(){
		return ultimoResultado;
	}

	public int divisionEntera(int dividendo, int divisor)
	{
		return dividendo/divisor;
	}
}

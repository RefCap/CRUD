package com.anahuac.calidad.tarea;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
//cambio

public class CalculadoraTest {
	
private static Calculadora calculadora;
	
@BeforeClass
	public static void setUp() throws Exception {
		System.out.println("++BEFORE++");
		calculadora = new Calculadora();
}

	@After
	public void tearDown() throws Exception {
		System.out.println("**AFTER**");

	}

	@Test
	public void SumaDosNumeroIgualesTest() {
		//2+2
		double resultadoEsperado =4;
		
		calculadora.suma(2,2);
		double resultadoEjercicio = calculadora.getUltimaResultado();
		//verificacion
		assertThat(resultadoEsperado,is(resultadoEjercicio));
	}
	@Test
	public void SumaDosNumerosDosDigitosTest() {
		//22+22
		double resultadoEsperado =44;
		
		calculadora.suma(22,22);
		double resultadoEjercicio = calculadora.getUltimaResultado();
		//Verification
		assertThat(resultadoEsperado,is(resultadoEjercicio));
	}
	@Test
	public void SumaMaxMasUnoTest() {
		//
		double resultadoEsperado = Double.MAX_VALUE ;
		
		calculadora.suma(Double.MAX_VALUE,1);
		double resultadoEjercicio = calculadora.getUltimaResultado();
		//Verification
		System.out.println(resultadoEjercicio);
		
		assertThat(resultadoEsperado,is(resultadoEjercicio));
	}
	@Test
	public void RestaNormalTest() {
		//22+22
		double resultadoEsperado = 5;
		
		calculadora.resta(10,5);
		double resultadoEjercicio = calculadora.getUltimaResultado();
		//Verification
		assertThat(resultadoEsperado,is(resultadoEjercicio));
	}
	
	@Test
	public void divisionEnteraTest() {
		//
		int resultadoEsperado = 5;
		int resultado;
		calculadora.divisionEntera(10,2);
		resultado = calculadora.divisionEntera(10, 2);
		//Verification
		assertThat(resultadoEsperado,is(resultado));
	}
	@Test(expected=ArithmeticException.class)
	public void divisionEntreCeroTest() {
		//22+22
		double resultadoEsperado = Double.POSITIVE_INFINITY;
		
		calculadora.divisionEntera(10,0);
		double resultadoEjercicio = calculadora.getUltimaResultado();
		//Verification
		assertThat(resultadoEsperado,is(resultadoEjercicio));
	}
	@Test
	public void MultiplicacionTest() {
		//22+22
		double resultadoEsperado =15;
		
		calculadora.multiplicacion(5,3);
		double resultadoEjercicio = calculadora.getUltimaResultado();
		//Verification
		assertThat(resultadoEsperado,is(resultadoEjercicio));
	}
}

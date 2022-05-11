package com.anahuac.calidad.tarea;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.*;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;;

@RunWith(Parameterized.class)
public class SumaParametrizadaTest {
//cambio
	private double suma1 = 0.0;
	private double suma2 = 0.0;
	private double resultado = 0.0;
	
	private Calculadora calculadora;
	
	public SumaParametrizadaTest(double sumando1,double sumando2, double resultado){
		this.suma1=sumando1;
		this.suma2=sumando2;
		this.resultado=resultado;
		
	}
	@Parameters
	public static Collection<Object[]>datos(){
		return Arrays.asList(new Object[][] {
			{2,2,4},
			{20,30,50},
			{20,0,20},
			{Double.MAX_VALUE,1,Double.MAX_VALUE}
		});

	}
	@Before
	public void setUp() throws Exception {
		calculadora = new Calculadora();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		double resultadoEjecucion = calculadora.suma(suma1, suma2);
		assertThat(resultadoEjecucion,is(resultado));
	}

}

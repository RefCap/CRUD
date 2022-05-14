package com.anahuac.calidad.TareaUnitTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import com.anahuac.calidad.crudMOCK.DAOmysqlEstudiante;
import com.anahuac.calidad.crudMOCK.Estudiante;
import com.anahuac.calidad.tareaUnitTest.AlertListener;
import com.anahuac.calidad.tareaUnitTest.Cuenta;
import com.anahuac.calidad.tareaUnitTest.DAOsqlCuenta;

public class DAOmysqlCuenta {
/*private	DAOsqlCuenta dao;
private Cuenta a;
private ArrayList<Cuenta> DB = new ArrayList<Cuenta>();
private AlertListener al;
	@Before
	public void setUp() throws Exception {
	dao = Mockito.mock(DAOsqlCuenta.class);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void AbonosComprasTest() {
	Cuenta a = new Cuenta(0,"holder",  null);
	Answer<Integer>agregar = invocation->{
		Cuenta newcuenta = (Cuenta) invocation.getArguments()[0];
		int sum = 0;
        for (int i = 0; i < DB.size(); i++) {
            sum+=DB.add(a);
        }
        System.out.println("Total = "+sum);
	};
	when(dao.añadirCuenta(a)).thenAnswer(agregar);
	int oldsize = DB.size();
	assertThat(oldsize+1,is(dao.createEstudiante(e))); 
	}
	
	@Test
	public void AlertaTest() {
		fail("Not yet implemented");
	}
*/
}

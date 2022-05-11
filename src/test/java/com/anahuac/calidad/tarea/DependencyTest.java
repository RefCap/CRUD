package com.anahuac.calidad.tarea;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import org.mockito.stubbing.Answer;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;

import com.anahuac.calidad.dobles.Dependency;

public class DependencyTest {
Dependency dependency;
	@Before
	public void setUp() throws Exception {
		dependency = Mockito.mock(Dependency.class);
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void DummyTest() {
		assertThat(dependency.getClassName(),is(nullValue()));
		assertThat(dependency.getClassNameUpperCase(),is(nullValue()));
		assertThat(dependency.getSubdependencyClassName(),is(nullValue()));
	}
	/*@Test
	public void test() {
		String expected = "com.anahuac.calidad.dobles.Dependency";
		String result = dependency.getClassName();
		assertThat(result,is(expected));
	}*/
	@Test
	public void ClassNameTest() {
		String expected = "com.anahuac.calidad.dobles.Dependency";
		when(dependency.getClassName()).thenReturn("com.anahuac.calidad.dobles.Dependency");
		String result = dependency.getClassName();
		assertThat(result,is(expected));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testException() {
		when(dependency.getClassName()).thenThrow(IllegalArgumentException.class);
		dependency.getClassName();
	}
	
	@Test
	public void AddTwoTest() {
		when(dependency.addTwo(10)).thenReturn(12);
		int expected = 12;
		int result = dependency.addTwo(10);
		assertThat(result,is(expected));
	}
	@Test
	public void ArgumentmatcherTest() {
		when(dependency.addTwo(10)).thenReturn(12);
		int expected = 12;
		int result = dependency.addTwo(10);
		assertThat(result,is(expected));
	}
	@Test
	public void testAnswer() {
		when(dependency.addTwo(anyInt())).thenAnswer(new Answer<Integer>(){
			public Integer answer(InvocationOnMock invocation) throws Throwable{
				int arg = (Integer) invocation.getArguments()[0];
				return arg + 20;
			}
		});
	assertThat(30,is( dependency.addTwo(10)));	
	}
	public Integer suma(Integer suma1, Integer suma2) {
		return suma1 + suma2;
	}
	@Test
	public void testMockAnswer() {
		Answer<Integer> calcularsuma = invocation -> {
			int arg = (Integer) invocation.getArguments()[0];
			return arg + 10;
			};
		when(dependency.addTwo(anyInt())).then(calcularsuma);
		assertThat(30,is( dependency.addTwo(10)));		
	}
	
}


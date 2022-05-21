package com.anahuac.calidad.DBunit;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;


import com.anahuac.calidad.crudMOCK.Estudiante;

import junit.framework.TestCase;

public class DAOAlumnoTest extends TestCase {
	
IDatabaseConnection connection;

public DAOAlumnoTest(String name)
{
	super(name);
}

protected IDataSet getDataSet() throws Exception {
	// TODO Auto-generated method stub
	return new FlatXmlDataSetBuilder().build(new File("src/resources/initDB.xml"));
}


@Before
public void setUp() throws Exception {
	super.setUp();
	Connection jdbcConnection;
	
	jdbcConnection = DriverManager.getConnection("jdbc:mysql:sql-data/dummy.sql");
	
	connection = new DatabaseConnection(jdbcConnection);
	
	try {

			PreparedStatement preparedStatement;
			preparedStatement = jdbcConnection.prepareStatement("Delete from sqlite_sequence WHERE name = ?");
			// Set the values to match in the ? on query
			
			
			preparedStatement.setString(1, "estudiante");
			
			Boolean result = false;

			// Return the result of connection and statement
			if (preparedStatement.executeUpdate() >= 1) {
				result = true;
			}
			preparedStatement.close();

		
		DatabaseOperation.CLEAN_INSERT.execute(connection, getDataSet());
	} catch(Exception e) {
		fail("Error in setup: " + e.getMessage());
		connection.close();
	 }
}
@After
public void tearDown()
{
	try {
		if (connection != null)
			connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public IDatabaseConnection getConnection()  {
	return connection;
}

@Test
public void test() {
	Estudiante alumno = new Estudiante( "Nombre", "Apellido", "dos@gmail.com","dos");
	DAOEstudianteSQLite daoSQLite = new DAOEstudianteSQLite();
	
	int id = daoSQLite.createEstudiante(alumno);
	alumno.setId(id);
	
	//verify
	try {
		IDataSet databaseDataSet = getConnection().createDataSet(); //esta es toda la base de datos
		
		ITable actualTable = databaseDataSet.getTable("estudiante");
		
		//Leer el archivo con el resultado esperado
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/insert_result.xml"));
		ITable expectedTable = expectedDataSet.getTable("estudiante");
		
		Assertion.assertEquals(expectedTable, actualTable);
		
		
	} catch (Exception e) {
		// TODO: handle exception
		fail("Error in insert ttest: " + e.getMessage());
	}
}

@Test
public void testUpdate() {
 
	DAOEstudianteSQLite daoSQLite = new DAOEstudianteSQLite ();
	
	Estudiante e2 = daoSQLite.findEstudiante(0);
	e2.setEmail("nuevo@mail.com");
	daoSQLite.updateEstudiante(e2);
	
	//verify
	try {
		IDataSet databaseDataSet = getConnection().createDataSet(); //esta es toda la base de datos
		
		ITable actualTable = databaseDataSet.getTable("estudiante");
		
		//Leer el archivo con el resultado esperado
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/update_result.xml"));
		ITable expectedTable = expectedDataSet.getTable("estudiante");
		
		Assertion.assertEquals(expectedTable, actualTable);
		
		
	} catch (Exception e) {
		// TODO: handle exception
		fail("Error in insert ttest: " + e.getMessage());
	}
}

@Test
public void testFind() {
 
	DAOEstudianteSQLite daoSQLite = new DAOEstudianteSQLite ();
	
	Estudiante e2 = daoSQLite.findEstudiante(0);
	
	
	//verify
	try {
		IDataSet databaseDataSet = getConnection().createDataSet(); //esta es toda la base de datos
		
		ITable actualTable = databaseDataSet.getTable("estudiante");
		
		//Leer el archivo con el resultado esperado
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/find_result.xml"));
		ITable expectedTable = expectedDataSet.getTable("estudiante");
		
	  Integer aux1 = Integer.parseInt((String) expectedTable.getValue(0, "id"));
	  String aux2 = (String) expectedTable.getValue(0, "Nombre");
	  String aux3 = (String) expectedTable.getValue(0, "Apellido");
	  String aux4 = (String) expectedTable.getValue(0, "Email");
	  String aux5 = (String) expectedTable.getValue(0, "Carrera");
		
		assertThat(e2.getId(),is(aux1));
		assertThat(e2.getNombre(),is(aux2));
		assertThat(e2.getAppellido(),is(aux3));
		assertThat(e2.getEmail(),is(aux4));
		assertThat(e2.getCarrera(),is(aux5));
		
		
	} catch (Exception e) {
		// TODO: handle exception
		//fail("Error in insert test: " + e.getMessage());
	}
}

@Test
public void testDelete() {
	
	DAOEstudianteSQLite daoSQLite = new DAOEstudianteSQLite ();
	
	Boolean e2 = daoSQLite.deleteEstudiante(0);

	
	//verify
	try {
		IDataSet databaseDataSet = getConnection().createDataSet(); //esta es toda la base de datos
		
		ITable actualTable = databaseDataSet.getTable("estudiante");
		
		//Leer el archivo con el resultado esperado
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/delete_result.xml"));
		ITable expectedTable = expectedDataSet.getTable("estudiante");
		
		Assertion.assertEquals(expectedTable, actualTable);
		
		
	} catch (Exception e) {
		// TODO: handle exception
		fail("Error in insert test: " + e.getMessage());
	}
}
}


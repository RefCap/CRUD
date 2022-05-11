package com.anahuac.calidad.DBunit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.anahuac.calidad.crudMOCK.Estudiante;
import com.anahuac.calidad.crudMOCK.IDAOEstudiante;

public class DAOEstudianteSQLite implements IDAOEstudiante{

	private static final String DRIVER_NAME = "org.sqlite.JDBC";
	//private static final String DB_URL = "jdbc:hsqldb:C:\\Users\\mrefp\\Desktop\\Estudiantes2.db";
	private static final String DB_URL = "jdbc:sqlite:C:\\Users\\mrefp\\Desktop\\Estudiantes2.db";
	private static final String ID = "";
	private static final String PASS = "";

	
	private Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			return DriverManager.getConnection(DB_URL);
		} catch (Exception e) {
			 e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	 
	
	public int createEstudiante(Estudiante estudiante) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int id = 0;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("INSERT INTO estudiante(nombre,apellido,email,carrera) VALUES(?,?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			//stmt.setInt(1, libro.getId());
			stmt.setString(1, estudiante.getNombre());
			stmt.setString(2, estudiante.getAppellido());
			stmt.setString(3, estudiante.getEmail());
			stmt.setString(4, estudiante.getCarrera());

			int result = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				estudiante.setId(rs.getInt(1));
				id = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			
			close(conn);
		}
		return id;
	}

	//Delete
	public int deleateEstudiante(Estudiante estudiante) {
	Connection connection = getConnection();
	int result = 0;

	try {
		// Declare statement query to run
		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement("Delete from alumnos_tbl WHERE id = ?");
		// Set the values to match in the ? on query
		preparedStatement.setInt(1, estudiante.getId());

		// Return the result of connection and statement
		if (preparedStatement.executeUpdate() >= 1) {
			result = 1;
		}
		System.out.println("\n");
		System.out.println("Alumno eliminado con exito");
		System.out.println(">> Return: " + result + "\n");
		// Close connection with the database
		connection.close();
		preparedStatement.close();

	} catch (Exception e) {
		System.out.println(e);
	}
	// Return statement
	return result;
	}
	//find
	public Estudiante findEstudiante(Estudiante estudiante) {
	Connection connection = getConnection();
			PreparedStatement preparedStatement;
			ResultSet rs;
			int result = 0;

			Estudiante retrieved = null;

			try {
				// Declare statement query to run
				preparedStatement = connection.prepareStatement("SELECT * from alumnos_tbl WHERE id = ?");
				// Set the values to match in the ? on query
				preparedStatement.setString(1, ID);
				rs = preparedStatement.executeQuery();

				// Obtain the pointer to the data in generated table
				rs.next();

				String retrivedNombre = rs.getString(1);
				String retrivedApellido = rs.getString(2);
				String retrivedEmail = rs.getString(3);
				String retrivedCarrera = rs.getString(4);

				retrieved = new Estudiante(retrivedNombre, retrivedApellido, retrivedEmail, retrivedCarrera);

							// Close connection with the database
				connection.close();
				rs.close();
				preparedStatement.close();

			} catch (Exception e) {
				System.out.println(e);
			}
			// Return statement
			return retrieved;
			}
	
public int updatestudiante(Estudiante estudiante){Connection connection = getConnection();
int result = 0;

try {
	// Declare statement query to run
	PreparedStatement preparedStatement;
	preparedStatement = connection.prepareStatement("UPDATE alumnos_tbl SET email = ? WHERE id = ?");
	// Set the values to match in the ? on query
	preparedStatement.setString(1, estudiante.getEmail());
	preparedStatement.setInt(2, estudiante.getId());

	// Return the result of connection and statement
	if (preparedStatement.executeUpdate() >= 1) {
		result = 1;
	}
	System.out.println("\n");
	System.out.println("Correo de alumno con ID: " + estudiante.getId() + " actualizado");
	System.out.println(">> Return: " + result + "\n");
	// Close connection with the database
	connection.close();
	preparedStatement.close();

} catch (Exception e) {
	System.out.println(e);
}
// Return statement
return result;
}

	@Override
	public boolean deleteEstudiante(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEstudiante(Estudiante e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Estudiante findEstudiante(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

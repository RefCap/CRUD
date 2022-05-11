package com.anahuac.calidad.DBunit;

import com.anahuac.calidad.crudMOCK.Estudiante;

public class DBDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estudiante a = new Estudiante("Nombre","Apellido","Email","Carrera");
		DAOEstudianteSQLite dao = new DAOEstudianteSQLite();
		dao.createEstudiante(a);
		//dao.findEstudiante(2);
		//dao.deleteEstudiante(1);
		//dao.updateEstudiante(a);
	}

}
package com.anahuac.calidad.crudMOCK;

public interface IDAOEstudiante {

	public int createEstudiante(Estudiante e);
	
	public boolean deleteEstudiante(int id);

	public boolean updateEstudiante(Estudiante e);
	
	public Estudiante findEstudiante(int id);

}

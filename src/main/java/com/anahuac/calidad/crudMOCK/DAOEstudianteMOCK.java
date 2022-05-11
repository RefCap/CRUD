/*package com.anahuac.calidad.crudMOCK;
import java.util.ArrayList; 

public class DAOEstudianteMOCK  implements IDAOEstudiante{

private ArrayList<Estudiante> DB = new ArrayList<Estudiante>();
public int dbsize() {return DB.size();} 

	@Override
	public int createEstudiante(Estudiante e) {
	int	id = DB.size();
	e.setId(id);
	DB.add(e);
	
	return id;
	}

	@Override
	public boolean deleteEstudiante(int id) 
	{
		DB.remove(id);
		
		return true;
	}
	@Override
	public boolean updateEstudiante(Estudiante e) {
		int id = e.getId();
		for(int i=0; i<=DB.size();i++) {
			if (i == id) {
			Estudiante oldEstudiante = DB.get(i);
			oldEstudiante.setEmail(e.getEmail());
			DB.add(i,oldEstudiante);
			}
		}
		
		return true;
	}

	@Override
	public Estudiante findEstudiante(int id) {
		Estudiante e = DB.get(id);
		
		return e;
	}

	

}*/

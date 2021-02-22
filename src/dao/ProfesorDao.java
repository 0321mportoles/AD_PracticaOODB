package dao;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import p3.modelos.Profesor;

public class ProfesorDao implements DAO<Profesor>{

	@Override
	public Profesor get(String id) {
		
		return null;
	}

	@Override
	public List<Profesor> getAll(ODB odb) {
		List<Profesor> profesores = new ArrayList<Profesor>();
		IQuery query = new CriteriaQuery(Profesor.class);
		org.neodatis.odb.Objects<Profesor> objectsProfesor = odb.getObjects(query);
		
		while (objectsProfesor.hasNext()) {
			profesores.add(objectsProfesor.next());
		}
		
		return profesores;
	}
	
	public List<Profesor> getAllHombres(ODB odb) {
		List<Profesor> profesores = new ArrayList<Profesor>();
		IQuery query = new CriteriaQuery(Profesor.class, Where.equal("sexo", "Hombre"));
		org.neodatis.odb.Objects<Profesor> objectsProfesor = odb.getObjects(query);
		
		while (objectsProfesor.hasNext()) {
			profesores.add(objectsProfesor.next());
		}
		return profesores;
	}
	
	public List<Profesor> getAllMismoNombre(ODB odb, String nombre, String apellido) {
		List<Profesor> profesores = new ArrayList<Profesor>();
		
		ICriterion criterio = new And().add(Where.like("nombre", nombre)).add(Where.like("apellidos", apellido));
		CriteriaQuery query = new CriteriaQuery(Profesor.class, criterio);
		
		org.neodatis.odb.Objects<Profesor> objectsProfesor = odb.getObjects(query);
		
		while (objectsProfesor.hasNext()) {
			profesores.add(objectsProfesor.next());
		}
		return profesores;
	}
	
	public void getAllNacidosAntes(ODB odb, String year) {
		IQuery query = new CriteriaQuery(Profesor.class, Where.lt("fechaNacimiento", year));
		org.neodatis.odb.Objects<Profesor> objectsProfesor = odb.getObjects(query);
		
		int i = 1;
		while (objectsProfesor.hasNext()) {
			System.out.println((i++) + "\t: " + objectsProfesor.next());
		}
	}

	@Override
	public void save(Profesor t, ODB odb) {
		odb.store(t);
		
	}

	@Override
	public void update(Profesor t, String nombreDocumento) {

		
	}

	@Override
	public void delete(ODB odb, int codigo) {
	
		
	}

}

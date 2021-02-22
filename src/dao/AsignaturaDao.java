package dao;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import p3.modelos.Asignatura;

public class AsignaturaDao implements DAO<Asignatura>{

	@Override
	public Asignatura get(String id) {
		
		return null;
	}

	@Override
	public List<Asignatura> getAll(ODB odb) {
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();
		IQuery query = new CriteriaQuery(Asignatura.class);
		org.neodatis.odb.Objects<Asignatura> objectsAsignatura = odb.getObjects(query);
		
		while (objectsAsignatura.hasNext()) {
			asignaturas.add(objectsAsignatura.next());
		}
		
		return asignaturas;
	}

	@Override
	public void save(Asignatura t, ODB odb) {
		odb.store(t);
	}

	@Override
	public void update(Asignatura t, String nombreDocumento) {
		
		
	}

	@Override
	public void delete(ODB odb, int codigo) {
		
		
	}

	public List<Asignatura> getNombre(ODB odb, String string) {
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();
		IQuery query = new CriteriaQuery(Asignatura.class, Where.equal("nombre", string));
		Objects<Asignatura> asignaturasDB = odb.getObjects(query);
		
		while(asignaturasDB.hasNext()) {
			asignaturas.add(asignaturasDB.next());
		}

		return asignaturas;
	}

}

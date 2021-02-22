package dao;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import p3.modelos.Centro;

public class CentroDao implements DAO<Centro>{

	@Override
	public Centro get(String id) {
		
		return null;
	}

	@Override
	public List<Centro> getAll(ODB odb) {
		List<Centro> centros = new ArrayList<Centro>();
		IQuery query = new CriteriaQuery(Centro.class);
		org.neodatis.odb.Objects<Centro> objectsCentros = odb.getObjects(query);
		
		while (objectsCentros.hasNext()) {
//			System.out.println(objectsCentros.next());
			centros.add(objectsCentros.next());
		}
		
		return centros;
	}

	@Override
	public void save(Centro centro, ODB odb) {
		odb.store(centro);
	}

	@Override
	public void update(Centro t, String nombreDocumento) {
		
		
	}

	@Override
	public void delete(ODB odb, int codigo) {
		
		
	}

}

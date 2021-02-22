package dao;

import java.util.List;

import org.neodatis.odb.ODB;

import p3.modelos.Centro;

public interface DAO <T> {
	T get(String id);
   
	List<T> getAll(ODB odb);
    
    void save(T t, ODB odb);
    
    void update(T t, String nombreDocumento);
    
    void delete(ODB odb, int codigo);	
}
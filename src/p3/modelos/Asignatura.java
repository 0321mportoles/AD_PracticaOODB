package p3.modelos;

import java.util.List;

public class Asignatura {
	
	private int codigo;
	private String nombre;
	private List<Profesor> listaProfesoresAsignatura;
		
	
	// constructor
	public Asignatura(int codigo, String nombre, List<Profesor> listaProfesoresAsignatura) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.listaProfesoresAsignatura = listaProfesoresAsignatura;
	}
	
	
	public Asignatura(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}


	// getters y setters
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Profesor> getListaProfesoresAsignatura() {
		return listaProfesoresAsignatura;
	}
	public void setListaProfesoresAsignatura(List<Profesor> listaProfesoresAsignatura) {
		this.listaProfesoresAsignatura = listaProfesoresAsignatura;
	}
	
	
	// metodos
	@Override
	public String toString() {
		return ("Asignatura [codigo=" + codigo + ", nombre=" + nombre + "]") ;
	}

	
}

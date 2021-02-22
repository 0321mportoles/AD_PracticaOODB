package p3;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import dao.AsignaturaDao;
import dao.CentroDao;
import dao.ProfesorDao;
import p3.modelos.Asignatura;
import p3.modelos.Centro;
import p3.modelos.Profesor;
import utils.Leer;

public class Applicacion {

	private static final String NOMBRE_DOCUMENTO = "BBDD5.neodatis";
	private static ODB odb;
	
	private static ProfesorDao profesorDao = new ProfesorDao();   
	private static CentroDao centroDao = new CentroDao();
	private static AsignaturaDao asignaturaDao = new AsignaturaDao();
	
	public static void main(String[] args) 
	{	
		try {
			//Conexion a la base de datos
			odb = ODBFactory.open(NOMBRE_DOCUMENTO);
			System.out.println(odb);
			rellenarBbDd(odb, profesorDao, asignaturaDao, centroDao);
			    	
			int opcion = 0;
			do {
			  	try {
		  			opcion = getOpcionDeMenu();
			 		ejecutarOpcion(opcion);
				} catch (Exception e) {
					opcion = 0;
					System.out.println("====> Error: " + e.getMessage());
					System.out.println("La opción introducida no es un número, cerrando programa");
				}
		   	} while (opcion != 0);
			
			System.out.println("\nPrograma terminado");
			
			odb.close();
		} catch (Exception e) {
			
			System.out.println("[ERROR]: " + e.getMessage());
			e.printStackTrace();
			
			if (odb != null) { 
				odb.close();
				System.out.println("Cerrando Base de datos para evitar datos corruptos");
			}
		}
		
	    		
	}
		
	private static void rellenarBbDd(ODB odb, ProfesorDao profesorDao, AsignaturaDao asignaturaDao,
		CentroDao centroDao) 
	{
		if (BDTieneDatos()) return;
		
		Profesor p1 = new Profesor(001,"Dario", "Ureña", "Hombre", "25/12/1986", 1);
    	Profesor p2 = new Profesor(002,"Julian", "Veron", "Hombre", "01/08/1994", 1);
    	Profesor p3 = new Profesor(003,"Eva", "Marina", "Mujer", "10/09/1980", 1);
    	
    	Profesor p4 = new Profesor(004,"Mario", "Royo", "Hombre", "15/06/1960", 2);
    	Profesor p5 = new Profesor(005,"Marta", "Asensio", "Mujer", "02/09/1972", 2);
    	Profesor p6 = new Profesor(006,"Guillermo", "Esteban", "Hombre", "20/02/1956", 2);
    	   	
    	List<Profesor> listaProfesores1 = new ArrayList<Profesor>();
    	listaProfesores1.add(p1);
    	listaProfesores1.add(p2);
    	listaProfesores1.add(p3);
    	List<Profesor> listaProfesores2 = new ArrayList<Profesor>();
    	listaProfesores2.add(p4);
    	listaProfesores2.add(p5);
    	listaProfesores2.add(p6);
    	
    	Centro c1 = new Centro(1, "IES Tiempos Modernos", p1, "Avenida Ranillas", "Zaragoza", "Zaragoza");
    	c1.setListaProfesoresCentro(listaProfesores1);
    	p1.setCentroProfesor(c1);
    	p2.setCentroProfesor(c1);
    	p3.setCentroProfesor(c1);
    	Centro c2 = new Centro(2, "IES Itaca", p2, "Avenida Estudiantes", "Zaragoza", "Zaragoza");
    	c2.setListaProfesoresCentro(listaProfesores2);
    	p4.setCentroProfesor(c2);
    	p5.setCentroProfesor(c2);
    	p6.setCentroProfesor(c2);
    	
    	List<Profesor> profesoresEmpresa = new ArrayList<Profesor>();
    	profesoresEmpresa.add(p2);
    	profesoresEmpresa.add(p4);
    	List<Profesor> profesoresIngles = new ArrayList<Profesor>();
    	profesoresIngles.add(p1);
    	profesoresIngles.add(p5);
    	List<Profesor> profesoresDesarrolloInterfaces = new ArrayList<Profesor>();
    	profesoresDesarrolloInterfaces.add(p3);
    	profesoresDesarrolloInterfaces.add(p6);
    	List<Profesor> profesoresProgramacion = new ArrayList<Profesor>();
    	profesoresProgramacion.add(p4);
    	profesoresProgramacion.add(p6);
    	profesoresProgramacion.add(p1);
    	List<Profesor> profesoresAccesoADatos = new ArrayList<Profesor>();
    	profesoresAccesoADatos.add(p5);
    	profesoresAccesoADatos.add(p4);
    	List<Profesor> profesoresBbdd = new ArrayList<Profesor>();
    	profesoresBbdd.add(p5);
    	profesoresBbdd.add(p4);
    	List<Profesor> profesoresPsp = new ArrayList<Profesor>();
    	profesoresPsp.add(p3);
    	profesoresPsp.add(p4);
    	List<Profesor> profesoresLenguajeMarcas = new ArrayList<Profesor>();
    	profesoresLenguajeMarcas.add(p6);
    	profesoresLenguajeMarcas.add(p3);
    	
    	Asignatura asig1 = new Asignatura(1001, "Empresa");
    	asig1.setListaProfesoresAsignatura(profesoresEmpresa);
    	Asignatura asig2 = new Asignatura(1002, "Ingles");
    	asig2.setListaProfesoresAsignatura(profesoresIngles);
    	Asignatura asig3 = new Asignatura(1003, "Desarrollo interfaces");
    	asig3.setListaProfesoresAsignatura(profesoresDesarrolloInterfaces);
    	Asignatura asig4 = new Asignatura(1004, "Programacion");
    	asig4.setListaProfesoresAsignatura(profesoresProgramacion);
    	Asignatura asig5 = new Asignatura(1005, "Acceso a datos");
    	asig5.setListaProfesoresAsignatura(profesoresAccesoADatos);
    	Asignatura asig6 = new Asignatura(1006, "Servicios y procesos");
    	asig6.setListaProfesoresAsignatura(profesoresPsp);
    	Asignatura asig7 = new Asignatura(1007, "Lenguaje de marcas");
    	asig7.setListaProfesoresAsignatura(profesoresLenguajeMarcas);
    	Asignatura asig8 = new Asignatura(1008, "Bases de datos");
    	asig8.setListaProfesoresAsignatura(profesoresBbdd);
    	
    	// guardo en bbdd centros, profesores y asignaturas  	
    	profesorDao.save(p1, odb);
    	profesorDao.save(p2, odb);
    	profesorDao.save(p3, odb);
    	profesorDao.save(p4, odb);
    	profesorDao.save(p5, odb);
    	profesorDao.save(p6, odb);
    	centroDao.save(c1, odb);
    	centroDao.save(c2, odb);
    	asignaturaDao.save(asig1, odb);
    	asignaturaDao.save(asig2, odb);
    	asignaturaDao.save(asig3, odb);
    	asignaturaDao.save(asig4, odb);
    	asignaturaDao.save(asig5, odb);
    	asignaturaDao.save(asig6, odb);
    	asignaturaDao.save(asig7, odb);
    	asignaturaDao.save(asig8, odb);
    	
    	odb.commit();
	}
	
		
	private static boolean BDTieneDatos() {
//		IQuery query = new CriteriaQuery(Centro.class, Where.like("nombre","%IES Tiempos Modernos%"));
		Objects<Centro> objects =odb.getObjects(Centro.class);

//		if (objects == null) return false;

		return objects.size() > 0;
	}

	private static void ejecutarOpcion(int opcion) {
		List<Profesor> profesores;
	    List<Asignatura> asignaturas;
			
		switch (opcion) {
			case 1:
				List<Centro> centros = centroDao.getAll(odb);
				for(Centro centro : centros) {
					System.out.println(centro);
				}
				break;
			case 2:
				profesores = profesorDao.getAll(odb);
				for(Profesor profesor : profesores) {
					System.out.println(profesor);
				}

				break;
			case 3:
				profesores = profesorDao.getAll(odb);
				for(Profesor profesor : profesores) {
					String fecha = profesor.getFechaNacimiento();
					int year = Integer.parseInt(fecha.substring(6, 10));
					if(year < 1993) {
						System.out.println(profesor);
					}
				}
				break;
			case 4:
				asignaturas = asignaturaDao.getNombre(odb, "Acceso a datos");		
				for(Asignatura asignatura : asignaturas) {
					profesores = asignatura.getListaProfesoresAsignatura();
					for(Profesor p : profesores) {
						if(p.getSexo().contentEquals("Hombre")) {
							System.out.println(p.toString());				
							}
					}
				}	

				break;
			case 5:
				System.out.print("Escribe el nombre del profesor: ");
				String nombre = Leer.pedirCadena();
				System.out.print("Escribe su apellido: ");
				String apellido = Leer.pedirCadena();
				System.out.println();
				
				profesores = profesorDao.getAllMismoNombre(odb, nombre, apellido);
				if(profesores.isEmpty()) {
					System.out.println("El profesor no esta en la base de datos.");
				}else {
					for(Profesor prof : profesores) {
						System.out.println(prof);
					}
				}
				break;
		
			default:
				break;
			}	
	}

	private static int getOpcionDeMenu() 
	{
		System.out.println("");
		System.out.println("******************************");
		System.out.println("******* Menú principal *******");
		System.out.println("******************************");
		System.out.println( "1.- Listar todos los centros" );
		System.out.println( "2.- Listar todos los profesores" );
		System.out.println( "3.- Listar todos los profesores de un centro cuya fecha de nacimiento sea anterior a 1993" );
		System.out.println( "4.- Listar los profesores con sexo masculino que impartan la asignatura de “Acceso a datos”." );
		System.out.println( "5.- Comprobar si un profesor ya existe." );
		System.out.print( "Selecciona una opcion (0 para terminar): " );
				
		return Leer.pedirEnteroValidar();
	}
}

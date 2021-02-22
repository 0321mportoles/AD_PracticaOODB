package p3;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import dao.AsignaturaDao;
import dao.CentroDao;
import dao.ProfesorDao;
import p3.modelos.Asignatura;
import p3.modelos.Profesor;

public class App {
	

	private static final String NOMBRE_DOCUMENTO = "BBDD.neodatis";
	
	public static void main(String[] args) 
	{

		//Conexion a la base de datos
		ODB odb = ODBFactory.open(NOMBRE_DOCUMENTO); 	
	
		ProfesorDao profesorDao = new ProfesorDao();   
		CentroDao centroDao = new CentroDao();
		AsignaturaDao asignaturaDao = new AsignaturaDao();
		    	
		rellenarBbDd(odb, profesorDao, asignaturaDao, centroDao);
		    	
		int opcion = 0;
		do {
		  	try {
	  			opcion = getOpcionDeMenu();
//		 		ejecutarOpcion(opcion);
			} catch (Exception e) {
				opcion = 0;
				System.out.println("====> Error: " + e.getMessage());
				System.out.println("La opción introducida no es un número, cerrando programa");
			}
	   	} while (opcion != 0);
	    		
	}
		
	private static void rellenarBbDd(ODB odb, ProfesorDao profesorDao, AsignaturaDao asignaturaDao,
		CentroDao centroDao) 
	{
		System.out.println("Rellenando bbdd" );
	}
		
//	private static void ejecutarOpcion(int opcion) {
//		List<Profesor> profesores;
//	    List<Asignatura> asignaturas;
//			
//		switch (opcion) {
//			case 1:
//			
//				break;
//			case 2:
//			
//
//				break;
//			case 3:
//			
//				break;
//			case 4:
//		
//
//				break;
//			case 5:
//		
//				break;
//		
//			default:
//				break;
//			}
//			
//	}

		


	
	private static int getOpcionDeMenu() 
	{
			
		int opcion = 0;
			
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
			
			
		return opcion;
	}
}
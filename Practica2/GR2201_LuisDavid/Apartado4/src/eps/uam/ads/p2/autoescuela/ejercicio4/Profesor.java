package eps.uam.ads.p2.autoescuela.ejercicio4;

/**
 * Clase que hereda de Persona. Contiene los datos y metodos
 * para gestionar la actividad laboral de un profesor de autoescuela.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Profesor extends Persona{
	
	private int numSegSoc;
	
	/**
	 * Contructor de la clase Profesor.
	 * 
	 * @param dni Entero con los digitos del dni
	 * @param nombre String con el nombre de la persona
	 * @param apellidos String con los apellidos de la persona
	 * @param telefono Entero con el numero de telefono de la persona
	 * @param numSegSoc Entero con el numero de la seguridad social del empleado
	 */
	
	public Profesor(int dni, String nombre, String apellidos, int telefono, int numSegSoc){
		super(dni, nombre, apellidos, telefono);
		this.numSegSoc = numSegSoc;
	}
	
	/**
	 * Metodo que devuelve el numero de la seguridad social de un profesor
	 * 
	 * @return Un entero con el numero de la Seguridad Social asignado
	 */
	
	public int getSS(){
		return this.numSegSoc;
	}

}
package eps.uam.ads.p2.autoescuela.ejercicio4;


/**
 * Superclase que encapsula varios de los campos de Alumno y
 * Profesor. No se ha incluido en la implementacion del ejercicio 1
 * ya que por aquel entonces no se especcificaba, pero seria conveniente.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public abstract class Persona {
	
	private int dni;
	private String nombre;
	private String apellidos;
	private int telefono;
	
	/**
	 * Contructor de la clase abstracta Persona.
	 * 
	 * @param dni Entero con los digitos del dni
	 * @param nombre String con el nombre de la persona
	 * @param apellidos String con los apellidos de la persona
	 * @param telefono Entero con el numero de telefono de la persona
	 */
	
	public Persona(int dni, String nombre, String apellidos, int telefono){
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}
	
	/**
	 * Metodo que devuelve el nombre de una persona
	 * 
	 * @return El nombre de la persona (String)
	 */
	
	public String getNombre(){
		return this.nombre;
	}
	
	/**
	 * Metodo que devuelve los apellidos de una persona
	 * 
	 * @return Los apellidos (String)
	 */
	
	public String getApellidos(){
		return this.apellidos;
	}
	
	/**
	 * Metodo que devuelve el documento de identidad
	 * 
	 * @return El dni de la persona (int)
	 */
	
	public int getDNI(){
		return this.dni;
	}
	
	/**
	 * Metodo que devuelve el telefono de la persona
	 * @return Un entero con el numero de telefono
	 */
	
	public int getTelefono(){
		return this.telefono;
	}
	
}

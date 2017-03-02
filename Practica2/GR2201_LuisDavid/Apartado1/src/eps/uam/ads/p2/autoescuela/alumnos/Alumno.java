package eps.uam.ads.p2.autoescuela.alumnos;

/**
 * Clase con la informacion y metodos necesarios para
 * gestionar la informacion de un alumno de una autoescuela.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Alumno {
	private int dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private int telefono;
	private Fecha fechaMatricula;
	private Fecha fechaSupTeorico;
	private Fecha fechaSupPractico;
	
	/**
	 * Contructor de la clase Alumno.
	 * 
	 * @param dni Entero con los digitos del dni
	 * @param nombre String con el nombre de la persona
	 * @param apellidos String con los apellidos de la persona
	 * @param direccion String con la direccion del alumno
	 * @param telefono Entero con el numero de telefono de la persona
	 * @param dia Dia de matriculacion en la autoescuela
	 * @param mes Mes de matriculacion en la autoescuela
	 * @param anyo Año de matriculacion en la autoescuela
	 */
	
	public Alumno(int dni, String nombre, String apellidos, String direccion, 
					int telefono, int dia, int mes, int anyo){
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaMatricula = new Fecha(dia, mes, anyo);
	}
	
	/**
	 * Comprueba si la fecha cumple:
	 * - El dia tiene un valor entre 1 y 31
	 * - El mes tiene un valor entre 1 y 12
	 * 
	 * @param f Fecha a comprobar
	 * @return True si se cumplen las condiciones, False en caso contrario
	 */
	
	public boolean isFechaValida(Fecha f){
		return f.isFechaValida();
	}
	
	/**
	 * Metodo que devuelve la fecha de matriculacion de un alumno
	 * 
	 * @return Fecha de matricula (Fecha)
	 */
	
	public Fecha getFechaMatricula(){
		return this.fechaMatricula;
	}
	
	/**
	 * Metodo que devuelve nombre y apellidos del alumno.
	 * 
	 * @return Un unico String con el nombre y los apellidos.
	 */
	
	public String getNombreYApellidos(){
		return this.nombre+" "+this.apellidos;
	}
	
	/**
	 * Metodo que devuelve la fecha en la que el alumno supero
	 * el examen practico.
	 * 
	 * @return Fecha en la que se aprobo el examen practico (Fecha)
	 */
	
	public Fecha getFechaSupPractico(){
		return this.fechaSupPractico;
	}
	
	/**
	 * Metodo que devuelve la fecha en la que el alumno supero
	 * el examen teorico.
	 * 
	 * @return Fecha en la que se aprobo el examen teorico (Fecha)
	 */
	
	public Fecha getFechaSupTeorico(){
		return this.fechaSupTeorico;
	}
	
	/**
	 * Metodo que configura la fecha de superacion del examen teorico
	 * @param dia Dia del aprobado
	 * @param mes Mes del aprobado
	 * @param anyo Año del aprobado
	 */
	
	public void setFechaSupTeorico(int dia, int mes, int anyo){
		this.fechaSupTeorico = new Fecha(dia, mes, anyo);
	}
	
	/**
	 * Metodo que configura la fecha de superacion del examen practico
	 * @param dia Dia del aprobado
	 * @param mes Mes del aprobado
	 * @param anyo Año del aprobado
	 */
	
	public void setFechaSupPractico(int dia, int mes, int anyo){
		this.fechaSupPractico = new Fecha(dia, mes, anyo);
	}
	
	/**
	 * Metodo que devuelve la informacion de un alumno
	 * 
	 * @return La informacion del alumno en un String
	 */
		
	public String toString(){
		String salida = "Datos del alumno <dni: "+this.dni+">\n\tNombre y apellidos: "
						+getNombreYApellidos()+"\n\tDirección: "+this.direccion+"\n\tTeléfono: "
						+this.telefono+"\n\tFecha de matriculación: "+this.fechaMatricula.getFecha();
		return salida;
						
	}
	
}

package eps.uam.ads.p2.autoescuela.ejercicio4;

/**
 * Clase que contiene los datos y metodos disponibles para gestionar
 * una sede de una autoescuela
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Autoescuela {
	
	private int codigo;
	private String nombre;
	private String direccion;
	private String encargado;
	private int numAulas;
	private Contrato[] contratos;
	int nContratos;
	int nActual;
	
	/**
	 * Constructor de la clase Autoescuela
	 * @param codigo Codigo de identificacion de la autoescuela
	 * @param nombre Nombre de la autoescuela
	 * @param direccion Localizacion de la sede
	 * @param encargado Persona al mando de la sede
	 * @param numAulas Cantidad de aulas disponibles en la sede
	 * @param nContratos Numero maximo de profesores que la auotescuela contrata 
	 * */
	
	public Autoescuela(int codigo, String nombre, String direccion, String encargado, int numAulas,
						int nContratos){
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.encargado = encargado;
		this.numAulas = numAulas;
		this.nContratos = nContratos;
		this.nActual = 0;
		this.contratos = new Contrato[this.nContratos];
	}
	
	/**
	 * Agrega un nuevo contrato a la lista de contratos de la autoescuela
	 * 
	 * @param profesor Nuevo trabajador contratado
	 * @param dia Dia de vigencia
	 * @param mes Mes de vigencia
	 * @param anyo Año de vigencia
	 * @param sueldoBase Sueldo base del profesor
	 * */
	
	public void addContrato(Profesor profesor, int dia, int mes, int anyo, double sueldoBase){
		this.contratos[nActual++] = new Contrato(dia, mes, anyo, profesor, sueldoBase);
	}
	
	/**
	 * Devuelve el codigo de una autoescuela
	 * 
	 * @return El codigo de la autoescuela (int)
	 * */
	public int getCodigo(){
		return this.codigo;
	}
	
	/**
	 * Devuelve el nombre de una autoescuela
	 * 
	 * @return El nombre de la autoescuela (String)
	 * */
	public String getNombre(){
		return this.nombre;
	}
	
	/**
	 * Metodo que devuelve la direccion de una sede
	 * 
	 * @return Direccion de la sede (String)
	 * */
	
	public String getDireccion(){
		return this.direccion;
	}
	
	/**
	 * Devuelve el nombre del encargado en la sede
	 * 
	 * @return Nombre del encargado (String)
	 * */
	
	public String getEncargado(){
		return this.encargado;
	}
	
	/**
	 * Metodo que devuelve el numero de aulas de las que dispone 
	 * la sede del autoescuela
	 * 
	 * @return Numero de aulas (int)
	 * */
	
	public int getAulas(){
		return this.numAulas;
	}
	
	/**
	 * Metodo que devuelve un array con todos los contratos de la
	 * autoescuela
	 * 
	 * @return Un array de objetos tipo contrato
	 */
	
	public Contrato[] getContratos(){
		return this.contratos;
	}
	
	/**
	 * Devuelve el numero de contratos de los que dispone actualmente
	 * la sede de la autoescuela (no tienen por que ser vigentes).
	 * 
	 * @return El numero de contratos (int)
	 * */
	
	public int getActual(){
		return this.nActual;
	}
	
	/**
	 * Configura la fecha de fin de un contrato
	 * 
	 * @param dni DNI del profesor al que se le acaba el contrato
	 * @param dia Dia de vencimiento
	 * @param mes Mes de vencimiento
	 * @param anyo Año de vencimiento
	 * 
	 * @return Un valor booleano. True si la accion se realizo satisfactoriamente
	 * y False si hubo algun error.
	 * */
	
	public boolean despedir(int dni, int dia, int mes, int anyo){
		for (Contrato cont : this.contratos){
			if((cont.getProfesor()).getDNI() == dni){
				cont.setFin(dia, mes, anyo);
				return true;
			}						
		}
		return false;
	}

}

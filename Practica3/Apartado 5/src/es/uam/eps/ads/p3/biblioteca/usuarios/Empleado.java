package es.uam.eps.ads.p3.biblioteca.usuarios;

/**
 * Clase que contiene la informacion necesaria para gestionar
 * las acciones de los usuarios de tipo empleado
 *  
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Empleado extends Usuario{
	
	private double sancion;
	/*Constantes con informacion propia de los empleados*/
	private static final int plazoIni = 4;
	private static final int maxP = 20;
	private static final double coste = 2.5;
	
	/**
	 * Constructor de la clase empleado.
	 * El valor de la sancion comienza en 0 euros
	 * @param nombre Nombre del usuario a crear
	 */
	
	public Empleado(String nombre){
		super(nombre, maxP, plazoIni);
		this.sancion = 0.0;
	}
	
	/**
	 * Sanciona con 2.5 euros por dia de retraso
	 * @param dias Numero de dias por los que se sanciona 
	 */
	
	public void sancionarPorRetraso(int dias){
		if (dias >= getnSanciones()){
			// Sancionamos
			sancion += (dias)*coste;
		}
		// En caso contrario la sancion se perdona
	}
	
	/**
	 * Configura a 0 euros la sancion de un empleado
	 */
	
	public void eliminarSancion(){
		this.sancion = 0.0;
	}
	
	/**
	 * Sobreescritura del metodo toString por defecto para que los empleados
	 * sean impresos segun los requisitos del enunciado.
	 */
	
	@Override
	public String toString(){
		if(sancion == 0){
			return "[E: "+this.getNombre()+"]";
		}
		return "[E: "+this.getNombre()+" $"+sancion+"]";
	}

}

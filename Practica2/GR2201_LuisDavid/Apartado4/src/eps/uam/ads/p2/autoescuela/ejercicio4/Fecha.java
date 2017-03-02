package eps.uam.ads.p2.autoescuela.ejercicio4;

/**
 * Clase fecha que conjunta los datos de dia, mes y año
 *
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Fecha {
	private int dia;
	private int mes;
	private int anyo;
	
	/**
	 * Contructor de la clase Fecha
	 * @param dia Dia 
	 * @param mes Mes
	 * @param anyo Año
	 */
	
	public Fecha(int dia, int mes, int anyo){
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
	}
	
	/**
	 * Comprueba si la fecha cumple:
	 * - El dia tiene un valor entre 1 y 31
	 * - El mes tiene un valor entre 1 y 12
	 * 
	 * @return True si se cumplen las condiciones, False en caso contrario
	 */
	
	public boolean isFechaValida(){
		if(this.dia <= 0 || this.dia > 31 || this.mes <= 0 || this.mes > 12){
			return false;
		}
		return true;
	}
	
	/**
	 * Metodo que convierte una fecha en String
	 * 
	 * @return String con los datos de la fecha en formato dia/mes/año
	 */
	
	public String getFecha(){
		String fecha = String.format("%d/%d/%d", this.dia, this.mes, this.anyo);
		return fecha;
	}
	
}
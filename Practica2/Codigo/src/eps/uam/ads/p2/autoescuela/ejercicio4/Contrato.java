package eps.uam.ads.p2.autoescuela.ejercicio4;
import eps.uam.ads.p2.autoescuela.alumnos.Fecha;

/**
 * Esta clase relaciona las clases Autoescuela y Profesor, para
 * conseguir que cierta sede pueda tener un numero determinado de
 * profesores contratados en un periodo de tiempo.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Contrato {
	private Fecha fechaInicio;
	private Fecha fechaFin;
	private Profesor profesor;
	private double sueldoBase;

	/**
	 * Contructor de la clase Contrato
	 * Crea un nuevo objeto de tipo contrato especificando la fecha de inicio
	 * y la de vencimiento.
	 * 
	 * @param dia1 Dia de inicio del contrato
	 * @param mes1 Mes de inicio del contrato
	 * @param anyo1 Año de inicio del contrato
	 * @param dia2 Dia de fin del contrato
	 * @param mes2 Mes de fin del contrato
	 * @param anyo2 Año de fin del contrato
	 * @param profesor Profesor contratado por la autoescuela
	 * @param sueldoBase Cantidad fija que gana el profesor al mes
	 */
	public Contrato(int dia1, int mes1, int anyo1, int dia2, int mes2, int anyo2, 
					Profesor profesor, double sueldoBase){
		this.fechaInicio = new Fecha(dia1, mes1, anyo1);
		this.fechaInicio = new Fecha(dia2, mes2, anyo2);
		this.profesor = profesor;
		this.sueldoBase = sueldoBase;
	}

	/**
	 * Contructor de la clase Contrato
	 * Crea un nuevo objeto de tipo contrato especificando la fecha de inicio.
	 * Por defecto configura la fecha de vencimiento como 0/0/0
	 * 
	 * @param dia1 Dia de inicio del contrato
	 * @param mes1 Mes de inicio del contrato
	 * @param anyo1 Año de inicio del contrato
	 * @param profesor Profesor contratado por la autoescuela
	 * @param sueldoBase Cantidad fija que gana el profesor al mes
	 */
	
	public Contrato(int dia1, int mes1, int anyo1, Profesor profesor, double sueldoBase) {
		this.fechaInicio = new Fecha(dia1, mes1, anyo1);
		this.fechaFin = new Fecha(0,0,0);
		this.profesor = profesor;
		this.sueldoBase = sueldoBase;
	}
	
	/**
	 * Agrega la fecha de vencimiento de un contrato
	 * 
	 * @param dia1 Dia de vencimiento del contrato
	 * @param mes1 Mes de vencimeinto
	 * @param anyo1 Año de vencimiento
	 */
	
	public void setFin(int dia1, int mes1, int anyo1){
		this.fechaFin = new Fecha(dia1, mes1, anyo1);
	}
	
	/**
	 * Metodo que devuelve la fecha de inicio del contrato
	 * 
	 * @return Fecha de inicio del contrato (Fecha)
	 */
	
	public Fecha getIni(){
		return this.fechaInicio;
	}
	
	/**
	 * Devuelve la fecha de vencimiento de un contrato
	 * 
	 * @return Fecha de vencimiento del contrato (Fecha)
	 */
	
	public Fecha getFin(){
		return this.fechaFin;
	}
	
	/**
	 * Devulve la cantidad fija de dinero que el profesor 
	 * gana al mes
	 * 
	 * @return La cantidad de dinero (double)
	 */
	
	public double getSueldoBase(){
		return this.sueldoBase;
	}
	
	/**
	 * Devuelve el profesor que toma parte en el contrato
	 * 
	 * @return Un objeto de tipo Profesor
	 */
	
	public Profesor getProfesor(){
		return this.profesor;
	}
	
	
}

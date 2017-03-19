package es.uam.eps.ads.p3.biblioteca;
import es.uam.eps.ads.p3.fechasimulada.FechaSimulada;
import java.time.LocalDate;

/**
 * Clase que contiene la informacion necesaria para gestionar
 * los prestamos de la biblioteca.
 *   
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Prestamo {
	
	private Ejemplar ejemplar;
	private Usuario usuario;
	private LocalDate fechaVencimiento;
	private static int numPrestamosHistoricos = 0;
	private static int numPrestamosPendientes = 0;
	
	/**
	 * Constructor de la clase Prestamo.
	 * Generamos la fecha de vencimiento a partir de la actual
	 * @param ejemplar
	 * @param usuario
	 */
	
	public Prestamo(Ejemplar ejemplar, Usuario usuario){
		this.ejemplar = ejemplar;
		this.usuario = usuario;
		this.fechaVencimiento = FechaSimulada.getHoy().plusDays(ejemplar.getObra().getPlazo());
	}
	
	/**
	 * Devuelve el ejemplar que ha sido prestado
	 * @return El ejemplar prestado
	 */

	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	/**
	 * Configura el ejemplar que se presta
	 */
	
	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}

	/**
	 * Devuelve el usuario que realiza el prestamo
	 * @return El usuario que ha realizado el prestamo
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Configura el usuario que realiza el prestamo
	 * @param EL usuario que realiza el prestamo
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Devuelve la fecha de vencimiento del prestamo
	 * @return Fecha de vencimiento
	 */
	
	public LocalDate getFechaVencimiento(){
		return this.fechaVencimiento;
	}
	
	public static int numPrestamosHistoricos(){
		return Prestamo.numPrestamosHistoricos;
	}
	
	public static int numPrestamosPendientes(){
		return Prestamo.numPrestamosPendientes;
	}
	
	public static void setnumHistoricos(int n){
		Prestamo.numPrestamosHistoricos = n;
	}
	
	public static void setnumPendientes(int n){
		Prestamo.numPrestamosPendientes = n;
	}
	
	@Override 
	public String toString(){
		return ejemplar+" prestado a "+" "+usuario+" hasta "+fechaVencimiento;
	}
	
}


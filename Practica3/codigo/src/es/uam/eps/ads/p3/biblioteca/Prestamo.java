package es.uam.eps.ads.p3.biblioteca;
import es.uam.eps.ads.p3.fechasimulada.FechaSimulada;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	private LocalDate fechaDevolucion;
	private static int numPrestamosHistoricos = 0;
	private static List<Prestamo> prestamosNoDevueltos = new ArrayList<Prestamo>();
	
	/**
	 * Constructor de la clase Prestamo.
	 * Generamos la fecha de vencimiento a partir de la actual
	 * @param ejemplar
	 * @param usuario
	 */
	
	public Prestamo(Ejemplar ejemplar, Usuario usuario){
		this.ejemplar = ejemplar;
		this.usuario = usuario;
		this.fechaVencimiento = FechaSimulada.getHoy().plusDays(ejemplar.getObra().plazoPrestamo());
		this.fechaDevolucion = null;
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
	
	public LocalDate getFechaDevolucion(){
		return this.fechaDevolucion;
	}
	
	public static int numPrestamosHistoricos(){
		return Prestamo.numPrestamosHistoricos;
	}
	
	public static int numPrestamosPendientes(){
		return Prestamo.prestamosNoDevueltos.size();
	}
	
	public static void setnumHistoricos(int n){
		Prestamo.numPrestamosHistoricos = n;
	}
	
	
	public int diasAtrasado(){
		int numDiasRetraso = Period.between(this.fechaVencimiento, FechaSimulada.getHoy()).getDays();
		return numDiasRetraso;
	}
	
	public static void addNuevoPrestamo(Prestamo p){
		Prestamo.prestamosNoDevueltos.add(p);
	}
	
	public boolean devolver(){
		if(Prestamo.prestamosNoDevueltos.contains(this) == false)
			return false;
		boolean ret = this.ejemplar.devolver();
		if(ret == false){
			return false;
		}
		this.fechaDevolucion = FechaSimulada.getHoy();
		return true;
	}
	
	public static void devolucion(Prestamo p){
		Prestamo.prestamosNoDevueltos.remove(p);
	}
	
	public static List<Prestamo> conVencimientoHoy(){
		List<Prestamo> vencenHoy = new ArrayList<Prestamo>();
		for(Prestamo p : Prestamo.prestamosNoDevueltos){
			if(p.diasAtrasado() == 0){
				vencenHoy.add(p);
			}
		}
		return Collections.unmodifiableList(vencenHoy);
	}
	
	public static List<Prestamo> pasadosDeVencimiento(){
		List<Prestamo> vencidos = new ArrayList<Prestamo>();
		for(Prestamo p : Prestamo.prestamosNoDevueltos){
			if(p.diasAtrasado() > 0)
				vencidos.add(p);
		}
		return Collections.unmodifiableList(vencidos);
	}
	
	// Eliminar despues
	
	public static List<Prestamo> todos(){
		return Collections.unmodifiableList(Prestamo.prestamosNoDevueltos);
	}
	
	@Override 
	public String toString(){
		if(this.fechaDevolucion == null)
		 return ejemplar+" prestado a "+" "+usuario+" hasta "+fechaVencimiento;
		return ejemplar+" prestado a "+" "+usuario+" hasta "+fechaVencimiento+" devuelto "+fechaDevolucion;
	}
	
}


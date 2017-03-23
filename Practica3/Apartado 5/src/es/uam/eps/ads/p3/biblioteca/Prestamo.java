package es.uam.eps.ads.p3.biblioteca;
import es.uam.eps.ads.p3.biblioteca.catalogo.Ejemplar;
import es.uam.eps.ads.p3.biblioteca.usuarios.Usuario;
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
	 * @param ejemplar El ejemplar a prestar
	 * @param usuario El usuario que realiza el prestamo
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
	 * @param ejemplar El ejemplar a anyadir
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
	 * @param usuario El usuario que realiza el prestamo
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
	
	/**
	 * Devuelve la fecha máxima de devolución sin
	 * sanción de un prestamo
	 * @return La fecha de devolución
	 */
	
	public LocalDate getFechaDevolucion(){
		return this.fechaDevolucion;
	}
	
	public static int numPrestamosHistoricos(){
		return Prestamo.numPrestamosHistoricos;
	}
	
	/**
	 * Devuelve un entero con el número de prestamos
	 * no devueltos en la biblioteca.
	 * @return El número de prestamos no devueltos
	 */
	
	public static int numPrestamosPendientes(){
		return Prestamo.prestamosNoDevueltos.size();
	}
	
	/**
	 * Configura el número de prestamos historicos 
	 * @param n El número de prestamos historicos
	 */
	
	public static void setnumHistoricos(int n){
		Prestamo.numPrestamosHistoricos = n;
	}
	
	/**
	 * Calcula el numero de dias de retraso que lleva un prestamo
	 * @return Un entero con el numero de dias
	 */
	
	public int diasAtrasado(){
		int numDiasRetraso = Period.between(this.fechaVencimiento, FechaSimulada.getHoy()).getDays();
		return numDiasRetraso;
	}
	
	/**
	 * Anyade un nuevo prestamo a la lista de prestamos no devueltos
	 * @param p El prestamo a anyadir
	 */
	
	public static void addNuevoPrestamo(Prestamo p){
		Prestamo.prestamosNoDevueltos.add(p);
	}
	
	/**
	 * Realiza el proceso de devolucion de un prestamo, configurando
	 * la fecha de devolucion.
	 * @return True si la devolucion se ha realizado correctamente,
	 * false en caso de que el prestamo no exista.
	 */
	
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
	
	/**
	 * Elimina un prestamo del array de prestamos no devueltos
	 * @param p El prestamo a eliminar
	 */
	
	public static void devolucion(Prestamo p){
		Prestamo.prestamosNoDevueltos.remove(p);
	}
	
	/**
	 * Itera sobre la lista de prestamos no devueltos para devolver
	 * una lista inmutable con los prestamos que vencen en la fecha actual
	 * @return La lista inmutable de prestamos con vencimiento hoy
	 */
	
	public static List<Prestamo> conVencimientoHoy(){
		List<Prestamo> vencenHoy = new ArrayList<Prestamo>();
		for(Prestamo p : Prestamo.prestamosNoDevueltos){
			if(p.diasAtrasado() == 0){
				vencenHoy.add(p);
			}
		}
		return Collections.unmodifiableList(vencenHoy);
	}
	
	/**
	 * Itera sobre la lista de prestamos no devueltos para devolver
	 * una lista inmutable con los prestamos que ya han vencido
	 * @return La lista inmutable de prestamos con vencimiento en dias
	 * anteriores.
	 */
	
	public static List<Prestamo> pasadosDeVencimiento(){
		List<Prestamo> vencidos = new ArrayList<Prestamo>();
		for(Prestamo p : Prestamo.prestamosNoDevueltos){
			if(p.diasAtrasado() > 0)
				vencidos.add(p);
		}
		return Collections.unmodifiableList(vencidos);
	}
	
	/**
	 * Sobreescritura del metodo toString por defecto para que los prestamos
	 * sean impresos segun los requisitos del enunciado.
	 */
	
	@Override 
	public String toString(){
		if(this.fechaDevolucion == null)
		 return ejemplar+" prestado a "+" "+usuario+" hasta "+fechaVencimiento;
		return ejemplar+" prestado a "+" "+usuario+" hasta "+fechaVencimiento+" devuelto "+fechaDevolucion;
	}
	
}


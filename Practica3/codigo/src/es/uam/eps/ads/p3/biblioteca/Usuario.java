package es.uam.eps.ads.p3.biblioteca;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que abarca las caracteristicas mas generales de
 * los usuarios de la biblioteca.
 *   
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public abstract	class Usuario {
	
	private String nombre;
	private int nMaxPrestamos;
	private int nSanciones;
	private int nPrestados;
	private List<Prestamo> prestamos;
	
	/**
	 * Constructor de la clase Usuario
	 * @param nombre Nombre del usuario
	 * @param max Maximo numero de prestamos que puede tener el usuario
	 * @param nSanciones Dias de retraso sin sancion que puede tener el usuario
	 */
	
	public Usuario(String nombre, int max, int nSanciones){
		this.nombre = nombre;
		this.nMaxPrestamos = max;
		this.nPrestados = 0;
		this.prestamos = new ArrayList<Prestamo>(nMaxPrestamos);
		this.nSanciones = nSanciones;
	}
	
	/**
	 * Configura el numero maximo de prestamos disponibles
	 * para el usuario.
	 * @param nMaxPrestamos Entero con el numero de prestamos
	 */

	public void setnMaxPrestamos(int nMaxPrestamos) {
		this.nMaxPrestamos = nMaxPrestamos;
	}
	
	/**
	 * Devuelve el maximo numero de prestamos disponibles
	 * @return El numero de prestamos posibles
	 */
	
	public int getnMaxPrestamos(){
		return this.nMaxPrestamos;
	}
	
	/**
	 * Anyade un prestamo a la lista de prestamos del usuario
	 * @param prestamo El prestamo que toma de la biblioteca
	 * @return True si se ha realizado correctamente, false
	 * si no se ha podido realizar el prestamo.
	 */
	
	public boolean anyadirPrestamo(Prestamo prestamo){
		if (this.nPrestados == this.nMaxPrestamos){
			return false;
		}
		for(Prestamo p : this.prestamos){
			if(p.getEjemplar().getObra().equals(prestamo.getEjemplar().getObra())){
				return false;
			}
		}
		this.prestamos.add(prestamo);
		this.nPrestados++;
		// Aumentamos el contador de veces prestado de la obra
		prestamo.getEjemplar().getObra().prestar();
		return true;
	}
	
	/**
	 * Elimina el prestamo seleccionado de la lista de prestamos,
	 * si existe.
	 * @param prestamo El prestamo a borrar
	 * @return true si se ha realizado correctamente la devolucion,
	 * false si no existia el prestamo
	 */
	
	public boolean eliminarPrestamo(Prestamo prestamo){
		if(this.prestamos.contains(prestamo) == false){
			return false;
		}	
		this.prestamos.remove(prestamo);
		this.nPrestados--;
		return true;
	}


	/**
	 * Devuelve el nombre del usuario
	 * @return El nombre del usuario
	 */
	
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo para sancionar a un usuario por retraso
	 * @param dias Dias de retraso
	 */
	
	public abstract void sancionarPorRetraso(int dias);

	/**
	 * Devuelve el numero de dias de retraso permitidos
	 * para el usuario
	 * @return El numero de sanciones
	 */
	public int getnSanciones() {
		return nSanciones;
	}

	/**
	 * Configura el numero de dias de retraso permitido
	 * @param nSanciones El numero de dias de retraso
	 */
	public void setnSanciones(int nSanciones) {
		this.nSanciones = nSanciones;
	}
	
	/**
	 * Elimina la sancion impuesta a un usuario
	 */
	
	public abstract void eliminarSancion();
	
	public List<Prestamo> getPrestamos(){
		return Collections.unmodifiableList(this.prestamos);
	}
	
	
}

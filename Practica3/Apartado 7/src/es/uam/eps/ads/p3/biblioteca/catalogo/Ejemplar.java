package es.uam.eps.ads.p3.biblioteca.catalogo;

import es.uam.eps.ads.p3.biblioteca.Prestamo;
import es.uam.eps.ads.p3.biblioteca.usuarios.Usuario;

/**
 * Clase que contiene la informacion necesaria para gestionar
 * los ejemplares que serán prestados en la biblioteca
 *  
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Ejemplar {
	
	private Obra obra;
	private int id;
	private static int lastID = 1;
	private Prestamo prestamo;
	
	/**
	 * Constructor de la clase ejemplar
	 * @param obra Obra a la que el ejemplar hace referencia
	 */
	
	public Ejemplar(Obra obra){
		this.obra = obra;
		this.id = lastID;
		lastID++;
		prestamo = null;
	}
	
	/**
	 * Devuelve la obra a la que el ejemplar hace referencia
	 * @return La obra relacionada con el ejemplar
	 */
	
	public Obra getObra(){
		return this.obra;
	}
	
	/**
	 * Devuelve el ID del ejemplar
	 * @return Un entero con el id
	 */
	
	public int getID(){
		return this.id;
	}
	
	/**
	 * Comprueba si un ejemplar esta prestado
	 * @return True si esta prestado, false si esta disponible
	 */
	
	public boolean estaPrestado(){
		if(prestamo == null)
			return false;
		return true;
	}
	
	/**
	 * Realiza el prestamo del ejemplar, comprueba que el usuario
	 * cumple los requisitos, crea el prestamo y lo almacena en el registro
	 * de prestamos de la clase Prestamo.
	 * @param user El usuario que toma prestado el ejemplar
	 * @return El prestamo creado, null en caso de que el usuario no cumpla con
	 * los requisitos o si el ejemplar ya está prestado.
	 */
	
	public Prestamo prestar(Usuario user){
		// Aquí comprobamos si el ejemplar está prestado
		if(prestamo != null){
			return null;
		}
		Prestamo p = new Prestamo(this, user);
		/*
		 * El siguiente metodo comprueba si el usuario puede
		 * tomar prestado el ejemplar
		 */
		
		boolean error = user.anyadirPrestamo(p);
		if(error == false){
			return null;
		}
		this.prestamo = p;
		Prestamo.setnumHistoricos(Prestamo.numPrestamosHistoricos()+1);
		Prestamo.addNuevoPrestamo(this.prestamo);
		return this.prestamo;
	}
	
	/**
	 * Realiza el proceso de devolucion de un ejemplar, eliminandolo de los
	 * registros de Usuario y de Prestamo.
	 * @return True si se ha realizado correctamente, false en caso de que
	 * el prestamo no exista.
	 */
	
	public boolean devolver(){
		if(this.prestamo == null)
			return false;
		Prestamo.devolucion(this.prestamo);
		// Eliminamos el prestamo del array del usuario
		this.prestamo.getUsuario().eliminarPrestamo(this.prestamo);
		// Eliminamos el prestamo de la referencia del ejemplar
		this.prestamo = null;
		return true;
	}
	
	/**
	 * Sobreescritura del metodo toString por defecto para que los ejemplares
	 * sean impresos segun los requisitos del enunciado.
	 */
	
	@Override	
	public String toString(){
		if(prestamo != null)
			return "{"+id+obra+"(prestado)]";
		return "{"+id+obra+"(disponible)}";
	}
	
}

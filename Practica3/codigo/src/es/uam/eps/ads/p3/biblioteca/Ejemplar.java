package es.uam.eps.ads.p3.biblioteca;

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
	
	public int getID(){
		return this.id;
	}
	
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
		Prestamo.setnumPendientes(Prestamo.numPrestamosPendientes()+1);
		return this.prestamo;
	}
	
	public void devolver(){
		if(this.prestamo == null)
			return;
		// Eliminamos el prestamo del array del usuario
		this.prestamo.getUsuario().eliminarPrestamo(this.prestamo);
		// Eliminamos el prestamo de la referencia del ejemplar
		this.prestamo = null;
		Prestamo.setnumPendientes(Prestamo.numPrestamosPendientes()-1);
	}
	
	@Override	
	public String toString(){
		if(prestamo != null)
			return "{"+id+obra+"(prestado)]";
		return "{"+id+obra+"(disponible)}";
	}
	
}

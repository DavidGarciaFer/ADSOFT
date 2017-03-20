package es.uam.eps.ads.p3.biblioteca;
import java.util.*;

/**
 * Clase que abarca las caracteristicas mas generales de los articulos
 * de la biblioteca.
 *  
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public abstract class Obra {

	private final String titulo;   // El titulo de una obra no puede ser cambiado
	private final String autor;    // El autor de una obra no puede ser cambiado
	private final int anyo;        // El año de publicacion no puede ser cambiado
	private int plazo = 0;
	private int vecesPrestado = 0; // Común a todos los ejemplares de una obra
	private List<Ejemplar> ejemplares;
	
	
	/**
	 * Constructor de la clase Obra. 
	 * @param titulo Titulo de la obra. 
	 * @param autor Nombre del autor o director de la obra.
	 * @param anyo Año de publicacion de la obra.
	 * @param plazo Plazo base de devolución de la obra.
	 */
	
	public Obra(String titulo, String autor, int anyo, int plazo){
		this.anyo = anyo;
		this.titulo = titulo;
		this.autor = autor;
		this.plazo = plazo;
		this.vecesPrestado = 0;
	}
	
	/**
	 * Metodo para obtener el plazo de devolución de la obra
	 * @return Un entero con el numero de dias de plazo
	 */

	public int plazoPrestamo() {
		return plazo;
	}
	
	/**
	 * Configura el plazo de la obra
	 * @param plazo Entero con el numero de dias de plazo
	 */

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}
	
	/**
	 * Metodo para obtener el titulo de una obra
	 * @return String con el titulo de la obra
	 */

	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Metodo para obtener el autor de una obra
	 * @return String con el autor de la obra
	 */
	
	public String getAutor(){
		return this.autor;
	}
	
	/**
	 * Metodo para obtener el anyo de una obra
	 * @return String con el anyo de la obra
	 */
	
	public int getAnyo(){
		return this.anyo;
	}
	
	/**
	 * Devuelve el numero de veces que una obra ha sido prestada
	 * @return Numero de prestamos que ha tenido la obra
	 */
	
	public int getVecesPrestado(){
		return this.vecesPrestado;
	}
	
	/**
	 * Incrementa en 1 el numero de veces que la obra ha sido prestada
	 * Decrementa el plazo de prestado si es necesario.
	 */
	
	/**
	 * Configura el numero de veces que ha sido prestada una obra
	 * @param veces Numero de veces a añadir
	 */
	
	public void setVecesPrestado(int veces){
		this.vecesPrestado += veces;
	}
	
	public abstract void prestar();
	
	/**
	 * Añade un nuevo ejemplar al array de ejemplares
	 * de la obra.
	 * @param ejemplar El ejemplar a añadir
	 */
	
	public void addEjemplar(Ejemplar ejemplar){
		this.ejemplares.add(ejemplar);
	}
	

	public boolean equals(Obra o){
		if(this.titulo == o.getTitulo() && this.autor == o.getAutor()){
			return true;
		}
		return false;
	}
}

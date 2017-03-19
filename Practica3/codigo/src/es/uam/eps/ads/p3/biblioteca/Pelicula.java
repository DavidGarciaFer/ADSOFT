package es.uam.eps.ads.p3.biblioteca;

/**
 * Clase que contiene la informacion necesaria para gestionar
 * las peliculas de la biblioteca.
 *  
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Pelicula extends Obra{
	
	/**
	 * Enumeracion con las clases de generos a los que puede
	 * pertenecer una pelicula
	 */
	
	public enum Genero {
	    DRAMA, COMEDIA, TERROR, WESTERN, ACCION,
	    AVENTURAS, FANTASTICO, CARTOON, THRILLER,
	    SCIFI;
	}
	
	private Genero genero;
	
	/**
	 * Constructor de la clase Pelicula.
	 * @param titulo Titulo de la pelicula
	 * @param autor Director de la pelicula
	 * @param anyo Anyo de estreno de la pelicula
	 * @param genero Genero cinematografico
	 */
	
	public Pelicula(String titulo, String autor, int anyo, Genero genero){
		super(titulo, autor, anyo, 2);
		this.genero = genero;
	}
	
	/**
	 * Metodo que devuelve el genero al que pertenece 
	 * una pelicula
	 * @return Un elemento de la enumeracion Genero con el genero
	 */

	public Genero getGenero() {
		return genero;
	}
	
	/**
	 * Configura el genero al que pertenece una pelicula
	 * @param genero EL genero de la pelicula
	 */
	
	public void setGenero(Genero genero){
		this.genero = genero;
	}
	
	public void prestar(){
		// Pendiente de implementar en futuras versiones
	}
	
	@Override	
	public String toString(){
		return "[P:"+this.getTitulo()+", de "+this.getAutor()+" ("+this.getAnyo()
				+")plazo:"+this.getPlazo()+"]";
	}
	
}

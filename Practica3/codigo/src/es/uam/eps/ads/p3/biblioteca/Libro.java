package es.uam.eps.ads.p3.biblioteca;

/**
 * Clase que contiene la informacion necesaria para gestionar
 * los libros de la biblioteca.
 *  
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Libro extends Obra{
	
	private String editorial;
	private int edicion;
	
	/**
	 * Constructor de la clase Libro
	 * @param titulo Titulo del libro
	 * @param autor Nombre del escritor
	 * @param anyo Año de publicacion
	 * @param editorial Editoral de la edicion
	 * @param edicion Numero de edicion
	 */
	
	public Libro(String titulo, String autor, int anyo, String editorial, int edicion){
		super(titulo, autor, anyo, 25);
		this.editorial = editorial;
		this.edicion = edicion;
	}
	
	/**
	 * Constructor de la clase Libro que omite los campos
	 * de editorial y edicion.
	 * @param titulo Titulo del libro
	 * @param autor Nombre del escritor
	 * @param anyo Año de publicacion
	 */
	
	public Libro(String titulo, String autor, int anyo){
		super(titulo, autor, anyo, 25);
	}

	/**
	 * Metodo que devuelve el nombre de la editorial
	 * @return El nombre de la editorial
	 */
		
	public String getEditorial() {
		return editorial;
	}
	
	/**
	 * Metodo para configurar el nombre de la editorial
	 * @param editorial Nombre de la editorial
	 */

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	/**
	 * Metodo que devuelve el numero de edicion
	 * @return El numero de edicion
	 */

	public int getEdicion() {
		return edicion;
	}
	
	/**
	 * Metodo para configurar el numero de edicion
	 * @param edicion
	 */

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}
	
	public void prestar(){
		this.setVecesPrestado(1);
		// Comprobamos si es necesario decrementar los plazos
		if (this.getVecesPrestado() % 10 == 0){
			int plazo = this.plazoPrestamo();
			// Solo decrementamos si el numero de dias es al menos 7
			if (plazo > 7){
				this.setPlazo(plazo - 1);
			}
		}
	}
	
	@Override
	public String toString(){
		return "[L:"+this.getTitulo()+", de "+this.getAutor()+" ("+this.getAnyo()
				+") plazo:"+this.plazoPrestamo()+"]";
	}
}

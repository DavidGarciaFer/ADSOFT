package es.uam.eps.ads.p3.biblioteca;
import java.util.*;
import es.uam.eps.ads.p3.biblioteca.catalogo.Ejemplar;
import es.uam.eps.ads.p3.biblioteca.catalogo.Obra;
import es.uam.eps.ads.p3.biblioteca.usuarios.Usuario;;

/**
 * Clase biblioteca con patron Singleton que almacena
 * listas con todos los items que puede gestionar una biblioteca.
 *
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Biblioteca {
	
	private List<Prestamo> prestamosHist;
	private List<Ejemplar> ejemplaresDisp; // Son los ejemplares que un usuario puede tomar prestados
	private List<Usuario> usuarios;
	private List<Obra> catalogo;
	
	private static final Biblioteca Instance = new Biblioteca();
	
	/**
	 * Constructor privado de la clase Biblioteca, simplemente crea
	 * la instancia de las listas de las que se compone inicializandolas
	 * como un ArrayList
	 */
	
	private Biblioteca(){
		prestamosHist = new ArrayList<Prestamo>();
		ejemplaresDisp = new ArrayList<Ejemplar>();
		usuarios = new ArrayList<Usuario>();
		catalogo = new ArrayList<Obra>();
	}
	
	/**
	 * Devuelve la unica instancia de Biblioteca que 
	 * se puede manejar en el programa.
	 * @return La instancia de la bibioteca.
	 */
    
	public static Biblioteca getInstance(){
		return Biblioteca.Instance;
	}
	
	/**
	 * Devuelve una lista inmutable con todos los prestamos
	 * realizados por la biblioteca.
	 * @return La lista de prestamos historicos.
	 */
	
	public List<Prestamo> getPrestamosHist(){
		return Collections.unmodifiableList(prestamosHist);
	}
	
	/**
	 * Devuelve una lista inmutable con todos los ejemplares
	 * que un usuario puede tomar prestados. Existen instancias
	 * de ejemplares (fuera de circulacion) que no estan existen
	 * en esta lista.
	 * @return La lista de los ejemplares disponibles
	 */
	
	public List<Ejemplar> getEjemplaresDisp(){
		return Collections.unmodifiableList(ejemplaresDisp);
	}
	
	/**
	 * Devuelve una lista inmutable con todos los usuarios 
	 * afiliados a la biblioteca.
	 * @return La lista con todos los usuarios
	 */
	
	public List<Usuario> getUsuarios(){
		return Collections.unmodifiableList(usuarios);
	}

	/**
	 * Devuelve una lista inmutable con todas las obras que
	 *  aparecen en el catalogo de la biblioteca.
	 * @return La lista con las obras.
	 */
	
	public List<Obra> getObras(){
		return Collections.unmodifiableList(catalogo);
	}
	
	/**
	 * Anyade un prestamo al registro de prestamos historicos
	 * @param p El prestamo a anyadir
	 */
	
	public void addPrestamo(Prestamo p){
		this.prestamosHist.add(p);
	}
	
	/**
	 * Anyade un ejemplar al conjunto de ejemplares disponibles
	 * @param e El ejemplar a anyadir
	 */
	
	public void addEjemplar(Ejemplar e){
		this.ejemplaresDisp.add(e);
	}
	
	/**
	 * Anyade un usuario al conjunto de usuarios afiliados
	 * @param u El usuario a anyadir
	 */
	
	public void addUsuario(Usuario u){
		this.usuarios.add(u);
	}
	
	/**
	 * Anyade una obra al catalogo de la biblioteca
	 * @param o La obra a anyadir
	 */
	
	public void addObra(Obra o){
		this.catalogo.add(o);
	}
	
	/**
	 * Elimina un ejemplar disponible si no esta prestado 
	 * actualmente a ningun usuario.
	 * @param ejemplar El ejemplar a eliminar
	 * @return True, en caso de que se elimine. False si no
	 * existia o si esta prestado actualmente.
	 */
	
    public boolean eliminarEjemplar (Ejemplar ejemplar){
    	if(ejemplaresDisp.contains(ejemplar) == false)
    		return false;
    	// Si el ejemplar está prestado devolvemos false
    	if(ejemplar.estaPrestado() == true)
    		return false;
    	/**
    	 *  Si no está prestado lo elimino de la lista de 
    	 *  préstamos disponibles, pero sigue existiendo la instancia
    	 *  en los registros de préstamos
    	 */
    	
    	ejemplaresDisp.remove(ejemplar);
        return true;
    }
    
    /**
     * Elimina una obra del catalogo en caso de que ninguno de sus 
     * ejemplares este prestado. Tambien elimina sus ejemplares.
     * @param obra La obra a eliminar.
     * @return True en caso de que se elimine correctamente. False
     * en caso de que no exista o de que alguno de sus ejemplares este
     * prestado.
     */

    public boolean eliminarObra (Obra obra){
    	if(catalogo.contains(obra) == false)
    		return false;
    	/** 
    	 * Hemos decidido que si hay algun ejemplar prestado, ni la
    	 * la obra ni ninguno de sus ejemplares se pueda retirar. 
    	 */
    	List<Ejemplar> ejemplares = obra.getEjemplares();
    	Iterator<Ejemplar> it = ejemplares.iterator();
    	// Comprobamos que ningun ejemplar esta prestado
    	while(it.hasNext()){
    		if(it.next().estaPrestado() == true)
    			return false;
    	}
    	it = ejemplares.iterator();
    	while(it.hasNext()){
    		ejemplaresDisp.remove(it.next());
    	}
    	catalogo.remove(obra);
    	return true;
    }
}

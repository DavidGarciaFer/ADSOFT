package es.uam.eps.ads.p3.biblioteca;
import java.util.*;

public class Biblioteca {
	private static final Biblioteca Instance = new Biblioteca();
	
	private Biblioteca(){
	}
    
	private List<Prestamos> prestamosHist;
	private List<Ejemplar> ejemplares;
	private List<Usuario> usuarios;
	private List<Obras> obras;
	
	public static Biblioteca getInstance(){
		return Biblioteca.Instance;
	}

    public boolean eliminarEjemplar (Ejemplar ejemplar){
		if(this.ejemplares.contains(ejemplar) == false){
			return false;
		}
        if(ejemplar.prestamo != null){
            return false;
        }

        // Ponemos el prestamo del ejemplar a null para que no se borre en los prestamosHist
        ejemplar.prestamo = null;

        //Código para eliminar puntero que tiene obra del ejemplar

        this.ejemplares.remove(ejemplar);

        return true;
    }

    public boolean eliminarObra (Obra obra){
		if(this.obras.contains(obra) == false){
			return false;
		}
        for (Ejemplar ejem: obra.ejemplares){
            this.ejemplares.remove(ejem);
        }

        obra.ejemplares = null;

        return true;

     }
}

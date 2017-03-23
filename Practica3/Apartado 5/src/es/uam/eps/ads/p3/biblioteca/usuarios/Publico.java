package es.uam.eps.ads.p3.biblioteca.usuarios;

import es.uam.eps.ads.p3.biblioteca.Prestamo;

/**
 * Clase que contiene la informacion necesaria para gestionar
 * las acciones de los usuarios de tipo publico
 *  
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Publico extends Usuario{
	
	private int bonificacion = 0;
	// Constantes 
	private static final int plazoIni = 0;
	private static final int maxP = 2;
	
	/**
	 * Constructor de la clase Publico
	 * @param nombre El nombre del usuario
	 */
	
	public Publico(String nombre){
		super(nombre, maxP, plazoIni);
	}
	
	/**
	 * Elimina la bonficacion de un usuario.
	 * @param dias El numero de dias que el usuario es sancionado
	 */
	
	public void sancionarPorRetraso(int dias){
		if(dias  == 0){
			return;
		}
		else if(dias > bonificacion){
			// La ponemos a 0 para que no sea un número negativo
			bonificacion = 0;
		} else {
			bonificacion = bonificacion - (dias+1); // +1 porque el numero de bonificacion empieza en 1
		}
		// El numero máximo de prestados vuelve al valor inicial
		this.setnMaxPrestamos(maxP);
	}
	
	/**
	 * Anyade un prestamo al array de prestamos del usuario
	 * y maneja el sistema de bonificaciones
	 * @param prestamo El prestamo a anyadir
	 * @return True si se ha realizado correctamente, false si ha
	 * habido algun problema con los requisitos del usuario.
	 */
	
	public boolean anyadirPrestamo(Prestamo prestamo){
		if(prestamo == null)
			return false;
		boolean ret = super.anyadirPrestamo(prestamo);
		if(ret == false){
			return false;
		}
		bonificacion++;
		int max = this.getnMaxPrestamos();
		if(bonificacion > max){
			// En este caso aplicamos la bonificacion
			this.setnMaxPrestamos(max + 1);
			bonificacion = 1;
		}
		return true;
	}
	
	/**
	 * Elimina la sancion impuesta a un usuario
	 */
	
	public void eliminarSancion(){
		// Sera implementada en futuras versioes
	}
	
	/**
	 * Sobreescritura del metodo toString por defecto para que los usuarios
	 * publicos sean impresos segun los requisitos del enunciado.
	 */
	
	@Override
	public String toString(){
		return "[P: "+this.getNombre()+",ppb:"+(bonificacion)
				+",ps:"+this.getnMaxPrestamos()+"]";
	}
	
}

package es.uam.eps.ads.p3.biblioteca;

public class Publico extends Usuario{
	
	private int bonificacion = 0;
	
	public Publico(String nombre){
		super(nombre, 2, 0);
	}
	
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
		this.setnMaxPrestamos(2);
	}
	
	public boolean anyadirPrestamo(Prestamo prestamo){
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
	
	@Override
	public String toString(){
		return "[P: "+this.getNombre()+",ppb:"+(bonificacion)
				+",ps:"+this.getnMaxPrestamos()+"]";
	}
	
}

package p4.punit;

/**
 * Enumeracion con los tipos de unidades medibles..
 *
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public enum Quantity {
	TIEMPO, LONGITUD, COMPUESTA;
	
	public String toString(){
		if(this.equals(TIEMPO))
			return "t";
		return "L";
	}
	
}



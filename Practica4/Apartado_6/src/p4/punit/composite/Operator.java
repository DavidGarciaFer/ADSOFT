package p4.punit.composite;

/**
 * Operadores que pueden aparecer en una unidad compuesta
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public enum Operator {
	DIV, MULT;

	/**
	 * Devuelve el simbolo relacionado con cada operacion
	 * @return El simbolo de la operacion
	 */
	
	public String toString(){
		if(this.equals(DIV))
			return "/";
		return "*";		
	}

}

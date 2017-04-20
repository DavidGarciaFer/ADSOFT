package p4.punit.composite;

import p4.exceptions.QuantityException;
import p4.msys.si.IMetricSystem;
import p4.punit.IPhysicalUnit;
import p4.punit.Quantity;

/**
 * Implementacion de referencia para la interfaz ICompositeUnit
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class CompositeUnit implements ICompositeUnit{
	
	IPhysicalUnit u1, u2;
	Operator op;
	
	/**
	 * Constructor de la clase
	 * @param u1 Unidad izquierda
	 * @param op Operacion 
	 * @param u2 Unidad derecha
	 */
	
	public CompositeUnit(IPhysicalUnit u1, Operator op, IPhysicalUnit u2){
		this.u1 = u1;
		this.u2 = u2;
		this.op = op;
	}
	
	/**
	 * Metodo que devuelve si la unidad se puede transformar a otra que se 
	 * le pasa como parametro. Propio de unidades compuestas
	 * @param u La unidad a la que se quiere llegar
	 * @return true en caso afirmativo, false en caso negativo
	 */
	
	@Override
	public boolean canTransformTo(IPhysicalUnit u) {
		if(this.op.equals(((CompositeUnit) u).getOperator()) == false)
			return false;
		return this.u1.canTransformTo(((ICompositeUnit)u).getLeftUnit()) && this.u2.canTransformTo(((ICompositeUnit)u).getRightUnit());
	}
	
	/**
	 * Metodo que convierte una magnitud a una unidad que se le pasa como parametro.
	 * Propio de unidades compuestas.
	 * @param d Cantidad a transformar
	 * @param u Unidad fisica que quieres obtener
	 * @return double La cantidad transformada
	 * @throws QuantityException En caso de que las unidades no sean compatibles
	 */

	@Override
	public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
		if(this.canTransformTo(u) == false)
			throw new QuantityException(this,u);
		double left = this.u1.transformTo(1.0, ((CompositeUnit) u).getLeftUnit());
		double right = this.u2.transformTo(1.0, ((CompositeUnit) u).getRightUnit());
		
		System.out.println("El izquierdo vale: "+left+" Derecho vale: "+right);
		
		if(this.op.equals(Operator.DIV)){
			return d*(left/right);
		}
		return d*left*right;
	}
	
	/**
	 * Devuelve el tipo de quantity que posee la unidad,
	 * por simplificacion de la codificacion hemos determinado
	 * una "compuesta" para todos.
	 * @return Una cantidad de tipo compuesta
	 */
	
	@Override
	public Quantity getQuantity() {
		return Quantity.COMPUESTA;
	}
	
	/**
	 * Devuelve las abreviaturas de cada unidad concatenadas
	 * con el simbolo de la operacion
	 * @return String con las abreviaturas 
	 */

	@Override
	public String abbrev() {
		return u1.abbrev()+" "+op+" "+u2.abbrev();
	}

	/**
	 * No implementado ya que pueden ser dos sistemas
	 * metricos diferentes
	 */
	
	@Override
	public IMetricSystem getMetricSystem() {
		return null;
	}
	
	/**
	 * Devuelve el operador que rige la composicion
	 * @return Un tipo operator (multiplicacion o division)
	 */
	
	@Override
	public Operator getOperator() {
		return this.op;
	}
	
	/**
	 * Devuelve la primera unidad de la composicion 
	 * @return Un objeto que implemente la interfaz IPhysicalUnit
	 */

	@Override
	public IPhysicalUnit getLeftUnit() {
		return this.u1;
	}
	
	/**
	 * Devuelve la segunda unidad de la composicion 
	 * @return Un objeto que implemente la interfaz IPhysicalUnit
	 */
	
	@Override
	public IPhysicalUnit getRightUnit() {
		return this.u2;
	}
	
	/**
	 * Devuelve la abreviatura de la unidad
	 */
	
	@Override
	public String toString(){
		return this.abbrev();
	}

}

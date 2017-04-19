/**
 * 
 */
package p4.exceptions;

import p4.punit.IPhysicalUnit;

/**
 * @author davidgf
 *
 */
public class QuantityException extends Exception{

	private static final long serialVersionUID = -5835302066041999790L;
	protected IPhysicalUnit q1, q2;	
	
	public QuantityException(IPhysicalUnit q1, IPhysicalUnit q2){
		this.q1 = q1;
		this.q2 = q2;
	}
	
	@Override 
	public String toString(){
		return "Quantities "+q2.getQuantity()+" and "+q1.getQuantity()+" are not compatible.";
	}
}

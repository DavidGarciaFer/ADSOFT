/**
 * 
 */
package p4.punit;

/**
 * @author davidgf
 *
 */
public class QuantityException extends Exception{

	private static final long serialVersionUID = -5835302066041999790L;
	private Quantity q1, q2;	
	
	public QuantityException(Quantity q1, Quantity q2){
		this.q1 = q1;
		this.q2 = q2;
	}
	
	@Override 
	public String toString(){
		return "Quantities "+q1+" and "+q2+" are not compatible.";
	}
}

package p4.punit;

public class UnknownUnitException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6623063048010430089L;
	Quantity q1;
	
	public UnknownUnitException(Quantity quantity){
		this.q1 = quantity;
	}
	@Override
	public String toString(){
		return "Unknown unit " + q1;
	}
}

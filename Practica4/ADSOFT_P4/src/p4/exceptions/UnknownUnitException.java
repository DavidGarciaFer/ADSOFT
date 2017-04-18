package p4.exceptions;

import p4.punit.IPhysicalUnit;
import p4.punit.PhysicalUnit;

public class UnknownUnitException extends QuantityException {
	private static final long serialVersionUID = -6623063048010430089L;
	protected PhysicalUnit q1;
	
	public UnknownUnitException(IPhysicalUnit q, IPhysicalUnit p){
		super(q,null);
	}
	@Override
	public String toString(){
		return "Unknown unit " + q1;
	}
}

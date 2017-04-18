package p4.exceptions;

import p4.punit.IPhysicalUnit;

public class TypeException extends QuantityException{

	private static final long serialVersionUID = 1L;
	
	public TypeException(IPhysicalUnit q1, IPhysicalUnit q2) {
		super(q1, q2);
	}

	@Override
	public String toString(){
		return "Cannot transform "+q1+" to "+q2;
	}
	
}

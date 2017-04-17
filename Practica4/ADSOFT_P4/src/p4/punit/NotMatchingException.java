package p4.punit;

public class NotMatchingException extends UnknownUnitException{

	private static final long serialVersionUID = 1L;
	
	public NotMatchingException(IPhysicalUnit q1, IPhysicalUnit q2) {
		super(q1, q2);		
	}

	public String toString(){
		return "Las unidades "+q1+" y "+q2+" a transformar no corresponden con las del conversor invocado.";
	}


}

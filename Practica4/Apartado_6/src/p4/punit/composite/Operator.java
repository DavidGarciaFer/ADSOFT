package p4.punit.composite;

public enum Operator {
	DIV, MULT;

	public String toString(){
		if(this.equals(DIV))
			return "/";
		return "*";		
	}

}

package p4.punit;

public abstract class LengthUnit extends PhysicalUnit{
	
	private static Quantity q = Quantity.LONGITUD;
	
	public LengthUnit(double measure, IMetricSystem sys) {
		super(measure, sys);
	}
	
	public Quantity getQuantity(){
		return q;
	}
	
	public double getMeasure(){
		return super.getMeasure();
	}

	public abstract String abbrev();
	
}
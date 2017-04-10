package p4.punit;

public abstract class LengthUnit extends PhysicalUnit{
	
	private static final Quantity q = Quantity.LONGITUD;
	
	public LengthUnit(double measure) {
		super(measure);
	}
	
	public Quantity getQuantity(){
		return LengthUnit.q;
	}
	
	public double getMeasure(){
		return super.getMeasure();
	}
		
}

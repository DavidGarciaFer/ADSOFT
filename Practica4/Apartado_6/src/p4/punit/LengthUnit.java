package p4.punit;

import p4.msys.si.IMetricSystem;

public class LengthUnit extends PhysicalUnit{
	
	private static final Quantity q = Quantity.LONGITUD;
	
	public LengthUnit(double measure, String ab, IMetricSystem sys) {
		super(measure, ab, sys);
	}
	
	public Quantity getQuantity(){
		return q;
	}

	@Override
	public IMetricSystem getMetricSystem() {
		return super.getSystem();
	}

	
}
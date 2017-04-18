package p4.punit;

import p4.msys.si.IMetricSystem;

public class TimeUnit extends PhysicalUnit{
	
	private static final Quantity q = Quantity.TIEMPO;
	
	public TimeUnit(double measure, String ab, IMetricSystem sys) {
		super(measure,ab, sys);
	}
	
	public Quantity getQuantity(){
		return TimeUnit.q;
	}
	
	@Override
	public IMetricSystem getMetricSystem() {
		return super.getSystem();
	}
		
}

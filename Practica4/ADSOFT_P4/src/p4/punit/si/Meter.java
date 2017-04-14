package p4.punit.si;

import p4.punit.IMetricSystem;
import p4.punit.LengthUnit;

public class Meter extends LengthUnit{
	
	
	public Meter() {
		super(1, SiLengthMetricSystem.SYSTEM);
	}

	@Override
	public String abbrev() {
		return "m";
	}
	@Override
	public IMetricSystem getMetricSystem() {
		return super.getSystem();
	}
	
}

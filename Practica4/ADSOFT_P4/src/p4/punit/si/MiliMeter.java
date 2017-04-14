package p4.punit.si;

import p4.punit.IMetricSystem;
import p4.punit.LengthUnit;

public class MiliMeter extends LengthUnit{
	
	
	public MiliMeter() {
		super(0.001, SiLengthMetricSystem.SYSTEM);
	}

	@Override
	public String abbrev() {
		return "mm";
	}
	@Override
	public IMetricSystem getMetricSystem() {
		return super.getSystem();
	}
	
}

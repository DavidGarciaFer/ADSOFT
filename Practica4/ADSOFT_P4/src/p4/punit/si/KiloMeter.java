package p4.punit.si;

import p4.punit.IMetricSystem;
import p4.punit.LengthUnit;

public class KiloMeter extends LengthUnit{
	
	
	public KiloMeter() {
		super(1000, SiLengthMetricSystem.SYSTEM);
	}

	@Override
	public String abbrev() {
		return "km";
	}
	@Override
	public IMetricSystem getMetricSystem() {
		return super.getSystem();
	}
}

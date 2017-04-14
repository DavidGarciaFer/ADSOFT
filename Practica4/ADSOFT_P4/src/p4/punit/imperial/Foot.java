package p4.punit.imperial;

import p4.punit.IMetricSystem;
import p4.punit.LengthUnit;

public class Foot extends LengthUnit{
	
	
	public Foot() {
		super(1, ImperialLengthMetricSystem.SYSTEM);
	}

	@Override
	public String abbrev() {
		return "ft";
	}
	@Override
	public IMetricSystem getMetricSystem() {
		return super.getSystem();
	}
	
}

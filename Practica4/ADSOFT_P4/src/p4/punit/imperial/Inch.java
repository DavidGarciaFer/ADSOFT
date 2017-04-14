package p4.punit.imperial;

import p4.punit.IMetricSystem;
import p4.punit.LengthUnit;

public class Inch extends LengthUnit{
	
	IMetricSystem sys = ImperialLengthMetricSystem.SYSTEM;
	
	public Inch() {
		super(1/12, ImperialLengthMetricSystem.SYSTEM);
	}

	@Override
	public String abbrev() {
		return "in";
	}
	@Override
	public IMetricSystem getMetricSystem() {
		return super.getSystem();
	}
	
}

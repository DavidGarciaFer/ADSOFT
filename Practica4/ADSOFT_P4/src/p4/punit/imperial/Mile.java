package p4.punit.imperial;

import p4.punit.IMetricSystem;
import p4.punit.LengthUnit;

public class Mile extends LengthUnit{
	
	
	public Mile() {
		super(5280, ImperialLengthMetricSystem.SYSTEM);
	}

	@Override
	public String abbrev() {
		return "ml";
	}
	@Override
	public IMetricSystem getMetricSystem() {
		return super.getSystem();
	}
}

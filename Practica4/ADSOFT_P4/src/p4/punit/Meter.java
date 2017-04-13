package p4.punit;

public class Meter extends LengthUnit{
	
	
	public Meter() {
		super(1, SiLengthMetricSystem.SYSTEM);
	}

	@Override
	public String abbrev() {
		return "m";
	}
	
}

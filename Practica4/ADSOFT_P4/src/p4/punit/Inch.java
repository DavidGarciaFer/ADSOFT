package p4.punit;

public class Inch extends LengthUnit{
	
	IMetricSystem sys = ImperialLengthMetricSystem.SYSTEM;
	
	public Inch() {
		super(1/12, ImperialLengthMetricSystem.SYSTEM);
	}

	@Override
	public String abbrev() {
		return "in";
	}
	
}

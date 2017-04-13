package p4.punit;

public class Foot extends LengthUnit{
	
	
	public Foot() {
		super(1, ImperialLengthMetricSystem.SYSTEM);
	}

	@Override
	public String abbrev() {
		return "ft";
	}
	
}

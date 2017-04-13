package p4.punit;

public class Mile extends LengthUnit{
	
	
	public Mile() {
		super(5280, ImperialLengthMetricSystem.SYSTEM);
	}

	@Override
	public String abbrev() {
		return "ml";
	}
	
}

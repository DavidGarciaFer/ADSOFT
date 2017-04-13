package p4.punit;

public class MiliMeter extends LengthUnit{
	
	
	public MiliMeter() {
		super(0.001, SiLengthMetricSystem.SYSTEM);
	}

	@Override
	public String abbrev() {
		return "mm";
	}
	
}

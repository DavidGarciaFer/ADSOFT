package p4.punit;

public class KiloMeter extends LengthUnit{
	
	
	public KiloMeter() {
		super(1000, SiLengthMetricSystem.SYSTEM);
	}

	@Override
	public String abbrev() {
		return "km";
	}
	
}

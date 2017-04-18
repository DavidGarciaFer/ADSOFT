package p4.msys.imperial;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import p4.msys.MetricSystem;
import p4.punit.IPhysicalUnit;
import p4.punit.LengthUnit;

public class ImperialLengthMetricSystem extends MetricSystem{
	public static final ImperialLengthMetricSystem SYSTEM = new ImperialLengthMetricSystem();
	public static final LengthUnit FOOT = new LengthUnit(1, "ft", SYSTEM);
	public static final LengthUnit MILE =  new LengthUnit(5280, "ml", SYSTEM);
	public static final LengthUnit INCH =  new LengthUnit(1/12, "in", SYSTEM);
	

	@Override
	public IPhysicalUnit base() {
		return FOOT;
	}

	@Override
	public Collection<IPhysicalUnit> units() {
		List<IPhysicalUnit> units = new ArrayList<IPhysicalUnit>();
		units.add(MILE);
		units.add(FOOT);
		units.add(INCH);
		return units;
	}

}

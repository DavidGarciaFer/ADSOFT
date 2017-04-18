package p4.msys.si;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import p4.msys.MetricSystem;
import p4.punit.IPhysicalUnit;
import p4.punit.LengthUnit;

public class SiLengthMetricSystem extends MetricSystem{
	public static final SiLengthMetricSystem SYSTEM = new SiLengthMetricSystem();
	public static final LengthUnit METER = new LengthUnit(1, "m", SYSTEM);
	public static final LengthUnit KILOMETER =  new LengthUnit(1000, "km", SYSTEM);
	public static final LengthUnit MILIMETER =  new LengthUnit(0.001, "mm", SYSTEM);
	

	@Override
	public IPhysicalUnit base() {
		return METER;
	}

	@Override
	public Collection<IPhysicalUnit> units() {
		List<IPhysicalUnit> units = new ArrayList<IPhysicalUnit>();
		units.add(KILOMETER);
		units.add(METER);
		units.add(MILIMETER);
		return units;
	}

}

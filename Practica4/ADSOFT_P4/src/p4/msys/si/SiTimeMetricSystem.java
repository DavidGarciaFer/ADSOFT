package p4.msys.si;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import p4.msys.MetricSystem;
import p4.punit.IPhysicalUnit;
import p4.punit.TimeUnit;

public class SiTimeMetricSystem extends MetricSystem{
	public static final SiTimeMetricSystem SYSTEM = new SiTimeMetricSystem();
	public static TimeUnit SECOND = new TimeUnit(1, "s", SYSTEM);
	public static TimeUnit HOUR = new TimeUnit(3600, "h", SYSTEM);
	public static TimeUnit MILISECOND = new TimeUnit(0.001, "ms", SYSTEM);

	@Override
	public IPhysicalUnit base() {
		return SECOND;
	}

	@Override
	public Collection<IPhysicalUnit> units() {
		List<IPhysicalUnit> units = new ArrayList<IPhysicalUnit>();
		units.add(HOUR);
		units.add(SECOND);
		units.add(MILISECOND);
		return units;
	}
}

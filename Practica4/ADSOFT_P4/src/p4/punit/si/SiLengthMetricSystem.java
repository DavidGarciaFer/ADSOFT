package p4.punit.si;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import p4.punit.IMetricSystem;
import p4.punit.IMetricSystemConverter;
import p4.punit.IPhysicalUnit;
import p4.punit.LengthUnit;
import p4.punit.Quantity;
import p4.punit.imperial.MetricSystem;

public class SiLengthMetricSystem extends MetricSystem{
	public static final SiLengthMetricSystem SYSTEM = new SiLengthMetricSystem();
	public static final LengthUnit METER = new Meter();
	public static final LengthUnit KILOMETER = new KiloMeter();
	public static final LengthUnit MILIMETER = new MiliMeter();
	
	private SiLengthMetricSystem(){
		quantity = Quantity.LONGITUD;
	}

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

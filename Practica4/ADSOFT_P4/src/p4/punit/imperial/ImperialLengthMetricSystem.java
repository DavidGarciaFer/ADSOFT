package p4.punit.imperial;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import p4.punit.IMetricSystem;
import p4.punit.IMetricSystemConverter;
import p4.punit.IPhysicalUnit;
import p4.punit.LengthUnit;
import p4.punit.Quantity;

public class ImperialLengthMetricSystem extends MetricSystem{
	public static final ImperialLengthMetricSystem SYSTEM = new ImperialLengthMetricSystem();
	public static LengthUnit FOOT = new Foot();
	public static LengthUnit MILE = new Mile();
	public static LengthUnit INCH = new Inch();
	
	private ImperialLengthMetricSystem(){
		quantity = Quantity.LONGITUD;
	}

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

package p4.punit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SiLengthMetricSystem implements IMetricSystem{
	public static final SiLengthMetricSystem SYSTEM = new SiLengthMetricSystem();
	public static final LengthUnit METER = new Meter();
	public static final LengthUnit KILOMETER = new KiloMeter();
	public static final LengthUnit MILIMETER = new MiliMeter();
	private Quantity quantity;
	
	
	private SiLengthMetricSystem(){
		quantity = Quantity.LONGITUD;
	}
	
	public Quantity getQuantity() {
		return this.quantity;
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

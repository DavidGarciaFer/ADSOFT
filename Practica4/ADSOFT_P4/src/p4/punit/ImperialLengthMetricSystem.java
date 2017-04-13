package p4.punit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ImperialLengthMetricSystem implements IMetricSystem{
	public static final ImperialLengthMetricSystem SYSTEM = new ImperialLengthMetricSystem();
	public static LengthUnit FOOT = new Foot();
	public static LengthUnit MILE = new Mile();
	public static LengthUnit INCH = new Inch();
	private Quantity quantity;
	
	
	private ImperialLengthMetricSystem(){
		quantity = Quantity.LONGITUD;
	}
	
	public Quantity getQuantity() {
		return this.quantity;
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

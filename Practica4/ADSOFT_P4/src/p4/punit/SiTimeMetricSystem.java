package p4.punit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SiTimeMetricSystem implements IMetricSystem{
	public static TimeUnit SECOND;
	public static TimeUnit HOUR;
	public static TimeUnit MILISECOND;
	public static final SiTimeMetricSystem SYSTEM = new SiTimeMetricSystem();
	
	private Quantity quantity = Quantity.LONGITUD;
	
	
	private SiTimeMetricSystem(){
		SECOND = new TimeUnit(1, SYSTEM);
		HOUR = new TimeUnit(3600, SYSTEM);
		MILISECOND = new TimeUnit(0.001, SYSTEM);
	}
	
	public Quantity getQuantity() {
		return this.quantity;
	}

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

package p4.punit.si;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import p4.punit.IMetricSystem;
import p4.punit.IMetricSystemConverter;
import p4.punit.IPhysicalUnit;
import p4.punit.Quantity;
import p4.punit.TimeUnit;

public class SiTimeMetricSystem implements IMetricSystem{
	public static TimeUnit SECOND;
	public static TimeUnit HOUR;
	public static TimeUnit MILISECOND;
	public static final SiTimeMetricSystem SYSTEM = new SiTimeMetricSystem();
	
	private Quantity quantity = Quantity.LONGITUD;
	private static ArrayList<IMetricSystemConverter> converters = new ArrayList<IMetricSystemConverter>();
	
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
	
	public static void registerConverter(IMetricSystemConverter ic){
		if (converters.contains(ic) == false){
			converters.add(ic);
		}
	}

	@Override
	public IMetricSystemConverter getConverter(IMetricSystem to) {
		for (IMetricSystemConverter imc: converters){
			if(imc.targetSystem().equals(to))
				return imc;
		}
		return null;
	}
}
package p4.punit.si;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import p4.punit.IMetricSystem;
import p4.punit.IMetricSystemConverter;
import p4.punit.IPhysicalUnit;
import p4.punit.LengthUnit;
import p4.punit.Quantity;

public class SiLengthMetricSystem implements IMetricSystem{
	public static final SiLengthMetricSystem SYSTEM = new SiLengthMetricSystem();
	public static final LengthUnit METER = new Meter();
	public static final LengthUnit KILOMETER = new KiloMeter();
	public static final LengthUnit MILIMETER = new MiliMeter();
	private Quantity quantity;
	private static ArrayList<IMetricSystemConverter> converters = new ArrayList<IMetricSystemConverter>();
	
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

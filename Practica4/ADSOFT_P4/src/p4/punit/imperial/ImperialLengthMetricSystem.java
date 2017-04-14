package p4.punit.imperial;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import p4.punit.IMetricSystem;
import p4.punit.IMetricSystemConverter;
import p4.punit.IPhysicalUnit;
import p4.punit.LengthUnit;
import p4.punit.Quantity;

public class ImperialLengthMetricSystem implements IMetricSystem{
	public static final ImperialLengthMetricSystem SYSTEM = new ImperialLengthMetricSystem();
	public static LengthUnit FOOT = new Foot();
	public static LengthUnit MILE = new Mile();
	public static LengthUnit INCH = new Inch();
	private Quantity quantity;
	private static ArrayList<IMetricSystemConverter> converters = new ArrayList<IMetricSystemConverter>();
	
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

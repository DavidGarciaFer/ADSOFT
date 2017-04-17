package p4.punit.imperial;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import p4.punit.IMetricSystem;
import p4.punit.IMetricSystemConverter;
import p4.punit.IPhysicalUnit;
import p4.punit.Quantity;

public abstract class MetricSystem implements IMetricSystem {
	

	protected Quantity quantity;
	protected static ArrayList<IMetricSystemConverter> converters = new ArrayList<IMetricSystemConverter>();

	@Override
	public abstract IPhysicalUnit base();

	@Override
	public abstract Collection<IPhysicalUnit> units();
	
	public Quantity getQuantity() {
		return this.quantity;
	}

	
	public List<IMetricSystemConverter> getConverters(){
		return converters;
	}
	
	public static void registerConverter(IMetricSystemConverter ic){
		if (converters.contains(ic) == false){
			converters.add(ic);
			((MetricSystem) ic.targetSystem()).getConverters().add(ic.reverse());
		}
	}
	
	public IMetricSystemConverter getConverter(IMetricSystem to) {
		for (IMetricSystemConverter imc: converters){
			if(imc.targetSystem().equals(to))
				return imc;
		}
		return null;
	}

}

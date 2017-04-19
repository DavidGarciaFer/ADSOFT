package p4.msys.si;

import java.util.Collection;

import p4.msys.converter.IMetricSystemConverter;
import p4.punit.IPhysicalUnit;

public interface IMetricSystem {
	IPhysicalUnit base();
	Collection<IPhysicalUnit> units();
	// Added for convertible
	IMetricSystemConverter getConverter(IMetricSystem to);
}

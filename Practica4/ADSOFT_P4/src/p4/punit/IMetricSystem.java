package p4.punit;

import java.util.Collection;

public interface IMetricSystem {
	IPhysicalUnit base();
	Collection<IPhysicalUnit> units();
	// Added for convertible
	IMetricSystemConverter getConverter(IMetricSystem to);
}

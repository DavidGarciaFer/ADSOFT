package p4.msys.converter;

import p4.exceptions.UnknownUnitException;
import p4.magnitude.IMagnitude;
import p4.msys.si.IMetricSystem;
import p4.punit.IPhysicalUnit;

public interface IMetricSystemConverter {
	IMetricSystem sourceSystem();
	IMetricSystem targetSystem();
	IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException;
	IMetricSystemConverter reverse();
}

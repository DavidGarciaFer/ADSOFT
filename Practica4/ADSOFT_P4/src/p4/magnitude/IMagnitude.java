package p4.magnitude;

import p4.exceptions.QuantityException;
import p4.punit.IPhysicalUnit;

public interface IMagnitude {
	IMagnitude add (IMagnitude m) throws QuantityException;
	IMagnitude subs(IMagnitude m) throws QuantityException;
	IMagnitude transformTo(IPhysicalUnit c) throws QuantityException;
	IPhysicalUnit getUnit();
	double getValue();
}
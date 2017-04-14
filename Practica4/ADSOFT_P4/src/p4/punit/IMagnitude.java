package p4.punit;

public interface IMagnitude {
	IMagnitude add (IMagnitude m) throws QuantityException;
	IMagnitude subs(IMagnitude m) throws QuantityException;
	IMagnitude transformTo(IPhysicalUnit c) throws QuantityException;
	IPhysicalUnit getUnit();
	double getValue();
}
package p4.punit.composite;

import p4.punit.IPhysicalUnit;

public interface ICompositeUnit extends IPhysicalUnit{
	Operator getOperator();
	IPhysicalUnit getLeftUnit();
	IPhysicalUnit getRightUnit();
}


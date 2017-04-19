package p4.punit.composite;

import p4.exceptions.QuantityException;
import p4.msys.si.IMetricSystem;
import p4.punit.IPhysicalUnit;
import p4.punit.Quantity;

public class CompositeUnit implements ICompositeUnit{
	
	IPhysicalUnit u1, u2;
	Operator op;
	
	public CompositeUnit(IPhysicalUnit u1, Operator op, IPhysicalUnit u2){
		this.u1 = u1;
		this.u2 = u2;
		this.op = op;
	}
	
	@Override
	public boolean canTransformTo(IPhysicalUnit u) {
		if(this.op.equals(((CompositeUnit) u).getOperator()) == false)
			return false;
		return this.u1.canTransformTo(((ICompositeUnit)u).getLeftUnit()) && this.u2.canTransformTo(((ICompositeUnit)u).getRightUnit());
	}

	@Override
	public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
		if(this.canTransformTo(u) == false)
			throw new QuantityException(this,u);
		double left = this.u1.transformTo(1.0, ((CompositeUnit) u).getLeftUnit());
		double right = this.u2.transformTo(1.0, ((CompositeUnit) u).getRightUnit());
		
		System.out.println("El izquierdo vale: "+left+" Derecho vale: "+right);
		
		if(this.op.equals(Operator.DIV)){
			return d*(left/right);
		}
		return d*left*right;
	}

	@Override
	public Quantity getQuantity() {
		return Quantity.COMPUESTA;
	}

	@Override
	public String abbrev() {
		return u1.abbrev()+" "+op+" "+u2.abbrev();
	}

	/**
	 * No implementado ya que pueden ser dos sistemas
	 * metricos diferentes
	 * @see Magnitude - transformTo()
	 */
	
	@Override
	public IMetricSystem getMetricSystem() {
		return null;
	}

	@Override
	public Operator getOperator() {
		return this.op;
	}

	@Override
	public IPhysicalUnit getLeftUnit() {
		return this.u1;
	}

	@Override
	public IPhysicalUnit getRightUnit() {
		return this.u2;
	}
	
	@Override
	public String toString(){
		return this.abbrev();
	}

}

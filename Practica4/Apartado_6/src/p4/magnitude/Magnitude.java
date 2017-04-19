/**
 * 
 */
package p4.magnitude;

import p4.exceptions.QuantityException;
import p4.exceptions.TypeException;
import p4.msys.converter.IMetricSystemConverter;
import p4.punit.IPhysicalUnit;
import p4.punit.composite.*;

/**
 * @author luis
 *
 */
public class Magnitude implements IMagnitude{
	private IPhysicalUnit unit;
	private double value;
	
	public Magnitude(double value, IPhysicalUnit unit){
		this.value = value;
		this.unit = unit;
	}
	
	public IMagnitude add (IMagnitude m) throws QuantityException{
		m = m.transformTo(this.unit);
		this.value += m.getValue();
		return this;
	}
	public IMagnitude subs(IMagnitude m) throws QuantityException{
		m = m.transformTo(this.unit);
		this.value -= m.getValue();
		return this;
	}
	
	public IMagnitude transformTo(IPhysicalUnit c) throws QuantityException{
		if(this.unit.canTransformTo(c) == false)
			throw new QuantityException(this.unit,c);
		if(this.unit instanceof CompositeUnit && c instanceof CompositeUnit){
			double val = this.value;
			IMagnitude m1 = new Magnitude(1, ((CompositeUnit) this.unit).getLeftUnit());
			IMagnitude m2 = new Magnitude(1, ((CompositeUnit) this.unit).getRightUnit());
			m1 = m1.transformTo(((CompositeUnit) c).getLeftUnit());
			m2 = m2.transformTo(((CompositeUnit) c).getRightUnit());
			if(((CompositeUnit) this.unit).getOperator().equals(Operator.DIV)){
				return new Magnitude(val*m1.getValue()/m2.getValue(), c);
			}
			return new Magnitude(val*m1.getValue()*m2.getValue(), c);
		}	
		
		if(this.unit.getMetricSystem().equals(c.getMetricSystem()) == true)
			return new Magnitude(this.getUnit().transformTo(value, c), c);
		IMetricSystemConverter conv = this.unit.getMetricSystem().getConverter(c.getMetricSystem());
			if( conv == null){
				throw new TypeException(this.unit, c);
			}
		
		return 	conv.transformTo(this, c);
		
	}
	
	public IPhysicalUnit getUnit(){
		return unit;
	}
	public double getValue(){
		return value;
	}
	
	@Override
	public String toString(){
		return this.value + " [" + this.unit + "]";
	}
}

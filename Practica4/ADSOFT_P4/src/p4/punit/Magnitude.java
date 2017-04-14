/**
 * 
 */
package p4.punit;

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
		Magnitude im = new Magnitude(this.unit.transformTo(this.value, c), c);
		return im;
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

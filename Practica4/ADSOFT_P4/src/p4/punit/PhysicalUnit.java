package p4.punit;

public abstract class PhysicalUnit implements IPhysicalUnit{
	
	private double measure; // Sirve para la conversión entre tipos 
	private IMetricSystem sys;
	
	public PhysicalUnit(double measure, IMetricSystem sys){
		this.measure = measure;
		this.sys = sys;
	}
	
	public double getMeasure(){
		return this.measure;
	}
	
	public boolean canTransformTo(IPhysicalUnit u){
		if((this.getQuantity().equals(Quantity.TIEMPO) && u.getQuantity().equals(Quantity.LONGITUD))
				|| (this.getQuantity().equals(Quantity.LONGITUD)) && u.getQuantity().equals(Quantity.TIEMPO))
			return false;
		// Si el conversor no ha sido agregado no podemos transformar de una unidad a otra
		if(this.sys.equals(((PhysicalUnit) u).getSystem()) == false){
			if(sys.getConverter(u.getMetricSystem()) == null){
				return false;
			}
		}
		return true;
	}
		
	public IMetricSystem getSystem(){
		return this.sys;
	}
	
	@Override
	public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
		if(this.canTransformTo(u) == false)
			throw new QuantityException(this,(PhysicalUnit) u);
			return d*this.getMeasure()/(((PhysicalUnit) u).getMeasure());
	}
	
	@Override
	public String toString(){
		return this.abbrev() + " " + this.getQuantity();
	}
	
}

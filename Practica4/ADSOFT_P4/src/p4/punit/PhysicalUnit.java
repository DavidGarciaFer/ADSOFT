package p4.punit;

public abstract class PhysicalUnit implements IPhysicalUnit{
	
	private double measure; // Sirve para la conversión entre tipos 
	
	public PhysicalUnit(double measure){
		this.measure = measure;
	}
	
	public double getMeasure(){
		return this.measure;
	}
	
	public boolean canTransformTo(IPhysicalUnit u){
		if((this.getQuantity().equals(Quantity.TIEMPO) && u.getQuantity().equals(Quantity.LONGITUD))
				|| (this.getQuantity().equals(Quantity.LONGITUD)) && u.getQuantity().equals(Quantity.TIEMPO))
			return false;
		return true;
	}
	
	public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
		if(this.canTransformTo(u) == false)
			throw new QuantityException(this.getQuantity(),u.getQuantity());
		
		return d*((PhysicalUnit) u).getMeasure()/this.getMeasure();
	}
	
}

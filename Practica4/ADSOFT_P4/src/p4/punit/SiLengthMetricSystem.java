package p4.punit;

public class SiLengthMetricSystem extends PhysicalUnit implements IPhysicalUnit{
	public static final SiLengthMetricSystem METER = new SiLengthMetricSystem();
	public static final SiLengthMetricSystem KILOMETER = new SiLengthMetricSystem();
	public static final SiLengthMetricSystem MILIMETER = new SiLengthMetricSystem();
	
	private Quantity quantity = Quantity.LONGITUD;
	
	
	private SiLengthMetricSystem(){
		
	}
	
	@Override
	public boolean canTransformTo(IPhysicalUnit u) {
		return super.canTransformTo(u);
	}
	@Override
	public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Quantity getQuantity() {
		return this.quantity;
	}
	@Override
	public String abbrev() {
		if(this.equals(METER))
			return "m";
		if(this.equals(KILOMETER))
			return "km";
		return "mm";
	}
}

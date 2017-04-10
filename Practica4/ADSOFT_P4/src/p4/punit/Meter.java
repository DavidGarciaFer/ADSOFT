package p4.punit;

public final class Meter extends PhysicalUnit {

	public Meter(double measure) {
		super(1);
	}

	@Override
	public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
		return super.canTransformTo(d, u);
	}

	@Override
	public Quantity getQuantity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String abbrev() {
		// TODO Auto-generated method stub
		return null;
	}

}

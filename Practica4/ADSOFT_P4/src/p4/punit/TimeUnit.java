package p4.punit;

public class TimeUnit extends PhysicalUnit{
	
	private static final Quantity q = Quantity.TIEMPO;
	
	public TimeUnit(double measure, IMetricSystem sys) {
		super(measure,sys);
	}
	
	public Quantity getQuantity(){
		return TimeUnit.q;
	}
	
	
	public double getMeasure(){
		return super.getMeasure();
	}
	
	@Override
	public String abbrev() {
		double m = this.getMeasure();
		if (m == 1)
			return "s";
		else if (m == 3600)
			return "h";
		return "ms";
	}
		
}

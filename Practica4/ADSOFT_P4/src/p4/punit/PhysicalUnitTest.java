package p4.punit;

public class PhysicalUnitTest {

	public static void main(String[] args) throws QuantityException {
		IPhysicalUnit meter = SiLengthMetricSystem.METER;
		System.out.println(meter);
		System.out.println(meter.canTransformTo(SiLengthMetricSystem.KILOMETER));
		System.out.println(meter.canTransformTo(SiTimeMetricSystem.SECOND));
		System.out.println("1000 m en km: "+meter.transformTo(1000, SiLengthMetricSystem.KILOMETER));
		try{
			System.out.println("1000 m en s: "+meter.transformTo(1000, SiTimeMetricSystem.SECOND));
		}
		catch(QuantityException e){
			System.out.println(e);
		}
	}

}

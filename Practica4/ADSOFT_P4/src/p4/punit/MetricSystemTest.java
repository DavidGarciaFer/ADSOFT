package p4.punit;

public class MetricSystemTest {

	public static void main(String[] args) {
		IMetricSystem ms = SiLengthMetricSystem.SYSTEM;
		// new SiLengthMetricSystem();
		System.out.println(ms.units());
		System.out.println("Base = "+ms.base());
		System.out.println(SiLengthMetricSystem.METER.canTransformTo(ImperialLengthMetricSystem.FOOT));

	}

}

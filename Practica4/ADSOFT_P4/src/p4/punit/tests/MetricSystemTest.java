package p4.punit.tests;

import p4.punit.IMetricSystem;
import p4.punit.imperial.ImperialLengthMetricSystem;
import p4.punit.si.SiLengthMetricSystem;

public class MetricSystemTest {

	public static void main(String[] args) {
		IMetricSystem ms = SiLengthMetricSystem.SYSTEM;
		// new SiLengthMetricSystem();
		System.out.println(ms.units());
		System.out.println("Base = "+ms.base());
		System.out.println(SiLengthMetricSystem.METER.canTransformTo(ImperialLengthMetricSystem.FOOT));

	}

}

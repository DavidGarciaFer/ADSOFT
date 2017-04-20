package p4.tests;

import p4.msys.imperial.ImperialLengthMetricSystem;
import p4.msys.si.IMetricSystem;
import p4.msys.si.SiLengthMetricSystem;

/**
 * Tester Apartado 2 de la práctica 4
 * @author Profesores ADS
 */

public class MetricSystemTest {

	public static void main(String[] args) {
		IMetricSystem ms = SiLengthMetricSystem.SYSTEM;
		// new SiLengthMetricSystem();
		System.out.println(ms.units());
		System.out.println("Base = "+ms.base());
		System.out.println(SiLengthMetricSystem.METER.canTransformTo(ImperialLengthMetricSystem.FOOT));

	}

}

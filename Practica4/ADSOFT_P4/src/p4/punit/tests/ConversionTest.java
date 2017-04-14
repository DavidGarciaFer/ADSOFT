package p4.punit.tests;

import p4.punit.*;
import p4.punit.imperial.ImperialLengthMetricSystem;
import p4.punit.si.SiLengthMetricSystem;

public class ConversionTest {
	public static void main(String[] args) throws QuantityException {
		Magnitude m = new Magnitude(10, SiLengthMetricSystem.KILOMETER);
		IMagnitude enMillas = null;
		try {
			enMillas = m.transformTo(ImperialLengthMetricSystem.MILE);
		} catch (QuantityException e) {
			System.out.println(e);
		}
		SiLengthMetricSystem.registerConverter(new SiLength2ImperialConverter());
		//	Registers the converter and the reverse
		enMillas = m.transformTo(ImperialLengthMetricSystem.MILE);
		System.out.println("En millas = "+enMillas);
		System.out.println("En m = "+ enMillas.transformTo(SiLengthMetricSystem.METER));
	}
}

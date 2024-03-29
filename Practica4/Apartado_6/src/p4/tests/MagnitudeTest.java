package p4.tests;

import p4.exceptions.QuantityException;
import p4.magnitude.IMagnitude;
import p4.magnitude.Magnitude;
import p4.msys.si.SiLengthMetricSystem;
import p4.msys.si.SiTimeMetricSystem;

/**
 * Tester Apartado 3 de la práctica 4
 * @author Profesores ADS
 */

public class MagnitudeTest {
	public static void main(String[] args) throws QuantityException{
		IMagnitude m = new Magnitude(12.5, SiLengthMetricSystem.KILOMETER);
		Magnitude m2 = new Magnitude(12.5, SiLengthMetricSystem.METER);
		System.out.println(m2.add(m));
		//m converted to meters and added to m2
		System.out.println(m.subs(m2).add(m2));
		//operations can be chained
		System.out.println(m.transformTo(SiLengthMetricSystem.METER));
		Magnitude s1 = new Magnitude(65, SiTimeMetricSystem.SECOND);
		try {
			System.out.println(s1.add(m));
		} catch (QuantityException q) {
			System.out.println(q);
		}
	}
}
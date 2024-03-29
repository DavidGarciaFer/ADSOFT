package p4.tests;

import p4.exceptions.*;
import p4.magnitude.*;
import p4.msys.converter.*;
import p4.msys.imperial.*;
import p4.msys.si.*;
import p4.punit.composite.*;

public class CompositeTest {
	public static void main(String[] args) throws QuantityException {
		SiLengthMetricSystem.registerConverter(new SiLength2ImperialConverter());

		Magnitude velocSI = new Magnitude(10,
				new CompositeUnit(SiLengthMetricSystem.METER, Operator.DIV, SiTimeMetricSystem.SECOND));
		Magnitude velocImp = new Magnitude(0,
				new CompositeUnit(ImperialLengthMetricSystem.MILE, Operator.DIV, SiTimeMetricSystem.HOUR));
		Magnitude velocSI2 = new Magnitude(0,
				new CompositeUnit(SiLengthMetricSystem.KILOMETER, Operator.DIV, SiTimeMetricSystem.HOUR));
		System.out.println(velocSI);
		System.out.println(velocImp);
		System.out.println(velocImp.add(velocSI));
		// implica convertir m/s a millas/hora
		System.out.println(velocSI2.add(velocSI));
		// implica convertir m/s a km/hora
	}
}
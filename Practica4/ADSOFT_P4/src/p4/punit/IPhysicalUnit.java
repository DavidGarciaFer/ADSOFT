/**
 * 
 */
package p4.punit;

import p4.exceptions.QuantityException;
import p4.msys.si.IMetricSystem;

/**
 * @author davidgf
 *
 */
public interface IPhysicalUnit {
	boolean canTransformTo(IPhysicalUnit u);
	double transformTo(double d, IPhysicalUnit u) throws QuantityException;
	Quantity getQuantity();
	String abbrev();
	IMetricSystem getMetricSystem(); 
}

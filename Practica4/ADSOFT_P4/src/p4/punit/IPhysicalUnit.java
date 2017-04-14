/**
 * 
 */
package p4.punit;

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

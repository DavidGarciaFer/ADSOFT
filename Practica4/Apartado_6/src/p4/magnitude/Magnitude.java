/**
 * 
 */
package p4.magnitude;

import p4.exceptions.QuantityException;
import p4.exceptions.TypeException;
import p4.msys.converter.IMetricSystemConverter;
import p4.punit.IPhysicalUnit;

/**
 * Clase que implementa la interfaz IMagnitude. Esta clase nos sirve para
 * dar soporte a las magnitudes, es decir, podemos guardar un valor asociado 
 * a una unidad, teniendo metodos para sumar o restar distintas magnitudes
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Magnitude implements IMagnitude{
	private IPhysicalUnit unit;
	private double value;
	
	/**
	 * Constructor asociado a esta clase
	 * @param value El valor de la magnitud
	 * @param unit La unidad asociada a dicho valor
	 */
	
	public Magnitude(double value, IPhysicalUnit unit){
		this.value = value;
		this.unit = unit;
	}
	
	/**
	 * Metodo para sumar a la IMagnitude invocada otra pasada por argumento (m)
	 * Primero se transforma m para que tenga la misma unidad que la primera
	 * IMagnitude y tras esto, se suman sus valores.
	 * @param m La magnitud con la que debe sumarse la invocacion
	 * @return IMagnitude El resultado de la operacion
	 * @throws QuantityException Cuando las unidades no son compatibles
	 */

	public IMagnitude add (IMagnitude m) throws QuantityException{
		m = m.transformTo(this.unit);
		this.value += m.getValue();
		return this;
	}
	
	/**
	 * Metodo para restar a la IMagnitude invocada otra pasada por argumento (m)
	 * Primero se transforma m para que tenga la misma unidad que la primera
	 * IMagnitude y tras esto, se restan sus valores. 
	 * @param m La magnitud con la que debe restarse la invocacion
	 * @return IMagnitude El resultado de la operacion
	 * @throws QuantityException Cuando las unidades no son compatibles
	 */
	
	public IMagnitude subs(IMagnitude m) throws QuantityException{
		m = m.transformTo(this.unit);
		this.value -= m.getValue();
		return this;
	}
	
	/**
	 * Metodo que transforma una misma magnitud de su unidad a otra, pasada por argumento,
	 * crea una nueva QuantityException en caso de que no se pueda realizar satisfactoriamente.
	 * @param c La unidad a la que queremos pasar
	 * @return IMagnitude La magnitud con la unidad cambiada
	 * @throws QuantityException Cuando las unidades no son compatibles
	 */
	
	public IMagnitude transformTo(IPhysicalUnit c) throws QuantityException{
		if(this.unit.getMetricSystem().equals(c.getMetricSystem()) == true)
			return new Magnitude(this.getUnit().transformTo(value, c), c);
		IMetricSystemConverter conv = this.unit.getMetricSystem().getConverter(c.getMetricSystem());
			if(this.unit.canTransformTo(c) == false){
				if(this.unit.getQuantity().equals(c.getQuantity()) == false)
					throw new QuantityException(this.unit,c);
			if( conv == null){
				throw new TypeException(this.unit, c);
			}
		}
		return 	conv.transformTo(this, c);
		
	}
	
	/**
	 * Metodo para conocer la unidad de la Magnitude
	 * @return IPhysicalUnit La unidad
	 */
	
	public IPhysicalUnit getUnit(){
		return unit;
	}
	
	/**
	 * Metodo para conocer el valor de la Magnitude
	 * @return double El valor de la Magnitude
	 */
	public double getValue(){
		return value;
	}
	
	/**
	 * Sobreescritura del metodo toString, para imprimir correctamente la clase Magnitude,
	 * con su valor y su unidad
	 */
	
	@Override
	public String toString(){
		return this.value + " [" + this.unit + "]";
	}
}

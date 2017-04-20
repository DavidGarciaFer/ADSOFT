package p4.msys.converter;

import p4.exceptions.NotMatchingException;
import p4.exceptions.QuantityException;
import p4.exceptions.UnknownUnitException;
import p4.magnitude.IMagnitude;
import p4.magnitude.Magnitude;
import p4.msys.imperial.ImperialLengthMetricSystem;
import p4.msys.si.IMetricSystem;
import p4.msys.si.SiLengthMetricSystem;
import p4.punit.IPhysicalUnit;

/**
 * Clase que implementa la interfaz IMetricSystemConverter, en este caso, da soporte al
 * convertidor entre el sistema internacional y el imperial (con respecto a la longitud).
 * El convertidor esta compuesto por un sistema metrico fuente, destino y un multiplicador
 * necesario para poder pasar de un sistema a otro. 
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class SiLength2ImperialConverter implements IMetricSystemConverter{
	private IMetricSystem source = SiLengthMetricSystem.SYSTEM;
	private IMetricSystem target = ImperialLengthMetricSystem.SYSTEM;
	private double multi = 3.280839895;
	
	/**
	 * Metodo que devuelve el sistema metrico del que parte nuestro convertidor.
	 * @return IMetricSystem El sistema metrico fuente, del que partimos
	 */
	
	public IMetricSystem sourceSystem(){
		return this.source;
	}
	
	/**
	 * Metodo que devuelve el sistema metrico destino de nuestro convertidor.
	 * @return IMetricSystem El sistema metrico objetivo, el destino
	 */
	
	public IMetricSystem targetSystem(){
		return this.target;
	}	
	
	/**
	 * Metodo para transformar una magnitud del sistema fuente a una unidad del sistema destino
	 * @param from Magnitud del sistema fuente
	 * @param to Unidad del sistema destino
	 * @return IMagnitude La Magnitud resultante
	 * @throws UnknownUnitException Cuando hay problemas con la unidad destino
	 */
	
	public IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException{

			if(!this.target.units().contains(to)){
				throw new UnknownUnitException(to, null);
			}
			if(from.getUnit().getMetricSystem().equals(source) == false || to.getMetricSystem().equals(target) == false){
				throw new NotMatchingException(from.getUnit(),to);
			}
			// Pasamos la magnitud from a la base de su sistema
			IMagnitude im1 = new Magnitude(from.getValue(),to);
			
			try {
				im1 = from.transformTo(from.getUnit().getMetricSystem().base());
			} catch (QuantityException e) {
				// No necesario ya que estamos en el mismo sistema
			}
			// Convertimos a la unidad base del sistema to
			IMagnitude im = new Magnitude(im1.getValue()*multi, to.getMetricSystem().base());
			try {
				im = im.transformTo(to);
			} catch (QuantityException e) {
				// De nuevo no necesario
			}
			return im;
				
	}		
	
	/**
	 * Metodo que devuelve un conversor entre el sistema destino y el fuente.
	 * @return IMetricSystemConverter Dicho conversor
	 */
	
	public IMetricSystemConverter reverse(){
		SiLength2ImperialConverter ret = new SiLength2ImperialConverter();
		ret.target = this.source;
		ret.source = this.target;
		ret.multi = 1/this.multi;
		return ret;
	}
}


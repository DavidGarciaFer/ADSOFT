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

public class SiLength2ImperialConverter implements IMetricSystemConverter{
	private IMetricSystem source = SiLengthMetricSystem.SYSTEM;
	private IMetricSystem target = ImperialLengthMetricSystem.SYSTEM;
	private double multi = 3.280839895;
	
	public IMetricSystem sourceSystem(){
		return this.source;
	}
	
	public IMetricSystem targetSystem(){
		return this.target;
	}	
	
	public IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException{
		//public IMagnitude transformTo(IPhysicalUnit c) throws QuantityException{
		//	Magnitude im = new Magnitude(this.unit.transformTo(this.value, c), c);
		//	return im;
		//}
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
	public IMetricSystemConverter reverse(){
		SiLength2ImperialConverter ret = new SiLength2ImperialConverter();
		ret.target = this.source;
		ret.source = this.target;
		ret.multi = 1/this.multi;
		return ret;
	}
}


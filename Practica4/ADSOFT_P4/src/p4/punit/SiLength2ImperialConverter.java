package p4.punit;

import p4.punit.imperial.ImperialLengthMetricSystem;
import p4.punit.si.SiLengthMetricSystem;

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
			if(!this.target.units().contains(to)){
				throw new UnknownUnitException(to.getQuantity());
			}
			if(!from.getUnit().getMetricSystem().equals(source) || !to.getMetricSystem().equals(target)){
				//No sé que poner aquí
			}
			IMagnitude im = new Magnitude(from.getValue()*multi, to);
			return im;
				
	}		
	public IMetricSystemConverter reverse(){
		
	}
}

package p4.msys.si;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import p4.msys.MetricSystem;
import p4.punit.IPhysicalUnit;
import p4.punit.TimeUnit;

/**
 * Clase que hereda de MetricSystem y que implementa el sistema metrico internacional
 * referente al tiempo. Tiene patron Singleton, ya que cuando se invoca a
 * esta clase, se puede hacer con SYSTEM (crea la clase en si) o con SECOND, HOUR
 * o MILISECOND, que son de tipo TimeUnit, y que se considerarian las unidades del sistema
 * metrico.
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class SiTimeMetricSystem extends MetricSystem{
	public static final SiTimeMetricSystem SYSTEM = new SiTimeMetricSystem();
	public static TimeUnit SECOND = new TimeUnit(1, "s", SYSTEM);
	public static TimeUnit HOUR = new TimeUnit(3600, "h", SYSTEM);
	public static TimeUnit MILISECOND = new TimeUnit(0.001, "ms", SYSTEM);

	/**
	 * Metodo que devuelve la base del sistema metrico, en este caso el segundo.
	 * @return IPhysicalUnit La base del sistema metrico
	 */
	@Override
	public IPhysicalUnit base() {
		return SECOND;
	}
	
	/**
	 * Metodo que devuelve la coleccion de unidades del sistema metrico, en este caso
	 * la hora, el segundo y el milisegundo.
	 * @return  La coleccion de las unidades del sistema
	 */

	@Override
	public Collection<IPhysicalUnit> units() {
		List<IPhysicalUnit> units = new ArrayList<IPhysicalUnit>();
		units.add(HOUR);
		units.add(SECOND);
		units.add(MILISECOND);
		return units;
	}
}

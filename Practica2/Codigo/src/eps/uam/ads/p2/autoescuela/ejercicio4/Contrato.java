package eps.uam.ads.p2.autoescuela.ejercicio4;
import eps.uam.ads.p2.autoescuela.alumnos.Fecha;


public class Contrato {
	private Fecha fechaInicio;
	private Fecha fechaFin;
	private Profesor profesor;
	private double sueldoBase;

	
	public Contrato(Fecha fechaini, Fecha fechaFin, Profesor profesor, double sueldoBase){
		this.fechaInicio = fechaini;
		this.fechaFin = fechaFin;
		this.profesor = profesor;
		this.sueldoBase = sueldoBase;
	}

	public Contrato(Fecha fechaIni, Profesor profesor, double sueldoBase) {
		this.fechaInicio = fechaIni;
		this.profesor = profesor;
		this.sueldoBase = sueldoBase;
	}
	
	public void setFin(Fecha fechaFin){
		this.fechaFin = fechaFin;
	}
	
	public Fecha getIni(){
		return this.fechaInicio;
	}
	
	public Fecha getFin(){
		return this.fechaFin;
	}
	
	public double getSueldoBase(){
		return this.sueldoBase;
	}
	
	public Profesor getProfesor(){
		return this.profesor;
	}
}

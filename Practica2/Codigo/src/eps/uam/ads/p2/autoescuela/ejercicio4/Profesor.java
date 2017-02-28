package eps.uam.ads.p2.autoescuela.ejercicio4;

public class Profesor extends Persona{
	
	private int numSegSoc;
	
	public Profesor(int dni, String nombre, String apellidos, int telefono, int numSegSoc){
		super(dni, nombre, apellidos, telefono);
		this.numSegSoc = numSegSoc;
	}
	
	public int getSS(){
		return this.numSegSoc;
	}

}

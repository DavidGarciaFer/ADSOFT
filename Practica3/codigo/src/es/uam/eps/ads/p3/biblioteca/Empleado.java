package es.uam.eps.ads.p3.biblioteca;

public class Empleado extends Usuario{
	
	double sancion;
	
	public Empleado(String nombre){
		super(nombre, 20, 4);
		this.sancion = 0.0;
	}
	
	public void sancionarPorRetraso(int dias){
		if (dias >= getnSanciones()){
			// Sancionamos
			sancion += dias*2.5;
		}
		// En caso contrario la sancion se perdona
	}
	
	public void eliminarSancion(){
		this.sancion = 0.0;
	}
	
	@Override
	public String toString(){
		if(sancion == 0){
			return "[E: "+this.getNombre()+"]";
		}
		return "[E: "+this.getNombre()+" $"+sancion+"]";
	}

}

package eps.uam.ads.p2.autoescuela.alumnos;

public class Fecha {
	private int dia;
	private int mes;
	private int anyo;
	
	public Fecha(int dia, int mes, int anyo){
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
	}
	
	public boolean isFechaValida(){
		if(this.dia <= 0 || this.dia > 31 || this.mes <= 0 || this.mes > 12){
			return false;
		}
		return true;
	}
	
	public String getFecha(){
		String fecha = String.format("%d/%d/%d", this.dia, this.mes, this.anyo);
		return fecha;
	}
	
}

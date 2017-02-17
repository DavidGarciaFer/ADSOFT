package eps.uam.ads.p2.autoescuela.alumnos;

public class Alumno {
	private int dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private int telefono;
	private Fecha fechaMatricula;
	private Fecha fechaSupTeorico;
	private Fecha fechaSupPractico;
	
	public Alumno(int dni, String nombre, String apellidos, String direccion, 
					int telefono, int dia, int mes, int anyo){
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaMatricula = new Fecha(dia, mes, anyo);
	}
	
	public boolean isFechaValida(Fecha f){
		return f.isFechaValida();
	}
	
	public Fecha getFechaMatricula(){
		return this.fechaMatricula;
	}
	
	public String getNombreYApellidos(){
		return this.nombre+" "+this.apellidos;
	}
	
	public Fecha getFechaSupPractico(){
		return this.fechaSupPractico;
	}
	
	public Fecha getFechaSupTeorico(){
		return this.fechaSupTeorico;
	}
	
	public void setFechaSupTeorico(int dia, int mes, int anyo){
		this.fechaSupTeorico = new Fecha(dia, mes, anyo);
	}
	
	public void setFechaSupPractico(int dia, int mes, int anyo){
		this.fechaSupPractico = new Fecha(dia, mes, anyo);
	}
	
	// Hacer el public String toString()
	
	public String toString(){
		String salida = "Datos del alumno <dni: "+this.dni+">\n\tNombre y apellidos: "
						+getNombreYApellidos()+"\n\tDirección: "+this.direccion+"\n\tTeléfono: "
						+this.telefono+"\n\tFecha de matriculación: "+this.fechaMatricula.getFecha();
		return salida;
						
	}
	
}

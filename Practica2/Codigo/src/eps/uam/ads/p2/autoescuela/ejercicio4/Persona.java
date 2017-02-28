package eps.uam.ads.p2.autoescuela.ejercicio4;

public class Persona {
	
	private int dni;
	private String nombre;
	private String apellidos;
	private int telefono;
	
	public Persona(int dni, String nombre, String apellidos, int telefono){
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}
	
	// Solo implementamos los getters y setters necesarios para el ejercicio
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getApellidos(){
		return this.apellidos;
	}
	
	public int getDNI(){
		return this.dni;
	}
	
	public int getTelefono(){
		return this.telefono;
	}
	// No sé todavía si faltan getters y setters
	
}

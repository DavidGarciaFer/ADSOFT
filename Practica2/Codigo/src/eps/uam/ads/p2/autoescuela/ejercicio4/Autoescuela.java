package eps.uam.ads.p2.autoescuela.ejercicio4;
import eps.uam.ads.p2.autoescuela.alumnos.Fecha;

public class Autoescuela {
	
	private int codigo;
	private String nombre;
	private String direccion;
	private String encargado;
	private int numAulas;
	private Contrato[] contratos;
	int nContratos;
	int nActual;
	
	public Autoescuela(int codigo, String nombre, String direccion, String encargado, int numAulas,
						int nContratos){
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.encargado = encargado;
		this.numAulas = numAulas;
		this.nContratos = nContratos;
		this.nActual = 0;
		this.contratos = new Contrato[this.nContratos];
	}
	
	public void addContrato(Profesor profesor, Fecha fechaIni, double sueldoBase){
		this.contratos[nActual++] = new Contrato(fechaIni, profesor, sueldoBase);
	}
	
	public int getCodigo(){
		return this.codigo;
	}
	
	public String getDireccion(){
		return this.direccion;
	}
	
	public String getEncargado(){
		return this.encargado;
	}
	
	public int getAulas(){
		return this.numAulas;
	}
	
	public boolean despedir(int dni, Fecha fecha){
		for (Contrato cont : this.contratos){
			if((cont.getProfesor()).getDNI() == dni){
				cont.setFin(fecha);
				return true;
			}						
		}
		return false;
	}
	
	public static void main(String[] args){
		/*Creamos una autoescuela*/
		Autoescuela a1 = new Autoescuela(1, "Arenal", "c/ Del Río 4", "Pedro Pérez", 5, 100);
		/*Creamos dos profesores*/
		Profesor p1 = new Profesor(03145412, "Francisco", "Lozano", 1234455, 124526);
		Profesor p2 = new Profesor(03143222, "María", "García", 1345667, 876567);
		/*Creamos fechas*/
		Fecha fecha1 = new Fecha(2,4,2017);
		Fecha fecha2 = new Fecha(3,5,2016);
		Fecha fecha3 = new Fecha(21, 10, 2017);
		/*Son contratados*/
		a1.addContrato(p1, fecha1, 500);
		a1.addContrato(p2, fecha2, 600);
		/*Son despedidos*/
		a1.despedir(03145412, fecha3);
		a1.despedir(03143222, fecha3);
		/*Obtenemos datos*/
		int i = 0;
		for(Contrato cont : a1.contratos){
			if(i >= a1.nActual)
				break;
			i++;
			System.out.println("El profesor/a "+(cont.getProfesor()).getNombre()+" "
								+(cont.getProfesor().getApellidos())+" trabajó en la autoescuela"
								+a1.nombre +" desde el "+cont.getIni().getFecha() +" hasta "
								+cont.getFin().getFecha());
		}
		
	}
}

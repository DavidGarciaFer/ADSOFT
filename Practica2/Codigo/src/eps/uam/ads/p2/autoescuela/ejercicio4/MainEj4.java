package eps.uam.ads.p2.autoescuela.ejercicio4;

/**
 * Esta aplicacion prueba las clases Autoescuela y Profesor
 * 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class MainEj4 {
	
	/**
	 * Punto de entrada de la aplicacion.
	 * 
	 * Este metodo realiza las acciones de crear una sede de una autoescuela,
	 * dos profesores, realiza un contrato y, tras finalizar el contrato imprime
	 * por pantalla la informacion de los contratos (periodo de tiempo que estuvo
	 * vigente)
	 * 
	 * @param args No se esperan argumentos de entrada
	 * */
	
	public static void main(String[] args){
		/*Creamos una autoescuela*/
		Autoescuela a1 = new Autoescuela(1, "Arenal", "c/ Del Río 4", "Pedro Pérez", 5, 100);
		/*Creamos dos profesores*/
		Profesor p1 = new Profesor(03145412, "Francisco", "Lozano", 1234455, 124526);
		Profesor p2 = new Profesor(03143222, "María", "García", 1345667, 876567);
		/*Son contratados*/
		a1.addContrato(p1, 2, 4, 2017, 500);
		a1.addContrato(p2, 3, 5, 2016, 600);
		/*Son despedidos*/
		a1.despedir(03143222, 21, 10, 2017);
		/*Obtenemos datos*/
		int i = 0;
		for(Contrato cont : a1.getContratos()){
			if(i >= a1.getActual())
				break;
			i++;
			if((cont.getFin()).isFechaValida() == true){
				System.out.println("El profesor/a "+(cont.getProfesor()).getNombre()+" "
								+(cont.getProfesor().getApellidos())+" trabajó en la autoescuela "
								+a1.getNombre() +" desde el "+cont.getIni().getFecha() +" hasta "
								+cont.getFin().getFecha());
			}
			else{
				System.out.println("El profesor/a "+(cont.getProfesor()).getNombre()+" "
						+(cont.getProfesor().getApellidos())+" ha trabajado en la autoescuela "
						+a1.getNombre() +" desde el "+cont.getIni().getFecha() +" hasta la actualidad");
			}
		}
		
	}
}

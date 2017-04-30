package p5.testers;

import p5.ejercicio2.Tasks;

/**
 * Test del apartado 2 de la Practica 5, clase Tasks
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Test2_Tasks {
	private static Tasks admin = Tasks.getInstance();
	
	public static void main(String[] args){
		
		admin.newTask("Matematicas");
		admin.newTask("Informatica");
		
		System.out.println("Tareas en el administrador de tareas: "+admin);
		
		// Si descomentamos este codigo recibimos una excepcion porque ya existe una
		// tarea con el mismo nombre
		// admin.newTask("MATEMATICAS");
		
		System.out.println("\nBuscamos la tarea Fisica: "+admin.searchTask("Fisica"));
		System.out.println("Buscamos la tarea matematicas: "+admin.searchTask("matematicas"));
		
		System.out.println("\nAñadimos algunas subtareas: ");
		admin.searchTask("informatica").addTask(admin.newTask("Sistemas Operativos"));
		admin.searchTask("informatica").addTask(admin.newTask("Analisis y diseño de software"));
		admin.searchTask("matematicas").addTask(admin.newTask("Probabilidad"));
		admin.searchTask("matematicas").addTask(admin.newTask("Calculo numerico"));
		System.out.println("Informatica -> "+admin.searchTask("informatica").getTasks());
		System.out.println("Matematicas -> "+admin.searchTask("matematicas").getTasks());
		System.out.println("Tareas en el administrador de tareas: "+admin);
		System.out.println("\nBuscamos la tarea PROBABILIDAD: "+admin.searchTask("PROBABILIDAD"));
		
		// Si descomentamos este codigo recibimos una excepcion porque ya existe una
		// tarea con el mismo nombre
		// admin.newTask("ANALISIS Y DISEÑO DE SOFTWARE");
		
	}
	
}

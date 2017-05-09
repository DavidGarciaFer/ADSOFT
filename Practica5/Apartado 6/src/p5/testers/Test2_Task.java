package p5.testers;

import java.util.*;

import p5.ejercicio2.Task;

/**
 * Test del apartado 2 de la Practica 5, clase Task
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Test2_Task {

	public static void main(String[] args) {
		
		// Creamos una estructura basica de tareas y subtareas
		
		Task t1 = new Task("Hacer la comida");	
		Task t2 = new Task("Comprar comida");
		Task t3 = new Task("Cocinar");
		Task t4 = new Task("Ir al super");
		Task t5 = new Task("Coger productos");
		Task t6 = new Task("Pagar");
		Task t7 = new Task("Lavar alimentos");
		Task t8 = new Task("Freir");
		
		List<Task> lista = Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8);
		
		for(Task t : lista){
			t.getDedicated().incrementTime(1);
			t.getEstimated().incrementTime(2);
		}
		
		t1.addTask(t2); t1.addTask(t3);
		t2.addTask(t4); t2.addTask(t5); t2.addTask(t6);
		t3.addTask(t7); t3.addTask(t8);
		
		System.out.println("Jerarquía de tareas inicial");
		System.out.println("Subtareas de: "+t1+" -> "+t1.getTasks());
		System.out.println("Subtareas de: "+t2+" -> "+t2.getTasks());
		System.out.println("Subtareas de: "+t3+" -> "+t3.getTasks());
		
		// Si descomentamos este codigo obtenemos una excepcion porque la tarea 
		// ya tiene un padre asignado:		
		// t2.addTask(t1);
		
		System.out.println("\nIntentamos añadir la tarea CoCINar a la tarea 1: "+t1.addTask(new Task("CoCINar")));
		System.out.println("Intentamos borrar la tarea 1 de la tarea 3: "+t3.removeTask(t1));
		System.out.println("Comprobamos si la subtarea FREIR está en la tarea 1: "+t1.containsTask(new Task("FREIR")));
		System.out.println("Comprobamos el padre de la tarea 8: "+t8.getParent());
		
		System.out.println("\nCambiamos el padre de la tarea 2, de la tarea 1 a la 3:");
		t2.setParent(t3);
		System.out.println("Jerarquía de tareas");
		System.out.println("Subtareas de: "+t1+" -> "+t1.getTasks());
		System.out.println("Subtareas de: "+t2+" -> "+t2.getTasks());
		System.out.println("Subtareas de: "+t3+" -> "+t3.getTasks());
		
	}

}

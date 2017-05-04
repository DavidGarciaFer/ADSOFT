package p5.ejercicio2;

import java.util.*;

/**
 * Clase con patron Singleton que sirve como administrador de tareas 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Tasks {
	
	private Collection<Task> tareas;
	private static Tasks INSTANCE = new Tasks();
	
	/**
	 * Constructor privado de la clase Tasks
	 */
	
	private Tasks(){
		tareas = new TreeSet<Task>();
	}
	
	/**
	 * Agrega una nueva task al conjunto de tareas, si ya existe 
	 * genera una RunTimeException del tipo IllegalArgument
	 * @param taskName Nombre de la nueva tarea
	 * @return La nueva tarea creada.
	 */
	
	public Task newTask(String taskName){
		Task newT = new Task(taskName);
		if(this.tareas.contains(newT))
			throw new IllegalArgumentException();
		tareas.add(newT);
		return newT;
	}
	
	/**
	 * Busca una tarea en el conjunto de tareas por nombre
	 * @param name Nombre de la tarea a buscar
	 * @return La tarea si la encuentra, null en caso contrario
	 */
	
	public Task searchTask(String name){
		String upper = name.toUpperCase();
		for(Task t : this.tareas){
			if(t.getName().toUpperCase().equals(upper))
				return t;
		}
		return null;
	}
	
	/**
	 * Devuelve la instancia de la clase con patron Singleton
	 * @return La instancia de la clase
	 */
	
	public static Tasks getInstance(){
		return INSTANCE;
	}
	
	/**
	 * Metodo del apartado opcional que devuelve el tiempo estimado total
	 * @return El tiempo estimado
	 */
	public Integer estimatedTotal(){
		Integer sum = new Integer(0);
		for (Task t: tareas){
			sum = sum + t.getEstimated().getValue();
		}
		return sum;
	}
	
	/**
	 * Metodo del apartado opcional que devuelve el tiempo dedicado total
	 * @return El tiempo dedicado
	 */
	
	public Integer dedicatedTotal(){
		Integer sum = new Integer(0);
		for (Task t: tareas){
			sum = sum + t.getDedicated().getValue();
		}
		return sum;
	}
	
	@Override
	public String toString(){
		return this.tareas.toString();
	}
	
}

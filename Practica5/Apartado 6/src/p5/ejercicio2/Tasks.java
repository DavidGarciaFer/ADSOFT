package p5.ejercicio2;

import java.util.*;

import p5.ejercicio1.PropertyObserver;

/**
 * Clase con patron Singleton que sirve como administrador de tareas 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Tasks {
	
	private Collection<Task> tareas;
	private int totalDedicado = 0;
	private int totalEstimado = 0;
	private PropertyObserver<Integer> dedicados;
	private PropertyObserver<Integer> estimados;
	private static Tasks INSTANCE = new Tasks();
	
	/**
	 * Constructor privado de la clase Tasks
	 */
	
	private Tasks(){
		tareas = new TreeSet<Task>();
		
		// El observador actualiza el valor del totalDedicado 
		// y del totalEstimado
		
		dedicados = (propiedad, oldV) -> {
			this.totalDedicado -= oldV;
			this.totalDedicado += propiedad.getValue();
		};
		
		estimados = (propiedad, oldV) -> {
			this.totalEstimado -= oldV;
			this.totalEstimado += propiedad.getValue();
		};
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
		
		// Como al crearse son tareas raíz añadimos
		// sus tiempos a los observadores
		
		addRoot(newT);
		
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
	 * Devuelve el valor dedicado de todos los árboles de tareas
	 * en conjunto
	 * @return Un entero con el tiempo dedicado
	 */
	
	public int dedicatedTotal(){
		return this.totalDedicado;
	}
	
	/**
	 * Devuelve el valor estimado de todos los árboles de tareas
	 * en conjunto
	 * @return Un entero con el tiempo estimado
	 */
	
	public int estimatedTotal(){
		return this.totalEstimado;
	}
	
	/**
	 * Devuelve el observador del tiempo dedicado
	 * @return Un Property Observer de tipo Integer
	 */
	
	
	public PropertyObserver<Integer> getDedicatedObserver(){
		return this.dedicados;
	}
	
	/**
	 * Devuelve el observador del tiempo estimado
	 * @return Un Property Observer de tipo Integer
	 */
	
	
	public PropertyObserver<Integer> getEstimatedObserver(){
		return this.estimados;
	}
	
	/**
	 * Añade una tarea al conjunto de tareas raíz observadas
	 * @param t La tarea que se añade a las raíces
	 */
	
	public void addRoot(Task t){
		t.getDedicated().addObserver(dedicados);
		this.totalDedicado += t.getDedicated().getValue();
		t.getEstimated().addObserver(estimados);
		this.totalEstimado += t.getEstimated().getValue();
	}
	
	/**
	 * Elimina una tarea del conjunto de tareas raíz observadas
	 * @param t La tarea que se elimina de las raíces
	 */
	
	public void removeRoot(Task t){
		t.getDedicated().removeObserver(dedicados);		
		this.totalDedicado -= t.getDedicated().getValue();
		t.getEstimated().removeObserver(estimados);
		this.totalEstimado -= t.getEstimated().getValue();
	}
	
	@Override
	public String toString(){
		return this.tareas.toString();
	}
	
}

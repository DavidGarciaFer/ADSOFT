package p5.ejercicio2;

import java.util.*;

import p5.ejercicio1.*;

/**
 * Clase que implementa las tareas que maneja nuestra consola 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Task implements Comparable<Task>{

	private String nombre;
	private ObservableObserver dedicado = new ObservableObserver(0);
	private ObservableObserver estimado = new ObservableObserver(0);
	private Set<Task> tareas = new LinkedHashSet<Task>();
	private Task padre = null;
	
	/**
	 * Constructor de la clase Task
	 * @param nombre Nombre de la tarea
	 */
	
	public Task(String nombre){
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve el nombre de la tarea
	 * @return Un string con el nombre
	 */
	
	public String getName(){
		return nombre;
	}
	
	/**
	 * Agrega una subtarea si se cumplen las condiciones y suscribe
	 * sus tiempos a los de la tarea hija.
	 * @param t La subtarea a agregar
	 * @return True si la subtarea se agrega correctamente,
	 * false en caso de que ya estuviese contenida en el 
	 * conjunto de subtareas, lanza una RunTimeException si la
	 * tarea ya tiene padre
	 */
	
	public boolean addTask(Task t){
		if(this.containsTask(t))
			return false;
		if(t.padre != null)
			throw new IllegalArgumentException();
		this.tareas.add(t);
		Tasks.getInstance().removeRoot(t); // La tarea deja de ser una raíz
		t.padre = this;
		this.dedicado.add(t.dedicado);
		this.estimado.add(t.estimado);
		
		return true;
	}
	
	/**
	 * Elimina una tarea del conjunto de subtareas
	 * @param t La tarea a eliminar
	 * @return True si la tarea se elimino correctamente,
	 * false si la subtarea no pertenecia al conjunto
	 */
	
	public boolean removeTask(Task t){
		if(this.containsTask(t) == false)
			return false;
		Tasks.getInstance().addRoot(t);
		Task padre = t.padre;		
		padre.tareas.remove(t);		
		padre.dedicado.remove(t.dedicado);		
		padre.estimado.remove(t.estimado);		
		t.padre = null;
		 // Como t no tiene padre es una raíz
		return true;
	}
	
	/**
	 * Devuelve las subtareas de la tarea instancia
	 * @return Un conjunto inmutable de subatareas
	 */
	
	public Set<Task> getTasks(){
		return Collections.unmodifiableSet(tareas);
	}
	
	/**
	 * Comprueba si una tarea pertenece a un conjunto de
	 * subtareas directa o indirectamente
	 * @param t La subtarea a comprobar
	 * @return True si pertenece, false en caso contrario
	 */
	
	public boolean containsTask(Task t){
		if(this.tareas.isEmpty())
			return false;
		if(this.tareas.contains(t))
			return true;
		for(Task task : this.tareas){
			if(task.containsTask(t))
				return true;
		}
		return false;
	}
	
	/**
	 * Devuelve el padre de la tarea
	 * @return El padre de la tarea (puede ser null)
	 */
	
	public Task getParent(){
		return this.padre;
	}
	
	/**
	 * Configura el padre de la subtarea
	 * @param t El nuevo padre de la tarea
	 */
	
	public void setParent(Task t){
		if(this.containsTask(t) || this.equals(t))
			throw new IllegalArgumentException();	
		if(this.padre == null){
			t.addTask(this); // Aquí se actualiza su valor como "no root"
			this.padre = t;
			return;
		}			
		Task old = this.padre; // En este caso ni era raíz ni lo va a ser
		old.removeTask(this);
		t.addTask(this);
	}
	
	/**
	 * Devuelve el tiempo estimado de la tarea
	 * @return El tiempo estimado
	 */
	
	public AdjustableTime getEstimated(){
		return this.estimado;
	}
	
	/**
	 * Devuelve el tiempo dedicado de la tarea
	 * @return El tiempo dedicado
	 */
	
	public AdjustableTime getDedicated(){
		return this.dedicado;
	}
	
	/**
	 * Consideramos que dos tareas son iguales si
	 * tienen el mismo nombre (case insensitive)
	 */
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Task == false)
			return false;
		return this.nombre.toUpperCase().equals(((Task) o).getName().toUpperCase());
	}
	
	/**
	 * Implementacion del metodo hashCode
	 */
	
	@Override
	public int hashCode(){
		return this.nombre.toUpperCase().hashCode();
	}

	/**
	 * Comparamos dos tareas por orden alfabetico de sus nombres
	 */
	
	@Override
	public int compareTo(Task o) {
		return this.nombre.toUpperCase().compareTo(o.nombre.toUpperCase());
	}
	
	@Override
	public String toString(){
		return nombre+" ["+dedicado.getValue()+","+estimado.getValue()+"]";
	}
}

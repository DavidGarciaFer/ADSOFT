package p5.ejercicio4;

import p5.ejercicio2.*;
import p5.ejercicio3.*;

/**
 * Clase con la que implementamos la consola de manejo de tareas,
 * agregando a TextConsole un estado y unos tiempos de ejecucion 
 * de la tarea actual
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class TaskConsole extends TextConsole{
	
	private Task estado;
	private long start;
	private long end;
	private static TaskConsole INSTANCE = new TaskConsole();
	
	/**
	 * Metodo que crea los comandos necesarios para el manejo de tareas
	 */
	
	public void loadCommands(){
		TextConsole consola = TaskConsole.getInstance();		
		
		/*
		 * Comando que inicializa una nueva tarea
		 */
		consola.addCommands("start", (datos) -> {
			if(datos.length != 1){
				System.out.println("Se espera un único nombre de tarea como parámetro de entrada.");
				return;
			}
			if(estado != null){
				// Detenemos la tarea actual si existe
				end = System.currentTimeMillis()/1000;
				estado.getDedicated().incrementTime((int) (end-start));
				System.out.println("Tarea "+estado.getName()+" detenida.");
			}
			Task tarea = Tasks.getInstance().searchTask(datos[0]);
			if(tarea == null)
				estado = Tasks.getInstance().newTask(datos[0]);
			else
				estado = tarea;
			start = System.currentTimeMillis()/1000;
			System.out.println("Ejecutandose la tarea "+datos[0]);
		});
		
		consola.addCommands("stop", (datos) -> {
			if(datos.length != 0){
				System.out.println("No se esperan argumentos para este comando.");
				return;
			}
			if(estado == null){
				System.out.println("Ninguna tarea ejecutandose actualmente.");
				return;
			}
			end = System.currentTimeMillis()/1000;
			estado.getDedicated().incrementTime((int) (end-start));
			estado = null;
		});
		
		consola.addCommands("addEstimate", (datos) -> {
			if(datos.length != 1){
				System.out.println("Se espera un único parámetro en minutos.");
				return;
			}
			if(consola.isNumeric(datos[0]) == false){
				System.out.println("El dato recibido no es un dato numérico válido.");
			}
			if(estado == null){
				System.out.println("No hay ninguna tarea ejecutándose actualmente.");
				return;
			}
			estado.getEstimated().incrementTime(Integer.parseInt(datos[0]));
		});
		
		consola.addCommands("spend", (datos) -> {
			if(datos.length != 1){
				System.out.println("Se espera un único parámetro en minutos.");
				return;
			}
			if(consola.isNumeric(datos[0]) == false){
				System.out.println("El dato recibido no es un dato numérico válido.");
				return;
			}
			if(estado == null){
				System.out.println("No hay ninguna tarea ejecutándose actualmente.");
				return;
			}
			estado.getDedicated().incrementTime(Integer.parseInt(datos[0]));
		});
		
		consola.addCommands("parent", (datos) -> {
			if(datos.length != 1){
				System.out.println("Se espera un único nombre de tarea como parámetro de entrada.");
			}
			if(estado == null){
				System.out.println("No hay ninguna tarea ejecutándose actualmente.");
				return;
			}
			Task padre = Tasks.getInstance().searchTask(datos[0]);
			if(padre == null){
				System.out.println("El padre especificado no existe. Use el comando list para ver las tareas creadas.");
				return;
			}
			// Para evitar que se lance la excepción
			if(estado.containsTask(padre) || estado.equals(padre)){
				System.out.println("El padre especificado pertenece a las subtareas de la tarea actual.");
				return;
			}				
			estado.setParent(padre);
		});
		
		consola.addCommands("list", (datos) -> {
			if(datos.length != 0){
				System.out.println("No se esperan parámetros de entrada.");
				return;
			}
			System.out.println(Tasks.getInstance());
		});
		
		consola.addCommands("status", (datos) -> {
			if(datos.length > 1){
				System.out.println("Se espera un único nombre de tarea como parámetro de entrada.");
				return;
			}
			Task tarea;
			if(datos.length == 0)
				tarea = estado;
			else
				tarea = Tasks.getInstance().searchTask(datos[0]);
			if(tarea == null){
				System.out.println("El nombre especificado no existe o no hay una tarea en ejecución. Use el comando list para ver las tareas creadas.");
				return;
			}
			System.out.println("Nombre: "+tarea.getName());
			System.out.println("Padre: "+tarea.getParent());
			System.out.println("Tiempo estimado: "+tarea.getEstimated().getValue());
			System.out.println("Tiempo dedicado: "+tarea.getDedicated().getValue());
		});	
	}
	
	/**
	 * Devuelve la instancia de la consola
	 * @return La instancia de la consola
	 */
	
	public static TaskConsole getInstance(){
		return INSTANCE;
	}
		
}

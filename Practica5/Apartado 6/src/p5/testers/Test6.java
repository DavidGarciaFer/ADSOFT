package p5.testers;

import p5.ejercicio2.Tasks;

/**
 * Test del apartado 2 de la Practica 5, clase Tasks
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Test6 {
	
	public static void main(String[] args){
		
		Tasks tasks = Tasks.getInstance();
		
		System.out.println("Tasks vacío: Dedicado "+tasks.dedicatedTotal()+", Estimado "+tasks.estimatedTotal());
		
		tasks.newTask("Matemáticas");
		
		tasks.searchTask("Matemáticas").getEstimated().incrementTime(2);
		tasks.searchTask("Matemáticas").getDedicated().incrementTime(5);
		
		System.out.println("Añadimos Matemáticas: Dedicado "+tasks.dedicatedTotal()+", Estimado "+tasks.estimatedTotal());
		
		tasks.newTask("Informática");
		tasks.searchTask("Informática").getEstimated().incrementTime(2);
		tasks.searchTask("Informática").getDedicated().incrementTime(5);
		
		System.out.println("Añadimos Informática: Dedicado "+tasks.dedicatedTotal()+", Estimado "+tasks.estimatedTotal());
		System.out.println("Tiempos por separado: "+tasks.searchTask("matemáticas")+" "+tasks.searchTask("informática"));
		
		tasks.newTask("Física");
		tasks.searchTask("Física").getEstimated().incrementTime(2);
		tasks.searchTask("Física").getDedicated().incrementTime(5);
		
		System.out.println("Añadimos Física: Dedicado "+tasks.dedicatedTotal()+", Estimado "+tasks.estimatedTotal());
		System.out.println("Tiempos por separado: "+tasks.searchTask("matemáticas")+" "+tasks.searchTask("informática")+" "+tasks.searchTask("física"));
		
		
		tasks.searchTask("matemáticas").addTask(tasks.searchTask("informática"));
		System.out.println("Añadimos Informática como subtarea de matemáticas: Dedicado "+tasks.dedicatedTotal()+", Estimado "+tasks.estimatedTotal());
		System.out.println("Tiempos por separado: "+tasks.searchTask("matemáticas")+" "+tasks.searchTask("informática")+" "+tasks.searchTask("física"));
				
		tasks.searchTask("matemáticas").setParent(tasks.searchTask("física"));
		System.out.println("Añadimos Física como padre de Matemáticas: Dedicado "+tasks.dedicatedTotal()+", Estimado "+tasks.estimatedTotal());
		System.out.println("Tiempos por separado: "+tasks.searchTask("matemáticas")+" "+tasks.searchTask("informática")+" "+tasks.searchTask("física"));
		
		
		tasks.searchTask("matemáticas").removeTask(tasks.searchTask("informática"));
		System.out.println("Liberamos Informática como subtarea de Matemáticas: Dedicado "+tasks.dedicatedTotal()+", Estimado "+tasks.estimatedTotal());
		System.out.println("Tiempos por separado: "+tasks.searchTask("matemáticas")+" "+tasks.searchTask("informática")+" "+tasks.searchTask("física"));
		
	}
	
}

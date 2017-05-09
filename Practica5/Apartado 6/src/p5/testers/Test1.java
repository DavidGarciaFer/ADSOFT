package p5.testers;

import java.util.*;

import p5.ejercicio1.ObservableObserver;

/**
 * Test del apartado 1 de la Practica 5
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Test1 {

	public static void printInfo(List<ObservableObserver> list){
		int i = 1;
		for(ObservableObserver o : list){
			System.out.println("El valor del observador "+i+" es: "+o.getValue());
			i++;
		}
	}
	
	public static void main(String[] args){
		
		ObservableObserver o1 = new ObservableObserver(1);
		ObservableObserver o2 = new ObservableObserver(2);
		ObservableObserver o3 = new ObservableObserver(3);
		ObservableObserver o4 = new ObservableObserver(4);
		ObservableObserver o5 = new ObservableObserver(5);
		
		List<ObservableObserver> lista = Arrays.asList(o1, o2, o3, o4, o5);
		
		System.out.println("Valores iniciales: ");
		printInfo(lista);
		
		// Si descomentamos el siguiente codigo deberia generar una RunTimeException del tipo IllegalArgument
		//o1.incrementTime(-2);
		
		o1.add(o2);
		System.out.println("\nEl observador 1 observa al 2: ");
		printInfo(lista);
		
		o2.add(o4);
		System.out.println("\nEl observador 2 observa al 4: ");
		printInfo(lista);
		
		o1.remove(o2);
		System.out.println("\nEl observador 1 ya no observa al 2:");
		printInfo(lista);
		
		o2.add(o5);
		System.out.println("\nEl observador 2 observa al 4 y al 5:");
		printInfo(lista);
		
		// Los siguientes casos se pueden dar en este apartado, en apartados siguientes
		// se eliminaran cuando se implementen las tasks
		
		o2.add(o4);
		System.out.println("\nEl observador 2 puede observar dos veces al 4:");
		printInfo(lista);
		
		o1.add(o4);
		System.out.println("\nEl observador 4 puede ser observado por el 1 y el 2 a la vez:");
		printInfo(lista);
		
		o5.add(o3);
		System.out.println("\nEl observador 5 observa al 3:");
		printInfo(lista);
		
		// Si descomentamos este codigo se crearía un bucle. Esto se evitara en la implementacion 
		// del ejercicio 2, ya que en esta nos hemos ocupado de los aspectos mas basicos de los observadores
		
		//o3.add(o2);
		//System.out.println("\nEl observador 3 no puede observar al 2 porque crearia un bucle:");
		//printInfo(lista);

		
		o1.remove(o4);
		System.out.println("\nEl observador 1 ya no observa al 4:");
		printInfo(lista);
		
		o5.remove(o3);
		System.out.println("\nEl observador 5 ya no observa al 3:");
		printInfo(lista);
		
		o2.remove(o5);
		System.out.println("\nEl observador 2 ya no observa al 5:");
		printInfo(lista);
		
		o2.remove(o4);
		System.out.println("\nEl observador 2 ya no observa al 4:");
		printInfo(lista);
		
		o2.remove(o4);
		System.out.println("\nEl observador 2 ya no observa al 4:");
		printInfo(lista);
		
	}
	
}

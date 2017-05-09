package p5.testers;

import java.io.IOException;

import p5.ejercicio4.TaskConsole;

/**
 * Test del apartado 4 de la Practica 5
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Test4 {
	
	public static void main(String[] args) throws IOException{
		
		TaskConsole consola = TaskConsole.getInstance();
		consola.loadCommands();
		consola.run();
	}
	
}

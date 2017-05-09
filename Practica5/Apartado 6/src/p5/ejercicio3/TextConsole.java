package p5.ejercicio3;

import java.io.*;
import java.util.*;

/**
 * Clase auxiliar que contiene la informacion de un comando
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

class Command{
	protected String name;
	protected Function funct;
	
	/**
	 * Constructor de la clase comando
	 * @param name Nombre del comando
	 * @param funct Operacion que realiza
	 */
	
	public Command(String name, Function funct){
		this.name = name;
		this.funct = funct;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
}

/**
 * Clase con en la que hemos implementado la
 * consola de comandos 
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class TextConsole {
	
	private Collection<Command> comandos = new ArrayList<Command>();
	private static TextConsole INSTANCE =  new TextConsole();
	
	/**
	 * Agrega un comando a la lista de comandos disponibles
	 * @param name El nombre del comando
	 * @param op La operacion que realiza
	 */
	
	public void addCommands(String name, Function op){
		// Si ya existe el comando no lo añadimos
		if(getCommand(name) != null)
			return;
		comandos.add(new Command(name, op));
	}
	
	/**
	 * Devuelve el comando con el nomnre especificado
	 * @param name El nombre del comando
	 * @return El comando si existe, null en caso contrario
	 */
	
	public Command getCommand(String name){
		for(Command c : comandos){
			if(c.name.equals(name))
				return c;
		}
		return null;
	}
	
	/**
	 * Imprime todos los comandos disponibles
	 */
	
	public void printCommands(){
		System.out.println("Comandos disponibles: ");
		for(Command c : this.comandos){
			System.out.println(c);
		}
		System.out.println("");
	}
	
	/**
	 * Bucle que ejecuta la consola de comandos
	 * @throws IOException Posible error leyendo desde la terminal
	 */
	
	public void run() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		
		String line = br.readLine();
				
		while(!line.equals("")){
			String[] comando = line.split(" ");
			Command c = getCommand(comando[0]);
			if(c == null){
				System.out.println("El comando "+comando[0]+" no existe.");
				this.printCommands();
				line = br.readLine();
				continue;
			}
			String[] datos = new String[comando.length-1];	
			System.arraycopy(comando, 1, datos, 0, comando.length-1);
			c.funct.execute(datos);
			System.out.println("\n");
			line = br.readLine();
		}
		System.out.println("Fin del programa.");
	}
	
	/**
	 * Comprueba si una cadena es un número 
	 * @param cadena La cadena a comprobar
	 * @return True si la cadena se puede parsear 
	 * a entero, false si no.
	 */
	
	public boolean isNumeric(String cadena){
		try{
			Integer.parseInt(cadena);
			return true;
		}
		catch(NumberFormatException nfe){
			return false;
		}
	}
	
	/**
	 * Devuelve la instancia de la consola de comandos
	 * @return La instancia de la consola
	 */
	
	public static TextConsole getInstance(){
		return INSTANCE;
	}
	
}

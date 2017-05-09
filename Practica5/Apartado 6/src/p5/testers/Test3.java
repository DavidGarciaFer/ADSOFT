package p5.testers;

import java.io.IOException;

import p5.ejercicio3.TextConsole;

/**
 * Test del apartado 3 de la Practica 5
 * @author David Garcia (david.garcia03@estudiante.uam.es)
 * @author Luis Carabe (luis.carabe@estudiante.uam.es)
 */

public class Test3 {
	public static void main(String[] args) throws IOException{
		
		TextConsole consola = TextConsole.getInstance();
		
		consola.addCommands("suma", (datos) -> {
			if(datos.length != 2){
				System.out.println("Se esperan dos operandos numéricos como parámetro");
				return;
			}
			if((consola.isNumeric(datos[0]) && consola.isNumeric(datos[1])) == false)
				throw new IllegalArgumentException();
			System.out.println("Resultado de la suma: "+(Integer.parseInt(datos[0])+Integer.parseInt(datos[1])));
		});
		
		consola.addCommands("resta", (datos) -> {
			if(datos.length != 2){
				System.out.println("Se esperan dos operandos numéricos como parámetro");
				return;
			}
			if((consola.isNumeric(datos[0]) && consola.isNumeric(datos[1])) == false)
				throw new IllegalArgumentException();
			System.out.println("Resultado de la resta: "+(Integer.parseInt(datos[0])-Integer.parseInt(datos[1])));
		});
		
		consola.addCommands("producto", (datos) -> {
			if(datos.length != 2){
				System.out.println("Se esperan dos operandos numéricos como parámetro");
				return;
			}
			if((consola.isNumeric(datos[0]) && consola.isNumeric(datos[1])) == false)
				throw new IllegalArgumentException();
			System.out.println("Resultado del producto: "+(Integer.parseInt(datos[0])*Integer.parseInt(datos[1])));
		});
		
		consola.addCommands("concatenar", (datos) -> {
			if(datos.length != 2){
				System.out.println("Se esperan dos operandos numéricos como parámetro");
			}
			System.out.println("Resultado de la concatenacion: "+datos[0]+datos[1]);
		});
		
		consola.run();
	}
}

package es.uam.eps.ads.p3.biblioteca;

public class Biblioteca {
	private static final Biblioteca Instance = new Biblioteca();
	
	private Biblioteca(){
		
	}
	
	public static Biblioteca getInstance(){
		return Biblioteca.Instance;
	}
}

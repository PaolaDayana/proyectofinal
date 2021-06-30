package Examen;
/*
 * Clase solo para validar y leer entradas
 * */
import java.util.Scanner;

public class Entrada  extends EntradaArchivo{
	
	
  private Scanner leer = new Scanner(System.in);
  private Scanner leerString = new Scanner(System.in);
private int num=0;
private String text=null;
  private double numD=0.0;
 
	
  //Validar doubles
  public double ComprobarDouble(double a, String error) {
		do {
			while (!leer.hasNextDouble()) {

				System.out.print("Debe introducir solo numeros, vuelva a ingresar " + error + ": ");
				leer.next();

			}

			a = leer.nextDouble();

			if (a <= 0) {
				System.out.print("Debe ingresar un numero mayor que cero, vuelva a ingresar " + error + ": ");
			}
		} while (a <= 0);
	
		return a;

	}
	
	//Polimorfismo
	public double ComprobarDouble( String error) {
		do {
			while (!leer.hasNextDouble()) {

				System.out.print("Debe introducir solo numeros, vuelva a ingresar " + error + ": ");
				leer.next();

			}

			numD= leer.nextDouble();

			if (numD <= 0) {
				System.out.print("Debe ingresar un numero mayor que cero, vuelva a ingresar " + error + ": ");
			}
		} while (numD <= 0);
	
		return numD;

	}
	public String ComprobarString(String error) {
	
			while (!leerString.hasNextLine()) {

				System.out.print("Debe introducir una linea de texto, vuelva a ingresar " + error + ": ");
				leerString.next();

			}
			
			
			text = leerString.nextLine();
		
		

		return text;
		
	}

	
	public int DeseaContinuar(String mensaje) {
		int opcion=0;
		do {
			System.out.println(mensaje+"? (1=si, 2=no)");
			while (!leer.hasNextInt()) {
				System.out.print("Debe introducir solo numeros, vuelva a ingresar la opcion: ");
				leer.next();
			}

			opcion = leer.nextInt();

			if (opcion <= 0 || opcion>2) {
				System.out.print("Debe ingresar una de las opciones disponibles, vuelva a intentarlo: ");
			}
		} while (opcion <= 0 || opcion>2);
		
		return opcion;
		
		
	}

	public  int ComprobarEntero(String error) {

		do {
			while (!leer.hasNextDouble()) {

				System.out.print("Debe introducir solo numeros, vuelva a ingresar " + error + ": ");
				leer.next();

			}

			num = leer.nextInt();
		
			if (num <= 0) {
				System.out.print("Debe ingresar un numero mayor que cero, vuelva a ingresar " + error + ": ");
			}
		} while (num <= 0);
	

		return num;
}
	
	
	
	public int ComprobarEntero() {
	 
	 return num;
 } 
  
	
	
	
	
}

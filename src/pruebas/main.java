package pruebas;

import java.util.Scanner;

public class main {
	
	 public static void main(String[] args) 
	    {
			Tablero tablero = new Tablero();
			Scanner sc=new Scanner(System.in);
			System.out.println("Pulsa 1 para leer de fichero");
			System.out.println("Pulsa 2 para hacerlo aleatoriamente");

			switch (sc.nextInt()){
				case 1:
					tablero.rellenarTableroFichero();
					tablero.imprimeTablero();
					break;
				case 2:
					tablero.rellenarTableroRan();
					tablero.imprimeTablero();
					break;
				default:
					System.out.println("Número incorrecto");
			}

	     //   tablero = new int[filas][columnas];
	        

	       
	      
	}

}

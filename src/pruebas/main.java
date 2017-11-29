package pruebas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
	
	 public static void main(String[] args) 
	    {
			Problema generar = new Problema();
			System.out.println("Pulsa 1 para leer de fichero");
			System.out.println("Pulsa 2 para hacerlo aleatoriamente");
			Scanner sc=new Scanner(System.in);
			int eleccion=sc.nextInt();
			System.out.println("Elige tipo de busqueda");
			System.out.println("0 para Anchura");
			System.out.println("1 para Profundidad simple");
			System.out.println("2 para Profundidad acotada");
			System.out.println("3 para Profundidad iterativa");
			Scanner scc=new Scanner(System.in);
			int eleccion2=scc.nextInt();
			Boolean fallo=false;
			do {
				try {
					switch (eleccion) {
						case 1:
							generar.rellenarTableroFichero(eleccion2);
							//tablero.imprimirTablero();

							break;
						case 2:
							generar.generarTerrenoRnd(eleccion2);
							break;
						default:
							System.out.println("Número incorrecto");
					}
				}catch(InputMismatchException e){
					fallo=true;
				}
			}while(fallo==true);


	}
   public void arbol(){

   }
}

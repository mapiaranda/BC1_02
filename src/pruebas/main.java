package pruebas;

import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class main {
	
	 public static void main(String[] args) throws Exception {
			Problema generar = new Problema();
			System.out.println("Pulsa 1 para leer de fichero");
			System.out.println("Pulsa 2 para hacerlo aleatoriamente");
			Scanner sc=new Scanner(System.in);
			int eleccion=sc.nextInt();
			System.out.println("Elige tipo de busqueda");
			System.out.println("0 para Anchura");
			System.out.println("1 para Profundidad ");
			System.out.println("2 para Coste Uniforme");
			System.out.println("3 para A*");
            System.out.println("4 para Voraz");
         Scanner scc=new Scanner(System.in);
			int eleccion2=scc.nextInt();
         System.out.println("Escribe la profundidad maxima");
         int prof_max=scc.nextInt();
			Boolean fallo=false;

			do {
				try {
					switch (eleccion) {
						case 1:
							generar.rellenarTableroFichero(eleccion2, prof_max);
							Estrategia.estrategia(generar, prof_max, eleccion2);

                            break;
						case 2:
							generar.generarTerrenoRnd(eleccion2);
							Estrategia.estrategia(generar, prof_max, eleccion2);
							break;
						default:
							System.out.println("Número incorrecto");
					}
				}catch(InputMismatchException e){
					fallo=true;
				}
			}while(fallo==true);


	}

}

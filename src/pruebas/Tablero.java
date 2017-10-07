package pruebas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tablero {

	int filas;
	int columnas;
	int tablero[][];
	int V; // cantidad de Arena que va haber en todo el tablero
	int K; // cantidad de arena que va a haber en cada casilla
	int max; // cantidad máxima que almacena cada casilla
	

	Tablero(int filas, int columnas) {

		this.filas = filas;
		this.columnas = columnas;
		tablero = new int[filas][columnas];

	}
	void rellenarTableroFichero(){
		Scanner entrada = null;
		try {
			entrada = new Scanner(new File("prueba.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int [] datos = new int [6];

		int i=0;
		for (int j = 0; j < 5; j++) {
			datos[j]=entrada.nextInt();
		}
		int [][] terreno=new int [datos[0]][datos[1]];
		for (int j = 0; j < datos[0]; j++) { //fila
			for (int k = 0; k < datos[1]; k++) { //columna
				terreno[j][k]=entrada.nextInt();
			}
		}
	}
		/*
		 * Método para rellenar el tablero con números aleatorios
		 */
	void rellenarTableroRan(int filas, int columnas) {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = (int) (Math.random() * 9);
			}
			System.out.println("\n");
		}
	}

		/*
		 * Método para imprimir el tablero generado de manera aleatoria
		 */
	void imprimeTablero(int filas, int columnas) {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

}
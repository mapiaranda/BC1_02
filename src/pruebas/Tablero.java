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

	public Tablero() {
	}


	void rellenarTableroFichero(){
		Scanner entrada = null;
		try {
			entrada = new Scanner(new File("prueba.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int [] datos = new int [6];

		for (int j = 0; j < 5; j++) {
			datos[j]=entrada.nextInt();
		}
		this.filas=datos[0];
		this.columnas=datos[1];
		System.out.println(datos[0]+" colum  "+datos[1]);
		tablero=new int[this.filas][this.columnas];
		for (int j = 0; j < datos[0]; j++) { //fila
			for (int k = 0; k < datos[1]; k++) { //columna
				tablero[j][k]=entrada.nextInt();
			}
		}
	}
		/*
		 * Método para rellenar el tablero con números aleatorios
		 */
	void rellenarTableroRan() {
		int filas = (int) (Math.random()*9);
		int columnas = (int) (Math.random()*9);
		tablero=new int[this.filas][this.columnas];
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
	void imprimeTablero() {
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

}
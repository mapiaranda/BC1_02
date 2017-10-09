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

	public Tablero(){

	}

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
	//*****************************************************
	// Métodos para generar el Terreno de Manera Aleatoria
	//*****************************************************
	
	void generarTerrenoRnd(){
		V =(int) (Math.random()*99)+1;;
		filas = (int) (Math.random()*9)+1;
		columnas = (int) (Math.random()*9)+1;
		K=V/filas*columnas;
		max=(int) (Math.random()*(V-1))+1;; //cantidad máxima que puede almacenar cada casilla, se pasa por parámetros
		int total=V;
		tablero=new int[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if(total<max){
					tablero[i][j]=(int) (Math.random()*total);
				}else{
					tablero[i][j] = (int) (Math.random()*max);
				}

				total = total - tablero[i][j];
			}
			System.out.println("\n");
		}

	}


	void imprimirTablero() {
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

}
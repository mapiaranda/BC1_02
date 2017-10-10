package pruebas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tablero {

	public static int filas;
	public static int columnas;
	public static Casilla tablero[][];
	public int V; // cantidad de Arena que va haber en todo el tablero
	public int K; // cantidad de arena que va a haber en cada casilla
	public int max; // cantidad máxima que almacena cada casilla

	public Tablero(){

	}



	void rellenarTableroFichero(){
		Scanner entrada = null;
		try {
			entrada = new Scanner(new File("prueba.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int [] datos = new int [6];

		for (int j = 0; j < 6; j++) {
			datos[j]=entrada.nextInt();
		}
		this.filas=datos[4];
		this.columnas=datos[5];
		this.max=datos[3];
		this.K=datos[2];
		Casilla casi;
		this.tablero=new Casilla[this.filas][this.columnas];
		Tractor t=new Tractor(datos[0],datos[1]);
		int i=0;
		for (int j = 0; j < this.filas; j++) { //fila
			for (int k = 0; k < this.columnas; k++) { //columna
				casi=new Casilla(i, entrada.nextInt(), max, j, k);
				this.tablero[j][k]=casi;
				i++;
			}
		}

		t.adyacentes();
	}
	//*****************************************************
	// Métodos para generar el Terreno de Manera Aleatoria
	//*****************************************************

	
	void generarTerrenoRnd(){
		V =(int) (Math.random()*99)+1;;
		filas = (int) (Math.random()*9)+1;
		columnas = (int) (Math.random()*9)+1;
		K=V/filas*columnas;
		max=(int) (Math.random()*(V-1))+1;; //cantidad máxima que puede almacenar cada casilla
		int total=V;
		tablero=new Casilla[filas][columnas];
		int a=0;
		Casilla casi;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if(total<max){
					casi=new Casilla(a,(int) (Math.random()*total), max, i, j );
					tablero[i][j]=casi;
				}else{
					casi=new Casilla(a,(int) (Math.random()*max), max, i, j );
					tablero[i][j]=casi;
				}
				a++;
				total = total - casi.getArena_casilla();
			}
			System.out.println("\n");
		}
		Tractor t=new Tractor(1,2);
		t.adyacentes();

	}


	void imprimirTablero() {
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
		}
	}

}
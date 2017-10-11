package pruebas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tablero {

	public static int filas;
	public static int columnas;
	public static Casilla tablero[][];
	public int V; // cantidad de Arena que va haber en todo el tablero
	public int K; // cantidad de arena que va a haber en cada casilla
	public int max; // cantidad máxima que almacena cada casilla
	int posX;
	int posY;
	int contadorSucesores;

	public Tablero(){

	}

	public void adyacentes(){
		ArrayList<Casilla> adya=new ArrayList<>();
		//comprobamos si existe casilla a la derecha, izquierda, arriba y abajo
		if((posX+1)<filas ){
			Casilla ca=tablero[posX+1][posY];
			adya.add(ca);
		}if((posX-1)>=0){
			Casilla ca=tablero[posX-1][posY];
			adya.add(ca);
		}if((posY+1)<columnas){
			Casilla ca=tablero[posX][posY+1];
			adya.add(ca);

		}if((posY-1)>=0){
			Casilla ca=tablero[posX][posY-1];
			adya.add(ca);
		}
		int sobra=max-tablero[posX][posY].getArena_casilla();

		for(int i=0; i<sobra;i++){
			
		}

		tablero[posX][posY].setVisitado(true);
		int contador=0;
		for (int i=0;i<filas;i++){
			for (int j=0; j<columnas;j++){ //Contamos los visitados de todo el tablero
				if(tablero[i][j].isVisitado()){
					contador+=1;
				}
			}
		}
		if(contador==(filas*columnas)){ //Si todos estan visitados ya hemos terminado
			//Termina
			System.out.println("El número de sucesores es: "+contadorSucesores);
		}else{
			int mover = (int) (Math.random() * (adya.size()));//Generamos un numero aleatorio y nos movemos a el
			switch (mover) {
				case 0:
					setPosX(adya.get(0).getPos_x());
					setPosY(adya.get(0).getPos_y());
					break;
				case 1:
					setPosX(adya.get(1).getPos_x());
					setPosY(adya.get(1).getPos_y());
					break;
				case 2:
					setPosX(adya.get(2).getPos_x());
					setPosY(adya.get(2).getPos_y());

					break;
				case 3:
					setPosX(adya.get(3).getPos_x());
					setPosY(adya.get(3).getPos_y());

					break;

			}

			adyacentes();//Volvemos a llamar al metodo, habiendo actualizado la nueva posicion del tractor
		}
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
		int i=0;
		for (int j = 0; j < this.filas; j++) { //fila
			for (int k = 0; k < this.columnas; k++) { //columna
				casi=new Casilla(i, entrada.nextInt(), max, j, k);
				this.tablero[j][k]=casi;
				i++;
			}
		}
		setPosX(datos[0]);
		setPosY(datos[1]);
		adyacentes();
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
		setPosX(2);
		setPosY(2);
		adyacentes();

	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getContadorSucesores() {
		return contadorSucesores;
	}

	public void setContadorSucesores(int contadorSucesores) {
		this.contadorSucesores = contadorSucesores;
	}

	void imprimirTablero() {
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
		}
	}

}
package pruebas;

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
	//*****************************************************
	// Métodos para generar el Terreno de Manera Aleatoria
	//*****************************************************
	
	void comprobarTerrenoRnd (){
		// Lo primero es comprobar que con los datos introducidos se pueda generar el terreno
		
		int k=0; //se pide por teclado, pasar por parametros desde el main
		int v =0;
		int filas=0; // se pide por teclado
		int columnas=0; // se pide por teclado
		v = filas*columnas*k;
		int comprobar = v/(filas*columnas); //Variable para calcular el peso que hay en cada casilla
		
		/*
		 * Si al calcular V y dividirlo entre el número de casillas el numero no es entero,
		 * no es posible generar el terreno 
		 */
		
			if (comprobar%1==0){
				System.out.println("No se puede generar el terreno");
			}
			else{
				generarTerrenoRnd();
			}
	}
	
	void generarTerrenoRnd(){
		
		
		int k=0; //se pide por teclado, pasar por parametros desde el main
		int v =0;
		int filas=0; // se pide por teclado
		int columnas=0; // se pide por teclado
		v = filas*columnas*k;
		int comprobar = v/(filas*columnas);
		int max=0; //cantidad máxima que puede almacenar cada casilla, se pasa por parámetros
		int total=0;
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = (int) (Math.random() * max);
					//necesite un método para comprobar que se vaya rellenando correctamente sin pasarse de V
				total = total + tablero[i][j]; 
				comprobarTerrenoValido(total); //le tengo que pasar el valor que haya generado
				
				
			}
			System.out.println("\n");
		}
		
	}
	
	void /* boolean */comprobarTerrenoValido(int total){ // Boolean para seguir o no construyendo el terreno
		int v=0; //que almacena el volumen máximo del terreno, paso por parámetros
		int cantidad=0; //almacenar el valor que se le haya pasado por parámetros
		int valorComprobar  = total;
		
		if(valorComprobar <= v){
			imprimirTablero(filas, columnas);
		}
		else {
			System.out.println("El terreno generado no es válido. /n" + "Se va a generar otro terreno.");
			System.out.println("----------------------------------------------------------------------");
			generarTerrenoRnd(); // llamada al método para generar un nuevo terreno
		}
		
	}

	void imprimirTablero(int filas, int columnas) {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

}
package pruebas;
public class main {
	
	 public static void main(String[] args) 
	    {
		 int filas = (int) (Math.random()*9);
		 int columnas = (int) (Math.random()*9);

	     //   tablero = new int[filas][columnas];
	        
	        Tablero tablero = new Tablero(filas,columnas);
	        
	        tablero.rellenarTableroRan(filas, columnas);

	        tablero.imprimeTablero(filas, columnas);
	       
	      
	}

}

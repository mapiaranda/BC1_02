package pruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerFichero {
	
	 public static void main(String[] args){
		      File archivo = null;
		      FileReader fr = null;
		      BufferedReader br = null;

		      try {
		         // Apertura del fichero y creacion de BufferedReader para poder
		         // hacer una lectura comoda (disponer del metodo readLine()).
		         archivo = new File ("datos.txt");
		         fr = new FileReader (archivo);
		         br = new BufferedReader(fr);

		         //Crear matriz para guardar los datos del txt
		         int tabla[][] = new int[0][0];
		         int aux=0;
		         
		         // Lectura del fichero
		         String linea;
		         while((linea=br.readLine())!=null){
		        	 aux++;
		            System.out.println(linea);
		         	
		         }
		         aux= aux-1;
		         	
		         
		            System.out.println(aux);   
		         }
		      catch(Exception e){
		         e.printStackTrace();
		      }finally{
		         // En el finally cerramos el fichero, para asegurarnos
		         // que se cierra tanto si todo va bien como si salta 
		         // una excepcion.
		         try{                    
		            if( null != fr ){   
		               fr.close();     
		            }                  
		         }catch (Exception e2){ 
		            e2.printStackTrace();
		         }
		      }
		      
		      //fuera del try/catch
		  
		   }
	 
		/* public static void main(String[] args){
		  try{
		   //Abrimos el archivo
		    BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream("datos.txt")));
		   //Leemos la primera linea que es en la que esta el numero de filas
		   int filas=Integer.parseInt(in.readLine());
		   //Leemos la segunda linea que es en la que esta el numero de columnas
		   int columnas=Integer.parseInt(in.readLine());
		   //Creamos el arreglo con las dimensiones dadas
		   int matriz[][]=new int[filas][columnas];
		   //Leemos los caracteres
		   for(int i=0;i < filas;i++){
		    for(int j=0;j < columnas;j++){
		     matriz[ i ][ j ]=(int)(in.read());
		     System.out.print (matriz[i][j]);
		     	if (j!=matriz[i].length-1) System.out.print("\t");
		    }
		   }
		   //Cerramos el archivo
		   in.close();
		  }catch(Exception e){}
		 }	 */
}

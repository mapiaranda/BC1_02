package pruebas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problema {
    public static EspacioDeEstados espacio;
    public static Estado es;

    public static boolean Solucion(int estado[][]){
        boolean b=true;
        for (int i=0; i<estado.length;i++){
            for (int j=0; j<estado.length;j++){
                if(estado[i][j]!=es.getK()){
                    b=false;
                    j=estado[i].length+1;
                    i=estado.length+1;
                }
            }
        }
        return b;
    }

    public  EspacioDeEstados getEspacio() {
        return espacio;
    }

    public  void setEspacio(EspacioDeEstados espacio) {
        Problema.espacio = espacio;
    }



    void rellenarTableroFichero(int tipoB){
        Scanner entrada = null;
        Estado e=new Estado();
        try {
            entrada = new Scanner(new File("Problema.dat"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        int [] datos = new int [6];
        for (int j = 0; j < 6; j++) {
            datos[j]=entrada.nextInt();
        }
        int i=0;
        int filas=datos[4];
        int columnas=datos[5];
        int terreno[][]=new int[datos[4]][datos[5]];
        for (int j = 0; j < filas; j++) { //fila
            for (int k = 0; k < columnas; k++) { //columna
                terreno[j][k]=entrada.nextInt();
                i++;
            }
        }
        e=new Estado(datos[4], datos[5], terreno, datos[0], datos[1], (datos[5]*datos[4])*datos[2],datos[2], datos[3], terreno[datos[0]][datos[1]]);
        es=e;
        Accion a=null;
        Nodo nodo=new Nodo(0,null,e, "", 0, 0, 0, false);
        Frontera f=new Frontera();
        f.insertarNodo(nodo);
        espacio=new EspacioDeEstados();

        espacio.adyacentes(f, tipoB, 0,0,0);
    }

    void generarTerrenoRnd(int tipoB){
        Estado e=new Estado();
        e.setV((int)(Math.random()*99)+1) ;
        e.setFilas( (int) (Math.random()*9)+1);
        e.setColumnas((int) (Math.random()*9)+1);
        e.setK(e.getV()/e.getFilas()*e.getColumnas());
        e.setMax((int) (Math.random()*(e.getV()-1))+1); //cantidad máxima que puede almacenar cada casilla
        int total=e.getV();
        int terreno[][]=new int[e.getFilas()][e.getColumnas()];
        Estado casi;
        int a=1;
        for (int i = 0; i < e.getFilas(); i++) {
            for (int j = 0; j < e.getColumnas(); j++) {
                if(total<e.getMax()){
                    terreno[i][j]=(int)Math.random()*total;

                }else if(total<e.getMax() && a==e.getFilas()*e.getColumnas() ){
                    terreno[i][j]=total;
                }else{
                    terreno[i][j]=(int)Math.random()*e.getMax();
                }
                a++;
                total = total - terreno[i][j];
            }
            System.out.println("\n");
        }
        e.setTerreno(terreno);
        e.setPosX(2);
        e.setPosY(2);
        es=e;
        Nodo nodo=new Nodo(0,null,e, "", 0, 0, 0, false);
        Frontera f=new Frontera();
        f.insertarNodo(nodo);
        espacio=new EspacioDeEstados();
        espacio.adyacentes(f, tipoB, 0,0,0);

    }
//Método para escribir en fichero
   public static void escribir (FileWriter fw, Nodo n, Accion a) {
		int [][] terreno = n.getEstado().getTerreno();
		Estado e=n.getEstado();
		try {
		    fw.write(a.toString());
		    fw.write(e.getPosX()+" "+e.getPosY()+" "+e.getK()+" "+e.getMax()+" "+e.getColumnas()+" "+e.getFilas());
			//fw.write("\nAccion -> Arriba: "+aux.get_accion_aplicada()[0]+"; Abajo: "+ aux.get_accion_aplicada()[1]+"; Derecha: "+aux.get_accion_aplicada()[2]+"; Izquierda: "+aux.get_accion_aplicada()[3]+"\n");
			for (int i = 0; i < terreno.length; i++) {
				for (int j = 0; j < terreno.length; j++) {
					fw.write(" " + terreno[i][j]);
				}
				fw.write("\n");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

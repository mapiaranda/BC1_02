package pruebas;

import java.io.File;
import java.io.FileNotFoundException;
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
            entrada = new Scanner(new File("prueba.txt"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        int [] datos = new int [6];

        for (int j = 0; j < 6; j++) {
            datos[j]=entrada.nextInt();
        }

        e.setFilas(datos[4]);
        e.setColumnas(datos[5]);
        e.setMax(datos[3]);
        e.setK(datos[2]);

        int i=0;
        int terreno[][]=new int[datos[4]][datos[5]];
        for (int j = 0; j < e.getFilas(); j++) { //fila
            for (int k = 0; k < e.getColumnas(); k++) { //columna
                terreno[j][k]=entrada.nextInt();
                i++;
            }
        }
        e.setTerreno(terreno);
        e.setPosX(datos[0]);
        e.setPosY(datos[1]);
        es=e;
        Accion a=null;
        Nodo nodo=new Nodo(0,null,e, "", 0, 0, 0, false);
        Frontera f=new Frontera();
        f.insertarNodo(nodo);
        espacio=new EspacioDeEstados();
        espacio.adyacentes(f, tipoB, 0);
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
        int a=0;
        Estado casi;
        for (int i = 0; i < e.getFilas(); i++) {
            for (int j = 0; j < e.getColumnas(); j++) {
                if(total<e.getMax()){
                    terreno[i][j]=(int)Math.random()*total;

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
        espacio.adyacentes(f, tipoB, 0);

    }
}

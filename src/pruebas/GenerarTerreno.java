package pruebas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GenerarTerreno {
    public static EspacioDeEstados espacio;
    public static Problema problema;


    void rellenarTableroFichero(){
        Scanner entrada = null;
        espacio=new EspacioDeEstados();
        problema=new Problema();
        try {
            entrada = new Scanner(new File("prueba.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int [] datos = new int [6];

        for (int j = 0; j < 6; j++) {
            datos[j]=entrada.nextInt();
        }

        espacio.setFilas(datos[4]);
        espacio.setColumnas(datos[5]);
        espacio.setMax(datos[3]);
        espacio.setK(datos[2]);
        Estado casi;
        Problema.estadoInicial=new Estado[espacio.getFilas()][espacio.getColumnas()];
        espacio.estados=new Estado[espacio.getFilas()][espacio.getColumnas()];
        int i=0;
        for (int j = 0; j < espacio.getFilas(); j++) { //fila
            for (int k = 0; k < espacio.getColumnas(); k++) { //columna
                casi=new Estado(i, entrada.nextInt(), j, k);
                Problema.estadoInicial[j][k]=casi;
                espacio.estados[j][k]=casi;
                i++;
            }
        }
        espacio.setPosX(datos[0]);
        espacio.setPosY(datos[1]);
        espacio.adyacentes();
    }

    void generarTerrenoRnd(){
        espacio.setV((int)(Math.random()*99)+1) ;
        espacio.setFilas( (int) (Math.random()*9)+1);
        espacio.setColumnas((int) (Math.random()*9)+1);
        espacio.setK(espacio.V/espacio.filas*espacio.columnas);
        espacio.setMax((int) (Math.random()*(espacio.V-1))+1); //cantidad máxima que puede almacenar cada casilla
        int total=espacio.V;
        Problema.estadoInicial=new Estado[espacio.getFilas()][espacio.getColumnas()];
        espacio.estados=new Estado[espacio.getFilas()][espacio.getColumnas()];
        int a=0;
        Estado casi;
        for (int i = 0; i < espacio.getFilas(); i++) {
            for (int j = 0; j < espacio.getColumnas(); j++) {
                if(total<espacio.getMax()){
                    casi=new Estado(a,(int) (Math.random()*total), i, j );
                    Problema.estadoInicial[i][j]=casi;
                    espacio.estados[i][j]=casi;
                }else{
                    casi=new Estado(a,(int) (Math.random()*espacio.max), i, j );
                    Problema.estadoInicial[i][j]=casi;
                    espacio.estados[i][j]=casi;
                }
                a++;
                total = total - casi.getArena_casilla();
            }
            System.out.println("\n");
        }
        espacio.setPosX(2);
        espacio.setPosY(2);
        espacio.adyacentes();

    }
}

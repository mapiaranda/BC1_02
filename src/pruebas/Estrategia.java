package pruebas;

import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class Estrategia {
    public static void estrategia(Problema generar, int prof_max, int tipoB) throws Exception {
        Nodo nodo;
        int costeTotal=0;
        boolean escribirCoste=false;
        Queue<Nodo> cola = new LinkedBlockingQueue<Nodo>();
        long tiempoInicial = System.currentTimeMillis();

        generar.rellenarTableroFichero(tipoB, prof_max);
        cola=generar.getEspacio().Busqueda_Acotada(generar,tipoB,prof_max);
        while(!cola.isEmpty() && cola!=null ){
            nodo=cola.poll();
            Accion a=nodo.getAcc();
            if(nodo.getAccion()!=null){
                costeTotal+=nodo.getCosto();
            }
            System.out.println("accion estrategia "+a.toString());
            Problema.escribir(nodo, a);
            escribirCoste=true;
        }
        if(escribirCoste==true){
            Problema.escribirCoste(costeTotal);
        }
        long tiempoFinal = System.currentTimeMillis();
        System.out.println("Tiempo "+(tiempoFinal-tiempoInicial));
    }
}

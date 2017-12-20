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
        
       // System.out.println("Profundidad: "+prof_max);
        while(!cola.isEmpty() && cola!=null ){
            nodo=cola.poll();
            Accion a=nodo.getAcc();
            if(nodo.getAcc()!=null){
                costeTotal+=nodo.getAcc().getCosto();
            }
           // System.out.println("accion estrategia "+a.toString());
            if(nodo.getPadre()!=null){
                System.out.println("Accion "+nodo.getAcc().toString()); //Mostrar la accion (2)
                System.out.println("Valor: "+nodo.getValor()); //Mostrar el valor (3)
                System.out.println(Estado.imp_terrain(nodo.getEstado().getTerreno()));
                Problema.escribir(nodo, a, escribirCoste);
                escribirCoste=true;
            }

        }
        System.out.println("Costo: "+costeTotal);
        if(escribirCoste==true){
            Problema.escribirCoste(costeTotal);
        }
        long tiempoFinal = System.currentTimeMillis();
        System.out.println("Tiempo "+(tiempoFinal-tiempoInicial));
    }
}

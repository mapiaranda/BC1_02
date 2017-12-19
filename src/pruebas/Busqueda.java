package pruebas;

import java.util.*;

public class Busqueda {


    public Nodo busqueda(Queue<Nodo> frontera){
        Nodo n2 = null;
        if(!frontera.isEmpty() ){
            if(!Problema.Solucion(frontera.peek().getEstado().getTerreno())){
                n2=frontera.poll();
            }
        }
            return n2;
    }
    public Hashtable<String, Nodo> comprobarNodo(Hashtable<String, Nodo> visitados, Nodo nodo, int tipoB, Frontera f){
        boolean b=false;
        Estado es2=nodo.getEstado();
        int aux = 0;

        System.out.println("tamaño frontera: "+f.getFrontera().size());
        if(!visitados.containsKey(nodo.getId()) ) {
           System.out.println("ID "+nodo.getId());
            visitados.put(nodo.getId(), nodo);
            f.insertarNodo(nodo);
        }
        return visitados;
    }


}

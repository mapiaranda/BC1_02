package pruebas;

import java.util.PriorityQueue;

public class Busqueda {

    public Nodo busqueda(PriorityQueue<Nodo> frontera){
        Nodo n2 = null;
        if(!frontera.isEmpty() ){
            if(!Problema.Solucion(frontera.peek().getEstado().getTerreno())){
                n2=frontera.poll();
            }
        }
            return n2;
    }


}

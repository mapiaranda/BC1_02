package pruebas;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

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
    public boolean comprobarNodo(ArrayList<Nodo> nodosvisitados, Nodo nodo){
        boolean b=false;
        Estado es2=nodo.getEstado();
        for (int i=0; i<nodosvisitados.size();i++){
            Estado es=nodosvisitados.get(i).getEstado();
            if(es.getPosX()==es2.getPosX() && es.getPosY()==es2.getPosY() && es.getTerreno().equals(es2.getTerreno())){
                b=true;
                i=nodosvisitados.size()+2;
                }

            }

        return b;
    }


}

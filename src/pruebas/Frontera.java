package pruebas;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Frontera{
	private PriorityQueue<Nodo> frontera=new PriorityQueue<>(100) ;

	public PriorityQueue<Nodo> getFrontera() {
		return frontera;
	}

	public void setFrontera(PriorityQueue<Nodo> frontera) {
		this.frontera = frontera;
	}
	public void insertarNodo(Nodo n){
		this.frontera.offer(n);

	}
	public void insertarListaNodos(ArrayList<Nodo> nodos, Hashtable<String,Nodo> visitados){
		for (int i=0; i< nodos.size();i++){
			Nodo nodo_inicial=nodos.get(i);
			if(!visitados.containsKey(nodo_inicial.getId()) || visitados.containsKey(nodo_inicial.getId()) && nodo_inicial.getValor()<visitados.get(nodo_inicial.getId()).getValor()) {
				visitados.put(nodo_inicial.getId(), nodo_inicial);
				//System.out.println("Accion en insertar "+nodo_inicial.getAcc());
				insertarNodo(nodo_inicial);
			}

			//insertarNodo(nodos.get(i));
		}
	}
	public Nodo eliminar(){
		return this.frontera.remove();
	}


	public boolean esVacia(){
		return this.frontera.isEmpty();
	}
}

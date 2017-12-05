package pruebas;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Frontera{
	private PriorityQueue<Nodo> frontera=new PriorityQueue<>() ;

	public PriorityQueue<Nodo> getFrontera() {
		return frontera;
	}

	public void setFrontera(PriorityQueue<Nodo> frontera) {
		this.frontera = frontera;
	}
	public void insertarNodo(Nodo n){
		this.frontera.offer(n);

	}
	public Nodo eliminar(){
		return this.frontera.poll();
	}


	public boolean esVacia(){
		return this.frontera.isEmpty();
	}
}

package pruebas;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Frontera{
	private PriorityQueue<NodoArbol> frontera;
	
	public Frontera(NodoArbol n){
		this.frontera.add(n);
	}
	
	/**
	 * @return frontera
	 */
	public PriorityQueue<NodoArbol> getFrontera() {
		return frontera;
	}
	
	/**
	 * @param frontera
	 */
	public void setFrontera(PriorityQueue<NodoArbol> frontera) {
		this.frontera = frontera;
	}

	/**
	 * Inserta nodos en la PriorityQueue
	 * @param nodo
	 */
	public void insertarNodo(NodoArbol nodo){
		this.frontera.offer(nodo);
	}
	
	/**
	 * Inserta nodos en la PriorityQueue de una lista que contiene los sucesores de un estado
	 * @param list
	 */
	public void insertarLista(LinkedList<NodoArbol> list){
		int i = 0;
		int size = list.size();
		while(i < size){
			this.frontera.offer(list.get(i));
			i++;
		}
	}

	public NodoArbol eliminar(){
		return this.frontera.poll();
	}
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean esVacia(){
		return this.frontera.isEmpty();
	}
}

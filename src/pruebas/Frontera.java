package pruebas;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Frontera{
	private PriorityQueue<Nodo> frontera=new PriorityQueue<>(new Comparator<Nodo>() {
		@Override
		public int compare(Nodo o1, Nodo o2) {
			int r=0;
			if(o1.getValor()> o2.getValor()){
				r=1;
			}else if(o2.getValor()>o1.getValor()){
				r=-1;
			}
			return r;
		}
	});
	
	public Frontera(){

	}
	
	/**
	 * @return frontera
	 */
	public PriorityQueue<Nodo> getFrontera() {
		return frontera;
	}
	

	public void setFrontera(PriorityQueue<Nodo> frontera) {
		this.frontera = frontera;
	}

	/**
	 * Inserta nodos en la PriorityQueue
	 * @param nodo
	 */
	public void insertarNodo(Nodo nodo){
		this.frontera.offer(nodo);
	}
	
	/**
	 * Inserta nodos en la PriorityQueue de una lista que contiene los sucesores de un estado
	 * @param list
	 */
	public void insertarLista(LinkedList<Nodo> list){
		int i = 0;
		int size = list.size();
		while(i < size){
			this.frontera.offer(list.get(i));
			i++;
		}
	}

	public Nodo eliminar(){
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

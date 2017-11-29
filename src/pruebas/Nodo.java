package pruebas;

import java.util.ArrayList;

public class Nodo implements Comparable<Nodo>{
	private int id;
	private Nodo padre; //información del nodo padre
	private Estado estado;
	private String accion; //arriba, abajo, derecha, izq
	private int costo; //número de movimientos
	private int valor; //valor por el cual se ordenará la frontera
	private int profundidad; //valor de la profundidad
	private boolean visitado;


	public Nodo(int id, Nodo padre, Estado estado, String accion, int costo, int valor, int profundidad, boolean visitado) {
		this.id=id;
		this.padre = padre;
		this.estado = estado;
		this.accion = accion;
		this.costo = costo;
		this.valor = valor;
		this.profundidad = profundidad;
		this.visitado = visitado;
	}

	public Nodo() {
	}



	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public Nodo getPadre() {
		return padre;
	}
	
		public void setPadre(Nodo padre) {
		this.padre = padre;
	}
	
	/**
	 * 
	 * @return Terreno
	 */

	public int getCosto() {
		return costo;
	}
	
	/**
	 * 
	 * @param costo
	 */
	public void setCosto(int costo) {
		this.costo = costo;
	}
	

	
	/**
	 * 
	 * @return int
	 */
	public int getValor() {
		return valor;
	}
	
	/**
	 * 
	 * @param valor
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	/**
	 * 
	 * @return int
	 */
	public int getProfundidad() {
		return profundidad;
	}
	
	/**
	 * 
	 * @param profundidad
	 */
	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}

	/**
	 * Compara el valor de los nodos para la introducción ordenada en la cola con prioridad
	 * @param nodo
	 * @return int
	 */
	public int compareTo(Nodo nodo){
        int r = 0;
        if (nodo.getValor() < getValor())
            r = 1;
        else if(nodo.getValor() > getValor())
        	r = -1;
        
        return r;
    }

	@Override
	public String toString() {
		return "Nodo{" +
				"padre=" + padre +
				", accion='" + accion + '\'' +
				", costo=" + costo +
				", valor=" + valor +
				", profundidad=" + profundidad +
				'}';
	}
}

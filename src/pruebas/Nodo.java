package pruebas;

import java.util.ArrayList;

public class Nodo implements Comparable<Nodo>{
	private String id;
	private Nodo padre; //información del nodo padre
	private Estado estado;
	private String accion; //arriba, abajo, derecha, izq
	private int costo; //número de movimientos
	private int valor; //valor por el cual se ordenará la frontera
	private int profundidad; //valor de la profundidad
	private boolean visitado;
	private Accion acc;


	public Nodo(String id, Nodo padre, Estado estado, String accion, Accion acc, int costo, int valor, int profundidad) {
		this.id=id;
		this.padre = padre;
		this.estado = estado;
		this.accion = accion;
		this.costo = costo;
		this.valor = valor;
		this.acc=acc;
		this.profundidad = profundidad;
	}

	public Nodo() {
	}

	public Accion getAcc() {
		return acc;
	}

	public void setAcc(Accion acc) {
		this.acc = acc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int compareTo(Nodo o) {
		int resultado = 0;
		if (this.valor < o.valor)
			resultado = -1;
		else if (this.valor > o.valor)
			resultado = 1;
		else {
			resultado = 0;
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "Nodo{" +
				"id='" + id + '\'' +
				", padre=" + padre +
				", estado=" + estado +
				", accion='" + accion + '\'' +
				", costo=" + costo +
				", valor=" + valor +
				", profundidad=" + profundidad +
				", visitado=" + visitado +
				", acc=" + acc.toString() +
				'}';
	}
}

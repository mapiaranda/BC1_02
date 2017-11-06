package pruebas;

public class NodoArbol implements Comparable<NodoArbol>{
	private NodoArbol padre; //información del nodo padre
	private Problema Problema; //representación del terreno actual
	private int costo; //número de movimientos
	private String accion; //arribar, abajo, derecha, izquierda
	private int valor; //valor por el cual se ordenará la frontera
	private int profundidad; //valor de la profundidad
	
	public NodoArbol(NodoArbol padre, Problema problema, int costo, String accion, int valor, int profundidad){
		this.padre = padre;
		this.Problema  = problema;
		this.costo = costo;
		this.accion = accion;
		this.valor = valor;
		this.profundidad = profundidad;
	}
	
	/**
	 * 
	 * @return NodoArbol
	 */
	public NodoArbol getPadre() {
		return padre;
	}
	
	/**
	 * 
	 * @param padre
	 */
	public void setPadre(NodoArbol padre) {
		this.padre = padre;
	}
	
	/**
	 * 
	 * @return Terreno
	 */
	public Problema getProblema() {
		return Problema;
	}
	
	public void setTerreno(Problema problema) {
		this.Problema = Problema;
	}

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
	 * @return String
	 */
	public String getAccion() {
		return accion;
	}
	
	/**
	 * 
	 * @param accion
	 */
	public void setAccion(String accion) {
		this.accion = accion;
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
	public int compareTo(NodoArbol nodo){
        int r = 0;
        if (nodo.getValor() < getValor())
            r = 1;
        else if(nodo.getValor() > getValor())
        	r = -1;
        
        return r;
    }
	
	@Override
	public String toString() {
		return "NodoArbol [Padre=" + getPadre() + ", Terreno=" + getProblema() + ", Costo=" + getCosto()
		+ ", Accion=" + getAccion() + ", Profundidad=" + getProfundidad() + ", Valor=" + getValor() + "]";
	}
	
}

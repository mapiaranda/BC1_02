package pruebas;

public class Estado {
	public int filas;
	public int columnas;
	public int [][] terreno;
	public int posX;
	public int posY;
	public static int contadorSucesores;
	public int V; // cantidad de Arena que va haber en todo el tablero
	public int K; // cantidad de arena que va a haber en cada casilla
	public int max; // cantidad máxima que almacena cada casilla
	private int id; // variable que almacena un id de cada casilla
	private int arena_casilla; //almacena la cantidad de arena de cada casilla

	public int[][] getTerreno() {
		return terreno;
	}

	public void setTerreno(int[][] terreno) {
		this.terreno = terreno;
	}

	public Estado(int filas, int columnas, int[][] terreno, int posX, int posY, int v, int k, int max, int arena_casilla) {
		this.filas = filas;
		this.columnas = columnas;
		this.terreno = terreno;
		this.posX = posX;
		this.posY = posY;
		V = v;
		K = k;
		this.max = max;
		this.arena_casilla = arena_casilla;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public int getContadorSucesores() {
		return contadorSucesores;
	}

	public void setContadorSucesores(int contadorSucesores) {
		Estado.contadorSucesores = contadorSucesores;
	}

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	public  int getK() {
		return K;
	}

	public void setK(int k) {
		K = k;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public Estado() {

	}

	public Estado(int id, int arena_casilla, int posX, int posY){
		this.id=id;
		this.arena_casilla = arena_casilla;
		this.posX=posX;
		this.posY=posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArena_casilla() {
		return arena_casilla;
	}

	public void setArena_casilla(int arena_casilla) {
		this.arena_casilla = arena_casilla;
	}

	@Override
	public String toString() {
		return "Estado{" +
				"filas=" + filas +
				", columnas=" + columnas +
				", posX=" + posX +
				", posY=" + posY +
				", V=" + V +
				", K=" + K +
				", max=" + max +
				", id=" + id +
				", arena_casilla=" + arena_casilla +
				'}';
	}
}

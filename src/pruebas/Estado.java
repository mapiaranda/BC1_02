package pruebas;

public class Estado {
	
	private int id; // variable que almacena un id de cada casilla
	private int arena_casilla; //almacena la cantidad de arena de cada casilla
	private boolean visitado;
	private int posX;
	private int posY;

	
	public Estado(int id, int arena_casilla, int posX, int posY){
		this.id=id;
		this.arena_casilla = arena_casilla;
		this.posX=posX;
		this.posY=posY;
		this.visitado=false;
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

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
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
				"id=" + id +
				", arena_casilla=" + arena_casilla +
				", visitado=" + visitado +
				'}';
	}
}

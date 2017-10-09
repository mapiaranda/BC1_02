package pruebas;

public class Casilla {
	
	private int id; // variable que almacena un id de cada casilla
	private int arena_casilla; //almacena la cantidad de arena de cada casilla
	private int max_arena; // cantidad de arena máxima que puede tener cada casilla (k)
	
	// Variables para manejar las casillas
	private int pos_x;
	private int pos_y;

	
	public Casilla(int id, int arena_casilla, int max_arena, int pos_x, int pos_y){
		this.id=id;
		this.arena_casilla = arena_casilla;
		this.max_arena = max_arena;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
	}

	// Métodos getters y setters de todas las variables
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

	public int getMax_arena() {
		return max_arena;
	}

	public void setMax_arena(int max_arena) {
		this.max_arena = max_arena;
	}

	public int getPos_x() {
		return pos_x;
	}

	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}

	public int getPos_y() {
		return pos_y;
	}

	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}
	
	// Método toString
	public String toString(){
		String cadena="Casilla "+this.id+":\n\t-Arena Actual:"+this.arena_casilla+
				"\n\t-Max Arena:"+this.max_arena+"\n\t-Coordenada:("+this.pos_x+","+this.pos_y+")";
		
		return cadena;
	}
}

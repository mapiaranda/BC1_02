package pruebas;

public class Tractor {
	
	int posX; // posición de la fila
	int posY; // posición de la columna
	
	Tractor(int posX, int posY){
		this.posX = posX;
		this. posY = posY;
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
}

package pruebas;

import java.util.ArrayList;

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
	public void adyacentes(){
		ArrayList<Casilla> adya=new ArrayList<>();
		if((posX+1)<=Tablero.columnas){
			Casilla ca=Tablero.tablero[posX+1][posY];
			adya.add(ca);
		}if((posX-1)>0){
			Casilla ca=Tablero.tablero[posX-1][posY];
			adya.add(ca);
		}if((posY+1)<=Tablero.filas){
			Casilla ca=Tablero.tablero[posY+1][posY];
			adya.add(ca);
		}if((posY-1)>0){
			Casilla ca=Tablero.tablero[posY-1][posY];
			adya.add(ca);
		}
		int mover=(int)Math.random()*(adya.size());
		switch (mover){
			case 0:
				setPosX(adya.get(1).getPos_x());
				setPosY(adya.get(1).getPos_y());
				break;
			case 1:
				setPosX(adya.get(1).getPos_x());
				setPosY(adya.get(1).getPos_y());
				break;
			case 2:
				setPosX(adya.get(2).getPos_x());
				setPosY(adya.get(2).getPos_y());
				break;
			case 3:
				setPosX(adya.get(3).getPos_x());
				setPosY(adya.get(3).getPos_y());
				break;

		}

	}
}

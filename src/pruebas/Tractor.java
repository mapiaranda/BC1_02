package pruebas;

import java.util.ArrayList;

public class Tractor {
	
	int posX; // posición de la fila
	int posY; // posición de la columna
	int contadorSucesores;
	
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

	public void setPosY(int posY)
	{
		this.posY = posY;
	}
	public void adyacentes(){
		ArrayList<Casilla> adya=new ArrayList<>();
		//comprobamos si existe casilla a la derecha, izquierda, arriba y abajo
		if((posX+1)<Tablero.filas ){
			if(!Tablero.tablero[posX+1][posY].isVisitado() && !Tablero.tablero[posX][posY].isVisitado()){ //Si no esta visitado el adyacente ni estamos en uno que ya hubieramos visitado anteriormente, lo contamos como sucesor
				contadorSucesores+=1;
			}
			Casilla ca=Tablero.tablero[posX+1][posY];
			adya.add(ca);
		}if((posX-1)>=0){
			if(!Tablero.tablero[posX-1][posY].isVisitado() && !Tablero.tablero[posX][posY].isVisitado()){
				contadorSucesores+=1;
			}
			Casilla ca=Tablero.tablero[posX-1][posY];
			adya.add(ca);

		}if((posY+1)<Tablero.columnas){
			if(!Tablero.tablero[posX][posY+1].isVisitado() && !Tablero.tablero[posX][posY].isVisitado()){
				contadorSucesores+=1;
			}
			Casilla ca=Tablero.tablero[posX][posY+1];
			adya.add(ca);

		}if((posY-1)>=0){
			if(!Tablero.tablero[posX][posY-1].isVisitado() && !Tablero.tablero[posX][posY].isVisitado()){
				contadorSucesores+=1;
			}
			Casilla ca=Tablero.tablero[posX][posY-1];
			adya.add(ca);

		}

		Tablero.tablero[posX][posY].setVisitado(true);
		int contador=0;
		for (int i=0;i<Tablero.filas;i++){
			for (int j=0; j<Tablero.columnas;j++){ //Contamos los visitados de todo el tablero
				if(Tablero.tablero[i][j].isVisitado()){
					contador+=1;
				}
			}
		}
		if(contador==(Tablero.filas*Tablero.columnas)){ //Si todos estan visitados ya hemos terminado
			//Termina
			System.out.println("El número de sucesores es: "+contadorSucesores);
		}else{
				int mover = (int) (Math.random() * (adya.size()));//Generamos un numero aleatorio y nos movemos a el
				switch (mover) {
					case 0:
							setPosX(adya.get(0).getPos_x());
							setPosY(adya.get(0).getPos_y());
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

			adyacentes();//Volvemos a llamar al metodo, habiendo actualizado la nueva posicion del tractor
		}
	}
}

package pruebas;

import java.util.ArrayList;

public class Accion {
    int costo;
    int posX;
    int posY;
    ArrayList<Distribucion> dis;

    public Accion(int costo, int posX, int posY, ArrayList<Distribucion> dis) {
        this.costo = costo;
        this.posX = posX;
        this.posY = posY;
        this.dis = dis;
    }

    @Override
    public String toString() {
        return "Accion{" +

                "( " + posX +
                ", " + posY +
                "), " + dis +
                ", costo=" + costo +
                '}';
    }
}


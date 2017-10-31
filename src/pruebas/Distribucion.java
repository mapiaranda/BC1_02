package pruebas;

public class Distribucion {
    int cantidad;
    int posX;
    int posY;

    public Distribucion(int cantidad, int posX, int posY) {
        this.cantidad = cantidad;
        this.posX = posX;
        this.posY = posY;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    @Override
    public String toString() {
        return "(" +
                " " + cantidad +
                ", (" + posX +
                ", " + posY +
                ')';
    }
}

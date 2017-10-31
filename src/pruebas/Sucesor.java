package pruebas;

public class Sucesor {
    int coste;
    Terreno t;
    Accion a;

    public Sucesor(int coste, Terreno t, Accion a) {
        this.coste = coste;
        this.t = t;
        this.a = a;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public Terreno getT() {
        return t;
    }

    public void setT(Terreno t) {
        this.t = t;
    }

    public Accion getA() {
        return a;
    }

    public void setA(Accion a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Sucesor{" +
                "coste=" + coste +
                ", t=" + t +
                ", a=" + a +
                '}';
    }
}

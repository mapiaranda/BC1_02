package pruebas;

import java.util.Arrays;

public class Sucesores {
    Estado e;
    Accion a;

    public Sucesores(Estado e, Accion a) {
        this.e = e;
        this.a = a;
    }

    public Sucesores(Accion a) {
        this.a = a;
    }

    public Estado getE() {
        return e;
    }

    public void setE(Estado e) {
        this.e = e;
    }

    public Accion getA() {
        return a;
    }

    public void setA(Accion a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Sucesores{" +
                "e=" + e +
                ", a=" + a +
                '}';
    }
}

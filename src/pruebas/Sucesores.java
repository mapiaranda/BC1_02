package pruebas;

import java.util.Arrays;

public class Sucesores {
    Estado e[][];
    Accion a;

    public Sucesores(Estado[][] e, Accion a) {
        this.e = e;
        this.a = a;
    }

    public Sucesores(Accion a) {
        this.a = a;
    }

    public Estado[][] getE() {
        return e;
    }

    public void setE(Estado[][] e) {
        this.e = e;
    }

    public Accion getA() {
        return a;
    }

    public void setA(Accion a) {
        this.a = a;
    }

    public void toS() {
        String estado;
        System.out.println("");
        System.out.print("Sucesores{");
        for (int b = 0; b < e.length; b++) {
            for (int a = 0; a < e.length; a++) {
                System.out.print(" "+e[b][a].toString());
            }
        }

        System.out.print(", a=" + a + '}');
    }
}

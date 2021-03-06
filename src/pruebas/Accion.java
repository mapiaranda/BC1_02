package pruebas;

import java.util.ArrayList;

public class Accion {
    int costo;
    int posX;
    int posY;
    ArrayList<Distribucion> dis;

    public Accion(int posX, int posY, ArrayList<Distribucion> dis) {
        int cantidad=0;
        for (int i=0;i<dis.size();i++){
            cantidad+=dis.get(i).getCantidad();
        }
        this.costo = cantidad+1;
        this.posX = posX;
        this.posY = posY;
        this.dis = dis;
    }
    public boolean compara(Accion a, Accion b){
        boolean comp=true;
        if(b.getCosto()==a.getCosto() && b.getPosX()==a.getPosX() && b.getPosY()==a.getPosY()){
            for (int i=0; i<b.getDis().size();i++){
                    if(b.getDis().get(i).getCantidad()!=a.getDis().get(i).getCantidad()){
                        comp= false;
                    }
            }
        }else{
            comp=false;
        }
        return comp;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
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

    public ArrayList<Distribucion> getDis() {
        return dis;
    }

    public void setDis(ArrayList<Distribucion> dis) {
        this.dis = dis;
    }

    @Override
    public String toString() {
        return "{" +

                "( " + posX +
                ", " + posY +
                "), " + dis +
                "," + costo +
                '}';
    }
}


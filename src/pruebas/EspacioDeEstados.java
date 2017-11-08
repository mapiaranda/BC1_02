package pruebas;

import java.util.ArrayList;

public class EspacioDeEstados {
    public static int filas;
    public static int columnas;
    public static int posX;
    public static int posY;
    public static int contadorSucesores;
    public int V; // cantidad de Arena que va haber en todo el tablero
    public int K; // cantidad de arena que va a haber en cada casilla
    public int max; // cantidad máxima que almacena cada casilla
    public static Estado estados[][];
    ArrayList<Estado> adya=new ArrayList<>();
    ArrayList<Accion> acc=new ArrayList<>();
    ArrayList<Distribucion> d=new ArrayList<>();
    int sobrante;

    public EspacioDeEstados() {
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public static int getPosX() {
        return posX;
    }

    public static void setPosX(int posX) {
        EspacioDeEstados.posX = posX;
    }

    public static int getPosY() {
        return posY;
    }

    public static void setPosY(int posY) {
        EspacioDeEstados.posY = posY;
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public int getK() {
        return K;
    }

    public void setK(int k) {
        K = k;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void distribuirArena(int i, int sobra, int posix, int posiy){
        if(i==adya.size()){
            ArrayList<Distribucion> daux=new ArrayList<>();
            int cantidad=0;
            for(int r=0;r<d.size();r++){
                cantidad+=d.get(r).getCantidad();
                daux.add(d.get(r));
            }
            boolean comp=false;
            Accion aci=new Accion(1, posix, posiy, daux);
            for(int a=0; a<acc.size();a++){
                if(acc.get(a).compara(aci, acc.get(a))==true){
                    comp=true;
                }
            }
            if( cantidad==sobrante && comp==false ){//
                acc.add(aci);
                System.out.println(aci);
            }

        }else {
            Distribucion dis;

            for (int j = sobra; j >= 0; j--) {
                if ((adya.get(i).getArena_casilla() + j) <= max) {
                    dis = new Distribucion(j, adya.get(i).getPosX(), adya.get(i).getPosY());
                    d.add(dis);
                }else{
                    dis=new Distribucion(0, adya.get(i).getPosX(), adya.get(i).getPosY());
                    d.add(dis);
                }
                distribuirArena(i + 1, sobra - dis.getCantidad(), posix, posiy);
                d.remove(i);


            }
        }
    }
    public void adyacentes(){
        sobrante=0;
        //comprobamos si existe casilla a la derecha, izquierda, arriba y abajo
        if((posX+1)<filas ){
            Estado ca=estados[posX+1][posY];
            adya.add(ca);
        }if((posX-1)>=0){
            Estado ca=estados[posX-1][posY];
            adya.add(ca);
        }if((posY+1)<columnas){
            Estado ca=estados[posX][posY+1];
            adya.add(ca);

        }if((posY-1)>=0){
            Estado ca=estados[posX][posY-1];
            adya.add(ca);
        }
        sobrante=estados[posX][posY].getArena_casilla()-K;

        for(int a=0; a<adya.size();a++){
            int sobra=estados[posX][posY].getArena_casilla()-K;
            distribuirArena(0, sobra, adya.get(a).getPosX(), adya.get(a).getPosY());
        }
        System.out.println("Nº de sucesores: "+acc.size());
        /*
        boolean terminado=true;
        for (int i=0; i<filas;i++){
            for (int j=0; j<columnas; j++){
                if(estados[i][j].getArena_casilla()!=K){
                    terminado=false;
                }
            }
        }
        if(terminado==true){ //Si todos estan visitados ya hemos terminado
            //Termina
            System.out.println("El número de sucesores es: "+contadorSucesores);
        }*/
    }
}

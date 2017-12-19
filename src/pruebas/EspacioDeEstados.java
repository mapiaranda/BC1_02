package pruebas;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class EspacioDeEstados {

    ArrayList<Accion> acc=new ArrayList<>();
    ArrayList<Distribucion> d=new ArrayList<>();
    ArrayList<Distribucion>distri = new ArrayList<>();
    ArrayList<Sucesores>lista_sucesores=new ArrayList<>();
    ArrayList<Estado> lista_adya=new ArrayList<>();

    int sobrante;



    public EspacioDeEstados() {
    }


    public Estado calcularEstado(Accion a, Estado e, int posx, int posy, int cantidad){
        int [][] terreno=new int[e.getFilas()][e.getColumnas()];
        for (int r=0; r<terreno.length;r++){
            for (int s=0; s<terreno.length;s++){
                terreno[r][s]=e.terreno[r][s];
            }
        }
        Estado es;
        for (int i=0; i<a.getDis().size(); i++) {
            terreno[a.getDis().get(i).getPosX()][a.getDis().get(i).getPosY()] = a.getDis().get(i).getCantidad() + terreno[a.getDis().get(i).getPosX()][a.getDis().get(i).getPosY()];

        }

        terreno[e.getPosX()][e.getPosY()]=e.getTerreno()[e.getPosX()][e.getPosY()]-cantidad;
        es=new Estado(e.getFilas(), e.getColumnas(), terreno, posx, posy, e.getV(), e.getK(), e.getMax(), terreno[posx][posy]);
       return es;
    }
    public void distribuirArena(int i, int sobra, int posix, int posiy, Estado e){
        if(i==lista_adya.size()){
            ArrayList<Distribucion> daux=new ArrayList<>();
            int cantidad=0;
            for(int r=0;r<d.size();r++){
                cantidad+=d.get(r).getCantidad();
                daux.add(d.get(r));
            }
            boolean comp=false;
            Accion aci=new Accion( posix, posiy, daux);

            for(int a=0; a<acc.size();a++){
                if(acc.get(a).compara(aci, acc.get(a))==true){
                    comp=true;
                }
            }

            if( cantidad==sobrante  && comp==false){
                Estado est=calcularEstado(aci, e, posix, posiy, cantidad);
                Sucesores s=new Sucesores(est,aci);
                acc.add(aci);
                lista_sucesores.add(s);
            }
        }else {
            Distribucion dis;
            for (int j = sobra; j >= 0; j--) {
                if ((lista_adya.get(i).getArena_casilla() + j) <= e.getMax()) {
                    dis = new Distribucion(j, lista_adya.get(i).getPosX(), lista_adya.get(i).getPosY());
                    d.add(dis);
                }else{
                    dis=new Distribucion(0, lista_adya.get(i).getPosX(), lista_adya.get(i).getPosY());
                    d.add(dis);
                }
                distribuirArena(i + 1, sobra - dis.getCantidad(), posix, posiy, e);
                d.remove(i);
            }
        }

    }
    public Queue<Nodo> Busqueda_Acotada(Problema prob, int tipoB, int prof_max) throws Exception {
        Frontera f = new Frontera();
        Hashtable<String,Nodo> visitados = new Hashtable<String,Nodo>();
        Nodo nodo_inicial=new Nodo(prob.encriptarMD5(prob.getEs()), null, prob.getEs(), "",null, 0,esObjetivo(prob.getEs()),0);

        /*
        calcularAdya(nodo_inicial.getEstado());
        ArrayList<Sucesores> suce=CalcularSucesores(nodo_inicial);
        for (int i=0;i<suce.size();i++){
            System.out.println(suce.get(i).getA().toString());
        }*/
        visitados.put(nodo_inicial.getId(), nodo_inicial);
        f.insertarNodo(nodo_inicial);
        Nodo nodoActual = new Nodo();
        boolean solucion=false;
        while(!solucion && !f.esVacia()){
            nodoActual=f.getFrontera().remove();
            if(Problema.Solucion(nodoActual.getEstado().getTerreno())==true){
                solucion=true;
            }else{
                if(nodoActual.getProfundidad()<prof_max){
                    calcularAdya(nodoActual.getEstado());
                    ArrayList<Sucesores> suc=CalcularSucesores(nodoActual);
                    ArrayList<Nodo> lista_nodos=CrearNodos(prob, suc, nodoActual, tipoB, prof_max);
                    f.insertarListaNodos(lista_nodos, visitados);
                }
            }
        }
        if(solucion==true){

            return CreaSolucion(nodoActual);
        }else{

            return null;
        }
    }
    public Queue<Nodo> CreaSolucion(Nodo nodo_actual){
        Stack<Nodo> pila = new Stack<Nodo>();
        Queue<Nodo> cola = new LinkedBlockingQueue<Nodo>();

        while (nodo_actual != null) {
            pila.add(nodo_actual);
            nodo_actual = nodo_actual.getPadre();
        }
        while (!pila.isEmpty()) {
            cola.add(pila.pop());
        }

        return cola;
    }
    public int esObjetivo(Estado est) {
        int heuristica = 0;

        for (int i = 0; i < est.getTerreno().length; i++) {
            for (int j = 0; j < est.getTerreno()[0].length; j++) {
                if (est.getTerreno()[i][j] != est.getK())
                    heuristica++;
            }
        }
        return heuristica;
    }
    public ArrayList<Nodo> CrearNodos(Problema pro, ArrayList<Sucesores>suc, Nodo nodo_acutal, int tipoB, int prof_max){
        ArrayList<Nodo> lista_nodo=new ArrayList<>();

        int profundidad=nodo_acutal.getProfundidad()+1;
        for(int i=0; i<suc.size(); i++){
            //System.out.println("Accion sucesor "+suc.get(i).getA());
            //int heuristica=esObjetivo(suc.get(i).getE());
            double heuristica=(esObjetivo(suc.get(i).getE())*0.7);
            int coste=suc.get(i).getA().getCosto();
            try {
                double valor=0;
                switch (tipoB){
                    case 0:
                        //Anchura
                        valor=profundidad;
                        break;
                    case 1:
                        //Profundidad
                        valor=prof_max-nodo_acutal.getProfundidad();
                        break;
                    case 2:
                        //Coste uniforme
                        valor=nodo_acutal.getCosto()-coste;
                        break;
                    case 3:
                        //Heuristica A *
                        //valor=nodo_acutal.getCosto()+coste+heuristica;
                        valor=((nodo_acutal.getCosto()+coste)*0.3)+heuristica;
                        break;
                    case 4:
                        //Voraz
                        valor=heuristica;
                        break;
                }

                Nodo n = new Nodo(pro.encriptarMD5(suc.get(i).getE()),nodo_acutal,suc.get(i).getE(), nodo_acutal.getAccion(),suc.get(i).getA(), nodo_acutal.getCosto()+suc.get(i).getA().getCosto(),valor, profundidad );
                lista_nodo.add(n);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return lista_nodo;
    }

    public void calcularAdya(Estado estado_actual){
        lista_adya.clear();
        if((estado_actual.getPosX()+1)<estado_actual.getFilas() ){
            Estado ca=new Estado(estado_actual.getFilas(), estado_actual.getColumnas(),estado_actual.getTerreno(),estado_actual.getPosX()+1,estado_actual.getPosY(),estado_actual.getV(), estado_actual.getK(), estado_actual.getMax(),estado_actual.terreno[estado_actual.getPosX()+1][estado_actual.getPosY()]);
            lista_adya.add(ca);
        }if((estado_actual.getPosX()-1)>=0){
            Estado ca=new Estado(estado_actual.getFilas(), estado_actual.getColumnas(),estado_actual.getTerreno(),estado_actual.getPosX()-1,estado_actual.getPosY(),estado_actual.getV(), estado_actual.getK(), estado_actual.getMax(),estado_actual.terreno[estado_actual.getPosX()-1][estado_actual.getPosY()]);
            lista_adya.add(ca);
        }if((estado_actual.getPosY()+1)<estado_actual.getColumnas()){
            Estado ca=new Estado(estado_actual.getFilas(), estado_actual.getColumnas(),estado_actual.getTerreno(),estado_actual.getPosX(),estado_actual.getPosY()+1,estado_actual.getV(), estado_actual.getK(), estado_actual.getMax(),estado_actual.terreno[estado_actual.getPosX()][estado_actual.getPosY()+1]);
            lista_adya.add(ca);
        }if((estado_actual.getPosY()-1)>=0){
            Estado ca=new Estado(estado_actual.getFilas(), estado_actual.getColumnas(),estado_actual.getTerreno(),estado_actual.getPosX(),estado_actual.getPosY()-1,estado_actual.getV(), estado_actual.getK(), estado_actual.getMax(),estado_actual.getTerreno()[estado_actual.getPosX()][estado_actual.getPosY()-1]);
            lista_adya.add(ca);
        }
    }
    public ArrayList<Sucesores> CalcularSucesores( Nodo nodo_actual){
        lista_sucesores.clear();

        int sobra=0;

        for(int a=0; a<lista_adya.size();a++){
            d.clear();
            acc.clear();
            distri.clear();
            sobra=nodo_actual.getEstado().getArena_casilla()-nodo_actual.getEstado().getK();
            sobrante=nodo_actual.getEstado().getArena_casilla()-nodo_actual.getEstado().getK();
            if(sobrante>0){
                distribuirArena(0, sobra, lista_adya.get(a).getPosX(), lista_adya.get(a).getPosY(), nodo_actual.getEstado());
            }else{
                for (int m=0;m<lista_adya.size();m++){
                    Distribucion d=new Distribucion(0,lista_adya.get(m).getPosX(), lista_adya.get(m).getPosY() );
                    distri.add(d);
                }
                Accion accio=new Accion(lista_adya.get(a).getPosX(), lista_adya.get(a).getPosY(), distri);
                Estado estad=new Estado(lista_adya.get(a).getFilas(), lista_adya.get(a).getColumnas(), lista_adya.get(a).getTerreno(), lista_adya.get(a).getPosX(),lista_adya.get(a).getPosY(), lista_adya.get(a).getV(), lista_adya.get(a).getK(), lista_adya.get(a).getMax(), lista_adya.get(a).getArena_casilla());
                Sucesores s=new Sucesores(estad, accio);
                lista_sucesores.add(s);
            }

        }
        return lista_sucesores;
    }
    public String CalcularAccion(ArrayList<Sucesores>suce, Nodo nodo_actual) {
        String accion=null;
        for (int i = 0; i < suce.size(); i++) {

            if (suce.get(i).getA().getPosX() < nodo_actual.getEstado().getPosX()) {
                accion = "arriba";
            } else if (suce.get(i).getA().getPosX() > nodo_actual.getEstado().getPosX()) {
                accion = "abajo";
            } else if (suce.get(i).getA().getPosY() > nodo_actual.getEstado().getPosY()) {
                accion = "derecha";
            } else {
                accion = "izquierda";
            }

        }
        return accion;
    }
    /*
    public void adyacentes(Frontera f, int tipoB, int id, int valor, int profundidad, Hashtable<String, Nodo> visitados, Problema pro, int prof_max){
        id++;
        Busqueda b=new Busqueda();
        Nodo nodoo=b.busqueda(f.getFrontera());
        if(nodoo==null ){
            if(profundidad>=prof_max){
                System.out.println("MAXIMO");
            }else{
                System.out.println("SOLUCIÓN COMPLETA");
            }

        }else{
            Estado e=nodoo.getEstado();
            System.out.println(" ");
            System.out.println("pos: "+e.getPosX()+e.getPosY());
            for (int i = 0; i < e.getTerreno().length; i++) {
                for (int j = 0; j <e.getTerreno().length; j++) {
                    System.out.print(e.getTerreno()[i][j]+" ");
                }
                System.out.println("");
            }
            sobrante=0;
            adya.clear();
            //comprobamos si existe casilla a la derecha, izquierda, arriba y abajo
            int filas=e.getFilas();
            int columnas=e.getColumnas();
            int terreno[][]=e.getTerreno();

            profundidad=nodoo.getProfundidad()+1;
            System.out.println("profundidaaa "+profundidad);
            for (int i=0; i<suc.size();i++){
                String accion;
                if(suc.get(i).getA().getPosX()<e.getPosX()){
                    accion="arriba";
                }else if(suc.get(i).getA().getPosX()>e.getPosX()){
                    accion="abajo";
                }else if(suc.get(i).getA().getPosY()>e.getPosY()){
                    accion="derecha";
                }else{
                    accion="izquierda";
                }
                switch (tipoB){
                    case 0:
                        valor=nodoo.getProfundidad();
                      //valor=valor+1;
                        break;
                    case 1:
                        valor=valor+1;
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }

                Nodo n= null;

                    try {
                        n = new Nodo(pro.encriptarMD5(suc.get(i).getE()),nodoo,suc.get(i).getE(), accion, suc.get(i).getA().getCosto(),valor, profundidad, false );
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    visitados=b.comprobarNodo(visitados, n, tipoB, f);
                }



            adyacentes(f,tipoB, id, valor, profundidad, visitados,pro, prof_max);
        }

        }*/


}


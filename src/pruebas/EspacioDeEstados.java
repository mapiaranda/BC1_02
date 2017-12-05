package pruebas;

import java.util.ArrayList;

public class EspacioDeEstados {
    ArrayList<Estado> adya=new ArrayList<>();
    ArrayList<Accion> acc=new ArrayList<>();
    ArrayList<Distribucion> d=new ArrayList<>();
    ArrayList<Distribucion>distri = new ArrayList<>();
    int sobrante;
    ArrayList<Nodo>nodosvisitados=new ArrayList<>();
    ArrayList<Sucesores> suc=new ArrayList<>();

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
    public void distribuirArena(int i, int sobra, int posix, int posiy, Estado e, Estado padre){
        if(i==adya.size()){
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
            if( cantidad==sobrante && comp==false ){
                Estado est=calcularEstado(aci, e, posix, posiy, cantidad);
                Sucesores s=new Sucesores(est,aci);

                acc.add(aci);
                suc.add(s);
            }
        }else {
            Distribucion dis;
            for (int j = sobra; j >= 0; j--) {
                if ((adya.get(i).getArena_casilla() + j) <= e.getMax()) {
                    dis = new Distribucion(j, adya.get(i).getPosX(), adya.get(i).getPosY());
                    d.add(dis);
                }else{
                    dis=new Distribucion(0, adya.get(i).getPosX(), adya.get(i).getPosY());
                    d.add(dis);
                }
                distribuirArena(i + 1, sobra - dis.getCantidad(), posix, posiy, e, padre);
                d.remove(i);
            }
        }
    }
    public void adyacentes(Frontera f, int tipoB, int id, int valor, int profundidad){
        id++;
        Busqueda b=new Busqueda();
        Nodo nodoo=b.busqueda(f.getFrontera());
        if(nodoo==null){
            System.out.println("SOLUCIÓN COMPLETA");
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

            if((e.getPosX()+1)<e.getFilas() ){
                Estado ca=new Estado(filas, columnas,terreno,e.getPosX()+1,e.getPosY(),e.getV(), e.getK(), e.getMax(),e.terreno[e.getPosX()+1][e.getPosY()]);
                adya.add(ca);
            }if((e.getPosX()-1)>=0){
                Estado ca=new Estado(filas, columnas,terreno,e.getPosX()-1,e.getPosY(),e.getV(), e.getK(), e.getMax(),e.terreno[e.getPosX()-1][e.getPosY()]);
                adya.add(ca);
            }if((e.getPosY()+1)<e.getColumnas()){
                Estado ca=new Estado(filas, columnas,terreno,e.getPosX(),e.getPosY()+1,e.getV(), e.getK(), e.getMax(),e.terreno[e.getPosX()][e.getPosY()+1]);
                adya.add(ca);
            }if((e.getPosY()-1)>=0){
                Estado ca=new Estado(filas, columnas,terreno,e.getPosX(),e.getPosY()-1,e.getV(), e.getK(), e.getMax(),e.terreno[e.getPosX()][e.getPosY()-1]);
                adya.add(ca);
            }
            suc.clear();
            acc.clear();

            for(int a=0; a<adya.size();a++){
                sobrante=e.getArena_casilla()-e.getK();
                if(sobrante>0){
                    distribuirArena(0, sobrante, adya.get(a).getPosX(), adya.get(a).getPosY(), e,nodoo.getPadre().getEstado());
                }else{
                        for (int m=0;m<adya.size();m++){
                            Distribucion d=new Distribucion(0,adya.get(m).getPosX(), adya.get(m).getPosY() );
                            distri.add(d);
                        }
                        Accion accio=new Accion(adya.get(a).getPosX(), adya.get(a).getPosY(), distri);
                        Estado estad=new Estado(adya.get(a).getFilas(), adya.get(a).getColumnas(), adya.get(a).getTerreno(), adya.get(a).getPosX(),adya.get(a).getPosY(), adya.get(a).getV(), adya.get(a).getK(), adya.get(a).getMax(), adya.get(a).getArena_casilla());
                        Sucesores s=new Sucesores(estad, accio);
                        suc.add(s);
                }

            }

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
                        valor=nodoo.getProfundidad()+1;
                        profundidad=nodoo.getProfundidad()+1;
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

                Nodo n=new Nodo(id,nodoo,suc.get(i).getE(), accion, suc.get(i).getA().getCosto(),valor, profundidad, false );
                if(b.comprobarNodo(nodosvisitados, n)==false){
                    nodosvisitados.add(n);
                    f.insertarNodo(n);
                }

            }
            adyacentes(f,tipoB, id, valor, profundidad);
        }

        }
    }


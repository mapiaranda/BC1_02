package pruebas;

import java.util.ArrayList;

public class EspacioDeEstados {
    ArrayList<Estado> adya=new ArrayList<>();
    ArrayList<Accion> acc=new ArrayList<>();
    ArrayList<Distribucion> d=new ArrayList<>();
    int sobrante;
    ArrayList<Sucesores> suc=new ArrayList<>();

    public EspacioDeEstados() {
    }


    public Estado calcularEstado(Accion a, Estado e, int posx, int posy){
        int [][] terreno=new int[e.getFilas()][e.getColumnas()];
        Estado es;
        for (int i=0; i<a.getDis().size(); i++){
            terreno[a.getDis().get(i).getPosX()][a.getDis().get(i).getPosY()]=a.getDis().get(i).getCantidad()+terreno[a.getDis().get(i).getPosX()][a.getDis().get(i).getPosX()];
        }
        es=new Estado(e.getFilas(), e.getColumnas(), terreno, posx, posy, e.getV(), e.getK(), e.getMax(), terreno[posx][posy]);
       return es;
    }
    public void distribuirArena(int i, int sobra, int posix, int posiy, Estado e){
        if(i==adya.size()){
            ArrayList<Distribucion> daux=new ArrayList<>();
            int cantidad=0;
            for(int r=0;r<d.size();r++){
                cantidad+=d.get(r).getCantidad();
                daux.add(d.get(r));
            }
            boolean comp=false;
            Accion aci=new Accion(cantidad+1, posix, posiy, daux);
            Estado est=calcularEstado(aci, e, posix, posiy);
            Sucesores s=new Sucesores(est,aci);
            for(int a=0; a<acc.size();a++){
                if(acc.get(a).compara(aci, acc.get(a))==true){
                    comp=true;
                }
            }
            if( cantidad==sobrante && comp==false ){//
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
                distribuirArena(i + 1, sobra - dis.getCantidad(), posix, posiy, e);
                d.remove(i);



            }
        }
    }
    public void adyacentes(Frontera f, int tipoB, int id){
        id++;
        Busqueda b=new Busqueda();
        Nodo nodoo=b.busqueda(f.getFrontera());
        if(nodoo==null){
            System.out.println("SOLUCIÓN COMPLETA");
        }else{
            Estado e=nodoo.getEstado();
            sobrante=0;
            adya.clear();
            System.out.println("pos actual "+e.getPosX()+e.getPosY());
            //comprobamos si existe casilla a la derecha, izquierda, arriba y abajo
            int filas=e.getFilas();
            int columnas=e.getColumnas();
            int terreno[][]=e.getTerreno();

            if((e.getPosX()+1)<e.getFilas() ){
                Estado ca=new Estado(filas, columnas,terreno,e.getPosX()+1,e.getPosY(),e.getV(), e.getK(), e.getMax(),e.getArena_casilla());
                adya.add(ca);
            }if((e.getPosX()-1)>=0){
                Estado ca=new Estado(filas, columnas,terreno,e.getPosX()-1,e.getPosY(),e.getV(), e.getK(), e.getMax(),e.getArena_casilla());
                adya.add(ca);
            }if((e.getPosY()+1)<e.getColumnas()){
                Estado ca=new Estado(filas, columnas,terreno,e.getPosX(),e.getPosY()+1,e.getV(), e.getK(), e.getMax(),e.getArena_casilla());
                adya.add(ca);
            }if((e.getPosY()-1)>=0){
                Estado ca=new Estado(filas, columnas,terreno,e.getPosX(),e.getPosY()-1,e.getV(), e.getK(), e.getMax(),e.getArena_casilla());
                adya.add(ca);
            }

            suc.clear();
            acc.clear();

            for(int a=0; a<adya.size();a++){
                sobrante=e.getArena_casilla()-e.getK();
                if(sobrante>0){
                    distribuirArena(0, sobrante, adya.get(a).getPosX(), adya.get(a).getPosY(), e);
                }
            }

            for (int i=0; i<suc.size();i++){
                System.out.println("sucesor: "+suc.get(i).getA());
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
                Nodo n=new Nodo(id,nodoo,suc.get(i).getE(), accion, suc.get(i).getA().getCosto(), nodoo.getProfundidad()+1, nodoo.getProfundidad()+1, false );
                f.insertarNodo(n);
            }
            adyacentes(f,tipoB, id);
        }

        }
    }


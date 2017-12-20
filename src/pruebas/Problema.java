package pruebas;

import java.io.*;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Problema {
    public static EspacioDeEstados espacio;
    public static Estado es;

    public static boolean Solucion(int estado[][]){
        boolean b=true;
        for (int i=0; i<estado.length;i++){
            for (int j=0; j<estado.length;j++){
                if(estado[i][j]!=es.getK()){
                    b=false;
                    j=estado[i].length+1;
                    i=estado.length+1;
                }
            }
        }
        return b;
    }

    public  EspacioDeEstados getEspacio() {
        return espacio;
    }

    public  void setEspacio(EspacioDeEstados espacio) {
        Problema.espacio = espacio;
    }

    public  Estado getEs() {
        return es;
    }

    public void setEs(Estado es) {
        Problema.es = es;
    }

    void rellenarTableroFichero(int tipoB, int prof_max){
        Scanner entrada = null;
        Estado e=new Estado();
        try {
            entrada = new Scanner(new File("Examen.dat"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        int [] datos = new int [6];
        for (int j = 0; j < 6; j++) {
            datos[j]=entrada.nextInt();
        }
        int i=0;
        int filas=datos[4];
        int columnas=datos[5];
        int terreno[][]=new int[datos[4]][datos[5]];
        for (int j = 0; j < filas; j++) { //fila
            for (int k = 0; k < columnas; k++) { //columna
                terreno[j][k]=entrada.nextInt();
                i++;
            }
        }
        e=new Estado(datos[4], datos[5], terreno, datos[0], datos[1], (datos[5]*datos[4])*datos[2],datos[2], datos[3], terreno[datos[0]][datos[1]]);
        es=e;
        Accion a=null;
        Nodo nodo= null;
        try {
            nodo = new Nodo(encriptarMD5(e),null,e, "",null, 0, 0, 0);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        Frontera f=new Frontera();
        f.insertarNodo(nodo);
        espacio=new EspacioDeEstados();
        //Hashtable<String,Nodo> visitados = new Hashtable<String,Nodo>();
        //espacio.adyacentes(f, tipoB, 0,0,0, visitados, this, 9);
    }

    void generarTerrenoRnd(int tipoB){
        Estado e=new Estado();
        e.setV((int)(Math.random()*99)+1) ;
        e.setFilas( (int) (Math.random()*9)+1);
        e.setColumnas((int) (Math.random()*9)+1);
        e.setK(e.getV()/e.getFilas()*e.getColumnas());
        e.setMax((int) (Math.random()*(e.getV()-1))+1); //cantidad máxima que puede almacenar cada casilla
        int total=e.getV();
        int terreno[][]=new int[e.getFilas()][e.getColumnas()];
        Estado casi;
        int a=1;
        for (int i = 0; i < e.getFilas(); i++) {
            for (int j = 0; j < e.getColumnas(); j++) {
                if(total<e.getMax()){
                    terreno[i][j]=(int)Math.random()*total;

                }else if(total<e.getMax() && a==e.getFilas()*e.getColumnas() ){
                    terreno[i][j]=total;
                }else{
                    terreno[i][j]=(int)Math.random()*e.getMax();
                }
                a++;
                total = total - terreno[i][j];
            }
            System.out.println("\n");
        }
        e.setTerreno(terreno);
        e.setPosX(2);
        e.setPosY(2);
        es=e;
        Nodo nodo= null;
        try {
            nodo = new Nodo(encriptarMD5(e),null,e, "", null,0, 0, 0);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        Frontera f=new Frontera();
        f.insertarNodo(nodo);
        Hashtable<String,Nodo> visitados = new Hashtable<String,Nodo>();
        visitados.put(nodo.getId(), nodo);
        espacio=new EspacioDeEstados();


    }
//Método para escribir en fichero
   public static void escribir (Nodo n, Accion a, boolean esc) throws IOException {

        FileWriter fw=new FileWriter("solucion.txt", esc);
       BufferedWriter bw=new BufferedWriter(fw);
		int [][] terreno = n.getEstado().getTerreno();
		Estado e=n.getEstado();

       try {
		    bw.write(a.toString());
		    //bw.write(e.getPosX()+" "+e.getPosY()+" "+e.getK()+" "+e.getMax()+" "+e.getColumnas()+" "+e.getFilas());

			bw.close();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public static void escribirCoste(int costeTotal) throws IOException {
        FileWriter fw=new FileWriter("solucionCoste.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write("Coste total: "+costeTotal);
        bw.close();
        fw.close();
    }


        public String encriptarMD5( Estado estado) throws Exception{
            MessageDigest md = MessageDigest.getInstance("MD5");
            String tee="";
            for (int i = 0; i < estado.getTerreno().length; i++) {
                for (int j = 0; j <estado.getTerreno().length; j++) {
                    tee+=estado.getTerreno()[i][j];
                }
            }
            String mensaje=String.valueOf(estado.getPosX())+String.valueOf(estado.getPosY())+tee;
            //System.out.println("mensaje "+mensaje);
            byte[] bytes = md.digest(mensaje.getBytes());
            int size = bytes.length;
            StringBuffer h = new StringBuffer(size);
            for (int i = 0; i < size; i++) {
                int u = bytes[i] & 255;
                if (u < 16) {
                    h.append("0" + Integer.toHexString(u));
                } else {
                    h.append(Integer.toHexString(u));
                }
            }
            return h.toString();

        }

}

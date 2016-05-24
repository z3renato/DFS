/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author felipeaugusto
 */
//import grafos.Aresta;
//import grafos.Grafo;
//import grafos.Vertice;
import grafos.Aresta;
import grafos.Grafo;
//import grafos.Vertice;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;


public class BellmanFord {
    Grafo g;
    private double[] distancias;
    private int[] pi;
    int numVertices;
    
    
    public BellmanFord(Grafo g, int origem){
        this.g = g;
        this.numVertices = g.numeroDeVertices();
        this.distancias = new double[numVertices];
        this.pi = new int[numVertices];
        
        this.inicializa(g, origem);
        
        this.BelFord();
    
    }

    public void inicializa(Grafo g, int origem) {
        distancias = new double[numVertices];
        pi = new int[numVertices];
        for (int i = 0; i < pi.length; i++) {
            distancias[i] = Double.POSITIVE_INFINITY;
            pi[i] = -1;
        }
        distancias[origem] = 0;
    }

    public void Relaxa(int u, int v, double w) {
        if (distancias[v] > distancias[u] + w) {
            distancias[v] = distancias[u] + w;
            pi[v] = u;
        }
    }

    public boolean BelFord() {

        LinkedList<Aresta> arestas =  new LinkedList<>();
        arestas = (LinkedList<Aresta>) g.arestas();
        
        for (int i = 1; i < numVertices; i++) {
            for (Aresta a : arestas) {
                Relaxa(a.getOrigem(), a.getDestino(), a.getPeso());
                //System.out.println("d: "+distancias[0]+"    "+distancias[1]+"   "+distancias[2]+"   "+distancias[3]);
                //System.out.println("p: "+pi[0]+"    "+pi[1]+"   "+pi[2]+"   "+pi[3]);
            }
        }
        for (Aresta a : arestas) {
            if(distancias[a.getDestino()] > distancias[a.getOrigem()] + a.getPeso()){
                return false;
            }
        }
        return true;
    }
    
//    public double distanciaAteOrigem(Grafo g, int origem, int destino){
//        
//        
//    }
//    
//    

    public void mostraCaminho(int origem, int destino) {
        if(origem == destino){
            System.out.print(origem);
        } else if(pi[destino] == -1){
            System.out.println("Não tem caminho");
        } else {
            mostraCaminho(origem, pi[destino]);
            System.out.print("->"+destino);
        }
        
    }

}

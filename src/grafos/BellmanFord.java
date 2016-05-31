package grafos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author felipeaugusto
 */
import grafos.Aresta;
import grafos.Grafo;
import static java.lang.System.exit;
import java.util.LinkedList;
import java.util.List;

public class BellmanFord {

    Grafo g;
    public double[] d;
    public int[] pai;
    int numVertices;
    int origem;
    public double custo;

    boolean[] Q;
    LinkedList<Integer> S;
    public List<Integer> caminho;

    public BellmanFord(Grafo g, int origem) throws Exception {
        this.g = g;
        custo = 0;
        this.numVertices = g.numeroDeVertices();
        this.d = new double[numVertices];
        this.pai = new int[numVertices];
        this.origem = origem;
        this.caminho = new LinkedList<>();
        this.inicializa(g, origem);

    }

    public boolean runBellmanFord() throws Exception {
        List<Aresta> arestas = g.getArestas();
        for (int i = 0; i < g.numeroDeVertices(); i++) {
            for (Aresta a : arestas) {
                // System.out.println("Aresta: "+a.getOrigem()+"->"+a.getDestino()+":"+a.getPeso());
                relaxa(a.getOrigem(), a.getDestino(), a.getPeso());
            }
        }

        int u, v;
        double w;
        for (Aresta a : arestas) {
            u = a.getOrigem();
            v = a.getDestino();
            w = a.getPeso();
            if (d[v] > (d[u] + w)) {
                return false;
            }
        }
        return true;

    }

    public void escreve(int s, int v) {
        if (v == s) {
            caminho.add(s);
            System.out.print(s + "-");
        } else if (pai[v] == -1) {

        } else {
            escreve(s, pai[v]);
            custo += d[v];
            caminho.add(v);
            System.out.print(v + "-");
        }
    }

    public void inicializa(Grafo g, int origem) {
        d = new double[numVertices];
        pai = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            d[i] = Double.POSITIVE_INFINITY;
            pai[i] = -1;
        }
        d[origem] = 0;

//        for (int i = 0; i < Q.length; i++) {
//            System.out.print(Q[i]+" ");
//        }
    }

    public void relaxa(int u, int v, double w) {
        if (d[v] > d[u] + w) {
            d[v] = d[u] + w;
            pai[v] = u;
        }
    }

}

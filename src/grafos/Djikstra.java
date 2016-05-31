/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import grafos.Aresta;
import grafos.Grafo;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author tribi
 */
public class Djikstra {

    Grafo g;
    public double[] d;
    public int[] pai;
    public double custo;
    int numVertices;
    int origem;
    public List<Integer> caminho;
    boolean[] Q;
    LinkedList<Integer> S;

    public Djikstra(Grafo g, int origem) throws Exception {
        this.g = g;
        custo = 0;
        this.numVertices = g.numeroDeVertices();
        this.d = new double[numVertices];
        this.pai = new int[numVertices];
        this.origem = origem;
        caminho = new LinkedList<>();
        this.inicializa(g, origem);

        this.S = new LinkedList<>();

        this.runDjikstra();

    }

    public void runDjikstra() throws Exception {
//        trataInal();
        for (int i = 0; i < Q.length; i++) {
            System.out.print(Q[i] + " ");
        }
        while (!isEmpty()) {
            int u = extraiMinimo();
            if (u == -1) {
                break;
            }
            System.out.println("u: " + u);
            Q[u] = false;
            S.add(u);
            for (int v : g.conjuntoDeAdjacentes(u)) {

                relaxa(u, v, g.getPeso(u, v));
//                System.out.println("d: "+d[0]+"        "+d[1]+"      "+d[2]+"    "+d[3]+"       "+d[4]);
//                System.out.println("p: "+pai[0]+"        "+pai[1]+"      "+pai[2]+"    "+pai[3]+"       "+pai[4]);
            }
//            System.out.println("Fila: "+Q.toString());
        }
        for (int i = 0; i < Q.length; i++) {
            System.out.print(Q[i] + " ");
        }

    }

    public void inicializa(Grafo g, int origem) {
        d = new double[numVertices];
        pai = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            d[i] = 999999999;
            pai[i] = -1;
        }
        d[origem] = 0;
        Q = new boolean[numVertices];
        for (int i = 0; i < Q.length; i++) {
            Q[i] = true;

        }
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

    public void escreve() {
        System.out.println("Vertice" + "\t" + "pai" + "\t" + "distancia");
        for (int i = 0; i < pai.length; i++) {
            System.out.println(i + "\t" + pai[i] + "\t" + d[i]);
        }
    }

    public void caminho(int s, int v) {
        if (v == s) {
            caminho.add(s);
            System.out.print(s + "-");
        } else if (pai[v] == -1) {

        } else {
            caminho(s, pai[v]);
            custo += d[v];
            caminho.add(v);
            System.out.print(v + "-");
        }
    }

    public int extraiMinimo() {

        double menor = 99999999;
        int ind = -1;
        for (int i = 0; i < Q.length; i++) {
            if (!Q[i]) {
                continue;
            }
            if (Q[i]) {
                if (menor > d[i]) {
                    menor = d[i];
                    ind = i;

                }
            }
        }
        if (ind != -1) {
            Q[ind] = false;
        }
        return ind;
    }

    public void trataInal() throws Exception {
        for (int i = 0; i < g.numeroDeVertices(); i++) {
            if (g.conjuntoDeAdjacentes(i).size() == 0) {
                Q[i] = false;
            }
        }
    }

    public boolean isEmpty() {
        for (int i = 0; i < Q.length; i++) {
            if (Q[i]) {
                return false;
            }
        }
        return true;
    }
}

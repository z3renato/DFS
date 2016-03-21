/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import static grafos.TipoDeRepresentacao.*;
import java.util.Set;

/**
 *
 * @author tribi
 */
public class Main {

    public static void main(String[] args) throws Exception {
        AlgoritmosGrafos a = new AlgoritmosGrafos();
//        Grafo g = a.carregarGrafo("instanciaExemplo.data", LISTA_DE_ADJACENCIA);
//        Grafo g = a.carregarGrafo("instanciaExemplo.data", LISTA_DE_ADJACENCIA);
        Grafo g = a.carregarGrafo("instanciaExemplo.data", LISTA_DE_ADJACENCIA);
        Grafo g2 = a.carregarGrafo("instanciaExemplo.data", LISTA_DE_ADJACENCIA);

        BuscaEmProfundidade b = new BuscaEmProfundidade();
        System.out.println("Conjunto de adjacentes");
        System.out.println(g.conjuntoDeAdjacentes(0));
        System.out.println(g.conjuntoDeAdjacentes(1));
        System.out.println(g.conjuntoDeAdjacentes(2));
        System.out.println(g.conjuntoDeAdjacentes(3));
        System.out.println("");
        //b.dfs(g);
        System.out.println("Arestas");
        g.escreveArestas();
        System.out.println("");
        System.out.println("");
        System.out.println("Arestas de Árvore");
        b.escreveArestas(b.arestasDeArvore(g));
        System.out.println("");
        System.out.println("");
        System.out.println("Arestas de Retorno");
        b.escreveArestas(b.arestasDeRetorno(g));
        System.out.println("");
        System.out.println("");
        System.out.println("Arestas de Avanço");
        b.escreveArestas(b.arestasDeAvanco(g));
        System.out.println("");
        System.out.println("");
        System.out.println("Arestas de Cruzamento");
        b.escreveArestas(b.arestasDeCruzamento(g));
        System.out.println("");
        System.out.println("");
        System.out.println("resultado da busca");
        b.escreveBusca();

        /*
        System.out.println("Aresta adicionada");
        g.adicionarAresta(3, 2, 32);
        g.escreveArestas();
        System.out.println("Arestas de Árvore");
        b.escreveArestas(b.arestasDeArvore(g));
         */
        // g.escreveArestas();
//        System.out.println(g.conjuntoDeAdjacentes(3).toString());
//        System.out.println("numero de vertices: "+g.numeroDeVertices());
//        System.out.println("numero de arestas: "+g.numeroDeArestas());
    }
}

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
      //  Grafo g = a.carregarGrafo("C:\\Users\\tribi\\Documents\\input graph\\v_00005_a0000010.grafo", LISTA_DE_ADJACENCIA);
        Grafo g2 = a.carregarGrafo("C:\\Users\\Mario\\Documents\\Ze\\netbeans\\grafos\\input\\v_00005_a0000010.grafo", MATRIZ_DE_ADJACENCIA);
        
        System.out.println("");
        System.out.println("");
        g2.escreveArestas();
        
        BellmanFord b = new BellmanFord(g2, 0);
        b.runBellmanFord();
       
        for (int i = 0; i < b.pai.length; i++) {
            System.out.print(b.pai[i]+"-");
        }
        System.out.println("--------------------");
        System.out.println("--------------------");
        b.escreve(0, 4);
        System.out.println("");
        System.out.println(b.custo);
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

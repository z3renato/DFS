/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import static grafos.TipoDeRepresentacao.LISTA_DE_ADJACENCIA;
import static grafos.TipoDeRepresentacao.MATRIZ_DE_ADJACENCIA;

/**
 *
 * @author tribi
 */
public class TestaBFS {

    public static void main(String[] args) throws Exception {

        AlgoritmosGrafos a = new AlgoritmosGrafos();
//        Grafo g = a.carregarGrafo("instanciaExemplo.data", LISTA_DE_ADJACENCIA);
//        Grafo g = a.carregarGrafo("instanciaExemplo.data", LISTA_DE_ADJACENCIA);
        Grafo g = a.carregarGrafo("C:\\Users\\tribi\\Documents\\input graph\\v_00005_a0000010.grafo", LISTA_DE_ADJACENCIA);
        Grafo g2 = a.carregarGrafo("C:\\Users\\tribi\\Documents\\input graph\\v_00005_a0000010.grafo", MATRIZ_DE_ADJACENCIA);
        g.escreveArestas();
        System.out.println("");
        System.out.println("");
        g2.escreveArestas();
        
        BuscaEmLargura b;
        b = new BuscaEmLargura(g, 0);
        System.out.println("");
        b.resultado();
        System.out.println("");
        b = new BuscaEmLargura(g, 1);
        System.out.println("");
        b.resultado();
        System.out.println("");
        b = new BuscaEmLargura(g, 3);
        System.out.println("");
        b.resultado();
        System.out.println("");
        System.out.println(Double.POSITIVE_INFINITY);
        
    }
}

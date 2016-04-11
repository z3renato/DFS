/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

//throw new UnsupportedOperationException("Not supported yet.");
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tribi
 */
public class AlgoritmosGrafos implements AlgoritmosEmGrafos {

    @Override
    public Grafo carregarGrafo(String path, TipoDeRepresentacao t) throws Exception {
        Grafo grafo = null;

        int numeroDeVertices;
        int numeroDeArestas;
        
        FileReader arq = new FileReader(path);
            BufferedReader lerArq = new BufferedReader(arq);
            String[] nVertice = lerArq.readLine().split("\\s+");
            numeroDeVertices = Integer.parseInt(nVertice[2]);
            System.out.println("Num Vértices: "+numeroDeVertices);
            String[] nAresta = lerArq.readLine().split("\\s+");
            numeroDeArestas= Integer.parseInt(nAresta[2]);
            System.out.println("Num Arestas: "+numeroDeArestas);
        if (t == TipoDeRepresentacao.MATRIZ_DE_ADJACENCIA) {
            grafo = new MatrizAdjacencia(numeroDeVertices);
        }
        if (t == TipoDeRepresentacao.LISTA_DE_ADJACENCIA)
           grafo = new ListaAdjacencia(numeroDeVertices) ;
        if (t == TipoDeRepresentacao.MATRIZ_DE_INCIDENCIA)
           grafo = new MatrizIncidencia(numeroDeVertices, numeroDeArestas) ;

        while(lerArq.ready()){
                String[] linha = lerArq.readLine().split("\\s+");
                
                
               
                    grafo.adicionarAresta(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]), Double.parseDouble(linha[2]));
                    
                
                //System.out.println(linha[0]+"->"+linha[1]+"\tPeso: "+linha[2]);
            }
        //grafo.escreveArestas();
        System.out.println("Grafo carregado...");
        return grafo;
    }

    @Override
    public ResultadoBuscaProfundidade buscaEmProfundidade(Grafo g, List<Integer> ordemDeVisita) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultadoBuscaLargura buscaEmLargura(Grafo g, int verticeInicial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

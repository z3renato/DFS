/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

//throw new UnsupportedOperationException("Not supported yet.");
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
        File arquivoCarregado;
        FileReader arq;
        Scanner read;

        arquivoCarregado = new File(path);
        arq = new FileReader(arquivoCarregado);
        read = new Scanner(arq);
        numeroDeVertices = read.nextInt();
        if (t == TipoDeRepresentacao.MATRIZ_DE_ADJACENCIA) {
            grafo = new MatrizAdjacencia(numeroDeVertices);
        }
        if (t == TipoDeRepresentacao.LISTA_DE_ADJACENCIA)
           grafo = new ListaAdjacencia(numeroDeVertices) ;
        if (t == TipoDeRepresentacao.MATRIZ_DE_INCIDENCIA)
           grafo = new MatrizIncidencia(numeroDeVertices) ;

        read.nextLine();
        while (read.hasNextLine()) {
            System.out.println("");
            String linha = read.nextLine();
            if (linha != "") {
                int o, d, p; //origem, destino e peso
                String split[] = linha.split("\t");
                o = Integer.parseInt(split[0]);
                d = Integer.parseInt(split[1]);
                p = Integer.parseInt(split[2]);

                grafo.adicionarAresta(o, d, (double) p);
            }
        }
        //grafo.escreveArestas();
        System.out.println("Grafo carregado...");
        return grafo;
    }

    @Override
    public ResultadoBuscaProfundidade buscaEmProfundidade(Grafo g, List<Integer> ordemDeVisita) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

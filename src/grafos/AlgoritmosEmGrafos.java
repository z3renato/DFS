/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.List;

/**
 *
 * @author humberto
 */
public interface AlgoritmosEmGrafos {

    public Grafo carregarGrafo(String path, TipoDeRepresentacao t) throws Exception;

    public ResultadoBuscaProfundidade buscaEmProfundidade(Grafo g, List<Integer> ordemDeVisita);

    public ResultadoBuscaLargura buscaEmLargura(Grafo g, int verticeInicial);

}

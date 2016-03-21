/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.Set;

/**
 *
 * @author HumbertoBrandão
 */
public interface ResultadoBuscaProfundidade {
    
    public Set<Aresta> arestasDeArvore(Grafo g);
    
    public Set<Aresta> arestasDeRetorno(Grafo g);
    
    public Set<Aresta> arestasDeAvanco(Grafo g);
    
    public Set<Aresta> arestasDeCruzamento(Grafo g);
    
    public int tempoDeDescoberta(int origem);
    
    public int tempoDeFinalizacao(int destino);
    
    public boolean existeCiclo(Grafo g);
    
}

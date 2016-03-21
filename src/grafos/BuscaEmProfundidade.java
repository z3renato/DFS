/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tribi
 */
public class BuscaEmProfundidade implements ResultadoBuscaProfundidade {

    /**
     * cores 0 = branco | 1 = cinza | 2 = preto
     *
     */
    private boolean buscaRealizada = false;
    private int[] cor;
    private int[] tempoDescoberta;
    private int[] tempoFinalizacao;
    private int numVertices;
    private Set<Aresta> arestasDeArvore;
    private Set<Aresta> arestasDeAvanco;
    private Set<Aresta> arestasDeCruzamento;
    private Set<Aresta> arestasDeRetorno;
    private Grafo g;
    private int tempo = 0;

    public void dfs(Grafo g) throws Exception {
        this.g = g;
        this.numVertices = g.numeroDeVertices();
        this.cor = new int[this.numVertices];
        this.tempoDescoberta = new int[this.numVertices];
        this.tempoFinalizacao = new int[this.numVertices];

        arestasDeArvore = new HashSet<>();
        arestasDeAvanco = new HashSet<>();
        arestasDeCruzamento = new HashSet<>();
        arestasDeRetorno = new HashSet<>();

        for (int i = 0; i < cor.length; i++) {
            cor[i] = 0;
        }
        this.tempo = 0;
        for (int i = 0; i < numVertices; i++) {
            if (cor[i] == 0) {
                visit(i);
            }
        }
        this.buscaRealizada = true;
        escreveBusca();

    }

    private void visit(int u) throws Exception {
        cor[u] = 1;
        tempo++;
        tempoDescoberta[u] = tempo;
        Set<Integer> adjacentes = g.conjuntoDeAdjacentes(u);
        for (int v : adjacentes) {
            if (cor[v] == 1) {
                arestasDeRetorno.add(new Aresta(u, v));
            }
            if (cor[v] == 2) {
                if (tempoDescoberta[u] < tempoDeDescoberta(v)) {
                    arestasDeAvanco.add(new Aresta(u, v));
                } else {
                    arestasDeCruzamento.add(new Aresta(u, v));
                }
            }
            if (cor[v] == 0) {
                arestasDeArvore.add(new Aresta(u, v));
                visit(v);
            }
        }
        cor[u] = 2;
        tempo++;
        tempoFinalizacao[u] = tempo;
    }

    @Override
    public Set<Aresta> arestasDeArvore(Grafo g) {
        if (!this.buscaRealizada) {
            try {
                dfs(g);
            } catch (Exception ex) {
                Logger.getLogger(BuscaEmProfundidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arestasDeArvore;
    }

    @Override
    public Set<Aresta> arestasDeRetorno(Grafo g) {
        if (!this.buscaRealizada) {
            try {
                dfs(g);
            } catch (Exception ex) {
                Logger.getLogger(BuscaEmProfundidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arestasDeRetorno;
    }

    @Override
    public Set<Aresta> arestasDeAvanco(Grafo g) {
        if (!this.buscaRealizada) {
            try {
                dfs(g);
            } catch (Exception ex) {
                Logger.getLogger(BuscaEmProfundidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arestasDeAvanco;
    }

    @Override
    public Set<Aresta> arestasDeCruzamento(Grafo g) {
        if (!this.buscaRealizada) {
            try {
                dfs(g);
            } catch (Exception ex) {
                Logger.getLogger(BuscaEmProfundidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arestasDeCruzamento;
    }

    @Override
    public int tempoDeDescoberta(int origem) {
        return tempoDescoberta[origem];
    }

    @Override
    public int tempoDeFinalizacao(int destino) {
        return tempoFinalizacao[destino];
    }

    @Override
    public boolean existeCiclo(Grafo g) {
        if (arestasDeRetorno.size() > 0) {
            return true;
        }
        return false;
    }

    public void escreveArestas(Set<Aresta> arestas) {
        for (Aresta a : arestas) {
            System.out.println(a.getOrigem() + "\t" + a.getDestino());
        }
    }

    public void escreveBusca() {
        System.out.println("Vértice | Cor | D | F");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(i + "\t   " + cor[i] + "\t" + tempoDescoberta[i] + " / " + tempoFinalizacao[i]);
        }
    }

}

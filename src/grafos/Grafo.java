package grafos;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 *
 * @author humberto
 */
public interface Grafo {

    public void adicionarAresta(int origem, int destino) throws Exception;

    public void adicionarAresta(int origem, int destino, double peso) throws Exception;

    public boolean existeAresta(int origem, int destino);

    public int grauDoVertice(int vertice) throws Exception;

    public int numeroDeVertices();

    public int numeroDeArestas();

    public List<Integer> listDeAdjacentes(int vertice) throws Exception;

    public Set<Integer> conjuntoDeAdjacentes(int vertice) throws Exception;

    public void setarPeso(int origem, int destino, double peso) throws Exception;

    public Set<Integer> vertices();

    public void escreveArestas();

    public double getPeso(int u, int v);
}

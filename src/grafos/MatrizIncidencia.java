/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tribi
 */
public class MatrizIncidencia implements Grafo {

    List<Double>[] matriz;

    public MatrizIncidencia(int numVertices) {
        matriz = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            matriz[i] = new LinkedList<>();
        }
    }

    @Override
    public void adicionarAresta(int origem, int destino) throws Exception {
        for (int i = 0; i < matriz.length; i++) {
            if (i == origem) {
                matriz[i].add((double) -1);
                continue;
            }
            if (i == destino) {
                matriz[i].add((double) 1);
                continue;
            }
            matriz[i].add(Double.POSITIVE_INFINITY);
        }
    }

    @Override
    public void adicionarAresta(int origem, int destino, double peso) throws Exception {
        for (int i = 0; i < matriz.length; i++) {
            if (i == origem) {
                matriz[i].add((double) -1);
                continue;
            }
            if (i == destino) {
                matriz[i].add(peso);
                continue;
            }
            matriz[i].add(Double.POSITIVE_INFINITY);
        }
    }

    @Override
    public boolean existeAresta(int origem, int destino) {
        for (int i = 0; i < matriz[0].size(); i++) {
            if (matriz[origem].get(i) != Double.POSITIVE_INFINITY
                    && matriz[origem].get(i) == -1
                    && matriz[destino].get(i) != Double.POSITIVE_INFINITY) {

                return true;
            }
        }
        return false;
    }

    @Override
    public int grauDoVertice(int vertice) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numeroDeVertices() {
        return matriz.length;
    }

    @Override
    public int numeroDeArestas() {
        return matriz[0].size();
    }

    @Override
    public List<Integer> listDeAdjacentes(int vertice) throws Exception {
        List<Integer> listDeAdjacentes = new LinkedList<>();
        for (int i = 0; i < matriz[0].size(); i++) {
            if (matriz[vertice].get(i) != -1) {
                continue;
            }
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[j].get(i) != Double.POSITIVE_INFINITY && matriz[j].get(i) != -1) {
                    listDeAdjacentes.add(j);
                }
            }
        }
        return listDeAdjacentes;
    }

    @Override
    public Set<Integer> conjuntoDeAdjacentes(int vertice) throws Exception {
        Set<Integer> conjuntoDeAdjacentes = new HashSet<>();
        for (int i = 0; i < matriz[0].size(); i++) {
            if (matriz[vertice].get(i) != -1) {
                continue;
            }
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[j].get(i) != Double.POSITIVE_INFINITY && matriz[j].get(i) != -1) {
                    conjuntoDeAdjacentes.add(j);
                }
            }
        }
        return conjuntoDeAdjacentes;
    }

    @Override
    public void setarPeso(int origem, int destino, double peso) throws Exception {
        for (int i = 0; i < matriz[origem].size(); i++) {
            if (matriz[origem].get(i) == (double) -1
                    && matriz[destino].get(i) != Double.POSITIVE_INFINITY) {
                System.out.println(matriz[destino].get(i));
                matriz[destino].set(i, peso);
                System.out.println(matriz[destino].get(i));

            }
        }
    }

    @Override
    public Set<Integer> vertices() {
        Set<Integer> vertices = new HashSet<>();
        for (int i = 0; i < matriz.length; i++) {
            vertices.add(i);
        }
        return vertices;
    }

    @Override
    public void escreveArestas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

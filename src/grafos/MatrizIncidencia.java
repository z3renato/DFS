/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author tribi
 */
public class MatrizIncidencia implements Grafo {

    Double matriz[][];
    int coluna = 0;

    public MatrizIncidencia(int numVertices, int numArestas) {
        matriz = new Double[numVertices][numArestas];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numArestas; j++) {
                matriz[i][j] = Double.POSITIVE_INFINITY;
            }
        }
    }

    @Override
    public void adicionarAresta(int origem, int destino) throws Exception {
        matriz[origem][coluna] = -1.0;
        matriz[destino][coluna] = 1.0;
        coluna++;
    }

    @Override
    public void adicionarAresta(int origem, int destino, double peso) throws Exception {
        matriz[origem][coluna] = -1.0;
        matriz[destino][coluna] = peso;
        coluna++;
    }

    @Override
    public boolean existeAresta(int origem, int destino) {
        for (int i = 0; i < matriz[origem].length; i++) {
            if (matriz[origem][i] == -1.0) {
                for (int j = 0; j < matriz.length; j++) {
                    if (matriz[j][i] != Double.POSITIVE_INFINITY) {
                        return true;
                    }
                }
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
        return matriz[0].length;
    }

    @Override
    public List<Integer> listDeAdjacentes(int vertice) throws Exception {
        List<Integer> listDeAdjacentes = new LinkedList<>();
        for (int i = 0; i < matriz[0].length; i++) {
            if (matriz[vertice][i] == -1.0) {
                for (int j = 0; j < matriz.length; j++) {
                    if (j == vertice) {
                        continue;
                    }
                    if (matriz[j][i] != Double.POSITIVE_INFINITY) {
                        listDeAdjacentes.add(j);
                        break;
                    }

                }
            }
        }
        Collections.sort(listDeAdjacentes);
        return listDeAdjacentes;
    }

    @Override
    public Set<Integer> conjuntoDeAdjacentes(int vertice) throws Exception {
        Set<Integer> conjuntoDeAdjacentes = new LinkedHashSet<>();
        for (int i = 0; i < matriz[0].length; i++) {
            if (matriz[vertice][i] == -1.0) {

                for (int j = 0; j < matriz.length; j++) {
                    if (j == vertice) {
                        continue;
                    }
                    if (matriz[j][i] != Double.POSITIVE_INFINITY) {
                        conjuntoDeAdjacentes.add(j);
                        break;
                    }

                }
            }
        }

        return conjuntoDeAdjacentes;
    }

    @Override
    public void setarPeso(int origem, int destino, double peso) throws Exception {
        for (int i = 0; i < matriz[origem].length; i++) {
            if (matriz[origem][i] == -1.0
                    && matriz[destino][i] != Double.POSITIVE_INFINITY) {

                matriz[destino][i] = peso;

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
        for (int i = 0; i < matriz.length; i++) {
            try {

                System.out.println(listDeAdjacentes(i).toString());
            } catch (Exception ex) {
                Logger.getLogger(MatrizIncidencia.class.getName()).log(Level.SEVERE, null, ex);
            };

        }
    }

    @Override
    public double getPeso(int u, int v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getArestas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

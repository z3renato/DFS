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
public class MatrizAdjacencia implements Grafo {

    double matriz[][];

    public MatrizAdjacencia(int numVertices) {
        matriz = new double[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matriz[i][j] = 0;
            }
        }
    }

    @Override
    public void adicionarAresta(int origem, int destino) throws Exception {
        matriz[origem][destino] = 1;
    }

    @Override
    public void adicionarAresta(int origem, int destino, double peso) throws Exception {
        matriz[origem][destino] = peso;
    }

    @Override
    public boolean existeAresta(int origem, int destino) {
        return matriz[origem][destino] !=0;
    }

    @Override
    public int grauDoVertice(int vertice) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numeroDeVertices() {
        return matriz.length;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numeroDeArestas() {
        int cont = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if(matriz[i][j]!=0)
                    cont++;
            }
        }
        return cont;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Integer> listDeAdjacentes(int vertice) throws Exception {
        List adjacentes = new LinkedList<Integer>();
        for (int i = 0; i < matriz.length; i++) {
            if(matriz[vertice][i]!=0)
                adjacentes.add(i);
        }
        return adjacentes;
    }

    @Override
    public Set<Integer> conjuntoDeAdjacentes(int vertice) throws Exception {
        Set<Integer> conjuntoDeAdjacentes = new  HashSet<Integer>();
         for (int i = 0; i < matriz.length; i++) {
            if(matriz[vertice][i]!=0)
                conjuntoDeAdjacentes.add(i);
        }
        return conjuntoDeAdjacentes;
    }

    @Override
    public void setarPeso(int origem, int destino, double peso) throws Exception {
        matriz[origem][destino] = peso;
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
    public void escreveArestas(){
        System.out.println("Arestas do grafo");
        for (int i = 0; i < matriz.length; i++) {
            
            for (int j = 0; j < matriz.length; j++) {
                if(matriz[i][j]!=0){
                    System.out.print(i+"\t"+j+"\t"+(int)matriz[i][j]);
                }
                System.out.println("");
            }
            
        }
    }

}

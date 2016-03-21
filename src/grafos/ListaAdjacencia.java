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
public class ListaAdjacencia implements Grafo {

    List<Aresta>[] listadj;
    int numVertices;

    public ListaAdjacencia(int numVertices) {
        listadj = new LinkedList[numVertices];
        this.numVertices = numVertices;
        for (int i = 0; i < numVertices; i++) {
            listadj[i] = new LinkedList<>();
        }
    }

    @Override
    public void adicionarAresta(int origem, int destino) throws Exception {
        listadj[origem].add(new Aresta(origem, destino));

    }

    @Override
    public void adicionarAresta(int origem, int destino, double peso) throws Exception {
        listadj[origem].add(new Aresta(origem, destino, peso));
    }

    @Override
    public boolean existeAresta(int origem, int destino) {
        for (Aresta a : listadj[origem]) {
            if (a.getDestino() == destino) {
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
        return numVertices;
    }

    @Override
    public int numeroDeArestas() {
        int cont = 0;
        for (int i = 0; i < listadj.length; i++) {
            cont += listadj[i].size();
        }
        return cont;
    }

    @Override
    public List<Integer> listDeAdjacentes(int vertice) throws Exception {
        List<Integer> listDeAdjacentes = new LinkedList<>();
        for (Aresta a : listadj[vertice]) {
            listDeAdjacentes.add(a.getDestino());
        }
        return listDeAdjacentes;
    }

    @Override
    public Set<Integer> conjuntoDeAdjacentes(int vertice) throws Exception {
        Set<Integer> conjuntoDeAdjacentes = new HashSet<>();
        for (Aresta a : listadj[vertice]) {
            conjuntoDeAdjacentes.add(a.getDestino());
        }
        return conjuntoDeAdjacentes;
    }

    @Override
    public void setarPeso(int origem, int destino, double peso) throws Exception {
        int index = -1;
        for (int i = 0; i < listadj[origem].size(); i++) {
            if (listadj[origem].get(i).getDestino() == destino) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            listadj[origem].get(index).setPeso(peso);
        }else{
            System.out.println("Aresta não encontrada!");
        }
    }

    @Override
    public Set<Integer> vertices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void escreveArestas() {
        System.out.println("");
        for (List<Aresta> listadj1 : listadj) {
            for (Aresta a : listadj1) {
                System.out.println(a.getOrigem() + "\t" + a.getDestino() + "\t" + (int) a.getPeso());
            }
        }
    }

}

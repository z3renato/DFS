/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import grafos.AlgoritmosGrafos;
import grafos.Grafo;
import static grafos.TipoDeRepresentacao.LISTA_DE_ADJACENCIA;

/**
 *
 * @author tribi
 */
public class Controller {

    private String path;
    public Grafo g;

    public Controller(String path) {
        this.path = path;
    }

    public void run() throws Exception {
        AlgoritmosGrafos a = new AlgoritmosGrafos();
        Grafo g = a.carregarGrafo(path, LISTA_DE_ADJACENCIA);
        this.g = g;
    }

    
}

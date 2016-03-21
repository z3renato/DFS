/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author tribi
 */
public class Vertice {

    private int vertice;

    public Vertice(int v) {
        this.vertice = v;
    }

    public int id() {
        return vertice;
    }

    public void setVertice(int vertice) {
        this.vertice = vertice;
    }
}

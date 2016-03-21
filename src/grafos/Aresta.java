/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author HumbertoBrandão
 */
public class Aresta {

    private int origem;
    private int destino;
    private double peso;

    public Aresta(int origem, int destino) {
        this.origem = origem;
        this.destino = destino;
    }

    public Aresta(int origem, int destino, double peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public int getOrigem() {
        return this.origem;
    }

    public int getDestino() {
        return this.destino;
    }

    public double getPeso() {
        return this.peso;
    }
    
    public void setPeso(double peso){
        this.peso = peso;
    }
    
   
}

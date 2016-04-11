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
public class TestaFila {

    public static void main(String[] args) {
        Fila f = new Fila(10);

        f.enfileira(0);
        f.enfileira(1);
        f.enfileira(2);
        f.enfileira(3);
        f.enfileira(6);
        f.enfileira(7);
        f.enfileira(5);
        f.enfileira(4);
        System.out.println("Tamanho da fila: " + f.tamanho);

        f.mostra();

        f.desenfileira();
        f.desenfileira();
        f.desenfileira();
        System.out.println("Tamanho da fila: " + f.tamanho);

        f.mostra();
        f.desenfileira();
        f.desenfileira();
        f.desenfileira();
        f.desenfileira();
        f.desenfileira();
        f.desenfileira();
        f.desenfileira();
        f.desenfileira();
        f.desenfileira();
        System.out.println("Tamanho da fila: " + f.tamanho);

    }
}

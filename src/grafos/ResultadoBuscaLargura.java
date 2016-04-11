/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.Set;

/**
 *
 * @author HumbertoBrandão
 */
public interface ResultadoBuscaLargura {
    
    public Integer predecessor(int vertice);
    
    public Integer distanciaParaOrige(int vertice);
        
}

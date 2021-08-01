/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern_abstract;

import pattern_abstract.nodoast.Nodo;

/**
 *
 * @author julio
 */
public abstract class Instruccion {
    private int fila;
    private int columna;

    public Instruccion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    
    
    public abstract Object interpretar();
    public abstract Nodo getNodo();
    
}

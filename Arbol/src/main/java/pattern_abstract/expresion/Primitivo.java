/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern_abstract.expresion;

import pattern_abstract.Instruccion;
import pattern_abstract.nodoast.Nodo;

/**
 *
 * @author julio
 */
public class Primitivo extends Instruccion{

    private Object valor;
    public Primitivo(int fila, int columna, Object valor) {
        super(fila, columna);
        this.valor = valor;
        System.out.println("Primitivo Creado "+String.valueOf(valor));
    }    

    public Object getValor() {
        return valor;
    }

    
    @Override
    public String toString() {
        return "Primitivo{" + "valor=" + valor + '}';
    }

    
    @Override
    public Object interpretar() {
        return this.valor;
    }

    @Override
    public Nodo getNodo() {
        
        Nodo nodo = new Nodo("Numero");
        nodo.addHijo(String.valueOf(valor));
        return nodo;
    }
}

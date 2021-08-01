/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern_abstract.expresion;

import grammar.ts.Operador;
import pattern_abstract.Instruccion;
import pattern_abstract.nodoast.Nodo;

/**
 *
 * @author julio
 */
public class Operacion extends Instruccion {

    private Operador operador;
    private Object izq;
    private Object der;

    public Operacion(Operador operador, Object izq, Object der, int fila, int columna) {
        super(fila, columna);
        this.operador = operador;
        this.izq = izq;
        this.der = der;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Object getIzq() {
        return izq;
    }

    public void setIzq(Object izq) {
        this.izq = izq;
    }

    public Object getDer() {
        return der;
    }

    public void setDer(Object der) {
        this.der = der;
    }

    @Override
    public Object interpretar() {
        if (izq instanceof Operacion) {
            Operacion op = (Operacion) izq;
            return op.interpretar();
        }
        if (der instanceof Operacion) {
            Operacion op = (Operacion) der;
            return op.interpretar();
        }

        if (operador == Operador.POR) {
            Primitivo izquierda = (Primitivo) izq;
            Primitivo derecha = (Primitivo) der;
            return Integer.valueOf(String.valueOf(izquierda.interpretar())) * Integer.valueOf(String.valueOf(derecha.interpretar()));
        }
        if (operador == Operador.MAS) {
            Primitivo izquierda = (Primitivo) izq;
            Primitivo derecha = (Primitivo) der;

            return Integer.valueOf(String.valueOf(izquierda.interpretar())) + Integer.valueOf(String.valueOf(derecha.interpretar()));

        }
        return 0;
    }

    @Override
    public Nodo getNodo() {
        Nodo nodo = new Nodo("Operacion");
        if (izq instanceof Operacion) {
            Operacion izqOp = (Operacion) izq;
            nodo.addHijoNodo(izqOp.getNodo());
        } else {
            Primitivo x = (Primitivo) izq;
            nodo.addHijoNodo(x.getNodo());
        }
        nodo.addHijo(String.valueOf(operador));
        if (der instanceof Operacion) {
            Operacion derOp = (Operacion) der;
            nodo.addHijoNodo(derOp.getNodo());
        } else {
            Primitivo x = (Primitivo) der;
            nodo.addHijoNodo(x.getNodo());
        }

        return nodo;

//        
//        Primitivo x = (Primitivo) izq;
//        nodo.addHijoNodo(x.getNodo());
//        nodo.addHijo(String.valueOf(operador));
//         x = (Primitivo) der;
//        //nodo.addHijoNodo(x.getNodo());
//        return nodo;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grammar.ts;

import java.util.HashMap;

/**
 *
 * @author julio
 */
public class Tabla {
   private  HashMap<String, Object> tabla;

    public Tabla(HashMap<String, Object> tabla) {
        this.tabla = tabla;
    }

    public HashMap<String, Object> getTabla() {
        return tabla;
    }

    public void setTabla(HashMap<String, Object> tabla) {
        this.tabla = tabla;
    }
    
   
}

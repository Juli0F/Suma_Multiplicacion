/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arbol.main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julio
 */
public class Exec {

    public void execProgram() {
        Runtime runTime = Runtime.getRuntime();

        String executablePath = "shotwell grafo.png";

        try {
            Process process = runTime.exec(executablePath);
        } catch (IOException ex) {
            Logger.getLogger(Exec.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import GUI.CampoDeBatalla;
import static java.lang.Thread.sleep;

/**
 *
 * @author X
 */
public class ThreadDefensa {
    CampoDeBatalla ventana;
    boolean isRunning = true;
    Defensa defensa;
    //boolean isPaused = false;
    
    public ThreadDefensa(Defensa defensa, CampoDeBatalla refVentana) {
        this.defensa = defensa; 
        this.ventana = refVentana;
    }
    
    public void run() {
        while(isRunning){
            try {
                /*
                defensa.moverse(13, 13, 1);
                System.out.println(defensa.getPosX()+", "+defensa.getPosY());
                ventana.moverLabel(defensa.getPosX()*25, defensa.getPosY()*25, defensa.getLabel());*/
                sleep(2000);
            } catch (InterruptedException ex) {
                
            }
            
        } 
    }

    public CampoDeBatalla getVentana() {
        return ventana;
    }

    public void setVentana(CampoDeBatalla ventana) {
        this.ventana = ventana;
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public Defensa getDefensa() {
        return defensa;
    }

    public void setDefensa(Defensa defensa) {
        this.defensa = defensa;
    }
    
    
}


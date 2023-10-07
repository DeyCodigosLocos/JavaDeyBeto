package Clases;

import GUI.CampoDeBatalla;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;

public class ThreadInGame extends Thread {
    CampoDeBatalla ventana;
    boolean isRunnig;

    public ThreadInGame(CampoDeBatalla ventana) {
        this.ventana = ventana;
        this.isRunnig = true;
    }
    
    @Override
    public void run() {
        while(isRunnig){
            try {
                if(ventana.allZombiesDead()){
                    System.out.println("TODOS LOS ZOMBIES ESTAN MUERTOS");
                    ventana.pararThreads();
                    ventana.getZombies().clear();
                    ventana.getDefensas().clear();
                }
                    
                if (ventana.allDefensesDead()){
                    System.out.println("TODOS LAS DEFENSAS ESTAN MUERTAS");
                    ventana.pararThreads();
                    ventana.getZombies().clear();
                    ventana.getDefensas().clear();
                }
                    
                sleep(1000);
            } catch (InterruptedException ex) {
                
            }
            
        } 
    }
}

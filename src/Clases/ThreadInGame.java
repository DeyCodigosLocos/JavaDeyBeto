package Clases;

import GUI.CampoDeBatalla;
import java.awt.Point;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;

public class ThreadInGame extends Thread implements Serializable {
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
                //System.out.println("Nivel actual: " + ventana.getNivel());
                if(ventana.allZombiesDead()){
                    //System.out.println("TODOS LOS ZOMBIES ESTAN MUERTOS");
                    ventana.stopThreads();
                    ventana.getZombies().clear();
                    ventana.getDefensas().clear();
                    ventana.finishLevel(true);
                }
                      
                 if(ventana.getTav().getDefensa().isDead()){
                    //System.out.println("TODOS LAS DEFENSAS ESTAN MUERTAS");
                    ventana.stopThreads();
                    ventana.getZombies().clear();
                    ventana.getDefensas().clear();
                    ventana.finishLevel(false);
                }
              
                    
                sleep(200);
            } catch (InterruptedException ex) {
                
            }
            
        } 
    }
    
     public void setIsRunnig(boolean isRunnig) {
        this.isRunnig = isRunnig;
    }

}

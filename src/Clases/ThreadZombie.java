 package Clases;

import GUI.CampoDeBatalla;
import TiposZombies.*;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author X
 */
public class ThreadZombie extends Thread implements Serializable{
    CampoDeBatalla ventana;
    private boolean isRunning = true;
    //boolean isAtacking = false;
    Zombie zombie;
    //boolean isPaused = false;
    
    public ThreadZombie(Zombie zombie, CampoDeBatalla refVentana) {
        this.zombie = zombie; 
        this.ventana = refVentana;
    }

    @Override
    public void run() {
        while(isRunning){
            try {
                switch (zombie.getTipo()) {
                    case "AEREO": 
                        ZombieVolador zomVolador = (ZombieVolador)zombie;
                        zomVolador.ataque(ventana);
                        break;
                    case "CHOQUE": 
                        ZombieChoque zomChoque = (ZombieChoque)zombie;
                        zomChoque.ataque(ventana);
                        if(zomChoque.isDead())
                            setIsRunning(false);
                        break;
                    default:
                        zombie.ataque(ventana);
                    
                }
                sleep(1000);
                //ventana.imprimirActividad();
                System.out.println("\n\n");
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

    public Zombie getZombie() {
        return zombie;
    }

    public void setZombie(Zombie zombie) {
        this.zombie = zombie;
    }

    @Override
    public String toString() {
        return "ThreadZombie{" + "zombie=" + zombie + '}';
    } 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import GUI.CampoDeBatalla;

/**
 *
 * @author X
 */
public class ThreadZombie extends Thread{
    CampoDeBatalla ventana;
    boolean isRunning = true;
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
                if (!zombie.isTraslape(zombie.getPosX()+1, zombie.getPosY()+1, ventana.getZombies(), ventana.getDefensas()))
                    zombie.moverse(13, 13, 1);
                //System.out.println(zombie.getPosX()+", "+zombie.getPosY());
                ventana.moverLabel(zombie.getPosX()*25, zombie.getPosY()*25, zombie.getLabel());
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

    public Zombie getZombie() {
        return zombie;
    }

    public void setZombie(Zombie zombie) {
        this.zombie = zombie;
    }
    
}

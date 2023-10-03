/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import GUI.CampoDeBatalla;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

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
            ArrayList<Point> puntos = zombie.sortPossibleMoves(zombie.setPossibleMoves(),13, 13);
            try {
                for (int i = 0; i < puntos.size(); i++) {
                    Point get = puntos.get(i);
                    if(!zombie.isTraslape(get, ventana.getZombies(), ventana.getDefensas())){
                        zombie.setPosX(get.x);
                        zombie.setPosY(get.y);
                        ventana.moverLabel(zombie.getPosX()*25, zombie.getPosY()*25, zombie.getLabel());
                    }  
                }
                //System.out.println(zombie.getPosX()+", "+zombie.getPosY());
                
                sleep((new Random()).nextInt(4)*1000);
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

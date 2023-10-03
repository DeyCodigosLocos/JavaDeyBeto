/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author X
 */
public class Defensa extends Personaje{
    int velocidad;
    JLabel label;

    public Defensa(JLabel label,String nombre, String tipo, int alcance, int nivel, int nivelAparicion, int espacios, int danoPorsegundo, int vida, int posX, int posY, boolean equipo) {
        super(nombre, tipo, alcance, nivel, nivelAparicion, espacios, danoPorsegundo, vida, posX, posY, equipo);
        this.velocidad = velocidad;
        this.label = label;
    }
    
    
    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
    
    public ThreadZombie getCloserZombie(ArrayList <ThreadZombie> zombies){
        for (int i = 1; i <= this.alcance; i++) {
            ArrayList<Point> puntos = setPossibleMoves(i);
            //System.out.println("PUNTOS POSIBLES: ");
            printPoints(puntos);
            //System.out.println("");
            for (int j = 0; i < puntos.size(); j++) {
                for (int k = 0; k < zombies.size(); k++) {
                    ThreadZombie zombie = zombies.get(k);
                    //System.out.println("ZOMBIE X:  " + zombie.getZombie().getPosX() + "  ZOMBIE Y :  " + zombie.getZombie().getPosY());
                    System.out.println("X:  " + puntos.get(j).x + "  Y:  " + puntos.get(j).y );
                    if(zombie.getZombie().getPosX() == puntos.get(j).x && zombie.getZombie().getPosY() == puntos.get(j).y)
                        return zombie;
                }
            }
        }
        return null;
    }
    
}

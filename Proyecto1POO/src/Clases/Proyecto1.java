/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

import GUI.CampoDeBatalla;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Xz
 */
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Point p1 = new Point();
        JLabel label = new JLabel();
        label.setLocation(100, 100);
        ArrayList<ThreadZombie> zombies = new ArrayList<ThreadZombie>();
        Zombie zombie = new Zombie(label, "alfredito", "contacto", 2, 1, 1, 1, 1, 1, 4, 4, false);
        ThreadZombie tz = new ThreadZombie(zombie, new CampoDeBatalla());
        zombies.add(tz);
        //System.out.println(zombie.getDistance(2, 6, 1, 3));
        //zombie.printPoints(zombie.setPossibleMoves());
        //System.out.println("\n\n\n\n\n");
        //zombie.printPoints(zombie.getEsquinas());
        Defensa defensa = new Defensa(label, "amanda", "contacto", 1, 1, 1, 1, 1, 1, 2, 2, false);
        System.out.println(defensa.getCloserZombie(zombies));
    }

}

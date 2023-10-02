/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

import java.awt.Point;
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
        Zombie zombie = new Zombie(label, "alfredito", "contacto", 12, 1, 1, 1, 1, 1, 23, 23, false);
        //System.out.println(zombie.getDistance(2, 6, 1, 3));
        zombie.printPoints(zombie.setPossibleMoves());
        System.out.println("\n\n\n\n\n");
        zombie.printPoints(zombie.sortPossibleMoves(zombie.setPossibleMoves(), 13, 13));
    }

}

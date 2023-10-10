package filemanager;

import TiposDefensas.DefensaAerea;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import Clases.*;
import TiposZombies.*;

public class Main {

    public static void main(String args[]) throws IOException {     
        //FileManager.writeFile("Defensas//sumama.txt", "Hola mundo\n");
        
        //String readContent = FileManager.readFile("sumama.txt");
        //System.out.println(readContent);
        Defensa defensa = new DefensaAerea("imgs//arbolDeLaVida.png",new JLabel(), "Fortin", "AEREO", 2, 1, 1, 1, 2, 1000, 0, 0);
        FileManager.writeObject(defensa, "Defensas//" + defensa.getNombre()+".txt");
        
        Defensa hola = (Defensa)FileManager.readObject("Defensas//Fortin.txt");
        System.out.println(hola.getNombre());
        Zombie zombie = new ZombieVolador("imgs//arbolDeLaVida.png",new JLabel(), "Alfredito", "CONTACTO", 2, 1, 1, 1, 2, 10, 0,0);
        FileManager.writeObject(zombie, "Zombies//" + zombie.getNombre()+".txt");
        Zombie hola1 = (Zombie)FileManager.readObject("Zombies//Alfredito.txt");
        System.out.println(hola1.getNombre());
    }
    
    
    
}

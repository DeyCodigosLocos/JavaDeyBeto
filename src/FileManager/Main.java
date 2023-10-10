package filemanager;

import TiposDefensas.DefensaAerea;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import Clases.*;

public class Main {

    public static void main(String args[]) throws IOException {     
        //FileManager.writeFile("Defensas//sumama.txt", "Hola mundo\n");
        
        //String readContent = FileManager.readFile("sumama.txt");
        //System.out.println(readContent);
        Defensa defensa = new DefensaAerea(new JLabel(), "Fortin", "AEREO", 2, 1, 1, 1, 2, 1000, 10, 10);
        FileManager.writeObject(defensa, "Defensas//" + defensa.getNombre()+".txt");
        
        Defensa hola = (Defensa)FileManager.readObject("Defensas//Fortin.txt");
        System.out.println(hola.getNombre());
       
    }
    
    
    
}

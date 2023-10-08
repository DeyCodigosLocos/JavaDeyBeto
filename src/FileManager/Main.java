package filemanager;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Main {

    public static void main(String args[]) throws IOException {     
        FileManager.writeFile("Defensas//sumama.txt", "Hola mundo\n");
        
        String readContent = FileManager.readFile("sumama.txt");
        System.out.println(readContent);
        //Partido p = new Partido("LDA", "Sapri");
        //FileManager.writeObject(p, "sumama.txt");
        
        
        
       
    }
    
    
    
}

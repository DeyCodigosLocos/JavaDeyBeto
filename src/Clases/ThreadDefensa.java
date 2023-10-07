package Clases;

import GUI.CampoDeBatalla;
import TiposDefensas.DefensaAerea;
import static java.lang.Thread.sleep;

/**
 *
 * @author X
 */
public class ThreadDefensa extends Thread{
    CampoDeBatalla ventana;
    boolean isRunning = true;
    Defensa defensa;
    //boolean isPaused = false;
    
    public ThreadDefensa(Defensa defensa, CampoDeBatalla refVentana) {
        this.defensa = defensa;
        this.ventana = refVentana;
    }
    
   
    
    @Override
    public void run() {
        while(isRunning){
            try {
                switch (defensa.getTipo()) {
                    case "AEREO":
                        System.out.println("Entró");
                        defensa = (DefensaAerea)defensa;
                        defensa.ataque(ventana);
                        break;
                    case "IMPACTO":
                        System.out.println("Seleccionaste la opción 3");
                        break;
                    
                    case "MULTIPLE":
                        System.out.println("Seleccionaste la opción 3");
                        break;
                    default:
                       
                        break;
                }
                
                sleep(1000);
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

    public Defensa getDefensa() {
        return defensa;
    }

    public void setDefensa(Defensa defensa) {
        this.defensa = defensa;
    }

    @Override
    public String toString() {
        return "ThreadDefensa{" + "defensa=" + defensa + '}';
    }

  
    
    
    
}


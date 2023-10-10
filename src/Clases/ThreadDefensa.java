package Clases;

import GUI.CampoDeBatalla;
import TiposDefensas.*;
import java.io.Serializable;

import static java.lang.Thread.sleep;

/**
 *
 * @author X
 */
public class ThreadDefensa extends Thread implements Serializable{
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
                        DefensaAerea defAereo = (DefensaAerea)defensa;
                        defAereo.ataque(ventana);
                        break;
                    case "IMPACTO":
                        DefensaImpacto defImpac = (DefensaImpacto)defensa;
                        defImpac.ataque(ventana);
                        if(defImpac.isDead())
                            setIsRunning(false);
                        break;
                    case "MULTIPLE":
                        DefensaAtaqueMultiple defAtaqueMulti = (DefensaAtaqueMultiple)defensa;
                        for (int i = 0; i < defAtaqueMulti.getRepeticiones(); i++){
                            defAtaqueMulti.ataque(ventana);
                        }
                        break;
                    default:
                        defensa.ataque(ventana);
                    
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


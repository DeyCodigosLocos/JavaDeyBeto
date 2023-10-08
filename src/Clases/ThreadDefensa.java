package Clases;

import GUI.CampoDeBatalla;
import TiposDefensas.DefensaAerea;
import TiposDefensas.DefensaImpacto;

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
                    case "AEREO" -> {
                        defensa = (DefensaAerea)defensa;
                        defensa.ataque(ventana);
                    }
                    case "IMPACTO" -> {
                        defensa = (DefensaImpacto)defensa;
                        defensa.setAlcance(1);
                        System.out.println("eso tilin");
                        defensa.ataque(ventana);
                        if(defensa.isDead())
                            setIsRunning(false);
                    }
                    case "MULTIPLE" -> {
                        int repeticiones = 10; //se ocupa el atributo o dato que indique el número de ataques por iteración
                        for (int i = 0; i < repeticiones; i++) {
                            defensa.ataque(ventana);
                        }
                    }
                    default -> {
                    }
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


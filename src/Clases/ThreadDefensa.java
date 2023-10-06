package Clases;

import GUI.CampoDeBatalla;
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
                
                //System.out.println("entro al try");
                if (defensa.getObjetivo() == null || defensa.getObjetivo().getZombie().isDead()){
                    //System.out.println("entro al if 1");
                    defensa.setObjetivo(defensa.getCloserZombie(ventana.getZombies()));
                }else{
                    defensa.atacarZombie();
                    defensa.getObjetivo().getZombie().getLabel().setText(defensa.getObjetivo().getZombie().getVida()+"");
                    if(defensa.getObjetivo().getZombie().isDead()){
                        defensa.getObjetivo().getZombie().morir();
                        defensa.getObjetivo().isRunning = false;
                        ventana.cambiarImagenDeLabel("imgs//zombieMuerto.png",defensa.getObjetivo().getZombie().getLabel());
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


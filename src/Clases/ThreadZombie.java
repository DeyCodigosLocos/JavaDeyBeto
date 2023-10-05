package Clases;

import GUI.CampoDeBatalla;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author X
 */
public class ThreadZombie extends Thread{
    CampoDeBatalla ventana;
    boolean isRunning = true;
    //boolean isAtacking = false;
    Zombie zombie;
    //boolean isPaused = false;
    
    public ThreadZombie(Zombie zombie, CampoDeBatalla refVentana) {
        this.zombie = zombie; 
        this.ventana = refVentana;
    }
    
    @Override
    public void run() {
        while(isRunning){
            ArrayList<Point> puntos = zombie.sortPossibleMoves(zombie.setPossibleMoves(1),ventana.getTav().getDefensa().getPosX(), ventana.getTav().getDefensa().getPosY());
            try {
//                if(zombie.isDead() && zombie.getObjetivo() != null){
//                    zombie.setVidaFinalObjetivo(zombie.getObjetivo().getDefensa().getVida());
//                    
//                }
                
                if (zombie.getObjetivo() == null || zombie.getObjetivo().getDefensa().isDead()){
                    //System.out.println("entro al if 1");
                    
                    /*if (zombie.getObjetivo() != null && zombie.getObjetivo().getDefensa().isDead()){
                        zombie.getObjetivo().getDefensa().getAtaques().add("Defensa" + zombie.getObjetivo().getDefensa().getPosX() + "," +zombie.getObjetivo().getDefensa().getPosY()+" atacó a " + zombie.getObjetivo().getDefensa().getObjetivo().getZombie().getPosX() + "," + zombie.getObjetivo().getDefensa().getObjetivo().getZombie().getPosY()
                        +" ,tenía " + zombie.getVidaInicialObjetivo() + " de vida y termino en 0 de vida" );
                    }*/
                    
                    zombie.setObjetivo(zombie.getCloserDefense(ventana.getDefensas()));
                    
                    if(zombie.getObjetivo() == null){
                        for (int i = 0; i < puntos.size(); i++) {
                            Point get = puntos.get(i);
                            if(!zombie.isTraslape(get, ventana.getZombies(), ventana.getDefensas())){
                                zombie.setPosX(get.x);
                                zombie.setPosY(get.y);
                                ventana.moverLabel(zombie.getPosX()*25, zombie.getPosY()*25, zombie.getLabel());
                            }     
                        }
                    }
                    
                }else{
                    zombie.atacarDefensa();
                    zombie.getObjetivo().getDefensa().getLabel().setText(zombie.getObjetivo().getDefensa().getVida()+"");
                    if(zombie.getObjetivo().getDefensa().isDead()){
                        /*
                        zombie.getAtaques().add("Zombie" + zombie.getPosX() + "," +zombie.getPosY()+" ataco a " + zombie.getObjetivo().getDefensa().getPosX() + "," + zombie.getObjetivo().getDefensa().getPosY()
                        +" ,tenia " + zombie.getVidaInicialObjetivo() + " de vida y termino en 0 de vida" );
                        */
                        
                        zombie.getObjetivo().getDefensa().morir();
                        
                        //se ocupa obtener el ataque en curso del objetivo en caso que lo tenga, baby girl si yo te quiero
                        
                        /*
                        if(zombie.getObjetivo().getDefensa().getIsAttacking()){
                            zombie.getObjetivo().getDefensa().getAtaques().add("Defensa" + zombie.getObjetivo().getDefensa().getPosX() + "," +zombie.getObjetivo().getDefensa().getPosY()+" atacó a " + zombie.getObjetivo().getDefensa().getObjetivo().getZombie().getPosX() + "," + zombie.getObjetivo().getDefensa().getObjetivo().getZombie().getPosY()
                            +" ,tenía " + zombie.getVidaInicialObjetivo() + " de vida y termino en 0 de vida" );
                        }*/
                        
                        
                        zombie.getObjetivo().isRunning = false;
                        //System.out.println(defensa.getObjetivo().getZombie().getPosX() + ", "+ defensa.getObjetivo().getZombie().getPosY());
                        ventana.cambiarImagenDeLabel("imgs//ruinas.png",zombie.getObjetivo().getDefensa().getLabel());
                    }
                }
                sleep(((new Random()).nextInt(3-1)+1)*1000);
                
                //ventana.imprimirActividad();
                
                System.out.println("\n\n");
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

    public Zombie getZombie() {
        return zombie;
    }

    public void setZombie(Zombie zombie) {
        this.zombie = zombie;
    }

    @Override
    public String toString() {
        return "ThreadZombie{" + "zombie=" + zombie + '}';
    } 
}

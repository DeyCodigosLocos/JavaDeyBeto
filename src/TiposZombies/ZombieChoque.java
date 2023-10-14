
package TiposZombies;

import Clases.Zombie;
import GUI.CampoDeBatalla;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author deyto
 */
public class ZombieChoque extends Zombie{
    
    public ZombieChoque(String imagen,JLabel label, String nombre, String tipo, int alcance, int nivel, int nivelAparicion, int espacios, int danoPorsegundo, int vida, int posX, int posY) {
        super(imagen,label, nombre, tipo, alcance, nivel, nivelAparicion, espacios, danoPorsegundo, vida, posX, posY);
    }
    
    public void ataque(CampoDeBatalla ventana){
        ArrayList<Point> puntos = sortPossibleMoves(setPossibleMoves(1),ventana.getTav().getDefensa().getPosX(), ventana.getTav().getDefensa().getPosY());
        if (getObjetivo() == null || getObjetivo().getDefensa().isDead()){
            setObjetivo(getCloserDefense(ventana.getDefensas(),false));
            if(getObjetivo() == null){
                for (int i = 0; i < puntos.size(); i++) {
                    Point get = puntos.get(i);
                    if(!isTraslape(get, ventana.getZombies(), ventana.getDefensas())){
                        setPosX(get.x);
                        setPosY(get.y);
                        ventana.moverLabel(getPosX()*25, getPosY()*25, getLabel());
                    }
                }
            }
        }else{
            this.getAtaques().add(getNombre() + " " + getPosX() + "," + getPosX() + " ataco a " + getObjetivo().getDefensa().getNombre() + " " + 
            getObjetivo().getDefensa().getPosX() + "," +getObjetivo().getDefensa().getPosY()+ " ,tenia " + getObjetivo().getDefensa().getVida() + " de vida y lo dejo a 0 vida");
            getObjetivo().getDefensa().morir();
            getObjetivo().setIsRunning(false);
            ventana.cambiarImagenDeLabel("imgs//ruinas.png",getObjetivo().getDefensa().getLabel());
            
            
            this.morir();
            //setIsRunning(false);
            ventana.cambiarImagenDeLabel("imgs//zombieMuerto.png",getLabel());
        }
    }
    
}

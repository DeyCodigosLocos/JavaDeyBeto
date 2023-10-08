
package TiposZombies;

import Clases.Zombie;
import GUI.CampoDeBatalla;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JLabel;

public class ZombieVolador extends Zombie {
    
    public ZombieVolador(JLabel label, String nombre, String tipo, int alcance, int nivel, int nivelAparicion, int espacios, int danoPorsegundo, int vida, int posX, int posY) {
        super(label, nombre, tipo, alcance, nivel, nivelAparicion, espacios, danoPorsegundo, vida, posX, posY);
    }
    
    @Override
    public void ataque(CampoDeBatalla ventana){
        ArrayList<Point> puntos = sortPossibleMoves(setPossibleMoves(1),ventana.getTav().getDefensa().getPosX(), ventana.getTav().getDefensa().getPosY());
        if (getObjetivo() == null || getObjetivo().getDefensa().isDead() || !inRange(getObjetivo().getDefensa().getPosX(),getObjetivo().getDefensa().getPosY())){
            
            setObjetivo(getCloserDefense(ventana.getDefensas(), true));
            
            if(getObjetivo() == null || !inRange(getObjetivo().getDefensa().getPosX(),getObjetivo().getDefensa().getPosY())){
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
            getObjetivo().getDefensa().setVida(this.getObjetivo().getDefensa().getVida()-this.getDanoPorSegundo());
            getObjetivo().getDefensa().getLabel().setText(getObjetivo().getDefensa().getVida()+"");
            if(getObjetivo().getDefensa().isDead()){
                getObjetivo().getDefensa().morir();
                getObjetivo().setIsRunning(false);
                ventana.cambiarImagenDeLabel("imgs//ruinas.png",getObjetivo().getDefensa().getLabel());
            }
        }
    }
    
}

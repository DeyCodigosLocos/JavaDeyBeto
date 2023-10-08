
package TiposDefensas;

import Clases.Defensa;
import Clases.ThreadZombie;
import GUI.CampoDeBatalla;
import GUI.CampoDeBatalla;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JLabel;


public class DefensaAerea extends Defensa{
    
    public DefensaAerea(JLabel label, String nombre, String tipo, int alcance, int nivel, int nivelAparicion, int espacios, int danoPorsegundo, int vida, int posX, int posY) {
        super(label, nombre, tipo, alcance, nivel, nivelAparicion, espacios, danoPorsegundo, vida, posX, posY);
    }
    
    
    @Override
    public void ataque(CampoDeBatalla ventana){
        
        if(getObjetivo()==null || getObjetivo().getZombie().isDead()){
            for (ThreadZombie zombie : ventana.getZombies()){
                if(!(zombie.getZombie().isDead())){
                    setObjetivo(zombie);
                }
            }
        }else{
            ArrayList<Point> puntos = sortPossibleMoves(setPossibleMoves(1),getObjetivo().getZombie().getPosX(), getObjetivo().getZombie().getPosY());
            
            for (int i = 0; i < puntos.size(); i++) {
                Point get = puntos.get(i);
                if(!isTraslape(get, ventana.getZombies(), ventana.getDefensas())){
                    setPosX(get.x);
                    setPosY(get.y);
                    ventana.moverLabel(getPosX()*25, getPosY()*25, getLabel());
                }
            }
            if (inRange(getObjetivo().getZombie().getPosX(),getObjetivo().getZombie().getPosY())){
                getObjetivo().getZombie().setVida(this.getObjetivo().getZombie().getVida()-this.getDanoPorSegundo());
                getObjetivo().getZombie().getLabel().setText(getObjetivo().getZombie().getVida()+"");
                if(getObjetivo().getZombie().isDead()){
                    getObjetivo().getZombie().morir();
                    getObjetivo().setIsRunning(false);
                    ventana.cambiarImagenDeLabel("imgs//zombieMuerto.png",getObjetivo().getZombie().getLabel());
                }
            }
        }
    }
    

    
    
}

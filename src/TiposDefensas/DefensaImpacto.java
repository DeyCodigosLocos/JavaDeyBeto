
package TiposDefensas;

import Clases.Defensa;
import GUI.CampoDeBatalla;
import javax.swing.JLabel;


public class DefensaImpacto extends Defensa {
    
    public DefensaImpacto(String imagen,JLabel label, String nombre, String tipo, int alcance, int nivel, int nivelAparicion, int espacios, int danoPorsegundo, int vida, int posX, int posY) {
        super(imagen,label, nombre, tipo, alcance, nivel, nivelAparicion, espacios, danoPorsegundo, vida, posX, posY);
    }
    
    @Override
    public void ataque(CampoDeBatalla ventana){
        if (getObjetivo() == null || getObjetivo().getZombie().isDead()){
            setObjetivo(getCloserZombie(ventana.getZombies(),false));
        }else{
            this.getAtaques().add(getNombre()+" " +getPosX()+","+getPosY()+" ataco a " + getObjetivo().getZombie().getNombre()+ " " +
            getObjetivo().getZombie().getPosX() + "," +getObjetivo().getZombie().getPosY()+" ,tenia " +getObjetivo().getZombie().getVida() + " de vida y lo dejo a 0 de vida");
            getObjetivo().getZombie().morir();
            getObjetivo().setIsRunning(false);
            ventana.cambiarImagenDeLabel("imgs//zombieMuerto.png",getObjetivo().getZombie().getLabel());
            
            morir();
            //setIsRunning(false);
            ventana.cambiarImagenDeLabel("imgs//ruinas.png",getLabel());
        }
    }
}

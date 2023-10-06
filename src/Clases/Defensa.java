package Clases;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Defensa extends Personaje{
    private int velocidad;
    private JLabel label;
    private ThreadZombie objetivo;
    private ArrayList<String> ataques;
    boolean isAttacking;

    public Defensa(JLabel label,String nombre, String tipo, int alcance, int nivel, int nivelAparicion, int espacios, int danoPorsegundo, int vida, int posX, int posY) {
        super(nombre, tipo, alcance, nivel, nivelAparicion, espacios, danoPorsegundo, vida, posX, posY);
        this.velocidad = velocidad;
        this.label = label;
        this.objetivo = null;
        this.ataques = new  ArrayList<String>();
    }

    public ArrayList<String> getAtaques() {
        return ataques;
    }

    public ThreadZombie getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(ThreadZombie objetivo) {
        this.objetivo = objetivo;
    }
    
    
    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public boolean getIsAttacking() {
        return isAttacking;
    }
    
    public ThreadZombie getCloserZombie(ArrayList <ThreadZombie> zombies){
        ArrayList<Point> esquinas = this.getEsquinas();
        Point punto1 = esquinas.get(0);
        Point punto2 = esquinas.get(1);
        for (int i = 0; i < zombies.size(); i++) {
            ThreadZombie zombie = zombies.get(i);
            if (punto1.x<= zombie.getZombie().getPosX() && punto2.x >= zombie.getZombie().getPosX())
                if(punto1.y<= zombie.getZombie().getPosY() && punto2.y >= zombie.getZombie().getPosY())
                    return zombie;
        }
        return null;
    }

    public void atacarZombie(){
        this.getObjetivo().getZombie().setVida(this.getObjetivo().getZombie().getVida()-this.getDanoPorSegundo());
    }
    
}

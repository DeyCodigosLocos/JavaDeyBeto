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
    
    public ThreadZombie getCloserZombie(ArrayList <ThreadZombie> zombies){
        for (int i = 1; i <= this.getAlcance(); i++) {
            ArrayList<Point> puntos = setPossibleMoves(i);
            for (int j = 0; j < puntos.size(); j++) {
                for (int k = 0; k < zombies.size(); k++) {
                    ThreadZombie zombie = zombies.get(k);
                    //System.out.println("ZOMBIE X:  " + zombie.getZombie().getPosX() + "  ZOMBIE Y :  " + zombie.getZombie().getPosY());
                    System.out.println("X:  " + puntos.get(j).x + "  Y:  " + puntos.get(j).y );
                    if(zombie.getZombie().getPosX() == puntos.get(j).x && zombie.getZombie().getPosY() == puntos.get(j).y)
                        return zombie;
                }
            }
        } 
        return null;
    }

    public void atacarZombie(){
        this.getObjetivo().getZombie().setVida(this.getObjetivo().getZombie().getVida()-this.getDanoPorSegundo());
    }
    
}

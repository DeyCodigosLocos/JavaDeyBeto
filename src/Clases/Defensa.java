package Clases;

import GUI.CampoDeBatalla;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Random;

enum tipo{
    CONTACTO, AEREO, M_ALCANCE, IMPACTO, BLOQUE, MULTIPLE;
}

public class Defensa extends Personaje implements Serializable{
    private int velocidad;
    private JLabel label;
    private ThreadZombie objetivo;
    private ArrayList<String> ataques;
    boolean isAttacking;

    public Defensa(String imagen,JLabel label,String nombre, String tipo, int alcance, int nivel, int nivelAparicion, int espacios, int danoPorsegundo, int vida, int posX, int posY) {
        super(imagen,nombre, tipo, alcance, nivel, nivelAparicion, espacios, danoPorsegundo, vida, posX, posY);
        this.velocidad = velocidad;
        this.label = label;
        this.objetivo = null;
        this.ataques = new  ArrayList<String>();
    }

    public static tipo tipoDefensaRand() {
        tipo[] valores = tipo.values();
        Random rand = new Random();
        return valores[rand.nextInt(valores.length)];
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
    
    public ThreadZombie getCloserZombie(ArrayList <ThreadZombie> zombies, boolean flag){ //flag = esta defensa es voladora
        for (int i = 0; i < zombies.size(); i++) {
            ThreadZombie zombie = zombies.get(i);
            if(inRange(zombie.getZombie().getPosX(),zombie.getZombie().getPosY()))
                if(flag){
                    return zombie;
                }else
                    if(!"AEREO".equals(zombie.getZombie().getTipo()))
                        return zombie;
        }
        return null;
    }
    
    public void ataque(CampoDeBatalla ventana){
        if (getObjetivo() == null || getObjetivo().getZombie().isDead()){
            setObjetivo(getCloserZombie(ventana.getZombies(), false));
        }else{
            this.getAtaques().add(getNombre()+" " +getPosX()+","+getPosY()+" ataco a " + getObjetivo().getZombie().getNombre()+ " " + 
            getObjetivo().getZombie().getPosX() + "," +getObjetivo().getZombie().getPosY()+" ,tenia " +getObjetivo().getZombie().getVida() + " de vida y lo dejo a " + (this.getObjetivo().getZombie().getVida()-this.getDanoPorSegundo()));
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

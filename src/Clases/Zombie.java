package Clases;

import GUI.CampoDeBatalla;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Random;

enum tipos{
        CONTACTO, AEREO, M_ALCANCE, CHOQUE;
}

public class Zombie extends Personaje implements Serializable{
    int velocidad;
    private JLabel label;
    ThreadDefensa objetivo;
    private int vidaInicialObjetivo,vidaFinalObjetivo;
    boolean isAttacking;
    
    public Zombie(String imagen,JLabel label,String nombre, String tipo, int alcance, int nivel, int nivelAparicion, int espacios, int danoPorsegundo, int vida, int posX, int posY) {
        super(imagen,nombre, tipo, alcance, nivel, nivelAparicion, espacios, danoPorsegundo, vida, posX, posY);
        this.velocidad = velocidad;
        this.label = label;
        this.vidaInicialObjetivo = 0;
        this.vidaFinalObjetivo = 0;
        isAttacking = false;
    }

    public void tipoZombieRand() {
        tipo[] valores = tipo.values();
        Random rand = new Random();
        this.setTipo(valores[rand.nextInt(valores.length)].name());
    }
    
    public void setStatsByType(){
        
    }
    
    public boolean isIsAttacking() {
        return isAttacking;
    }

    public void setIsAttacking(boolean isAttacking) {
        this.isAttacking = isAttacking;
    }
    
    
    public int getVidaInicialObjetivo() {
        return vidaInicialObjetivo;
    }

    public void setVidaInicialObjetivo(int vidaInicialObjetivo) {
        this.vidaInicialObjetivo = vidaInicialObjetivo;
    }

    public int getVidaFinalObjetivo() {
        return vidaFinalObjetivo;
    }

    public void setVidaFinalObjetivo(int vidaFinalObjetivo) {
        this.vidaFinalObjetivo = vidaFinalObjetivo;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public ThreadDefensa getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(ThreadDefensa objetivo) {
        this.objetivo = objetivo;
    }
    
    public ThreadDefensa getCloserDefense(ArrayList <ThreadDefensa> defensas, boolean flag){ //flag = este zombie es volador
       for (int i = 0; i < defensas.size(); i++) {
            ThreadDefensa defensa = defensas.get(i);
            if(inRange(defensa.getDefensa().getPosX(),defensa.getDefensa().getPosY()))
                if(flag){
                    return defensa;
                }else
                    if(!"AEREO".equals(defensa.getDefensa().getTipo()))
                        return defensa;
        }
        return null;
    }
    
    public void ataque(CampoDeBatalla ventana){
        ArrayList<Point> puntos = sortPossibleMoves(setPossibleMoves(1),ventana.getTav().getDefensa().getPosX(), ventana.getTav().getDefensa().getPosY());
        if (getObjetivo() == null || getObjetivo().getDefensa().isDead()){
            setObjetivo(getCloserDefense(ventana.getDefensas(), false));
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
            getObjetivo().getDefensa().setVida(this.getObjetivo().getDefensa().getVida()-this.getDanoPorSegundo());
            getObjetivo().getDefensa().getLabel().setText(getObjetivo().getDefensa().getVida()+"");
            if(getObjetivo().getDefensa().isDead()){
                getObjetivo().getDefensa().morir();
                getObjetivo().isRunning = false;
                ventana.cambiarImagenDeLabel("imgs//ruinas.png",getObjetivo().getDefensa().getLabel());
            }
        }
    }
}
            


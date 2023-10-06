package Clases;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author X
 */
public class Zombie extends Personaje{
    int velocidad;
    private JLabel label;
    ThreadDefensa objetivo;
    private int vidaInicialObjetivo,vidaFinalObjetivo;
    boolean isAttacking;
    

    public Zombie(JLabel label,String nombre, String tipo, int alcance, int nivel, int nivelAparicion, int espacios, int danoPorsegundo, int vida, int posX, int posY) {
        super(nombre, tipo, alcance, nivel, nivelAparicion, espacios, danoPorsegundo, vida, posX, posY);
        this.velocidad = velocidad;
        this.label = label;
        this.vidaInicialObjetivo = 0;
        this.vidaFinalObjetivo = 0;
        isAttacking = false;
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
    
    public double getDistance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
    }
    public ArrayList<Point> sortPossibleMoves(ArrayList<Point> array, int objX, int objY){
        if (!array.isEmpty()){
             for (int i = 0; i < array.size()-1; i++) {
                for (int j = 0; j < array.size() - 1; j++) {
                    if (getDistance(array.get(j).x,array.get(j).y,objX,objY) < getDistance(array.get(j+1).x,array.get(j+1).y,objX,objY)){
                        Point p1 = new Point(array.get(j));
                        Point p2 = new Point(array.get(j+1));
                        array.set(j, p2);
                        array.set(j+1, p1);
                    }
                }
            }
        }
        return array;
    }
    
    public ThreadDefensa getCloserDefense(ArrayList <ThreadDefensa> defensas){
        ArrayList<Point> esquinas = this.getEsquinas();
        Point punto1 = esquinas.get(0);
        Point punto2 = esquinas.get(1);
        for (int i = 0; i < defensas.size(); i++) {
            ThreadDefensa defensa = defensas.get(i);
            if (punto1.x<= defensa.getDefensa().getPosX() && punto2.x >= defensa.getDefensa().getPosX())
                if(punto1.y<= defensa.getDefensa().getPosY() && punto2.y >= defensa.getDefensa().getPosY())
                    return defensa;
        }
        return null;
    }
    
    public void atacarDefensa(){
        this.getObjetivo().getDefensa().setVida(this.getObjetivo().getDefensa().getVida()-this.getDanoPorSegundo());
    }
}
            


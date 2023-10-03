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
    JLabel label;

    public Zombie(JLabel label,String nombre, String tipo, int alcance, int nivel, int nivelAparicion, int espacios, int danoPorsegundo, int vida, int posX, int posY, boolean equipo) {
        super(nombre, tipo, alcance, nivel, nivelAparicion, espacios, danoPorsegundo, vida, posX, posY, equipo);
        this.velocidad = velocidad;
        this.label = label;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
    
    
    public void moverse(int objPosX,int objPosY,int cantidadMov){
        if (objPosX < posX){
            posX-=cantidadMov;
        }else if (objPosX > posX){
            posX+=cantidadMov;
        }
        if (objPosY < posY){
            posY-=cantidadMov;
        }else if (objPosY > posY){
            posY+=cantidadMov;
        }
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
}
            


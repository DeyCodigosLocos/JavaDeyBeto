/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
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
}

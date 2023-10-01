package Clases;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Personaje {
    String nombre,tipo;
    int alcance,nivel,nivelAparicion,espacios,danoPorsegundo,vida,posX,posY;
    boolean equipo;
    //ImageIcon imagen;

    public Personaje(String nombre, String tipo, int alcance, int nivel, int nivelAparicion, int espacios, int danoPorsegundo, int vida, int posX, int posY, boolean equipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.alcance = alcance;
        this.nivel = nivel;
        this.nivelAparicion = nivelAparicion;
        this.espacios = espacios;
        this.danoPorsegundo = danoPorsegundo;
        this.vida = vida;
        this.posX = posX;
        this.posY = posY;
        this.equipo = equipo;
        //this.imagen = imagen;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    
    
}

package Clases;

//import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Iterator;
import static java.util.Spliterators.iterator;

public class Personaje {
    private String nombre,tipo;
    private int alcance,nivel,nivelAparicion,espacios,danoPorSegundo,vida,posX,posY;
    private boolean activo;
    private ArrayList<String> ataques;

    public Personaje(String nombre, String tipo, int alcance, int nivel, int nivelAparicion, int espacios, int danoPorsegundo, int vida, int posX, int posY) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.alcance = alcance;
        this.nivel = nivel;
        this.nivelAparicion = nivelAparicion;
        this.espacios = espacios;
        this.danoPorSegundo = danoPorsegundo;
        this.vida = vida;
        this.posX = posX;
        this.posY = posY;
        this.activo = true;
        ArrayList<String> ataques = new ArrayList<String>();
    }
    
    public String toString(){
        return "Nombre: " + nombre + " X: " + posX + " Y: " + posY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public int getNivelAparicion() {
        return nivelAparicion;
    }

    public void setNivelAparicion(int nivelAparicion) {
        this.nivelAparicion = nivelAparicion;
    }

    public int getEspacios() {
        return espacios;
    }

    public void setEspacios(int espacios) {
        this.espacios = espacios;
    }

    public int getDanoPorSegundo() {
        return danoPorSegundo;
    }

    public void setDanoPorsegundo(int danoPorsegundo) {
        this.danoPorSegundo = danoPorsegundo;
    }

    public ArrayList<String> getAtaques() {
        return ataques;
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    
    
    public boolean isTraslape(Point punto,ArrayList<ThreadZombie> zombies,ArrayList<ThreadDefensa> defensas ){
        for (int i = 0; i < defensas.size(); i++) {
            ThreadDefensa defensa = defensas.get(i);
            if(defensa.getDefensa().getPosX() == punto.x && defensa.getDefensa().getPosY() == punto.y)
                return true;  
        }
        for (int i = 0; i < zombies.size(); i++) {
            ThreadZombie zombie = zombies.get(i);
            if(zombie.getZombie().getPosX() == punto.x && zombie.getZombie().getPosY() == punto.y)
                return true;  
        }
        return false;
    }
    
    public void printPoints(ArrayList<Point> puntos){
        for (int i = 0; i < puntos.size(); i++) {
            Point get = puntos.get(i);
            System.out.println(get.x + ", "+get.y);
        }
    }
    
    public ArrayList<Point> setPossibleMoves(int cant){
        ArrayList<Point> puntos = new ArrayList<Point>();
        puntos.add(new Point(this.posX+cant,this.posY));
        puntos.add(new Point(this.posX-cant,this.posY));
        puntos.add(new Point(this.posX,this.posY+cant));
        puntos.add(new Point(this.posX,this.posY-cant));
        puntos.add(new Point(this.posX+cant,this.posY+cant));
        puntos.add(new Point(this.posX-cant,this.posY+cant));
        puntos.add(new Point(this.posX-cant,this.posY-cant));
        puntos.add(new Point(this.posX+cant,this.posY-cant));

        Iterator<Point> iterator = puntos.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Point punto = iterator.next();
            if(punto.x < 0 || punto.x > 25){
                iterator.remove();
            }else if (punto.y < 0 || punto.y > 25){
                iterator.remove(); 
            }
        }
        return puntos;
    }
    
    public ArrayList<Point> getEsquinas(){
        ArrayList<Point> puntos = new ArrayList<Point>();
        puntos.add(new Point(this.posX-this.alcance, this.posY-this.alcance));
        puntos.add(new Point(this.posX+this.alcance, this.posY+this.alcance));
        for (int i = 0; i < puntos.size(); i++) {
            Point get = puntos.get(i);
            if(get.x < 0 )
                get.x = 0;
            if (get.x > 24)
                get.x = 24;
            if (get.y < 0)
                get.y = 0;
            if (get.y > 24)
                get.y = 24;
        }
        return puntos;
    }
    
    public boolean isDead(){
        return this.getVida() <= 0;
    }
    
    public void morir(){
        this.setPosX(-1);
        this.setPosY(-1);
    }
    
}


package TiposDefensas;

import Clases.Defensa;
import javax.swing.JLabel;

public class DefensaAtaqueMultiple extends Defensa {
    
    private int repeticiones;

    public DefensaAtaqueMultiple(JLabel label, String nombre, String tipo, int alcance, int nivel, int nivelAparicion, int espacios, int danoPorsegundo, int vida, int posX, int posY, int repeticiones) {
        super(label, nombre, tipo, alcance, nivel, nivelAparicion, espacios, danoPorsegundo, vida, posX, posY);
        this.repeticiones = repeticiones;
    }

    public int getRepeticiones() {
        return repeticiones;
    }
    
    
    
}

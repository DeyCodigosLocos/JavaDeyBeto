package GUI;

import TiposDefensas.DefensaAerea;
import Clases.*;
import TiposDefensas.*;
import TiposZombies.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;


public class CampoDeBatalla extends javax.swing.JFrame {
    int nivel;
    ArrayList<ThreadZombie> zombies;
    ArrayList<ThreadDefensa> defensas;
    ThreadDefensa tav;
    JLabel[][] matriz = new JLabel[25][25];
    
    
    public CampoDeBatalla() {
        zombies = new ArrayList<ThreadZombie>();
        defensas = new ArrayList<ThreadDefensa>();
        initComponents();
        generaMatriz();
        pintarZonaSegura();
        cambiarImagenDeBoton("imgs//arbolDeLaVida.png", btnColocarArbolDeVida);
        Defensa arbolVida = new Defensa(new JLabel(),"arbol", "", 0, 1, 1, 0, 0, 100, 0, 0);
        tav = new ThreadDefensa(arbolVida, this);
        this.nivel = 0;
        btnIniciarGuerra.setEnabled(false);
        
    }
    
    public void generarZombies(int size){
        for (int i = 0; i < size; i++) {
            //crea el label
            JLabel label =  new JLabel(""+i);
            label.setSize(25,25);
            label.setBackground(Color.WHITE);
            label.setOpaque(true);
            setAparicion(label);
            int tipoElegido = new Random().nextInt(4);
            Zombie zombie;
            switch (tipoElegido) {
                case 0:
                    zombie = new ZombieVolador(new JLabel(), "Alfredito", "AEREO", 2, 1, 1, 1, 2, 10, label.getLocation().x/25, label.getLocation().y/25);
                    break;
                case 1:
                    zombie = new ZombieChoque(new JLabel(), "Alfredito", "CHOQUE", 1, 1, 1, 1, 2, 10, label.getLocation().x/25, label.getLocation().y/25);
                    break;
                case 2:
                    zombie = new Zombie(new JLabel(), "Alfredito", "M_ALCANCE", 3, 1, 1, 1, 2, 10, label.getLocation().x/25, label.getLocation().y/25);
                    break;
                default:
                    zombie = new Zombie(new JLabel(), "Alfredito", "CONTACTO", 1, 1, 1, 1, 1, 10, label.getLocation().x/25, label.getLocation().y/25);
                    
            }
            
            zombie.setLabel(label);
            label.setText(zombie.getTipo()+"");
            // Crear el thread
            ThreadZombie tz =  new ThreadZombie(zombie, this);
            zombies.add(tz);
            label.addMouseListener(new MouseAdapter() {
                        @Override
                     public void mouseEntered(MouseEvent e) {
                         imprimirActividadZombie(tz);
                         label.setForeground(Color.RED);
                     }

                        @Override
                     public void mouseExited(MouseEvent e) {
                         quitarActividad();
                         label.setForeground(Color.BLACK);
                     }
            });
            pnlCampoJuego.add(label);
        } 
    }
    
    public void pintarZonaSegura(){
        for (int i = 4; i < 21; i++) 
            for (int j = 4; j < 21; j++){
                if(j%2 == 0)
                    matriz[i][j].setBackground(new Color(105, 255, 102));
                else
                    matriz[i][j].setBackground(new Color(153, 255, 152));
            }
    }
    
    //cambia el tamano de la imagen
    private static ImageIcon resizeGifIcon(ImageIcon originalIcon, int width, int height) {
        Image img = originalIcon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
    
    //Genera la matriz del campo de juego
    public void generaMatriz (){
        int posX, posY = 0;
        for (int i = 0; i < 25; i++){
            posX = 0;
            for (int j = 0; j < 25; j++){
                matriz[i][j] = new JLabel("");
                //matriz[i][j].setOpaque(true);
                matriz[i][j].setLayout(null);
                matriz[i][j].setSize(25,25);
                matriz[i][j].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
                pnlCampoJuego.add(matriz[i][j]);
                matriz[i][j].setLocation(posX, posY);
                posX += 25;
            }
            posY += 25;
        }
    }
    
    //posiciona aleatoriamente a los zombies
    public void setAparicion(JLabel label){
        int colOrRow = (new Random()).nextInt(2);//0: col  1: filas
        int dir = (new Random()).nextInt(2);//0: primera  1: segunda
        if (colOrRow == 0){
            if (dir == 0)
                label.setLocation((new Random()).nextInt(25)*25, 0);
            else
                label.setLocation((new Random()).nextInt(25)*25, 600);
        }else{
            if (dir == 0)
                label.setLocation(0, (new Random()).nextInt(25)*25);
            else
                label.setLocation(600, (new Random()).nextInt(25)*25);
        }         
    }
    
    //Cambia la imagen de un JLabel
    public void cambiarImagenDeLabel(String ruta,JLabel label){
        ImageIcon icon = new ImageIcon(ruta);
        icon = resizeGifIcon(icon, 32, 32);
        label.setIcon(icon);
        label.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
        label.setVerticalAlignment(JLabel.CENTER);
        GridBagLayout layout = new GridBagLayout();
        label.setLayout(layout);
        
        
    }
    
    //Cambia la imagen de un boton
    public void cambiarImagenDeBoton(String ruta,JButton btn){
        ImageIcon icon = new ImageIcon(ruta);
        icon = resizeGifIcon(icon, 85, 85);
        btn.setIcon(icon);
        btn.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
        btn.setVerticalAlignment(JLabel.CENTER);
        GridBagLayout layout = new GridBagLayout();
        btn.setLayout(layout);
        
    }
    
    
    public ThreadDefensa getTav() {
        return tav;
    }
    
    public ArrayList<ThreadZombie> getZombies() {
        return zombies;
    }

    public ArrayList<ThreadDefensa> getDefensas() {
        return defensas;
    }
    
    //Mueve un label a la posicion deseada
    public void moverLabel(int posX,int posY,JLabel label){
        label.setLocation(posX, posY);
    }
    
    //Revisa si la posX y posY, ya esta ocupada por algun personaje
    private boolean checkPosition(int posX,int posY){
        for (int i = 0; i < zombies.size(); i++) {
            ThreadZombie get = zombies.get(i);
            if (get.getZombie().getPosX() == posX && get.getZombie().getPosY() == posY)
                return false;
        }
        for (int i = 0; i < defensas.size(); i++) {
            ThreadDefensa get = defensas.get(i);
            if (get.getDefensa().getPosX() == posX && get.getDefensa().getPosY() == posY)
                return false;
        }
        if(tav.getDefensa().getPosX() == posX && tav.getDefensa().getPosY() == posY)
            return false;
        return true;
    }
    
    //Retorna true si el dato ingresado es un entero
    private boolean isInt(String dato){
        try {
            Integer.parseInt(dato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCampoJuego = new javax.swing.JPanel();
        btnIniciarGuerra = new javax.swing.JButton();
        txfPosX = new javax.swing.JTextField();
        txfPosY = new javax.swing.JTextField();
        btnColocarDefensa = new javax.swing.JButton();
        lblPosX = new javax.swing.JLabel();
        lblPosY = new javax.swing.JLabel();
        btnColocarArbolDeVida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaRegistroDeActividad = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlCampoJuego.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlCampoJuego.setOpaque(false);
        pnlCampoJuego.setPreferredSize(new java.awt.Dimension(625, 625));
        pnlCampoJuego.setLayout(null);

        btnIniciarGuerra.setText("Iniciar");
        btnIniciarGuerra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarGuerraActionPerformed(evt);
            }
        });

        txfPosY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfPosYActionPerformed(evt);
            }
        });

        btnColocarDefensa.setText("Colocar");
        btnColocarDefensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColocarDefensaActionPerformed(evt);
            }
        });

        lblPosX.setText("X:");

        lblPosY.setText("Y:");

        btnColocarArbolDeVida.setText("Colocar Arbol");
        btnColocarArbolDeVida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColocarArbolDeVidaActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 255, 153));
        jLabel1.setText("jLabel1");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });

        txaRegistroDeActividad.setBackground(new java.awt.Color(255, 255, 255));
        txaRegistroDeActividad.setColumns(20);
        txaRegistroDeActividad.setForeground(new java.awt.Color(0, 0, 0));
        txaRegistroDeActividad.setRows(5);
        jScrollPane1.setViewportView(txaRegistroDeActividad);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pnlCampoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnColocarArbolDeVida, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIniciarGuerra, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnColocarDefensa)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblPosX, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txfPosX, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                                    .addComponent(txfPosY)))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIniciarGuerra, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1)
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfPosX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPosX, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jScrollPane1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnColocarDefensa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnColocarArbolDeVida, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(pnlCampoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton para iniciar la guerra
    private void btnIniciarGuerraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarGuerraActionPerformed
        generarZombies(nivel*5+20);
        for (int i = 0; i < zombies.size(); i++) {
            ThreadZombie get = zombies.get(i);
            get.start();
        }
        for (int i = 0; i < defensas.size(); i++) {
            ThreadDefensa get = defensas.get(i);
            get.start();
        }
        btnIniciarGuerra.setEnabled(false);
    }//GEN-LAST:event_btnIniciarGuerraActionPerformed
    
    //Boton para colocar una defensa en el campo de juego
    private void btnColocarDefensaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColocarDefensaActionPerformed
        if (isInt(txfPosX.getText()) && isInt(txfPosY.getText())){
            int posX = Integer.parseInt(txfPosX.getText());
            int posY = Integer.parseInt(txfPosY.getText());
            if(posX >= 4 && posX < 21 && posY >= 4 && posY < 21){
                if(checkPosition(posX, posY)){
                    String tipoElegido = "CONTACTO";
                    Defensa defensa;
                    switch (tipoElegido) {
                        case "AEREO":
                            defensa = new DefensaAerea(new JLabel(), "Fortin", "AEREO", 2, 1, 1, 1, 2, 1000, posX, posY);
                            break;
                        case "IMPACTO":
                            defensa = new DefensaImpacto(new JLabel(), "Fortin", "IMPACTO", 2, 1, 1, 1, 2, 1000, posX, posY);
                            break;
                        case "MULTIPLE":
                            defensa = new DefensaAtaqueMultiple(new JLabel(), "Fortin", "MULTIPLE", 2, 1, 1, 1, 2, 1000, posX, posY, 10);
                            break;
                        case "CONTACTO":
                            defensa = new DefensaAtaqueMultiple(new JLabel(), "Fortin", "CONTACTO", 1, 1, 1, 1, 2, 1000, posX, posY, 10);
                            break;
                        case "ALCANCE" :
                            defensa = new DefensaAtaqueMultiple(new JLabel(), "Fortin", "MULTIPLE", 3, 1, 1, 1, 2, 1000, posX, posY, 10);
                            break;
                       default :
                            defensa = new Defensa(new JLabel(), "Fortin", "BLOQUE", 0, 1, 1, 1, 0, 1000, posX, posY);
                        
                    }
                    System.out.println(posX + ", " + posY);
                    JLabel label = new JLabel(defensa.getNivel()+ "");
                    label.setSize(25,25);
                    label.setBackground(Color.BLUE);
                    label.setLocation(posX*25, posY*25);
                    label.setVisible(true);
                    label.addMouseListener(new MouseAdapter() {
                                @Override
                             public void mouseEntered(MouseEvent e) {
                                 imprimirActividadDefensa(tav);
                                 label.setForeground(Color.RED);
                             }

                                @Override
                             public void mouseExited(MouseEvent e) {
                                 quitarActividad();
                                 label.setForeground(Color.BLACK);
                             }
                    });

                    defensa.setLabel(label);

                    ThreadDefensa td = new ThreadDefensa(defensa, this);
                    defensas.add(td);
                    pnlCampoJuego.add(label);
                    label.setText(defensa.getVida()+"");
                    //cambiarImagenDeLabel("imgs//defensa1.png", label); 
                }else
                    JOptionPane.showMessageDialog(pnlCampoJuego, "Error: " + posX + "," + posY + " posicion en uso", "Error", JOptionPane.ERROR_MESSAGE);
            }else
                JOptionPane.showMessageDialog(pnlCampoJuego, "Error, no se puede colocar una defensa en " + posX + "," + posY, "Error", JOptionPane.ERROR_MESSAGE);
        }else
             JOptionPane.showMessageDialog(pnlCampoJuego, "Error, debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnColocarDefensaActionPerformed

    private void txfPosYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPosYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPosYActionPerformed
    
    //Boton para colocar el arbol de la vida
    private void btnColocarArbolDeVidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColocarArbolDeVidaActionPerformed
        if (isInt(txfPosX.getText()) && isInt(txfPosY.getText())){
            int posX = Integer.parseInt(txfPosX.getText());
            int posY = Integer.parseInt(txfPosY.getText());
            if(posX >= 4 && posX < 21 && posY >= 4 && posY < 21){
                if(checkPosition(posX, posY)){
                    tav.getDefensa().setPosX(posX);
                    tav.getDefensa().setPosY(posY);
                    System.out.println(posX + ", " + posY);
                    JLabel label = new JLabel(tav.getDefensa().getNivel()+ "");
                    label.setSize(25,25);
                    label.setBackground(Color.BLUE);
                    label.setLocation(posX*25, posY*25);
                    label.setVisible(true); 
                    label.setText(tav.getDefensa().getVida()+"");
                    label.addMouseListener(new MouseAdapter() {
                                @Override
                             public void mouseEntered(MouseEvent e) {
                                 imprimirActividadDefensa(tav);
                                 label.setForeground(Color.RED);
                             }

                                @Override
                             public void mouseExited(MouseEvent e) {
                                 quitarActividad();
                                 label.setForeground(Color.BLACK);
                             }
                    });
                    tav.getDefensa().setLabel(label);
                    pnlCampoJuego.add(label);
                    label.setText(tav.getDefensa().getVida()+"");
                    cambiarImagenDeBoton("imgs//arbolDeLaVida.png", btnColocarArbolDeVida); 
                    defensas.add(tav);
                    //cambiarImagenDeLabel("imgs//arbolDeLaVida.png", label);
                    btnIniciarGuerra.setEnabled(true);
                }else
                    JOptionPane.showMessageDialog(pnlCampoJuego, "Error: " + posX + "," + posY + " posicion en uso", "Error", JOptionPane.ERROR_MESSAGE);
            }else
                JOptionPane.showMessageDialog(pnlCampoJuego, "Error, no se puede colocar una defensa en " + posX + "," + posY, "Error", JOptionPane.ERROR_MESSAGE);
        }else
             JOptionPane.showMessageDialog(pnlCampoJuego, "Error, debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnColocarArbolDeVidaActionPerformed

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseEntered
    
    //Funcion para imprimir la actividad de ataque en un text area
    public void imprimirActividadDefensa(ThreadDefensa defensa){
        for (int i = 0; i < defensa.getDefensa().getAtaques().size(); i++) {
            txaRegistroDeActividad.append(defensa.getDefensa().getAtaques().get(i)+"\n");
            System.out.println(defensa.getDefensa().getAtaques().get(i)+"\n");
        }
    }
    
    //Funcion para imprimir la actividad de ataque en un text area
    public void imprimirActividadZombie(ThreadZombie zombie){
        for (int i = 0; i < zombie.getZombie().getAtaques().size(); i++) {
            txaRegistroDeActividad.append(zombie.getZombie().getAtaques().get(i)+"\n");
            System.out.println(zombie.getZombie().getAtaques().get(i)+"\n");
        }
    }
    
    //Quita todo el registro de actividad del text are
    public void quitarActividad(){
        txaRegistroDeActividad.removeAll();
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CampoDeBatalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColocarArbolDeVida;
    private javax.swing.JButton btnColocarDefensa;
    private javax.swing.JButton btnIniciarGuerra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPosX;
    private javax.swing.JLabel lblPosY;
    private javax.swing.JPanel pnlCampoJuego;
    private javax.swing.JTextArea txaRegistroDeActividad;
    private javax.swing.JTextField txfPosX;
    private javax.swing.JTextField txfPosY;
    // End of variables declaration//GEN-END:variables
}

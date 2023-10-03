
package GUI;

import Clases.*;
import Clases.Zombie;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;


public class CampoDeBatalla extends javax.swing.JFrame {
    int nivel;
    ArrayList<ThreadZombie> zombies;
    ArrayList<ThreadDefensa> defensas;
    JLabel[][] matriz = new JLabel[25][25];
    
    
    public CampoDeBatalla() {
        zombies = new ArrayList<ThreadZombie>();
        defensas = new ArrayList<ThreadDefensa>();
        initComponents();
        generaMatriz();
        
        
        this.nivel = 0;
        
    }
    
    public void generarZombies(int size){
        for (int i = 0; i < size; i++) {
            //crea el label
            
            JLabel label =  new JLabel(""+i);
            label.setSize(25,25);
            label.setBackground(Color.BLUE);
            setAparicion(label);
            // crear el zombie aleatoriamente, del tipo que corresponda
            Zombie zombie = new Zombie(label, "alfredito", "contacto", 12, 1, 1, 1, 1, 1, label.getLocation().x/25, label.getLocation().y/25, false);
            zombie.setLabel(label);
            
            // Crear el thread
            ThreadZombie tz =  new ThreadZombie(zombie, this);
            zombies.add(tz);
            pnlCampoJuego.add(label);
            cambiarImagen("imgs//zombie1.png", label);
        } 
    }
    
    private static ImageIcon resizeGifIcon(ImageIcon originalIcon, int width, int height) {
        Image img = originalIcon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
    
    public void generaMatriz (){
        int posX, posY = 0;
        for (int i = 0; i < 25; i++){
            posX = 0;
            for (int j = 0; j < 25; j++){
                matriz[i][j] = new JLabel("");
                matriz[i][j].setSize(25,25);
                matriz[i][j].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
                pnlCampoJuego.add(matriz[i][j]);
                matriz[i][j].setLocation(posX, posY);
                posX += 25;
            }
            posY += 25;
        }
    }
    
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
    
    void cambiarImagen(String ruta,JLabel label){
        ImageIcon icon = new ImageIcon(ruta);
        icon = resizeGifIcon(icon, 32, 32);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        GridBagLayout layout = new GridBagLayout();
        label.setLayout(layout);
        
    }
    
    public void moverLabel(int posX,int posY,JLabel label){
        label.setLocation(posX, posY);
    }

    public ArrayList<ThreadZombie> getZombies() {
        return zombies;
    }

    public ArrayList<ThreadDefensa> getDefensas() {
        return defensas;
    }
    
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
        return true;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlCampoJuego.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlCampoJuego.setPreferredSize(new java.awt.Dimension(625, 625));

        javax.swing.GroupLayout pnlCampoJuegoLayout = new javax.swing.GroupLayout(pnlCampoJuego);
        pnlCampoJuego.setLayout(pnlCampoJuegoLayout);
        pnlCampoJuegoLayout.setHorizontalGroup(
            pnlCampoJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );
        pnlCampoJuegoLayout.setVerticalGroup(
            pnlCampoJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pnlCampoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIniciarGuerra, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPosX, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnColocarDefensa)
                            .addComponent(txfPosX, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(txfPosY))))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIniciarGuerra, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfPosX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPosX, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnColocarDefensa))
                    .addComponent(pnlCampoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarGuerraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarGuerraActionPerformed
        generarZombies(nivel*5+20);
        for (int i = 0; i < zombies.size(); i++) {
            ThreadZombie get = zombies.get(i);
            get.start();   
        }
        btnIniciarGuerra.setEnabled(false);
    }//GEN-LAST:event_btnIniciarGuerraActionPerformed

    private void btnColocarDefensaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColocarDefensaActionPerformed
        int posX = Integer.parseInt(txfPosX.getText());
        int posY = Integer.parseInt(txfPosY.getText());
        if(posX >= 0 && posX < 25 && posY >= 0 && posY < 25){
            if(checkPosition(posX, posY)){
                System.out.println(posX + ", " + posY);
                JLabel label = new JLabel(posX + ", " + posY);
                label.setSize(25,25);
                label.setBackground(Color.BLUE);
                label.setLocation(posX*25, posY*25);
                
                Defensa defensa = new Defensa(new JLabel(), "alfredito", "contacto", 12, 1, 1, 1, 1, 1, label.getLocation().x/25, label.getLocation().y/25, true);
                defensa.setLabel(label);

                ThreadDefensa td = new ThreadDefensa(defensa, this);
                defensas.add(td);
                pnlCampoJuego.add(label);
                cambiarImagen("imgs//defensa1.png", label);
                label.setVisible(true); 
            }    
        }
    }//GEN-LAST:event_btnColocarDefensaActionPerformed

    private void txfPosYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPosYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPosYActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CampoDeBatalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CampoDeBatalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CampoDeBatalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CampoDeBatalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CampoDeBatalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColocarDefensa;
    private javax.swing.JButton btnIniciarGuerra;
    private javax.swing.JLabel lblPosX;
    private javax.swing.JLabel lblPosY;
    private javax.swing.JPanel pnlCampoJuego;
    private javax.swing.JTextField txfPosX;
    private javax.swing.JTextField txfPosY;
    // End of variables declaration//GEN-END:variables
}

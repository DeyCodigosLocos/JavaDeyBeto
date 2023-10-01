
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
    JLabel[][] matriz = new JLabel[25][25];
    
    
    public CampoDeBatalla() {
        zombies = new ArrayList<ThreadZombie>();
        initComponents();
        generaMatriz();
        
        this.nivel = 0;
        
    }
    
    public void generarZombies(int size){
        for (int i = 0; i < size; i++) {
            //crea el label
            JLabel label =  new JLabel("100");
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
            
            cambiarImagen("C:\\Users\\X\\Desktop\\zombie1.png", label);

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
        icon = resizeGifIcon(icon, 25, 25);
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        GridBagLayout layout = new GridBagLayout();
        label.setLayout(layout);
        
    }
    
    public void moverLabel(int posX,int posY,JLabel label){
        label.setLocation(posX, posY);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCampoJuego = new javax.swing.JPanel();
        btnIniciarGuerra = new javax.swing.JButton();
        lblTest = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlCampoJuego.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlCampoJuego.setPreferredSize(new java.awt.Dimension(625, 625));

        javax.swing.GroupLayout pnlCampoJuegoLayout = new javax.swing.GroupLayout(pnlCampoJuego);
        pnlCampoJuego.setLayout(pnlCampoJuegoLayout);
        pnlCampoJuegoLayout.setHorizontalGroup(
            pnlCampoJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );
        pnlCampoJuegoLayout.setVerticalGroup(
            pnlCampoJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );

        btnIniciarGuerra.setText("Iniciar");
        btnIniciarGuerra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarGuerraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pnlCampoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnIniciarGuerra, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblTest, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIniciarGuerra, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(lblTest, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlCampoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
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
    private javax.swing.JButton btnIniciarGuerra;
    private javax.swing.JLabel lblTest;
    private javax.swing.JPanel pnlCampoJuego;
    // End of variables declaration//GEN-END:variables
}

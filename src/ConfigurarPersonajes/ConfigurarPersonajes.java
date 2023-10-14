package ConfigurarPersonajes;

import Clases.*;
import TiposDefensas.DefensaAerea;
import TiposDefensas.DefensaAtaqueMultiple;
import TiposDefensas.DefensaImpacto;
import TiposZombies.ZombieChoque;
import TiposZombies.ZombieVolador;
import filemanager.FileManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ConfigurarPersonajes extends javax.swing.JFrame {
    String cantidadAtaques;
    public ConfigurarPersonajes() {
        initComponents();
        cmbTipoDeDefensa.setVisible(false);
        cantidadAtaques = "";
        this.setLocationRelativeTo(null);
        ImageIcon icono = new ImageIcon("imgs//zombie.png");
        this.setIconImage(icono.getImage());
        cmbTipoDePersonaje.setSelectedIndex(0);
        cmbTipoDeZombie.setSelectedIndex(0);
    }

    private boolean checkInputs(){
        if(isInt(txfVidaPersonaje.getText()) && isInt(txfDanoPersonaje.getText()))
            if(isInt(txfEspacioPersonaje.getText()) && isInt(txfNivelAparicionPersonaje.getText()))
                if(isInt(txfAlcancePersonaje.getText()))
                    return true;
        return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCreandoPersonaje = new javax.swing.JLabel();
        cmbTipoDePersonaje = new javax.swing.JComboBox<>();
        lblNivelAparicionPersonaje = new javax.swing.JLabel();
        txfEspacioPersonaje = new javax.swing.JTextField();
        lblImagenPersonaje = new javax.swing.JLabel();
        txfImagenPersonaje = new javax.swing.JTextField();
        lblVidaPersonaje = new javax.swing.JLabel();
        txfVidaPersonaje = new javax.swing.JTextField();
        lblDanoPersonaje1 = new javax.swing.JLabel();
        txfDanoPersonaje = new javax.swing.JTextField();
        lblDanoPersonaje2 = new javax.swing.JLabel();
        txfAlcancePersonaje = new javax.swing.JTextField();
        lblNombrePersonaje = new javax.swing.JLabel();
        txfNombrePersonaje = new javax.swing.JTextField();
        cmbTipoDeZombie = new javax.swing.JComboBox<>();
        lblTipoPersonaje = new javax.swing.JLabel();
        cmbTipoDeDefensa = new javax.swing.JComboBox<>();
        lblAlcancePersonaje = new javax.swing.JLabel();
        txfNivelAparicionPersonaje = new javax.swing.JTextField();
        btnCrearPersonaje = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblCreandoPersonaje.setText("Creando:");

        cmbTipoDePersonaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Zombie", "Defensa" }));
        cmbTipoDePersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoDePersonajeActionPerformed(evt);
            }
        });

        lblNivelAparicionPersonaje.setText("Nivel De Aparicion:");

        txfEspacioPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfEspacioPersonajeActionPerformed(evt);
            }
        });

        lblImagenPersonaje.setText("Imagen:");

        txfImagenPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfImagenPersonajeActionPerformed(evt);
            }
        });

        lblVidaPersonaje.setText("Vida:");

        txfVidaPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfVidaPersonajeActionPerformed(evt);
            }
        });

        lblDanoPersonaje1.setText("Daño del ataque:");

        txfDanoPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfDanoPersonajeActionPerformed(evt);
            }
        });

        lblDanoPersonaje2.setText("Espacio:");

        txfAlcancePersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfAlcancePersonajeActionPerformed(evt);
            }
        });

        lblNombrePersonaje.setText("Nombre:");

        txfNombrePersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombrePersonajeActionPerformed(evt);
            }
        });

        cmbTipoDeZombie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contacto", "Medio Alcance", "Aereo", "Choque" }));
        cmbTipoDeZombie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoDeZombieActionPerformed(evt);
            }
        });

        lblTipoPersonaje.setText("Tipo:");

        cmbTipoDeDefensa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contacto", "Mediano Alcance", "Aereo", "Impacto", "Ataque Multiple", "Bloque" }));
        cmbTipoDeDefensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoDeDefensaActionPerformed(evt);
            }
        });

        lblAlcancePersonaje.setText("Alcance:");

        txfNivelAparicionPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNivelAparicionPersonajeActionPerformed(evt);
            }
        });

        btnCrearPersonaje.setText("Crear Personaje");
        btnCrearPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPersonajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAlcancePersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCreandoPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblVidaPersonaje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblImagenPersonaje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblNombrePersonaje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                                        .addComponent(lblDanoPersonaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblDanoPersonaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTipoPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(13, 13, 13))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lblNivelAparicionPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbTipoDeZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTipoDeDefensa, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txfVidaPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfDanoPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfEspacioPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfImagenPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfAlcancePersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipoDePersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfNombrePersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfNivelAparicionPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnCrearPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCreandoPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoDePersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoDeZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoDeDefensa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombrePersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNombrePersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImagenPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfImagenPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVidaPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfVidaPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDanoPersonaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfDanoPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDanoPersonaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfEspacioPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNivelAparicionPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNivelAparicionPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlcancePersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfAlcancePersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCrearPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoDePersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoDePersonajeActionPerformed
        if(cmbTipoDePersonaje.getSelectedIndex() == 0){
            cmbTipoDeDefensa.setVisible(false);
            cmbTipoDeZombie.setVisible(true);
            cmbTipoDeZombie.setLocation(160, 64);
            
        }else{
            cmbTipoDeZombie.setVisible(false);
            cmbTipoDeDefensa.setVisible(true);
            cmbTipoDeDefensa.setLocation(160, 64);
            txfEspacioPersonaje.setEnabled(true);
            txfEspacioPersonaje.setText("");
        }     
    }//GEN-LAST:event_cmbTipoDePersonajeActionPerformed

    private void txfEspacioPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfEspacioPersonajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEspacioPersonajeActionPerformed

    private void txfImagenPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfImagenPersonajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfImagenPersonajeActionPerformed

    private void txfVidaPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfVidaPersonajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfVidaPersonajeActionPerformed

    private void txfDanoPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfDanoPersonajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfDanoPersonajeActionPerformed

    private void txfAlcancePersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfAlcancePersonajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfAlcancePersonajeActionPerformed

    private void txfNombrePersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombrePersonajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombrePersonajeActionPerformed

    private void cmbTipoDeZombieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoDeZombieActionPerformed
        if (cmbTipoDeZombie.getSelectedIndex() == 0 || cmbTipoDeZombie.getSelectedIndex() == 3 ){
            txfAlcancePersonaje.setEnabled(false);
            txfAlcancePersonaje.setText("1");
        }else{
            txfAlcancePersonaje.setEnabled(true);
            txfAlcancePersonaje.setText("");
        }
    }//GEN-LAST:event_cmbTipoDeZombieActionPerformed

    private void cmbTipoDeDefensaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoDeDefensaActionPerformed
        
        if(cmbTipoDeDefensa.getSelectedIndex() == 5){
            txfAlcancePersonaje.setEnabled(false);
            txfAlcancePersonaje.setText("0");
            txfDanoPersonaje.setEnabled(false);
            txfDanoPersonaje.setText("0");
            
        }else{
            txfDanoPersonaje.setEnabled(true);
            txfDanoPersonaje.setText("");
            txfAlcancePersonaje.setEnabled(true);
            txfAlcancePersonaje.setText("");
        }
        if (cmbTipoDeDefensa.getSelectedIndex() == 0 || cmbTipoDeDefensa.getSelectedIndex() == 3 ){
            txfAlcancePersonaje.setEnabled(false);
            txfAlcancePersonaje.setText("1");
        }else{
            txfAlcancePersonaje.setEnabled(true);
            txfAlcancePersonaje.setText("");
        }
        if(cmbTipoDeDefensa.getSelectedIndex() == 4){
            this.cantidadAtaques = JOptionPane.showInputDialog("Cuantos disparos lanza por segundo: ");
            if (!isInt(cantidadAtaques)){
                JOptionPane.showMessageDialog(null, "Error, el dato tiene que ser entero", "Error", JOptionPane.ERROR_MESSAGE);
                cantidadAtaques = "";
            }
        }
        
        
    }//GEN-LAST:event_cmbTipoDeDefensaActionPerformed
    
    private boolean isInt(String dato){
        try {
            Integer.parseInt(dato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private void txfNivelAparicionPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNivelAparicionPersonajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNivelAparicionPersonajeActionPerformed

    private void btnCrearPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPersonajeActionPerformed
        if (checkInputs()){
            System.out.println("hola");
            if (cmbTipoDePersonaje.getSelectedIndex() == 0){
                if(cmbTipoDeZombie.getSelectedIndex() == 0){
                    Zombie zombie = new Zombie(txfImagenPersonaje.getText(),new JLabel(), txfNombrePersonaje.getText(), "CONTACTO",1, 1, Integer.parseInt(txfNivelAparicionPersonaje.getText()), Integer.parseInt(txfEspacioPersonaje.getText()), Integer.parseInt(txfDanoPersonaje.getText()), Integer.parseInt(txfVidaPersonaje.getText()), 0, 0);
                    FileManager.writeObject(zombie, "Zombies//" + zombie.getNombre()+".txt");
                }else if(cmbTipoDeZombie.getSelectedIndex() == 1){
                    Zombie zombie = new Zombie(txfImagenPersonaje.getText(),new JLabel(), txfNombrePersonaje.getText(), "M_ALCANCE",Integer.parseInt(txfAlcancePersonaje.getText()), 1, Integer.parseInt(txfNivelAparicionPersonaje.getText()), Integer.parseInt(txfEspacioPersonaje.getText()), Integer.parseInt(txfDanoPersonaje.getText()), Integer.parseInt(txfVidaPersonaje.getText()), 0, 0);
                    FileManager.writeObject(zombie, "Zombies//" + zombie.getNombre()+".txt");
                }else if(cmbTipoDeZombie.getSelectedIndex() == 2){
                    Zombie zombie = new ZombieVolador(txfImagenPersonaje.getText(),new JLabel(), txfNombrePersonaje.getText(), "AEREO",Integer.parseInt(txfAlcancePersonaje.getText()), 1, Integer.parseInt(txfNivelAparicionPersonaje.getText()), Integer.parseInt(txfEspacioPersonaje.getText()), Integer.parseInt(txfDanoPersonaje.getText()), Integer.parseInt(txfVidaPersonaje.getText()), 0, 0);
                    FileManager.writeObject(zombie, "Zombies//" + zombie.getNombre()+".txt");
                }else {
                    Zombie zombie = new ZombieChoque(txfImagenPersonaje.getText(),new JLabel(), txfNombrePersonaje.getText(), "CHOQUE",Integer.parseInt(txfAlcancePersonaje.getText()), 1, Integer.parseInt(txfNivelAparicionPersonaje.getText()), Integer.parseInt(txfEspacioPersonaje.getText()), Integer.parseInt(txfDanoPersonaje.getText()), Integer.parseInt(txfVidaPersonaje.getText()), 0, 0);
                    FileManager.writeObject(zombie, "Zombies//" + zombie.getNombre()+".txt");
                }
                JOptionPane.showMessageDialog(null, txfNombrePersonaje.getText()+" ha sido creado", "Personaje Creado", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if(cmbTipoDeDefensa.getSelectedIndex() == 0){
                    Defensa defensa = new Defensa(txfImagenPersonaje.getText(),new JLabel(), txfNombrePersonaje.getText(), "CONTACTO",1, 1, Integer.parseInt(txfNivelAparicionPersonaje.getText()), Integer.parseInt(txfEspacioPersonaje.getText()), Integer.parseInt(txfDanoPersonaje.getText()), Integer.parseInt(txfVidaPersonaje.getText()), 0, 0);
                    FileManager.writeObject(defensa, "Defensas//" + defensa.getNombre()+".txt");
                }else if(cmbTipoDeDefensa.getSelectedIndex() == 1){
                    Defensa defensa = new Defensa(txfImagenPersonaje.getText(),new JLabel(), txfNombrePersonaje.getText(), "M_ALCANCE",Integer.parseInt(txfAlcancePersonaje.getText()), 1, Integer.parseInt(txfNivelAparicionPersonaje.getText()), Integer.parseInt(txfEspacioPersonaje.getText()), Integer.parseInt(txfDanoPersonaje.getText()), Integer.parseInt(txfVidaPersonaje.getText()), 0, 0);
                    FileManager.writeObject(defensa, "Defensas//" + defensa.getNombre()+".txt");
                }else if(cmbTipoDeDefensa.getSelectedIndex() == 2){
                    Defensa defensa = new DefensaAerea(txfImagenPersonaje.getText(),new JLabel(), txfNombrePersonaje.getText(), "AEREO",Integer.parseInt(txfAlcancePersonaje.getText()), 1, Integer.parseInt(txfNivelAparicionPersonaje.getText()), Integer.parseInt(txfEspacioPersonaje.getText()), Integer.parseInt(txfDanoPersonaje.getText()), Integer.parseInt(txfVidaPersonaje.getText()), 0, 0);
                    FileManager.writeObject(defensa, "Defensas//" + defensa.getNombre()+".txt");
                }else if(cmbTipoDeDefensa.getSelectedIndex() == 3){
                    Defensa defensa = new DefensaImpacto(txfImagenPersonaje.getText(),new JLabel(), txfNombrePersonaje.getText(), "IMPACTO",Integer.parseInt(txfAlcancePersonaje.getText()), 1, Integer.parseInt(txfNivelAparicionPersonaje.getText()), Integer.parseInt(txfEspacioPersonaje.getText()), Integer.parseInt(txfDanoPersonaje.getText()), Integer.parseInt(txfVidaPersonaje.getText()), 0, 0);
                    FileManager.writeObject(defensa, "Defensas//" + defensa.getNombre()+".txt");
                }else if(cmbTipoDeDefensa.getSelectedIndex() == 4){
                    Defensa defensa = new DefensaAtaqueMultiple(txfImagenPersonaje.getText(),new JLabel(), txfNombrePersonaje.getText(), "A_MULTIPLE",Integer.parseInt(txfAlcancePersonaje.getText()), 1, Integer.parseInt(txfNivelAparicionPersonaje.getText()), Integer.parseInt(txfEspacioPersonaje.getText()), Integer.parseInt(txfDanoPersonaje.getText()), Integer.parseInt(txfVidaPersonaje.getText()), 0, 0,Integer.parseInt(cantidadAtaques));
                    FileManager.writeObject(defensa, "Defensas//" + defensa.getNombre()+".txt");
                }else {
                    Defensa defensa = new Defensa(txfImagenPersonaje.getText(),new JLabel(), txfNombrePersonaje.getText(), "BLOQUE",0, 1, Integer.parseInt(txfNivelAparicionPersonaje.getText()), Integer.parseInt(txfEspacioPersonaje.getText()), 0, Integer.parseInt(txfVidaPersonaje.getText()), 0, 0);
                    FileManager.writeObject(defensa, "Defensas//" + defensa.getNombre()+".txt");
                }
                JOptionPane.showMessageDialog(null, txfNombrePersonaje.getText()+" ha sido creado", "Personaje Creado", JOptionPane.INFORMATION_MESSAGE);
            }
        }else
            JOptionPane.showMessageDialog(null, "Error, los datos tiene que ser enteros", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnCrearPersonajeActionPerformed


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
            java.util.logging.Logger.getLogger(ConfigurarPersonajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigurarPersonajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigurarPersonajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigurarPersonajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfigurarPersonajes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearPersonaje;
    private javax.swing.JComboBox<String> cmbTipoDeDefensa;
    private javax.swing.JComboBox<String> cmbTipoDePersonaje;
    private javax.swing.JComboBox<String> cmbTipoDeZombie;
    private javax.swing.JLabel lblAlcancePersonaje;
    private javax.swing.JLabel lblCreandoPersonaje;
    private javax.swing.JLabel lblDanoPersonaje1;
    private javax.swing.JLabel lblDanoPersonaje2;
    private javax.swing.JLabel lblImagenPersonaje;
    private javax.swing.JLabel lblNivelAparicionPersonaje;
    private javax.swing.JLabel lblNombrePersonaje;
    private javax.swing.JLabel lblTipoPersonaje;
    private javax.swing.JLabel lblVidaPersonaje;
    private javax.swing.JTextField txfAlcancePersonaje;
    private javax.swing.JTextField txfDanoPersonaje;
    private javax.swing.JTextField txfEspacioPersonaje;
    private javax.swing.JTextField txfImagenPersonaje;
    private javax.swing.JTextField txfNivelAparicionPersonaje;
    private javax.swing.JTextField txfNombrePersonaje;
    private javax.swing.JTextField txfVidaPersonaje;
    // End of variables declaration//GEN-END:variables
}

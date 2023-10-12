package GUI;

import TiposDefensas.DefensaAerea;
import Clases.*;
import TiposDefensas.*;
import TiposZombies.*;
import filemanager.FileManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;


public class CampoDeBatalla extends javax.swing.JFrame {
    int nivel;
    boolean arbolColocado;
    ArrayList<ThreadZombie> zombies;
    ArrayList<ThreadDefensa> defensas;
    ThreadDefensa tav;
    ThreadInGame tig;
    JLabel[][] matriz = new JLabel[25][25];
    ArrayList<Defensa> personajeDefensa;
    ArrayList<Zombie> personajeZombie;
    Defensa defensaParaColocar;
    
    public CampoDeBatalla(){
        arbolColocado = false;
        zombies = new ArrayList<ThreadZombie>();
        defensas = new ArrayList<ThreadDefensa>();
        personajeZombie = new ArrayList<Zombie>();
        personajeDefensa = new ArrayList<Defensa>();
        initComponents();
        generaMatriz();
        pintarZonaSegura();
        Defensa arbolVida = new Defensa("imgs//arbolDeLaVida.png",new JLabel(),"arbol", "CONTACTO", 0, 1, 1, 0, 0, 100, 0, 0);
        tav = new ThreadDefensa(arbolVida, this);
        this.nivel = 1;
        btnIniciarGuerra.setEnabled(false);
        cargarZombies();
        cargarDefensas();
        personajeDefensa.add(arbolVida);
        defensaParaColocar = null;
        tig = new ThreadInGame(this);
        refreshDefensesListBox(personajeDefensa);
    }
    
    public ThreadDefensa buscarDefensa(int posX,int posY){
        for (int i = 0; i < defensas.size(); i++) {
            ThreadDefensa get = defensas.get(i);
            if (get.getDefensa().getPosX() == posX && get.getDefensa().getPosY() == posY)
                return get;
        }
        return null;
    }
    
    //Detiene todos los threads del campo de juego
    public void stopThreads(){
        for (int i = 0; i < zombies.size(); i++) {
           pnlCampoJuego.remove(zombies.get(i).getZombie().getLabel());
           pnlCampoJuego.revalidate();
           pnlCampoJuego.repaint();
           zombies.get(i).setIsRunning(false);
        }
        for (int i = 0; i < defensas.size(); i++) {
           pnlCampoJuego.remove(defensas.get(i).getDefensa().getLabel());
           pnlCampoJuego.revalidate();
           pnlCampoJuego.repaint();
           zombies.get(i).setIsRunning(false);
        }
    }
    
    //Funcion que carga todos las defensas que se crearon
    private void cargarDefensas(){
        System.out.println("");
        File carpeta = new File("Defensas");
        if (carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile()) {
                        System.out.println(archivo.getName());
                        Defensa defensa = ((Defensa)FileManager.readObject("Defensas//"+archivo.getName()));
                        if (defensa == null)
                            System.out.println("me cago en las defensas");
                        else{
                            personajeDefensa.add(defensa);
                        }
                            
                            
                    }
                }
            }
        }else{
            System.out.println("La ruta especificada no es una carpeta.");
        }
    }
    
    //Funcion que carga todos los zombies que se crearon
    private void cargarZombies(){
        System.out.println("");
        File carpeta = new File("Zombies");
        if (carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile()) {
                        System.out.println(archivo.getName());
                        Zombie zombie = (Zombie)FileManager.readObject("Zombies//" + archivo.getName());
                        
                        if (zombie != null)
                            System.out.println("me cago en los zombies");
                        personajeZombie.add(zombie);
                    }
                }
            }
        } else {
            System.out.println("La ruta especificada no es una carpeta.");
        }
    }
    
    //Genera aleatoriamente los zombies en el campo de batalla
    public void generarZombies(int size){
        for (int i = 0; i < size; i++) {
            //crea el label
            JLabel label =  new JLabel(""+i);
            label.setSize(25,25);
            label.setBackground(Color.WHITE);
            label.setOpaque(true);
            setAparicion(label);
            String tipoElegido;
            Zombie zombie = personajeZombie.get(new Random().nextInt(personajeZombie.size()));
            tipoElegido = zombie.getTipo();
            switch (tipoElegido) {
                case "AEREO":
                    zombie = new ZombieVolador("hola",new JLabel(), zombie.getNombre(), "AEREO", zombie.getAlcance(), 1, zombie.getNivelAparicion(), zombie.getEspacios(), zombie.getDanoPorSegundo(), zombie.getVida(), label.getLocation().x/25, label.getLocation().y/25);
                    break;
                case "CHOQUE":
                    zombie = new ZombieChoque("hola",new JLabel(), zombie.getNombre(), "CHOQUE", 1, 1, zombie.getNivelAparicion(), zombie.getEspacios(), zombie.getDanoPorSegundo(), zombie.getVida(), label.getLocation().x/25, label.getLocation().y/25);
                    break;
                case "M_ALCANCE":
                    zombie = new Zombie("hola",new JLabel(), zombie.getNombre(), "M_ALCANCE", zombie.getAlcance(), 1, zombie.getNivelAparicion(), zombie.getEspacios(), zombie.getDanoPorSegundo(), zombie.getVida(), label.getLocation().x/25, label.getLocation().y/25);
                    break;
                default:
                    zombie = new Zombie("hola",new JLabel(), zombie.getNombre(), "CONTACTO", zombie.getAlcance(), 1, zombie.getNivelAparicion(), zombie.getEspacios(), zombie.getDanoPorSegundo(), zombie.getVida(), label.getLocation().x/25, label.getLocation().y/25);
            }
            zombie.setLabel(label);
            label.setText(zombie.getTipo()+"");
            // Crear el thread
            ThreadZombie tz =  new ThreadZombie(zombie, this);
            zombies.add(tz);
            label.addMouseListener(new MouseAdapter() {
                        @Override
                     public void mouseEntered(MouseEvent e) {
                         label.setForeground(Color.RED);
                     }

                        @Override
                     public void mouseExited(MouseEvent e) {
                         label.setForeground(Color.BLACK);
                     }
            });
            pnlCampoJuego.add(label);
        }
    }
    
    public void refreshDefensesListBox(ArrayList<Defensa> defensas){
        limpiarDefensesListBox();
        DefaultListModel modelo = (DefaultListModel) lstDefensas.getModel();
        for (int i = 0; i < defensas.size(); i++) {
            Defensa defensa = defensas.get(i);
            if(defensa.getNivelAparicion() <= this.nivel)
                modelo.addElement(defensa.getNombre());
        }
    }
    
    public void limpiarDefensesListBox(){
        DefaultListModel modelo = new DefaultListModel();
        lstDefensas.setModel(modelo);
    }
    
     
    
    
    //----------------------------------------------------GUI DE VENTANA------------------------------------------------------
    //Funcion no implementada
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
    
    //posiciona aleatoriamente el label
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
    
    //Mueve un label a la posicion deseada
    public void moverLabel(int posX,int posY,JLabel label){
        label.setLocation(posX, posY);
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
    //----------------------------------------------------GUI DE VENTANA------------------------------------------------------

    //Get el arbol de la vida 
    public ThreadDefensa getTav() {
        return tav;
    }
    
    //Get lista de zombies en el juego 
    public ArrayList<ThreadZombie> getZombies() {
        return zombies;
    }

    //Get lista de defensas en el campo de juego
    public ArrayList<ThreadDefensa> getDefensas() {
        return defensas;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        pnlCampoJuego = new javax.swing.JPanel();
        btnIniciarGuerra = new javax.swing.JButton();
        txfPosX = new javax.swing.JTextField();
        txfPosY = new javax.swing.JTextField();
        btnColocarDefensa = new javax.swing.JButton();
        lblPosX = new javax.swing.JLabel();
        lblPosY = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstDefensas = new javax.swing.JList<>();
        btnQuitarDefensa = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

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

        lstDefensas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstDefensasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lstDefensas);

        btnQuitarDefensa.setText("Quitar");
        btnQuitarDefensa.setPreferredSize(new java.awt.Dimension(75, 26));
        btnQuitarDefensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarDefensaActionPerformed(evt);
            }
        });

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
                        .addComponent(lblPosX, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txfPosX, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txfPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnColocarDefensa)
                            .addGap(18, 18, 18)
                            .addComponent(btnQuitarDefensa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnIniciarGuerra, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPosX, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfPosX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnColocarDefensa)
                            .addComponent(btnQuitarDefensa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(121, 121, 121)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlCampoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton para iniciar la guerra
    private void btnIniciarGuerraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarGuerraActionPerformed
        generarZombies(nivel*5+15);
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
        if(defensaParaColocar != null){
                if(defensaParaColocar.getNombre()== "arbol" && arbolColocado){
                JOptionPane.showMessageDialog(pnlCampoJuego, "Error, arbol ya colocado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                if (isInt(txfPosX.getText()) && isInt(txfPosY.getText())){
                    int posX = Integer.parseInt(txfPosX.getText());
                    int posY = Integer.parseInt(txfPosY.getText());
                    if(posX >= 4 && posX < 21 && posY >= 4 && posY < 21){
                        if(checkPosition(posX, posY)){
                            String tipoElegido = defensaParaColocar.getTipo();
                            if(defensaParaColocar.getNombre().equals("arbol")){
                                arbolColocado = true;
                                defensaParaColocar.setPosX(posX);
                                defensaParaColocar.setPosY(posY);
                                btnIniciarGuerra.setEnabled(true);
                            }   
                            int repeticiones = 0;
                            Defensa defensa;
                            switch (tipoElegido) {
                                case "AEREO":
                                    defensa = new DefensaAerea("imgs//arbolDeLaVida.png",new JLabel(), defensaParaColocar.getNombre(), "AEREO", defensaParaColocar.getAlcance(), defensaParaColocar.getNivel(), defensaParaColocar.getNivelAparicion(), defensaParaColocar.getEspacios(), defensaParaColocar.getDanoPorSegundo(), defensaParaColocar.getVida(), posX, posY);
                                    break;
                                case "IMPACTO":
                                    defensa = new DefensaImpacto("imgs//arbolDeLaVida.png",new JLabel(), defensaParaColocar.getNombre(), "IMPACTO", defensaParaColocar.getAlcance(), defensaParaColocar.getNivel(), defensaParaColocar.getNivelAparicion(), defensaParaColocar.getEspacios(), defensaParaColocar.getDanoPorSegundo(), defensaParaColocar.getVida(), posX, posY);
                                    break;
                                case "MULTIPLE":
                                    DefensaAtaqueMultiple defensaMultiple = (DefensaAtaqueMultiple)defensaParaColocar;
                                    repeticiones = defensaMultiple.getRepeticiones();
                                    defensa = new DefensaAtaqueMultiple("imgs//arbolDeLaVida.png",new JLabel(), defensaParaColocar.getNombre(), "MULTIPLE", defensaParaColocar.getAlcance(), defensaParaColocar.getNivel(), defensaParaColocar.getNivelAparicion(), defensaParaColocar.getEspacios(), defensaParaColocar.getDanoPorSegundo(), defensaParaColocar.getVida(), posX, posY, repeticiones);
                                    break;
                                case "CONTACTO":
                                    defensa = new Defensa("imgs//arbolDeLaVida.png",new JLabel(), defensaParaColocar.getNombre(), "CONTACTO", defensaParaColocar.getAlcance(), defensaParaColocar.getNivel(), defensaParaColocar.getNivelAparicion(), defensaParaColocar.getEspacios(), defensaParaColocar.getDanoPorSegundo(), defensaParaColocar.getVida(), posX, posY);
                                    break;
                                case "ALCANCE" :
                                    defensa = new Defensa("imgs//arbolDeLaVida.png",new JLabel(), defensaParaColocar.getNombre(), "MULTIPLE", defensaParaColocar.getAlcance(), defensaParaColocar.getNivel(), defensaParaColocar.getNivelAparicion(), defensaParaColocar.getEspacios(), defensaParaColocar.getDanoPorSegundo(), defensaParaColocar.getVida(), posX, posY);
                                    break;
                               default :
                                    defensa = new Defensa("imgs//arbolDeLaVida.png",new JLabel(), defensaParaColocar.getNombre(), "BLOQUE", 0, defensaParaColocar.getNivel(), defensaParaColocar.getNivelAparicion(), defensaParaColocar.getEspacios(), 0, defensaParaColocar.getVida(), posX, posY);
                            }
                            JLabel label = new JLabel(defensa.getNombre()+ "");
                            label.setSize(25,25);
                            label.setBackground(Color.BLUE);
                            label.setLocation(posX*25, posY*25);
                            label.setVisible(true);
                            label.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseEntered(MouseEvent e) {
                                    label.setForeground(Color.RED);
                                }
                                @Override
                                public void mouseExited(MouseEvent e) {
                                    label.setForeground(Color.BLACK);
                                }
                            });
                            defensa.setLabel(label);
                            ThreadDefensa td = new ThreadDefensa(defensa, this);
                            defensas.add(td);
                            pnlCampoJuego.add(label);
                            pnlCampoJuego.revalidate();
                            pnlCampoJuego.repaint();
                        }else
                            JOptionPane.showMessageDialog(pnlCampoJuego, "Error: " + posX + "," + posY + " posicion en uso", "Error", JOptionPane.ERROR_MESSAGE);
                    }else
                        JOptionPane.showMessageDialog(pnlCampoJuego, "Error, no se puede colocar una defensa en " + posX + "," + posY, "Error", JOptionPane.ERROR_MESSAGE);
                }else
                     JOptionPane.showMessageDialog(pnlCampoJuego, "Error, debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
            } 
        }else
            JOptionPane.showMessageDialog(pnlCampoJuego, "Error, selecciona una defensa", "Error", JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_btnColocarDefensaActionPerformed

    private void txfPosYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPosYActionPerformed
        System.out.println("hola");
    }//GEN-LAST:event_txfPosYActionPerformed
    
    private void lstDefensasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstDefensasMouseClicked
        for (int i = 0; i < personajeDefensa.size(); i++) {
            Defensa get = personajeDefensa.get(i);
            if (get.getNombre().equals(lstDefensas.getSelectedValue()))
                defensaParaColocar = get;
        }
        System.out.println(defensaParaColocar.getNombre());
    }//GEN-LAST:event_lstDefensasMouseClicked

    private void btnQuitarDefensaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarDefensaActionPerformed
        if (isInt(txfPosX.getText()) && isInt(txfPosY.getText())){
            int posX = Integer.parseInt(txfPosX.getText());
            int posY = Integer.parseInt(txfPosY.getText());
            ThreadDefensa buscado = buscarDefensa(posX,posY);
            if(buscado != null){
                pnlCampoJuego.remove(buscado.getDefensa().getLabel());
                pnlCampoJuego.revalidate();
                pnlCampoJuego.repaint();
                defensas.remove(buscado);
                buscado.getDefensa().setLabel(null);
            }
        }else
                 JOptionPane.showMessageDialog(pnlCampoJuego, "Error, debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnQuitarDefensaActionPerformed
    
    
    
    public boolean allZombiesDead(){
        for (int i = 0; i < zombies.size(); i++) {
            ThreadZombie get = zombies.get(i);
            if (!get.getZombie().isDead())
                return false;
        }
        return true;
    }
    
    public void finishLevel(boolean winState){
        if (winState){
            JOptionPane.showMessageDialog(null, "Has ganado el nivel, puede continuar con el siguiente.", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
            //refreshLevel(nivel+1);
        }else{
            String[] opciones = {"Repetir nivel", "Siguiente nivel"};
            int seleccion = JOptionPane.showOptionDialog(
            null,
            "Ingrese la opcion para continuar",
            "Nivel perdido",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
            );

            // Verifica la selección del usuario y muestra un mensaje correspondiente
            switch (seleccion) {
                case 0:
                JOptionPane.showMessageDialog(null, "Has seleccionado Repetir", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                refreshLevel(nivel);
                
                case 1:
                JOptionPane.showMessageDialog(null, "Has seleccionado Siguiente", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                refreshLevel(nivel+1);
                
                default: // El usuario cerró el cuadro de diálogo
                    JOptionPane.showMessageDialog(null, "Has cerrado el cuadro de diálogo", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                //acá hay que decidir qué hacer si se toca la x o si se intenta bloquear
            }
        }
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void refreshLevel(int nivel){
        //se deben actualizar los listbox con los valores disponibles según nivel
        //
        this.setNivel(nivel);
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CampoDeBatalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColocarDefensa;
    private javax.swing.JButton btnIniciarGuerra;
    private javax.swing.JButton btnQuitarDefensa;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPosX;
    private javax.swing.JLabel lblPosY;
    private javax.swing.JList<String> lstDefensas;
    private javax.swing.JPanel pnlCampoJuego;
    private javax.swing.JTextField txfPosX;
    private javax.swing.JTextField txfPosY;
    // End of variables declaration//GEN-END:variables
}

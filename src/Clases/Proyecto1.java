package Clases;

import GUI.CampoDeBatalla;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;


public class Proyecto1 {

    public static void main(String[] args) {
        
        // Crear un nuevo JFrame
        JFrame frame = new JFrame("Barra de Progreso");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        // Crear una barra de progreso
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        // Crear un botón para iniciar la barra de progreso
        JButton startButton = new JButton("Iniciar");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Iniciar un hilo para actualizar la barra de progreso
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i <= 100; i++) {
                            final int progressValue = i;
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setValue(progressValue);
                                }
                            });
                            try {
                                Thread.sleep(100); // Simula un proceso
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();
            }
        });

        // Crear un panel para contener la barra de progreso y el botón
        JPanel panel = new JPanel();
        panel.add(progressBar);
        panel.add(startButton);

        // Agregar el panel al frame
        frame.add(panel);

        // Mostrar el frame
        frame.setVisible(true);
          
          
          
    }

}

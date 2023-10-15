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


public class Proyecto1 {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("FileChooser Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton openButton = new JButton("Abrir Archivo");
        JButton saveButton = new JButton("Guardar Archivo");
        final JLabel selectedFileLabel = new JLabel();

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    String selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                    selectedFileLabel.setText("Archivo seleccionado: " + selectedFilePath);
                } else {
                    selectedFileLabel.setText("Ningún archivo seleccionado");
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showSaveDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String selectedFilePath = selectedFile.getAbsolutePath();
                    selectedFileLabel.setText("Archivo guardado en: " + selectedFilePath);

                    // Ejemplo: Escribir algo en el archivo guardado
                    try {
                        FileWriter writer = new FileWriter(selectedFile);
                        writer.write("Contenido del archivo guardado.");
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    selectedFileLabel.setText("No se guardó ningún archivo.");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(openButton);
        panel.add(saveButton);
        panel.add(selectedFileLabel);

        frame.add(panel);
        frame.setSize(400, 150);
        frame.setVisible(true);
          
          
          
    }

}

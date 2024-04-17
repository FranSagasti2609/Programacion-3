package com.cerp.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridLayout; //Para crear los 4 botones.
import javax.swing.*;

import com.cerp.FileHandler;
import com.cerp.Controlador.InicioControlador;
import com.cerp.Modelo.Pregunta;

/**
 * @file InicioVista.java
 * @brief Clase para la vista principal de la aplicación.
 * @date 20/03/2023
 * @version 1.0
 */  
 
 public class InicioVista extends JFrame {
     private JMenuBar menuBar;
     private JMenuItem menuItemAdmin;
     private JMenuItem menuItemPreguntas;
     private JLabel numPreguntas; 
     //UPDATE 1.1 
     private JLabel mensaje = new JLabel("Bienvenido al software de repaso de conceptos de la POO de 3ro!");
        
     JPanel fourButtons = new JPanel(new GridLayout(2, 2, 10, 10)); //2 filas y 2 columnas
     JButton boton1 = new JButton("Abstraccion");
     JButton boton2 = new JButton("Herencia");
     JButton boton3 = new JButton("Polimorfismo");
     JButton boton4 = new JButton("Encapsulamiento");
    
    private FileHandler<Pregunta> fileHandler;
    private InicioControlador controlador;

     public InicioVista(FileHandler<Pregunta> fileHandler) {
         super("Conceptos de la POO - Edit 1.1 by Fran :D");

         this.fileHandler = fileHandler;
         initComponents();
     }
 
     private void initComponents() {
         // Crear la barra de menú y agregarla a la ventana
         menuBar = new JMenuBar();
         setJMenuBar(menuBar);

         //Update 1.1
         menuBar.add(mensaje); //Mensaje Introductorio al programa

        fourButtons.add(boton1);
        fourButtons.add(boton2);
        fourButtons.add(boton3);
        fourButtons.add(boton4);
        add(fourButtons); //agregamos el Jpanel a la vista principal.
        

         // Panel para mostrar la pregunta
         JPanel inicioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

         add(inicioPanel);
         setSize(800, 400);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setVisible(true);
     }
    
    public FileHandler<Pregunta> getFileHandler() {
        return fileHandler;
    }

    public void setFileHandler(FileHandler<Pregunta> fileHandler) {
        this.fileHandler = fileHandler;
    }

    public void setControlador(InicioControlador controlador) {
        this.controlador = controlador;
    }

    public InicioControlador getControlador(){
        return this.controlador;
    }

    /*public JMenuBar getJMenuBar() {
        return menuBar;
    }

    public void setJMenuBar(JMenuBar menuBar){
        this.menuBar = menuBar;
    }*/

    public JMenuItem getItemAdmin() {
        return menuItemAdmin;
    }

   /* public void setItemAdmin(JMenuItem menuItemAdmin){
        this.menuItemAdmin = menuItemAdmin;
    }*/

    public JMenuItem getItemPreguntas() {
        return menuItemPreguntas;
    }

    /*public void setItemPreguntas(JMenuItem menuItemPreguntas){
        this.menuItemPreguntas = menuItemPreguntas;
    }*/

    public JLabel getLabelPreguntas() {
        return numPreguntas;
    }

    public void setLabelPreguntas(JLabel  numPreguntas){
        this.numPreguntas =  numPreguntas;
    }

}
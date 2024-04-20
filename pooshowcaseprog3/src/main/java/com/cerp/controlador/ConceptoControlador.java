package com.cerp.controlador;

import com.cerp.Randomizer;
import com.cerp.modelo.Concepto;
import com.cerp.vista.InicioVista;
import com.cerp.vista.ConceptoVista;

import java.net.URI;
import java.awt.Desktop;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;


import javax.swing.JOptionPane;

/**
 * @file ConceptoControlador.java
 * @brief Clase que define la interfaz gráfica de usuario para mostrar conceptos y descripciones.
 * @date 2024-04-17
 * @version 1.0
 */

/**
 * Clase para representar el controlador de la interfaz gráfica de preguntas.
 */
public class ConceptoControlador implements ActionListener {
    private List<Concepto> modelo;
    private ConceptoVista vista;
    private InicioVista vistaInicio2;
    private Concepto conceptoActual;

    private Concepto obtenerConceptoActual() {
        return conceptoActual;
    }
    
    public ConceptoControlador(List<Concepto> modelo, ConceptoVista vista, InicioVista vistaInicio) {
        this.modelo = modelo;
        this.vista = vista;
        this.vistaInicio2 = vistaInicio;
//this: Utilizo está clase en particular
        vista.getUrlButton().addActionListener(this);
        vista.getAtrasButton().addActionListener(this);
        vista.getSiguienteButton().addActionListener(this);

        vista.getIdLabel().setText("ID de pregunta: Numero");
        vista.getConceptoLabel().setText("aca otra cosa");
        vista.getDescripcionArea().setText("Aca va a ir la descripcion");
        
        this.cargarConcepto();

        this.vista.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaInicio2.getControlador().guardarConcepto();
                System.exit(0);
            }
        });
    }

    private void cargarConcepto(){
        //Primer pregunta
        // Crear un objeto Randomizer para obtener un elemento aleatorio de la lista
        Randomizer<Concepto> randomizer = new Randomizer<>();
        // Obtener un elemento aleatorio de la lista de preguntas
        Concepto conceptoVisible = randomizer.getRandomElement(modelo);
        
        vista.getIdLabel().setText("ID de concepto: " + conceptoVisible.getIdConcepto());
        //set es para cambiar, get para traer
        vista.getConceptoLabel().setText(conceptoVisible.getNombre());
        vista.getDescripcionArea().setText(conceptoVisible.getDescripcion());
        vista.getUrlButton().setText(conceptoVisible.getUrlReplit()); 
        
        //Cargo el concepto actual para acceder a sus atributos, puntualmente a la URL
        Randomizer<Concepto> random = new Randomizer<>();
        conceptoActual = random.getRandomElement(modelo);

        
    }
   
    /**
     * Acción a realizar cuando se presiona un botón en la interfaz.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getSiguienteButton()) {
            this.cargarConcepto();

        } else if (e.getSource() == vista.getUrlButton())
            //Al pulsar boton de URL....
        {              
            JOptionPane.showMessageDialog(vista, "¡Redireccionando al enlace!");
            Concepto conceptoActual = obtenerConceptoActual();
             if (conceptoActual != null) {
            String url = conceptoActual.getUrlReplit();


            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                    Desktop.getDesktop().browse(new URI(url)); //Acceder a la url especificada
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(vista, "Error al abrir la URL: " + ex.getMessage());
                }
            }
         }
            
        } else if (e.getSource() == vista.getAtrasButton()) {
            vista.getParentWindow().setVisible(true);
            vista.dispose();
        }
        //pack(); // Ajustar tamaño al contenido
        //setResizable(false); // No permitir redimensionar
    }   
}




/*package ConceptosDelCursoMVC;

import javax.swing.*;

import ConceptosDelCursoMVC.Modelo.Concepto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ConceptoVista extends JFrame implements ActionListener {
    private JLabel idLabel;
    private JLabel preguntaLabel;
    private JLabel opcionesLabel;
    private JLabel correctaLabel;
    private JButton siguienteButton;
    private JButton confirmarButton;
    private JButton atrasButton;

    private List<Concepto> modelo;
    // Agregar atributo InicioVista llamado parentWindow
    private InicioVista parentWindow;


    private JRadioButton[] respuestaButtons;
    private ButtonGroup buttonGroup;

    private int correctIndex;


    public ConceptoVista(FileHandler<Concepto> fileHandler, InicioVista parentWindow) {
        List<Concepto> modelo = new ArrayList<Concepto>();
        
        // Cargar las preguntas desde preguntas.txt
        try {
            modelo = fileHandler.fileToList();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        this.modelo = modelo;
        this.parentWindow = parentWindow; // Asignar el objeto recibido al atributo parentWindow


        // Configuración de la ventana
        setTitle("Juego de preguntas para Programación 3 - CeRP del Suroeste - Prof. Domingo Pérez");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Panel para mostrar la pregunta
        JPanel preguntaPanel = new JPanel();
        preguntaPanel.setLayout(new BoxLayout(preguntaPanel, BoxLayout.Y_AXIS));
        preguntaPanel.setPreferredSize(new Dimension(600, 50)); // especificar una altura fija

        // Configuración de los componentes
        idLabel = new JLabel("ID de pregunta: " + "num");
        idLabel.setBounds(20, 20, 200, 20);
        preguntaPanel.add(idLabel, BorderLayout.CENTER);

        preguntaLabel = new JLabel("Concepto:");
        preguntaLabel.setBounds(20, 50, 80, 20);
        preguntaPanel.add(preguntaLabel, BorderLayout.CENTER);


        opcionesLabel = new JLabel("Opciones:");
        opcionesLabel.setBounds(20, 80, 80, 20);
        preguntaPanel.add(opcionesLabel, BorderLayout.CENTER);

        correctaLabel = new JLabel("Respuesta correcta:");
        correctaLabel.setBounds(20, 110, 140, 20);
        preguntaPanel.add(correctaLabel, BorderLayout.CENTER);


        add(preguntaPanel, BorderLayout.CENTER);

        // Crear el panel de respuestas
        JPanel answerPanel = new JPanel();
        answerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // agregar márgenes
        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));

        respuestaButtons = new JRadioButton[5];
        buttonGroup = new ButtonGroup();

        for (int i = 0; i < respuestaButtons.length; i++) {
            respuestaButtons[i] = new JRadioButton("Opción " + (i + 1));
            respuestaButtons[i].setActionCommand(Integer.toString(i));
            buttonGroup.add(respuestaButtons[i]);
            answerPanel.add(respuestaButtons[i]);
        }

        add(answerPanel, BorderLayout.SOUTH);

        //Primer pregunta
        // Crear un objeto Randomizer para obtener un elemento aleatorio de la lista
        Randomizer<Concepto> randomizer = new Randomizer<>();
        // Obtener un elemento aleatorio de la lista de preguntas
        Concepto preguntaVisible = randomizer.getRandomElement(modelo);
        
        idLabel.setText("ID de pregunta: " + preguntaVisible.getIdConcepto());
        String correctAnswer = preguntaVisible.getCorrecta();
        preguntaLabel.setText(preguntaVisible.getConcepto());
        int correctButtonIndex = Randomizer.getRandomIndex(0, respuestaButtons.length - 1);
        //int correctButtonIndex = (int) (Math.random() * (respuestaButtons.length));
        respuestaButtons[correctButtonIndex].setText(correctAnswer);
        int optionIndex = 0;
        for (int i = 0; i < respuestaButtons.length; i++) {
            if (i == correctButtonIndex) {
                continue;
            }
            String option = preguntaVisible.getOpciones()[optionIndex];
            respuestaButtons[i].setText(option);  

            optionIndex++;
        }

        
        // Panel para mostrar los botones de acción
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout());

        siguienteButton = new JButton("Siguiente");
        siguienteButton.setBounds(150, 170, 100, 30);
        siguienteButton.addActionListener(this);

        confirmarButton = new JButton("Confirmar");
        confirmarButton.setBounds(260, 170, 100, 30);
        confirmarButton.addActionListener(this);

        atrasButton = new JButton("Atrás");
        atrasButton.setBounds(20, 170, 100, 30);
        atrasButton.addActionListener(this);

        actionPanel.add(siguienteButton);
        actionPanel.add(confirmarButton);
        actionPanel.add(atrasButton);

        add(actionPanel, BorderLayout.SOUTH);


    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == siguienteButton) {
            int numConcepto = Randomizer.getRandomIndex(0, modelo.size() - 1);
            Concepto preguntaVisible = modelo.get(numConcepto);
            String correctAnswer = preguntaVisible.getCorrecta();
            idLabel.setText("ID de pregunta: " + preguntaVisible.getIdConcepto());
            preguntaLabel.setText(preguntaVisible.getConcepto());
            int correctButtonIndex = Randomizer.getRandomIndex(0, respuestaButtons.length - 1);
            this.correctIndex = correctButtonIndex;
            //int correctButtonIndex = (int) (Math.random() * (respuestaButtons.length));
            respuestaButtons[correctButtonIndex].setText(correctAnswer);
            int optionIndex = 0;
            for (int i = 0; i < respuestaButtons.length; i++) {
                if (i == correctButtonIndex) {
                    continue;
                }
                String option = preguntaVisible.getOpciones()[optionIndex];
                if (option.equals(correctAnswer)) {
                    optionIndex++;
                }
                respuestaButtons[i].setText(option);
                optionIndex++;
            }
                
            buttonGroup.clearSelection();

        } else if (e.getSource() == confirmarButton) {
            int selectedAnswer = Integer.parseInt(buttonGroup.getSelection().getActionCommand());
                if (selectedAnswer==this.correctIndex){
                    JOptionPane.showMessageDialog(ConceptoVista.this, "¡Correcto!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ConceptoVista.this, "¡Incorrecto!" + selectedAnswer + this.correctIndex , "Resultado", JOptionPane.ERROR_MESSAGE);
                }
            
        } else if (e.getSource() == atrasButton) {
            parentWindow.setVisible(true); // Hacer visible la ventana InicioVista
            dispose();
        }
        //pack(); // Ajustar tamaño al contenido
        //setResizable(false); // No permitir redimensionar
    }

        
}*/
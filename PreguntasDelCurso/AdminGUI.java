package PreguntasDelCurso;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import PreguntasDelCursoMVC.FileHandler;
import PreguntasDelCursoMVC.Modelo.Pregunta;

/**
 * @file AdminGUI.java
 * @brief Clase para representar la interfaz gráfica de administración de preguntas.
 * @date 20/03/2023
 * @version 1.0
 */
public class AdminGUI extends JFrame implements ActionListener {
    private PreguntasList questionList;
    private FileHandler<Pregunta> fileHandler;
    private int currentQuestionIndex;

    private JLabel idLabel;
    private JLabel preguntaLabel;
    private JTextField preguntaField;
    private JLabel opcionesLabel;
    private JTextField opcionesField;
    private JLabel correctaLabel;
    private JTextField correctaField;
    private JButton confirmarButton;
    private JButton atrasButton;

    // Agregar atributo InicioGUI llamado parentWindow
    private InicioGUI parentWindow;

    /**
     * Constructor de la clase AdminGUI.
     * @param questionList la lista de preguntas existente.
     * @param fileHandler el manejador de archivos a utilizar.
     */
    public AdminGUI(PreguntasList questionList, FileHandler<Pregunta> fileHandler, InicioGUI parentWindow) {
        this.questionList = questionList;
        this.fileHandler = fileHandler;
        this.currentQuestionIndex = 0;
        this.parentWindow = parentWindow; // Asignar el objeto recibido al atributo parentWindow


        // Configuración de la ventana
        setTitle("Panel de Administración de Preguntas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Panel para mostrar la pregunta
        JPanel preguntaPanel = new JPanel();
        preguntaPanel.setLayout(new BoxLayout(preguntaPanel, BoxLayout.Y_AXIS));
        preguntaPanel.setPreferredSize(new Dimension(600, 50)); // especificar una altura fija


        // Configuración de los componentes
        idLabel = new JLabel("ID de pregunta: " + (questionList.size()+1));
        idLabel.setBounds(20, 20, 200, 20);
        preguntaPanel.add(idLabel, BorderLayout.CENTER);

        preguntaLabel = new JLabel("Pregunta:");
        preguntaLabel.setBounds(20, 50, 80, 20);
        preguntaPanel.add(preguntaLabel, BorderLayout.CENTER);

        preguntaField = new JTextField();
        preguntaField.setBounds(100, 50, 300, 20);
        preguntaPanel.add(preguntaField, BorderLayout.CENTER);

        opcionesLabel = new JLabel("Opciones:");
        opcionesLabel.setBounds(20, 80, 80, 20);
        preguntaPanel.add(opcionesLabel, BorderLayout.CENTER);

        opcionesField = new JTextField();
        opcionesField.setBounds(100, 80, 300, 20);
        preguntaPanel.add(opcionesField, BorderLayout.CENTER);

        correctaLabel = new JLabel("Respuesta correcta:");
        correctaLabel.setBounds(20, 110, 140, 20);
        preguntaPanel.add(correctaLabel, BorderLayout.CENTER);

        correctaField = new JTextField();
        correctaField.setBounds(160, 110, 240, 20);
        preguntaPanel.add(correctaField, BorderLayout.CENTER);

        add(preguntaPanel, BorderLayout.CENTER);

        
        // Panel para mostrar los botones de acción
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout());

        confirmarButton = new JButton("Confirmar");
        confirmarButton.setBounds(260, 170, 100, 30);
        confirmarButton.addActionListener(this);

        atrasButton = new JButton("Atrás");
        atrasButton.setBounds(20, 170, 100, 30);
        atrasButton.addActionListener(this);

        actionPanel.add(confirmarButton);
        actionPanel.add(atrasButton);

        add(actionPanel, BorderLayout.SOUTH);

    }

    /**
     * 
     * @brief Método para establecer el índice de la pregunta actual.
     * @param index El índice de la pregunta actual.
    */
    public void setCurrentQuestionIndex(int index) {
        this.currentQuestionIndex = index;
    }
    /**
     * 
     * @brief Método para obtener el índice de la pregunta actual.
     * @return El índice de la pregunta actual.
    */
    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    /**
     * Acción a realizar cuando se presiona un botón en la interfaz.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmarButton) {
            if (preguntaField.getText().isEmpty() || opcionesField.getText().isEmpty() || correctaField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                confirmarButton.setEnabled(false); // Desactivar el botón de confirmar temporalmente
                // Obtener los valores de los campos de texto
                String pregunta = preguntaField.getText();
                String opcionesString = opcionesField.getText();
                String correcta = correctaField.getText();

                // Separar las opciones en un arreglo usando el caracter: ,
                String[] opciones = opcionesString.split(",");

                // Crear la nueva pregunta
                Pregunta nuevaPregunta = new Pregunta(questionList.size() + 1, pregunta, correcta, opciones);

                // Agregar la pregunta a la lista y escribir la lista en el archivo
                questionList.addQuestion(nuevaPregunta);
                try {
                    fileHandler.listToFile(questionList);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al escribir en el archivo: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Mostrar mensaje de confirmación
                JOptionPane.showMessageDialog(this, "Pregunta agregada correctamente.", "Confirmación",
                        JOptionPane.INFORMATION_MESSAGE);

                // Actualizar el índice de la pregunta actual y el ID de pregunta
                currentQuestionIndex++;
                idLabel.setText("ID de pregunta: " + (questionList.size() + 1));

                // Limpiar los campos de pregunta, opciones y respuesta correcta
                preguntaField.setText("");
                opcionesField.setText("");
                correctaField.setText("");
                confirmarButton.setEnabled(true); // Volver a activar el botón de confirmar
            }   
        } else if (e.getSource() == atrasButton) {
            parentWindow.setVisible(true); // Hacer visible la ventana InicioGUI
            dispose();
        }
        //pack(); // Ajustar tamaño al contenido
        //setResizable(false); // No permitir redimensionar
    }
}

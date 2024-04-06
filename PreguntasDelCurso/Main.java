package PreguntasDelCurso;

import java.io.IOException;

import PreguntasDelCursoMVC.FileHandler;
import PreguntasDelCursoMVC.Modelo.Pregunta;

/**
 * @file Main.java
 * @brief Clase principal del programa que permite crear, modificar y eliminar preguntas.
 * @date 20/03/2023
 * @version 1.0
 * @author Domingo Pérez
 */

/**
 * @class Main
 * @brief Clase principal que permite interactuar con la aplicación de preguntas.
 */
public class Main {
    /**
     * @brief Método principal que inicia la ejecución del programa.
     * @param args Parámetros de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        
        // Crear instancia de FileHandler para cargar las preguntas desde preguntas.txt
        FileHandler<Pregunta> fileHandler = new FileHandler<Pregunta>("PreguntasDelCurso\\preguntas.data");
        
        // Crear instancia de QuestionList para manejar las preguntas en memoria
        PreguntasList questionList = new PreguntasList();

        /*// Limpio el archivo
        try {
            fileHandler.limpiarArchivo();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

        /* 
        // Cargar la primera pregunta
        String questionText1 = "1|¿Cuál es el concepto fundamental de la Programación Orientada a Objetos?|Objetos|Variables, Métodos, Clases, Interfaces|1";
        Pregunta question1 = Pregunta.fromString(questionText1);
        questionList.addQuestion(question1);*/

        
        
        // Cargar las preguntas desde preguntas.txt
        try {
            questionList = (PreguntasList) fileHandler.fileToList();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Número de preguntas cargadas: " + questionList.size());

         // Inicia la ventana de inicio de la aplicación
        InicioGUI inicioGUI = new InicioGUI(questionList, fileHandler);
        inicioGUI.setVisible(true);
    }
}

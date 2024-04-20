package com.cerp.modelo;

/**
 * @file Concepto.java
 * @brief Clase para representar un concepto en el juego de conceptos y descripciones.
 * @date 16/04/2023
 * @version 1.0
 */
///Prueba
 import java.io.Serializable;

 /**
  * @class Concepto
  * @brief Clase para representar una concepto en el juego de conceptos y descripciones.
  * Implementa Serializable para poder ser guardada en un archivo.
  */
 public class Concepto implements Serializable{
    private int idConcepto; // índice de la concepto
    private String nombre; // concepto
    private String urlReplit; // enlace a un replit con code del concepto
    private String descripcion; // Descrición del concepto
    
    /**
     * Constructor para la clase concepto.
     * @param idConcepto int que representa el numero del concepto
     * @param nombre String que representa el nombre del concepto.
     * @param urlReplit String que contiene el url hacia un replit para ejemplificar los conceptos.
     * @param descripcion String que representa la descripcion de un concepto .
     */
    public Concepto(int idC, String nom, String url, String descr) {
        this.idConcepto = idC;
        this.nombre = nom;
        this.urlReplit = url;
        this.descripcion = descr;
    }

    /**
     * Getter para obtener el id de la concepto.
     * @return int que representa el id de la concepto.
     */
    public int getIdConcepto() {
        return idConcepto;
    }

    /**
     * Setter para establecer el id de la concepto.
     * @param idConcepto int que representa el id de la concepto.
     */
    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    /**
     * Getter para obtener la concepto.
     * @return String que representa la concepto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter para establecer la concepto.
     * @param concepto String que representa la concepto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * Getter para obtener la respuesta correcta.
     * @return String que representa la respuesta correcta.
     */
    public String getUrlReplit() {
        return urlReplit;
    }

    /**
     * Setter para establecer la respuesta correcta.
     * @param correcta String que representa la respuesta correcta.
     */
    public void setUrlReplit(String url) {
        this.urlReplit = url;
    }

    /**
     * Getter para obtener las opciones posibles.
     * @return String[] que contiene las opciones posibles.
     */
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static Concepto fromString(String ConceptoString) {
        // Separar la cadena en los diferentes campos
        String[] fields = ConceptoString.split("\\|");

        System.out.println("ID de concepto: " + fields[0]);
        System.out.println("Concepto: " + fields[1]);
        System.out.println("Descripcion: " + fields[2]);
        System.out.println("URL: " + fields[3]);
    
        // Crear la concepto a partir de los campos
        int idConcepto = Integer.parseInt(fields[0]);
        String concepto = fields[1];
        String descripcion = fields[2];
        String url = fields[3];
    
        return new Concepto(idConcepto, concepto, url, descripcion);
    }
}

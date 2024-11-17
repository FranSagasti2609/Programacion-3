package com.testbd;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHandler {
    private static final String DB_NAME = "carmen_sandiego.db"; // Nombre de la base de datos
    private static Connection connection = null;

    // Método para obtener la conexión
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Obtener la ruta del archivo desde el classpath
                String dbPath = DataBaseHandler.class.getClassLoader()
                        .getResource(DB_NAME).getPath();
                // Decodificar la ruta (manejar espacios y caracteres especiales)
                dbPath = URLDecoder.decode(dbPath, StandardCharsets.UTF_8);

                // Establecer la conexión
                connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
                System.out.println("Conexión a SQLite establecida: " + dbPath);
            } catch (NullPointerException e) {
                System.err.println("Error: No se pudo encontrar la base de datos en el classpath: " + DB_NAME);
            } catch (SQLException e) {
                System.err.println("Error al conectar con SQLite: " + e.getMessage());
            }
        }
        return connection;
    }

    // Método para cerrar la conexión
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión a SQLite cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

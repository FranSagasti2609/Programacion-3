package com.testbd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        // Obtener conexión desde DatabaseHandler
        try (Connection conn = DataBaseHandler.getConnection()) {
            if (conn != null) {
                // Crear una tabla de ejemplo
                String sql = "CREATE TABLE IF NOT EXISTS lugares (" +
                             "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                             "nombre TEXT NOT NULL)";
                Statement stmt = conn.createStatement();
                stmt.execute(sql);
                System.out.println("Tabla creada correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la operación en SQLite: " + e.getMessage());
        } finally {
            // Cerrar la conexión al final
            DataBaseHandler.closeConnection();
        }
    }
    
}

package com.usta.configuraciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class MiConexion {

    private static final String URL = "jdbc:mysql://localhost:3306/bd_labfisicamecanica";
    private static final String USERNAME = "user_poo";
    private static final String PASSWORD = "123456";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    protected String miCadenaSQL;
    protected ResultSet misRegistros;
    protected Connection miObjConexion;
    protected Integer miCantidad;
    protected PreparedStatement miConsulta;

    private static Connection conexion = null; // Instancia única de la conexión

    public MiConexion() {
        conectarse();
    }

    private static void crearConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            try {
                Class.forName(DRIVER);
                conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Conectado a MySQL!!!");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(MiConexion.class.getName()).log(Level.SEVERE, null, ex);
                throw new SQLException("Error al conectar con la base de datos", ex);
            }
        }
    }

    public static Connection obtenerConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            crearConexion();
        }
        return conexion;
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void conectarse() {
        try {
            miObjConexion = obtenerConexion();
        } catch (SQLException ex) {
            Logger.getLogger(MiConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


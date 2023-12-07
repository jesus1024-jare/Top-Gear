package Modelo;

import Main.Conexion;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class Modelo {

    private static Modelo instance;
    
    Conexion conectar = new Conexion();
    private static Connection con;
    public static PreparedStatement ps;
    public static ResultSet rs;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String paswword = "";
    private static final String url = "jdbc:mysql://localhost:3306/ProyectoP3";
    
    private Modelo() {
        con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, paswword);
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }
    public static Modelo getinstance(){
        if(instance == null){
            instance = new Modelo();
        }
        return instance;
    }

    public Connection getConnection() {
        return con;
    }

    public void desconectar() {
        con = null;
    }
    public void actualizarEstado(String marca, String modelo, String nuevoEstado) {
        // Query para actualizar el estado del vehículo en la base de datos
        String query = "UPDATE deportivo SET estado = ? WHERE marca = ? AND modelo = ?";
        
        try {
            // Preparar la declaración SQL
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, nuevoEstado);
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, modelo);
            
            // Ejecutar la actualización
            int filasActualizadas = preparedStatement.executeUpdate();
            
            if (filasActualizadas > 0) {
                System.out.println("Estado del vehículo actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el estado del vehículo.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void actualizarEstadoC(String marca, String modelo, String nuevoEstado) {
        // Query para actualizar el estado del vehículo en la base de datos
        String query = "UPDATE clasico SET estado = ? WHERE marca = ? AND modelo = ?";
        
        try {
            // Preparar la declaración SQL
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, nuevoEstado);
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, modelo);
            
            // Ejecutar la actualización
            int filasActualizadas = preparedStatement.executeUpdate();
            
            if (filasActualizadas > 0) {
                System.out.println("Estado del vehículo actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el estado del vehículo.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void actualizarEstadoF(String marca, String modelo, String nuevoEstado) {
        // Query para actualizar el estado del vehículo en la base de datos
        String query = "UPDATE familiares SET estado = ? WHERE marca = ? AND modelo = ?";
        
        try {
            // Preparar la declaración SQL
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, nuevoEstado);
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, modelo);
            
            // Ejecutar la actualización
            int filasActualizadas = preparedStatement.executeUpdate();
            
            if (filasActualizadas > 0) {
                System.out.println("Estado del vehículo actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el estado del vehículo.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }public void actualizarEstadoT(String marca, String modelo, String nuevoEstado) {
        // Query para actualizar el estado del vehículo en la base de datos
        String query = "UPDATE todoterreno SET estado = ? WHERE marca = ? AND modelo = ?";
        
        try {
            // Preparar la declaración SQL
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, nuevoEstado);
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, modelo);
            
            // Ejecutar la actualización
            int filasActualizadas = preparedStatement.executeUpdate();
            
            if (filasActualizadas > 0) {
                System.out.println("Estado del vehículo actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el estado del vehículo.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
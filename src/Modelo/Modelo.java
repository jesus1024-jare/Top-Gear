/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Main.Conexion;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Ventanas.*;
import java.util.ArrayList;

public class Modelo {

    Conexion conectar = new Conexion();
    private static Connection con;
    public static PreparedStatement ps;
    public static ResultSet rs;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String paswword = "";
    private static final String url = "jdbc:mysql://localhost:3306/ProyectoP3";

    public Modelo() {
        con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, paswword);
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }

    public Connection getConnection() {
        return con;
    }

    public void desconectar() {
        con = null;
    }

    public DefaultTableModel cargarDatos() {
        Connection reg = getConnection();
        String SQL = "SELECT * FROM clasico";
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Fabricación");
        modelo.addColumn("ValorH");
        modelo.addColumn("Estado");

        try {
            PreparedStatement pst = reg.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getString("marca");
                fila[1] = rs.getString("modelo");
                fila[2] = rs.getInt("fabricacion");
                fila[3] = rs.getDouble("valorH");
                fila[4] = rs.getString("estado");
                modelo.addRow(fila);
            }

            return modelo;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + ex.getMessage(), "Error en la operación", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}

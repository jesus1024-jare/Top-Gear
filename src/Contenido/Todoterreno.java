/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contenido;

import Modelo.Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author ingerioj
 */
public class Todoterreno {

    String marca;
    String modelo;
    double Achacis;
    double TSuspension;
    String estado;

    public Todoterreno() {
        marca = "";
        modelo = "";
        Achacis = 0;
        TSuspension = 0;
        estado = "";
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getAchacis() {
        return Achacis;
    }

    public void setAchacis(double Achacis) {
        this.Achacis = Achacis;
    }

    public double getTSuspension() {
        return TSuspension;
    }

    public void setTSuspension(double TSuspension) {
        this.TSuspension = TSuspension;
    }
    Modelo m = Modelo.getinstance();
    public boolean Añadir() {
        Connection reg = m.getConnection();
        String SQL = "Insert into todoterreno (marca, modelo, Achacis, Tsuspension, estado) values (?,?,?,?,?)";
        setEstado("Disponible");
        try {
            PreparedStatement pst = reg.prepareStatement(SQL);
            pst.setString(1,getMarca()); 
            pst.setString(2,getModelo()); 
            pst.setDouble(3,getAchacis()); 
            pst.setDouble(4,getTSuspension());
            pst.setString(5, getEstado());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Registro!" + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
    }
    public ArrayList<Todoterreno> obtenerDeportivosDesdeBaseDeDatos() {
        ArrayList<Todoterreno> dp = new ArrayList<>();
        Connection reg = m.getConnection(); // Obtener la conexión a la base de datos

        // Consulta SQL para obtener los datos de clientes
        String SQL = "SELECT marca, modelo, Achacis, Tsuspension, estado FROM todoterreno";

        try {
            PreparedStatement pst = reg.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();

            // Iterar a través de los resultados y crear objetos Cliente
            while (rs.next()) {
                Todoterreno td = new Todoterreno();
                td.setMarca(rs.getString("marca"));
                td.setModelo(rs.getString("modelo"));
                td.setAchacis(rs.getDouble("Achacis"));
                td.setTSuspension(rs.getDouble("Tsuspension"));
                td.setEstado(rs.getString("estado"));

                dp.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos de clientes desde la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return dp;
    }
}

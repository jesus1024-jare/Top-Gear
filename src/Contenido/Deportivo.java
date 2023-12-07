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
public class Deportivo {

    String marca;
    String modelo;
    double velocidad_maxima;
    double Taceleracion;
    String estado;

    public Deportivo() {
        marca = "";
        modelo = "";
        velocidad_maxima = 0;
        Taceleracion = 0;
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

    public double getVelocidad_maxima() {
        return velocidad_maxima;
    }

    public void setVelocidad_maxima(double velocidad_maxima) {
        this.velocidad_maxima = velocidad_maxima;
    }

    public double getTaceleracion() {
        return Taceleracion;
    }

    public void setTaceleracion(double Taceleracion) {
        this.Taceleracion = Taceleracion;
    }
    
    Modelo m = Modelo.getinstance();
    public boolean Añadir() {
        Connection reg = m.getConnection();
        String SQL = "Insert into deportivo (marca, modelo, VelocidadM, Taceleracion, estado) values (?,?,?,?,?)";
        setEstado("Disponible");
        try {
            PreparedStatement pst = reg.prepareStatement(SQL);
            pst.setString(1,getMarca()); 
            pst.setString(2,getModelo()); 
            pst.setDouble(3,getVelocidad_maxima()); 
            pst.setDouble(4,getTaceleracion());
            pst.setString(5, getEstado());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Registro!" + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
    }
    public ArrayList<Deportivo> obtenerDeportivosDesdeBaseDeDatos() {
        ArrayList<Deportivo> dp = new ArrayList<>();
        Connection reg = m.getConnection(); // Obtener la conexión a la base de datos

        // Consulta SQL para obtener los datos de clientes
        String SQL = "SELECT marca, modelo, VelocidadM, Taceleracion, estado FROM deportivo";

        try {
            PreparedStatement pst = reg.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();

            // Iterar a través de los resultados y crear objetos Cliente
            while (rs.next()) {
                Deportivo depor = new Deportivo();
                depor.setMarca(rs.getString("marca"));
                depor.setModelo(rs.getString("modelo"));
                depor.setVelocidad_maxima(rs.getDouble("VelocidadM"));
                depor.setTaceleracion(rs.getDouble("Taceleracion"));
                depor.setEstado(rs.getString("estado"));

                dp.add(depor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos de clientes desde la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return dp;
    }
    
}

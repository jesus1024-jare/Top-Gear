/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contenido;

import Modelo.Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
    public boolean Añadir(Modelo m) {
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
}

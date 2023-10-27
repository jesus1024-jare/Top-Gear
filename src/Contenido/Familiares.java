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
public class Familiares {

    String marca;
    String modelo;
    int capPersonas;
    String estado;

    public Familiares() {
        marca = "";
        modelo = "";
        capPersonas = 0;
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

    public int getCapPersonas() {
        return capPersonas;
    }

    public void setCapPersonas(int capPersonas) {
        this.capPersonas = capPersonas;
    }
    Modelo m = Modelo.getinstance();
    public boolean Añadir() {
        Connection reg = m.getConnection();
        String SQL = "Insert into familiares (marca, modelo, capPersonas, estado) values (?,?,?,?)";
        setEstado("Disponible");
        try {
            PreparedStatement pst = reg.prepareStatement(SQL);
            pst.setString(1,getMarca()); 
            pst.setString(2,getModelo()); 
            pst.setInt(3,getCapPersonas()); 
            pst.setString(5, getEstado());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Registro!" + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
    }
}

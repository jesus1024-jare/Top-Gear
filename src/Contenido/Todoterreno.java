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
    public boolean Añadir(Modelo m) {
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
}

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
public class Clasico {

    String marca;
    String modelo;
    int Fabricacion;
    double valorH;
    String Estado;

    public Clasico() {
        marca = "";
        modelo = "";
        Fabricacion = 0;
        valorH = 0;
        Estado = "";
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

    public int getFabricacion() {
        return Fabricacion;
    }

    public void setFabricacion(int Fabricacion) {
        this.Fabricacion = Fabricacion;
    }

    public double getValorH() {
        return valorH;
    }

    public void setValorH(double valorH) {
        this.valorH = valorH;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    Modelo m = Modelo.getinstance();
    public boolean Añadir() {
    
    Connection reg = m.getConnection();
    String SQL = "Insert into clasico (marca, modelo, fabricacion, valorH, estado) values (?,?,?,?,?)";
    setEstado("Disponible");
    
    try {
        PreparedStatement pst = reg.prepareStatement(SQL);
        pst.setString(1,getMarca()); 
        pst.setString(2,getModelo()); 
        pst.setInt(3,getFabricacion()); 
        pst.setDouble(4,getValorH());
        pst.setString(5, getEstado());
        pst.executeUpdate();
        return true;
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error de Registro!" + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE); 
        return false;
    }
}


}

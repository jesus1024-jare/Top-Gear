/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contenido;

import Modelo.Modelo;
import Modelo.R_Interface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ingerioj
 */
public class Cliente{

    String nombre;
    String apellido;
    int id;
    String mar;
    String mode;
    public int dia;
    public int precio;
    public int total;

    public Cliente() {
        nombre = "";
        apellido = "";
        id = 0;
        mar = "";
        mode = "";
        dia = 0;
        precio = 0;
        total = 0;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    

    public String getMar() {
        return mar;
    }

    public void setMar(String mar) {
        this.mar = mar;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    Modelo m = Modelo.getinstance();
    public boolean Añadir() {
        Connection reg = m.getConnection();
        String SQL = "Insert into cliente (Nombre, Apellido, Identificacion, MarcaDeAutoAlquilada, ModeloAlquilado, DíasDeAlquiler, Total) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = reg.prepareStatement(SQL);
            pst.setString(1,    getNombre()); 
            pst.setString(2, getApellido()); 
            pst.setInt(3, getId()); 
            pst.setString(4, getMar());
            pst.setString(5, getMode());
            pst.setInt(6, getDia());
            pst.setInt(7, getTotal());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Registro!" + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
    }

    public R_Interface multiplicacion = (x, y) -> {
    double resultado = x * y;
    return resultado;
    };

}

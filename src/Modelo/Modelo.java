package Modelo;

import Main.Conexion;
import java.sql.Connection;
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

}
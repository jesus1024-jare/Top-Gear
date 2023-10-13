/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controlador.*;
import Contenido.*;
/**
 *
 * @author ingerioj
 */
public class Conexion {
    public static void main(String[] args) {
        Cliente cl = new Cliente();
        Todoterreno to = new Todoterreno();
        Familiares fam = new Familiares();
        Deportivo de = new Deportivo();
        Clasico c = new Clasico();
        Controller con = new Controller(c, de, to, fam, cl);
        con.run();
    }
}

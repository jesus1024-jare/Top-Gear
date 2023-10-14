/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Contenido.*;
import Ventanas.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ingerioj
 */
public class Controller implements ActionListener{

    Clasico cla;
    Deportivo dep;
    Todoterreno todo;
    Familiares fami;
    Principal pri;
    Cliente cli;
    public Controller(Clasico c, Deportivo de, Todoterreno to, Familiares fam, Cliente cl) {
        cla = c;
        cli = cl;
        dep = de;
        todo = to;
        fami = fam;
        pri = new Principal();
        mod = (DefaultTableModel)pri.getTclientes().getModel();
        mod = (DefaultTableModel)pri.getTdeportivo().getModel();
        mod = (DefaultTableModel)pri.getTclasico().getModel();
        mod = (DefaultTableModel)pri.getTerreneitor().getModel();
        mod = (DefaultTableModel)pri.getTfamiliar().getModel();
        pri.getDep().addActionListener(this);
        pri.getJdep().addActionListener(this);
        pri.getJfam().addActionListener(this);
        pri.getJclien().addActionListener(this);
        pri.getJtod().addActionListener(this);
    }
     
    ArrayList<Cliente> datos = new ArrayList();
    DefaultTableModel mod;
    
    public void run(){
        pri.setVisible(true);
        pri.setLocationRelativeTo(null);
        botonTransparente();
    }
    public void llenar(Cliente p){
        datos.add(p);
    }
    
    public void mostrar(String nom, String ape, int d){
        mod.addRow(new Object[]{nom, ape, d});
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pri.getDep()){
            pri.Panel.setSelectedIndex(2);
        }if(e.getSource() == pri.getJdep()){
            pri.Panel.setSelectedIndex(1);
        }if(e.getSource() == pri.getJclien()){
            pri.Panel.setSelectedIndex(0);
        }if(e.getSource() == pri.getJtod()){
            pri.Panel.setSelectedIndex(4);
        }if(e.getSource() == pri.getJfam()){
            pri.Panel.setSelectedIndex(3);
        }
    }
    
    public void botonTransparente(){
        pri.getJclien().setOpaque(false);
        pri.getJclien().setContentAreaFilled(false);
        pri.getJclien().setBorderPainted(false);
        pri.getJdep().setOpaque(false);
        pri.getJdep().setContentAreaFilled(false);
        pri.getJdep().setBorderPainted(false);
        pri.getJfam().setOpaque(false);
        pri.getJfam().setContentAreaFilled(false);
        pri.getJfam().setBorderPainted(false);
        pri.getJtod().setOpaque(false);
        pri.getJtod().setContentAreaFilled(false);
        pri.getJtod().setBorderPainted(false);
        pri.getDep().setOpaque(false);
        pri.getDep().setContentAreaFilled(false);
        pri.getDep().setBorderPainted(false);
        
    }
    
}

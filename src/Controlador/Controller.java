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
    Client cc;
    public Controller(Clasico c, Deportivo de, Todoterreno to, Familiares fam, Cliente cl) {
        cla = c;
        cli = cl;
        dep = de;
        todo = to;
        fami = fam;
        cc = new Client();
        pri = new Principal();
        mod = (DefaultTableModel)cc.getTablacli().getModel();
        pri.getDep().addActionListener(this);
    }
     
    ArrayList<Cliente> datos = new ArrayList();
    DefaultTableModel mod;
    
    public void run(){
        pri.setVisible(true);
        pri.setLocationRelativeTo(null);
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
        }
    }
    
}

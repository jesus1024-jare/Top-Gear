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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ingerioj
 */
public class Controller implements ActionListener {

    Clasico cla;
    Deportivo dep;
    Todoterreno todo;
    Familiares fami;
    Principal pri;
    Cliente cli;
    Client clientd;
    Deport deport;
    Familiar f;
    Clasicos clas;
    TodoTerreno tr;

    public Controller(Clasico c, Deportivo de, Todoterreno to, Familiares fam, Cliente cl) {
        cla = c;
        cli = cl;
        dep = de;
        todo = to;
        fami = fam;
        f = new Familiar();
        pri = new Principal();
        clientd = new Client();
        deport = new Deport();
        clas = new Clasicos();
        tr = new TodoTerreno();
        mod = (DefaultTableModel) pri.getTclientes().getModel();
        moddep = (DefaultTableModel) pri.getTdeportivo().getModel();
        modcla = (DefaultTableModel) pri.getTclasico().getModel();
        modterre = (DefaultTableModel) pri.getTerreneitor().getModel();
        modfami = (DefaultTableModel) pri.getTfamiliar().getModel();
        pri.getDep().addActionListener(this);
        pri.getJdep().addActionListener(this);
        pri.getJfam().addActionListener(this);
        pri.getJclien().addActionListener(this);
        pri.getJtod().addActionListener(this);
        pri.getSalida().addActionListener(this);
        pri.getAgregar().addActionListener(this);
        pri.getGdeport().addActionListener(this);
        pri.getGclas().addActionListener(this);
        pri.getGfami().addActionListener(this);
        pri.getGtodo().addActionListener(this);
        clientd.getGuardarr().addActionListener(this);
        clientd.getCancelarr().addActionListener(this);
        deport.getGuardar().addActionListener(this);
        deport.getCancelar().addActionListener(this);
        f.getCancelar().addActionListener(this);
        f.getGuardar().addActionListener(this);
        clas.getGuardar().addActionListener(this);
        clas.getCancelar().addActionListener(this);
        tr.getGuardar().addActionListener(this);
        tr.getCancelar().addActionListener(this);
        pri.getAlqui().addActionListener(this);
    }

    ArrayList<Cliente> datos = new ArrayList();
    ArrayList<Deportivo> depor = new ArrayList();
    ArrayList<Familiares> fam = new ArrayList();
    ArrayList<Todoterreno> tere = new ArrayList();
    ArrayList<Clasico> casic = new ArrayList();

    DefaultTableModel mod;
    DefaultTableModel moddep;
    DefaultTableModel modcla;
    DefaultTableModel modterre;
    DefaultTableModel modfami;

    public void run() {
        pri.setVisible(true);
        pri.setLocationRelativeTo(null);
        botonTransparente();
    }

    public void llenar(Cliente p) {
        datos.add(p);
    }

    public void llenard(Deportivo d) {
        depor.add(d);
    }

    public void llenarf(Familiares f) {
        fam.add(f);
    }

    public void llenart(Todoterreno t) {
        tere.add(t);
    }

    public void llenarc(Clasico c) {
        casic.add(c);
    }

    public void mostrar(String nom, String ape, int d, String a, String b, int Di) {
        mod.addRow(new Object[]{nom, ape, d, a, b, Di});
    }

    public void mostrard(String ma, String mo, double p, double n, String e) {
        moddep.addRow(new Object[]{ma, mo, p, n, e});
    }

    public void mostrarf(String ma, String mo, int p) {
        modfami.addRow(new Object[]{ma, mo, p});
    }

    public void mostrart(String ma, String mo, double c, double s) {
        modterre.addRow(new Object[]{ma, mo, c, s});
    }

    public void mostrarc(String ma, String mo, int v, double h, String est) {
        modcla.addRow(new Object[]{ma, mo, v, h, est});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pri.getDep()) {
            pri.Panel.setSelectedIndex(2);
        } else {
            if (e.getSource() == pri.getJdep()) {
                pri.Panel.setSelectedIndex(1);
            }
            if (e.getSource() == pri.getJclien()) {
                pri.Panel.setSelectedIndex(0);
            }
            if (e.getSource() == pri.getJtod()) {
                pri.Panel.setSelectedIndex(4);
            }
            if (e.getSource() == pri.getJfam()) {
                pri.Panel.setSelectedIndex(3);
            }
            if (e.getSource() == pri.getSalir()) {
                System.exit(0);
            }
            if (e.getSource() == pri.getAgregar()) {
                clientd.setVisible(true);
                clientd.setLocationRelativeTo(null);
            }
            if (e.getSource() == clientd.getGuardarr()) {
                cli.setNombre(clientd.getJnom().getText());
                cli.setApellido(clientd.getJapelli().getText());
                cli.setId(Integer.parseInt(clientd.getJide().getText()));
                cli.setMar(clientd.getAlqui().getText());
                cli.setMode(clientd.getModelo().getText());
                cli.setDia(Integer.parseInt(clientd.getDias().getText()));
                if (cli.getMar().equalsIgnoreCase(dep.getMarca()) || cli.getMode().equalsIgnoreCase(dep.getModelo())) {
                    llenar(cli);
                    mostrar(cli.getNombre(), cli.getApellido(), cli.getId(), cli.getMar(), cli.getMode(), cli.getDia());
                    // Cambiar el estado del vehículo a "En uso"
                    dep.setEstado("En uso");

                    // Buscar el auto deportivo correspondiente en la lista y actualizar su estado
                    for (Deportivo deportivo : depor) {
                        if (deportivo.getMarca().equalsIgnoreCase(dep.getMarca()) && deportivo.getModelo().equalsIgnoreCase(dep.getModelo())) {
                            deportivo.setEstado("En uso");
                            break; // Una vez encontrado y actualizado, puedes salir del bucle
                        }
                    }
                    // Ahora actualiza la tabla de autos deportivos
                    DefaultTableModel moddep = (DefaultTableModel) pri.getTdeportivo().getModel();
                    // Puedes reemplazar la fila existente en la tabla en lugar de agregar una nueva fila
                    int rowIndexToUpdate = encontrarFilaEnTabla(moddep, dep.getMarca(), dep.getModelo());
                    if (rowIndexToUpdate != -1) {
                        moddep.setValueAt("En uso", rowIndexToUpdate, 4); // 4 es el índice de la columna de estado
                    }

                    // Notifica al modelo de datos que se ha realizado un cambio
                    moddep.fireTableDataChanged();
                }
                if (cli.getMar().equalsIgnoreCase(cla.getMarca()) || cli.getMode().equalsIgnoreCase(cla.getModelo())) {
                    llenar(cli);
                    mostrar(cli.getNombre(), cli.getApellido(), cli.getId(), cli.getMar(), cli.getMode(), cli.getDia());
                }
                if (cli.getMar().equalsIgnoreCase(fami.getMarca()) || cli.getMode().equalsIgnoreCase(fami.getModelo())) {
                    llenar(cli);
                    mostrar(cli.getNombre(), cli.getApellido(), cli.getId(), cli.getMar(), cli.getMode(), cli.getDia());
                }
                if (cli.getMar().equalsIgnoreCase(todo.getMarca()) || cli.getMode().equalsIgnoreCase(todo.getModelo())) {
                    llenar(cli);
                    mostrar(cli.getNombre(), cli.getApellido(), cli.getId(), cli.getMar(), cli.getMode(), cli.getDia());
                } else {
                    JOptionPane.showMessageDialog(null, "Datos Invalidos");
                }
            }
            if (e.getSource() == clientd.getCancelarr()) {
                clientd.dispose();
            }
            if (e.getSource() == pri.getGdeport()) {
                deport.setVisible(true);
                deport.setLocationRelativeTo(null);
            }
            if (e.getSource() == deport.getGuardar()) {
                dep.setMarca(deport.getJmarca().getText());
                dep.setModelo(deport.getJmodelo().getText());
                dep.setTaceleracion(Double.parseDouble(deport.getJtemp().getText()));
                dep.setVelocidad_maxima(Double.parseDouble(deport.getJvelo().getText()));
                llenard(dep);
                mostrard(dep.getMarca(), dep.getModelo(), dep.getVelocidad_maxima(), dep.getTaceleracion(), dep.getEstado());
            }
            if (e.getSource() == deport.getCancelar()) {
                deport.dispose();
            }
            if (e.getSource() == pri.getGfami()) {
                f.setVisible(true);
                f.setLocationRelativeTo(null);
            }
            if (e.getSource() == f.getGuardar()) {
                fami.setMarca(f.getMarca().getText());
                fami.setModelo(f.getModelo().getText());
                fami.setCapPersonas(Integer.parseInt(f.getCapacidad().getText()));
                llenarf(fami);
                mostrarf(fami.getMarca(), fami.getModelo(), fami.getCapPersonas());
            }
            if (e.getSource() == f.getCancelar()) {
                f.dispose();
            }
            if (e.getSource() == pri.getGclas()) {
                clas.setVisible(true);
                clas.setLocationRelativeTo(null);
            }
            if (e.getSource() == clas.getGuardar()) {
                cla.setMarca(clas.getMarca().getText());
                cla.setModelo(clas.getModelo().getText());
                cla.setFabricacion(Integer.parseInt(clas.getAño().getText()));
                cla.setValorH(Double.parseDouble(clas.getValorH().getText()));
                cla.setEstado(clas.getEstado().getText());
                llenarc(cla);
                mostrarc(cla.getMarca(), cla.getModelo(), cla.getFabricacion(), cla.getValorH(), cla.getEstado());
            }
            if (e.getSource() == clas.getCancelar()) {
                clas.dispose();
            }
            if (e.getSource() == pri.getGtodo()) {
                tr.setVisible(true);
                tr.setLocationRelativeTo(null);
            }
            if (e.getSource() == tr.getGuardar()) {
                todo.setMarca(tr.getMarca().getText());
                todo.setModelo(tr.getModelo().getText());
                todo.setAchacis(Double.parseDouble(tr.getAncho().getText()));
                todo.setTSuspension(Double.parseDouble(tr.getAlto().getText()));
                llenart(todo);
                mostrart(todo.getMarca(), todo.getModelo(), todo.getAchacis(), todo.getTSuspension());
            }
            if (e.getSource() == tr.getCancelar()) {
                tr.dispose();
            }
            if (e.getSource() == pri.getAlqui()) {
            }
        }
    }

    public void botonTransparente() {
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
        clientd.getGuardarr().setOpaque(false);
        clientd.getGuardarr().setContentAreaFilled(false);
        clientd.getGuardarr().setBorderPainted(false);
        clientd.getCancelarr().setOpaque(false);
        clientd.getCancelarr().setContentAreaFilled(false);
        clientd.getCancelarr().setBorderPainted(false);
        deport.getGuardar().setOpaque(false);
        deport.getGuardar().setContentAreaFilled(false);
        deport.getGuardar().setBorderPainted(false);
        deport.getCancelar().setOpaque(false);
        deport.getCancelar().setContentAreaFilled(false);
        deport.getCancelar().setBorderPainted(false);
        f.getGuardar().setOpaque(false);
        f.getGuardar().setContentAreaFilled(false);
        f.getGuardar().setBorderPainted(false);
        f.getCancelar().setOpaque(false);
        f.getCancelar().setContentAreaFilled(false);
        f.getCancelar().setBorderPainted(false);
        clas.getGuardar().setOpaque(false);
        clas.getGuardar().setContentAreaFilled(false);
        clas.getGuardar().setBorderPainted(false);
        clas.getCancelar().setOpaque(false);
        clas.getCancelar().setContentAreaFilled(false);
        clas.getCancelar().setBorderPainted(false);
        tr.getGuardar().setOpaque(false);
        tr.getGuardar().setContentAreaFilled(false);
        tr.getGuardar().setBorderPainted(false);
        tr.getCancelar().setOpaque(false);
        tr.getCancelar().setContentAreaFilled(false);
        tr.getCancelar().setBorderPainted(false);
    }
    private int encontrarFilaEnTabla(DefaultTableModel model, String marca, String modelo) {
    for (int row = 0; row < model.getRowCount(); row++) {
        String marcaEnTabla = (String) model.getValueAt(row, 0); // 0 es el índice de la columna de marca
        String modeloEnTabla = (String) model.getValueAt(row, 1); // 1 es el índice de la columna de modelo

        if (marcaEnTabla.equalsIgnoreCase(marca) && modeloEnTabla.equalsIgnoreCase(modelo)) {
            return row; // Se encontró una coincidencia, devuelve el índice de la fila
        }
    }

    return -1; // No se encontró ninguna coincidencia
}

}

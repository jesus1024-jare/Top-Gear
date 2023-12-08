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
import Modelo.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;

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
    Modelo mo;

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
        mo = Modelo.getinstance();
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
        pri.getBusqueda().addActionListener(this);
        clientes = cli.obtenerClientesDesdeBaseDeDatos();
        deporti = dep.obtenerDeportivosDesdeBaseDeDatos();
        Familiar = fami.obtenerFamiliarDesdeBaseDeDatos();
        clasico = cla.obtenerClasicDesdeBaseDeDatos();
        todoterren = todo.obtenerTodoTerrenoDesdeBaseDeDatos();
    }
    ArrayList<Todoterreno> todoterren = new ArrayList();
    ArrayList<Clasico> clasico = new ArrayList();
    ArrayList<Familiares> Familiar = new ArrayList();
    ArrayList<Deportivo> deporti = new ArrayList();
    ArrayList<Cliente> clientes = new ArrayList();
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
    DefaultTableModel modelo;

    public void run() {
        // Hilo para cargar la vista
        Thread hiloVista = new Thread(() -> {
            pri.setVisible(true);
            pri.setLocationRelativeTo(null);
            botonTransparente();
            mo.getConnection();
        });

        // Hilo para cargar los datos en la tabla
        Thread hiloDatos = new Thread(() -> {
            actualizarTablaDesdeBaseDeDatos();
        });

        // Iniciar ambos hilos
        hiloVista.start();
        try {
            hiloVista.join(); // Esperar a que el hiloVista termine
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hiloDatos.start();
        try {
            hiloDatos.join(); // Esperar a que el hiloDatos termine
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    public void mostrar(String nom, String ape, int d, String a, String b, int Di, int gp) {

        mod.addRow(new Object[]{nom, ape, d, a, b, Di, gp});
    }

    public void mostrard(String ma, String mo, double p, double n, String e) {
        moddep.addRow(new Object[]{ma, mo, p, n, e});
    }

    public void mostrarf(String ma, String mo, int p, String s) {
        modfami.addRow(new Object[]{ma, mo, p, s});
    }

    public void mostrart(String ma, String mo, double c, double s, String e) {
        modterre.addRow(new Object[]{ma, mo, c, s, e});
    }

    public void mostrarc(String ma, String mo, int v, double h, String est) {
        modcla.addRow(new Object[]{ma, mo, v, h, est});
    }

    public R_Interface multiplicacion = (x, y) -> {
        double resultado = x * y;
        return resultado;
    };
    public void actualizarTablaDeportiva() {
    moddep.setRowCount(0); // Limpiar la tabla deportiva
    for (Deportivo depp : deporti) {
        mostrard(depp.getMarca(), depp.getModelo(), depp.getVelocidad_maxima(), depp.getTaceleracion(), depp.getEstado());
    }
    }
    // Método para actualizar tabla de vehículos clásicos
public void actualizarTablaClasicos() {
    modcla.setRowCount(0); // Limpiar la tabla de clásicos
    for (Clasico clasi : clasico) {
        mostrarc(clasi.getMarca(), clasi.getModelo(), clasi.getFabricacion(), clasi.getValorH(), clasi.getEstado());
    }
}

// Método para actualizar tabla de todoterrenos
public void actualizarTablaTodoterrenos() {
    modterre.setRowCount(0); // Limpiar la tabla de todoterrenos
    for (Todoterreno terr : todoterren) {
        mostrart(terr.getMarca(), terr.getModelo(), terr.getAchacis(), terr.getTSuspension(), terr.getEstado());
    }
}

// Método para actualizar tabla de vehículos familiares
public void actualizarTablaFamiliares() {
    modfami.setRowCount(0); // Limpiar la tabla de familiares
    for (Familiares fami : Familiar) {
        mostrarf(fami.getMarca(), fami.getModelo(), fami.getCapPersonas(), fami.getEstado());
    }
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

                boolean encontrado = false;

                for (Deportivo depp : deporti) {
                    if (cli.getMar().equalsIgnoreCase(depp.getMarca()) || cli.getMode().equalsIgnoreCase(depp.getModelo())) {
                        llenar(cli);
                        cli.setPrecio(1000);
                        int n = (int) multiplicacion.calcular(cli.getPrecio(), cli.getDia());
                        cli.setTotal(n);
                        mostrar(cli.getNombre(), cli.getApellido(), cli.getId(), cli.getMar(), cli.getMode(), cli.getDia(), cli.getTotal());
                        cli.Añadir();
                        JOptionPane.showMessageDialog(null, "Cliente añadido");

                        // Cambiar el estado del vehículo deportivo a "En uso"
                        depp.setEstado("En uso");
                        mo.actualizarEstado(depp.getMarca(), depp.getModelo(), depp.getEstado());
                        actualizarTablaDeportiva();
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    for (Clasico clasi : clasico) {
                        if (cli.getMar().equalsIgnoreCase(clasi.getMarca()) || cli.getMode().equalsIgnoreCase(clasi.getModelo())) {
                            llenar(cli);
                            cli.setPrecio(500);
                            int n = (int) multiplicacion.calcular(cli.getPrecio(), cli.getDia());
                            cli.setTotal(n);
                            mostrar(cli.getNombre(), cli.getApellido(), cli.getId(), cli.getMar(), cli.getMode(), cli.getDia(), cli.getTotal());
                            cli.Añadir();
                            JOptionPane.showMessageDialog(null, "Cliente añadido");

                            // Cambiar el estado del vehículo clásico a "En uso"
                            clasi.setEstado("En uso");
                            mo.actualizarEstadoC(clasi.getMarca(), clasi.getModelo(), clasi.getEstado());
                            actualizarTablaClasicos();
                            encontrado = true;
                            break;
                        }
                    }
                }

                if (!encontrado) {
                    for (Todoterreno terr : todoterren) {
                        if (cli.getMar().equalsIgnoreCase(terr.getMarca()) || cli.getMode().equalsIgnoreCase(terr.getModelo())) {
                            llenar(cli);
                            cli.setPrecio(600);
                            int n = (int) multiplicacion.calcular(cli.getPrecio(), cli.getDia());
                            cli.setTotal(n);
                            mostrar(cli.getNombre(), cli.getApellido(), cli.getId(), cli.getMar(), cli.getMode(), cli.getDia(), cli.getTotal());
                            cli.Añadir();
                            JOptionPane.showMessageDialog(null, "Cliente añadido");

                            // Cambiar el estado del vehículo todo a "En uso"
                            terr.setEstado("En uso");
                            mo.actualizarEstadoT(terr.getMarca(), terr.getModelo(), terr.getEstado());
                            actualizarTablaTodoterrenos();
                            encontrado = true;
                            break;
                        }
                    }
                }

                if (!encontrado) {
                    for (Familiares fam : Familiar) {
                        if (cli.getMar().equalsIgnoreCase(fam.getMarca()) || cli.getMode().equalsIgnoreCase(fam.getModelo())) {
                            llenar(cli);
                            cli.setPrecio(450);
                            int n = (int) multiplicacion.calcular(cli.getPrecio(), cli.getDia());
                            cli.setTotal(n);
                            mostrar(cli.getNombre(), cli.getApellido(), cli.getId(), cli.getMar(), cli.getMode(), cli.getDia(), cli.getTotal());
                            cli.Añadir();
                            JOptionPane.showMessageDialog(null, "Cliente añadido");

                            // Cambiar el estado del vehículo familiar a "En uso"
                            fam.setEstado("En uso");
                            mo.actualizarEstadoF(fam.getMarca(), fam.getModelo(), fam.getEstado());
                            actualizarTablaFamiliares();
                            encontrado = true;
                            break;
                        }
                    }
                }

                if (!encontrado) {
                    JOptionPane.showMessageDialog(null, "Auto no encontrado en la base de datos");
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
                dep.Añadir();
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
                fami.Añadir();
                mostrarf(fami.getMarca(), fami.getModelo(), fami.getCapPersonas(), fami.getEstado());
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
                llenarc(cla);
                cla.Añadir();
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
                todo.Añadir();
                mostrart(todo.getMarca(), todo.getModelo(), todo.getAchacis(), todo.getTSuspension(), todo.getEstado());
            }
            if (e.getSource() == tr.getCancelar()) {
                tr.dispose();
            }
            if (e.getSource() == pri.getBusqueda()) {
                String mod = JOptionPane.showInputDialog("Digite el modelo del auto a buscar");
                boolean encontrado = false;

                for (Cliente cliente : clientes) {
                    if (cliente.getMode().equalsIgnoreCase(mod)) {
                        JOptionPane.showMessageDialog(null, "Cliente encontrado: \n"
                                + "Nombre: " + cliente.getNombre() + "\n"
                                + "Apellido: " + cliente.getApellido() + "\n"
                                + "ID: " + cliente.getId() + "\n"
                                + "Marca: " + cliente.getMar() + "\n"
                                + "Modelo: " + cliente.getMode() + "\n"
                                + "Días: " + cliente.getDia() + "\n"
                                + "Total: " + cliente.getTotal());
                        encontrado = true;
                        break; // Si ya se encontró el cliente, se sale del bucle
                    }
                }
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

    public void cargarDatosEnTablaClientes() {
        // Obtener la referencia al JTable de clientes desde la ventana principal (suponiendo que se llame tclientes)
        JTable tablaClientes = pri.getTclientes();

        // Limpiar la tabla antes de cargar nuevos datos
        DefaultTableModel modeloTablaClientes = (DefaultTableModel) tablaClientes.getModel();
        modeloTablaClientes.setRowCount(0); // Limpiar la tabla

        // Llenar la tabla con los datos de la base de datos
        ArrayList<Cliente> clientes = cli.obtenerClientesDesdeBaseDeDatos(); // Obtener los datos de la base de datos
        for (Cliente cliente : clientes) {
            modeloTablaClientes.addRow(new Object[]{
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getId(),
                cliente.getMar(),
                cliente.getMode(),
                cliente.getDia(),
                cliente.getTotal()
            });
        }
    }

    public void cargarDatosEnTablaDeportivos() {
        // Obtener la referencia al JTable de deportivos desde la ventana principal (suponiendo que se llame tclientes)
        JTable tablaDeportivos = pri.getTdeportivo();

        // Limpiar la tabla antes de cargar nuevos datos
        DefaultTableModel modeloTablaDeportivo = (DefaultTableModel) tablaDeportivos.getModel();
        modeloTablaDeportivo.setRowCount(0); // Limpiar la tabla

        // Llenar la tabla con los datos de la base de datos
        ArrayList<Deportivo> de = dep.obtenerDeportivosDesdeBaseDeDatos(); // Obtener los datos de la base de datos
        for (Deportivo depp : de) {
            modeloTablaDeportivo.addRow(new Object[]{
                depp.getMarca(),
                depp.getModelo(),
                depp.getVelocidad_maxima(),
                depp.getTaceleracion(),
                depp.getEstado()
            });
        }
    }

    public void cargarDatosEnTablaClasico() {
        // Obtener la referencia al JTable de deportivos desde la ventana principal (suponiendo que se llame tclientes)
        JTable tablaClasico = pri.getTclasico();

        // Limpiar la tabla antes de cargar nuevos datos
        DefaultTableModel modeloTablaClasic = (DefaultTableModel) tablaClasico.getModel();
        modeloTablaClasic.setRowCount(0); // Limpiar la tabla

        // Llenar la tabla con los datos de la base de datos
        ArrayList<Clasico> clasi = cla.obtenerClasicDesdeBaseDeDatos(); // Obtener los datos de la base de datos
        for (Clasico ca : clasi) {
            modeloTablaClasic.addRow(new Object[]{
                ca.getMarca(),
                ca.getModelo(),
                ca.getFabricacion(),
                ca.getValorH(),
                ca.getEstado()
            });
        }
    }

    public void cargarDatosEnTablaFamiliar() {
        // Obtener la referencia al JTable de deportivos desde la ventana principal (suponiendo que se llame tclientes)
        JTable tablaFamiliar = pri.getTfamiliar();

        // Limpiar la tabla antes de cargar nuevos datos
        DefaultTableModel modeloTablaFamili = (DefaultTableModel) tablaFamiliar.getModel();
        modeloTablaFamili.setRowCount(0); // Limpiar la tabla

        // Llenar la tabla con los datos de la base de datos
        ArrayList<Familiares> fam = fami.obtenerFamiliarDesdeBaseDeDatos();
        for (Familiares fa : fam) {
            modeloTablaFamili.addRow(new Object[]{
                fa.getMarca(),
                fa.getModelo(),
                fa.getCapPersonas(),
                fa.getEstado()
            });
        }
    }

    public void cargarDatosEnTablaTodoTerreno() {
        // Obtener la referencia al JTable de deportivos desde la ventana principal (suponiendo que se llame tclientes)
        JTable tablaTerre = pri.getTerreneitor();

        // Limpiar la tabla antes de cargar nuevos datos
        DefaultTableModel modeloTablaTerre = (DefaultTableModel) tablaTerre.getModel();
        modeloTablaTerre.setRowCount(0); // Limpiar la tabla

        // Llenar la tabla con los datos de la base de datos
        ArrayList<Todoterreno> td = todo.obtenerTodoTerrenoDesdeBaseDeDatos();
        for (Todoterreno tdd : td) {
            modeloTablaTerre.addRow(new Object[]{
                tdd.getMarca(),
                tdd.getModelo(),
                tdd.getAchacis(),
                tdd.getTSuspension(),
                tdd.getEstado()
            });
        }
    }

    public void actualizarTablaDesdeBaseDeDatos() {
        cargarDatosEnTablaClientes();
        cargarDatosEnTablaDeportivos();
        cargarDatosEnTablaClasico();
        cargarDatosEnTablaFamiliar();
        cargarDatosEnTablaTodoTerreno();
    }
}

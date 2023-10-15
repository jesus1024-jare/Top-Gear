/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contenido;

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
}

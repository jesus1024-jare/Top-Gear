/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contenido;

/**
 *
 * @author ingerioj
 */
public class Deportivo {

    String marca;
    String modelo;
    double velocidad_maxima;
    double Taceleracion;

    public Deportivo() {
        marca = "";
        modelo = "";
        velocidad_maxima = 0;
        Taceleracion = 0;
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

    public double getVelocidad_maxima() {
        return velocidad_maxima;
    }

    public void setVelocidad_maxima(double velocidad_maxima) {
        this.velocidad_maxima = velocidad_maxima;
    }

    public double getTaceleracion() {
        return Taceleracion;
    }

    public void setTaceleracion(double Taceleracion) {
        this.Taceleracion = Taceleracion;
    }

}

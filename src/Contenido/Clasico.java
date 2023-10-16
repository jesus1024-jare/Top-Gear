/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contenido;

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

}

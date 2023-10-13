/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contenido;

/**
 *
 * @author ingerioj
 */
public class Todoterreno {

    String marca;
    String modelo;
    double Achacis;
    double TSuspension;

    public Todoterreno(String marca, String modelo, double Achacis, double TSuspension) {
        this.marca = marca;
        this.modelo = modelo;
        this.Achacis = Achacis;
        this.TSuspension = TSuspension;
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

    public double getAchacis() {
        return Achacis;
    }

    public void setAchacis(double Achacis) {
        this.Achacis = Achacis;
    }

    public double getTSuspension() {
        return TSuspension;
    }

    public void setTSuspension(double TSuspension) {
        this.TSuspension = TSuspension;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoparcial;

/**
 *
 * @author MARIELOS
 */
public class Vehiculo {
//Los atributos de la clase vehiculo

    private String nombre_vehiculo;
    private Vida vida;
    private int ataque;
//El constructor de la clase 

    public Vehiculo(String nombre_vehiculo, Vida vida, int ataque) {
        this.nombre_vehiculo = nombre_vehiculo;
        this.vida = vida;
        this.ataque = ataque;
    }
//Metodo de mostrar informacion

    public void mostrarInformacion() {
        System.out.println("Vehiculo: " + nombre_vehiculo + " " + vida.getActual() + "/" + vida.getMaxima() + " Ataque: " + ataque);
    }
//Get y set

    public String getNombre_vehiculo() {
        return nombre_vehiculo;
    }

    public void setNombre_vehiculo(String nombre_vehiculo) {
        this.nombre_vehiculo = nombre_vehiculo;
    }

    public Vida getVida() {
        return vida;
    }

    public void setVida(Vida vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

}

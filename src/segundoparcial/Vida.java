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
public class Vida {

    public int vida_maxima;
    public int vida_actual;
    public String nombre_edificio;

    public Vida(int vida_maxima, String nombre_edificio) {
        this.vida_actual = this.vida_maxima = vida_maxima;
        this.nombre_edificio = nombre_edificio;
    }
//    public void mostrarVida()

    public int recibir_dano(int cant) {
        if (cant <= vida_actual) {
            vida_actual -= cant;
        } else {
            System.out.println(nombre_edificio + " ha caido");
            vida_actual = 0;
        }
        return vida_actual;
    }

    public int getActual() {
        return vida_actual;
    }

    public int getMaxima() {
        return vida_maxima;
    }

}

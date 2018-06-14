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
public class MiembroMilicia {
    //Los atributos de la clase miembro milicia

    private String nombre_miembro;
    private Vida vida;
    private int ataque;
    //Contructor de la clase miembro milicia

    public MiembroMilicia(String nombre_miembro, Vida vida, int ataque) {
        this.nombre_miembro = nombre_miembro;
        this.vida = vida;
        this.ataque = ataque;
    }
    //Metodo mostrar informacion

    public void mostrarInformacion() {
        System.out.println("Miembro: " + nombre_miembro + " " + vida.getActual() + "/" + vida.getMaxima() + " Ataque: " + ataque);
    }
    //Get y set 

    public String getNombre_miembro() {
        return nombre_miembro;
    }

    public void setNombre_miembro(String nombre_miembro) {
        this.nombre_miembro = nombre_miembro;
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

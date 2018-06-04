/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoparcial;

/**
 *
 * @author marielos
 */
public class CentroDeMando {
//Creando los metodos de la clase Centro de Mando

    private int r_energia = 10000;
    private int r_hierro = 5000;
    private int r_agua = 3000;
    private int r_energia_actual = r_energia;
    private int r_hierro_actual = r_hierro;
    private int r_agua_actual = r_agua;
    private String nombre_centro;

//Creando el contructor de la clase centro de mando
    public CentroDeMando(String nombre_centro) {
        this.nombre_centro = nombre_centro;
    }

//Creando el metodo mostrar recursos del centro de mando
    public void mostrarRecursos() {
        System.out.println("Centro de mando: " + nombre_centro);
        System.out.println("Energia: " + r_energia_actual + "/" + r_energia);
        System.out.println("Hierro: " + r_hierro_actual + "/" + r_hierro);
        System.out.println("Agua : " + r_agua_actual + "/" + r_agua);
    }
//Creando el metodo gastar energia

    public void gastarEnergia(int cant) {
        if (cant <= r_energia_actual) {
            r_energia_actual -= cant;
        } else {
            System.out.println("Error: Energia insuficiente");
        }
    }
//Creando el metodo gastar hierro

    public void gastarHierro(int cant) {
        if (cant <= r_hierro_actual) {
            r_hierro_actual -= cant;
        } else {
            System.out.println("Error: Hierro insuficiente");
        }
    }
//Creando el metodo gastar agua

    public void gastarAgua(int cant) {
        if (cant <= r_agua_actual) {
            r_agua_actual -= cant;
        } else {
            System.out.println("Error: Agua insuficiente");
        }
    }
}

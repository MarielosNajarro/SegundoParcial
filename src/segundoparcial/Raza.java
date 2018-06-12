/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoparcial;

import java.util.ArrayList;

/**
 *
 * @author marielos
 */
public class Raza {
//Atributos de la clase
    
    private String nombre_raza;
    private CentroDeMando mando;
    private ArrayList<MiembroMilicia> miembros = new ArrayList();
    private ArrayList<Vehiculo> vehiculos = new ArrayList();
//Contructor de la clase

    public Raza(String nombre_raza, String nombre_mando, int vida_centro_mando) {
        this.nombre_raza = nombre_raza;
        mando = new CentroDeMando(nombre_mando, vida_centro_mando);
    }
//Metodo de mostrar informacion  

    public void mostrarInformacion() {
        System.out.println(nombre_raza.toUpperCase());
        mando.mostrarRecursos();
    }

    public void agregarMiembroMilicia(MiembroMilicia miembro) {
        this.miembros.add(miembro);
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public void asignar_recurso_a(String nombre_a, int valor) {
        mando.setRecurso_a(new Recurso(nombre_a, valor));
    }

    public void asignar_recurso_b(String nombre_b, int valor) {
        mando.setRecurso_b(new Recurso(nombre_b, valor));
    }

    public void asignar_recurso_c(String nombre_c, int valor) {
        mando.setRecurso_c(new Recurso(nombre_c, valor));
    }
//Get y set

    public String getNombre_raza() {
        return nombre_raza;
    }

    public void setNombre_raza(String nombre_raza) {
        this.nombre_raza = nombre_raza;
    }

    public CentroDeMando getMando() {
        return mando;
    }

    public void setMando(CentroDeMando mando) {
        this.mando = mando;
    }

}

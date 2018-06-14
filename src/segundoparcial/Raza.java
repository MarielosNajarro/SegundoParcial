/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoparcial;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author marielos
 */
public class Raza {
//Atributos de la clase

    private String nombre_raza;
    private CentroDeMando mando;
    //Lista que guarda los miembros y vehiculos
    private ArrayList<MiembroMilicia> miembros = new ArrayList();
    private ArrayList<Vehiculo> vehiculos = new ArrayList();
//Contructor de la clase

    public Raza(String nombre_raza, String nombre_mando, int vida_centro_mando) {
        this.nombre_raza = nombre_raza;
        mando = new CentroDeMando(nombre_mando, vida_centro_mando);
    }
//Metodo de mostrar informacion  
    //Recorre la lista de miembro y vehiculos para mostrarlos como una lista en pantalla
    public void mostrarInformacion() {
        System.out.println(nombre_raza.toUpperCase());
        mando.mostrarRecursos();
        System.out.println("\tMIEMBROS: ");
        for (int i = 0; i < miembros.size(); i++) {
            System.out.print("\t\t" + (i + 1) + ") ");
            miembros.get(i).mostrarInformacion();
        }
        System.out.println("\tVEHICULOS: ");
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.print("\t\t" + (i + 1) + ") ");
            vehiculos.get(i).mostrarInformacion();
        }
    }
//Metodo de recibir dano

    public void recibirDano(int ataque) {
        int opcion; //Se usa opcion - 1 en el codigo ya qe al jugador se le muestra a partir de la opcion 1
                    //Pero las listas comienzan a partir de la 0, entonces se le resta 1
        Scanner leer = new Scanner(System.in);
        System.out.println("A que quieres atacar?");
        // sin no hauy miembros o vehiculos el dano lo recibe
        // directamente el centro de mando
        if (vehiculos.size() == 0 && miembros.size() == 0) {
            System.out.println("1) Centro de mando");
            mando.getVida().recibir_dano(ataque);
        } else {
            //En cambio si hay al menos una unidad disponible
            //Se muestra una lista de miembros y se pregunta
            //a que se quiere atacar
            //(El "ataque" lo manda el jugador contrario)
            System.out.println("1) Atacar a la milicia");
            System.out.println("2) Atacar a un vehiculo");
            System.out.print("Digite opcion: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    //Si hay miembros entonces pregunta a cual quiere
                    if (miembros.size() > 0) {
                        System.out.println("A que miembro?");
                        for (int i = 0; i < miembros.size(); i++) {
                            System.out.print("\t" + (i + 1) + ") ");
                            miembros.get(i).mostrarInformacion();
                        }
                        System.out.print("Digite opcion: ");
                        opcion = leer.nextInt();
                        miembros.get(opcion - 1).getVida().recibir_dano(ataque);
                        //Aqui se pregunta si el miembro del jugador contrario se quedo sin vida
                        //de ser asi se remueve de al lista
                        if (miembros.get(opcion - 1).getVida().vida_actual == 0) {
                            System.out.println("\t\t" + miembros.get(opcion - 1).getNombre_miembro() + " YA SE MURIO");
                            miembros.remove(opcion - 1);
                        }
                    } else {
                        System.out.println("No hay miembros disponibles");
                    }
                    break;
                case 2:
                    if (vehiculos.size() > 0) {
                        System.out.println("A que vehiculo?");
                        for (int i = 0; i < vehiculos.size(); i++) {
                            System.out.print("\t" + (i + 1) + ") ");
                            vehiculos.get(i).mostrarInformacion();
                        }
                        System.out.print("Digite opcion: ");
                        opcion = leer.nextInt();
                        vehiculos.get(opcion - 1).getVida().recibir_dano(ataque);
                        if (vehiculos.get(opcion - 1).getVida().vida_actual == 0) {
                            System.out.println("\t\t" + vehiculos.get(opcion - 1).getNombre_vehiculo() + " YA SE ARRUINO");
                            vehiculos.remove(opcion - 1);
                        }
                    } else {
                        System.out.println("No hay vehiculos disponibles");
                    }
                    break;
            }
        }
    }
//Metodo de agregar miembro milicia
    public void agregarMiembroMilicia(MiembroMilicia miembro) {
        //El miembro se manda por medio de la clase "SegundoParcial"
        //En el menu de crear miembro
        this.miembros.add(miembro);
    }
//Metodo de agregar vehiculo

    public void agregarVehiculo(Vehiculo vehiculo) {
        //El vehiculo se manda por medio de la clase "SegundoParcial"
        //En el menu de crear miembro
        this.vehiculos.add(vehiculo);
    }
    
    //Se asignan los recursos a traves de la clase SegundoParcial
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

    public ArrayList<MiembroMilicia> getMiembros() {
        return miembros;
    }

    public void setMiembros(ArrayList<MiembroMilicia> miembros) {
        this.miembros = miembros;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoparcial;

import java.util.Scanner;

/**
 *
 * @author marielos
 */
public class SegundoParcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Raza jugador1, jugador2;
        int opcion;
        Scanner leer = new Scanner(System.in);
        System.out.println("Bienvenido a Alejandra Najarro's World");
        System.out.println("Jugador 1, escoja una raza");
        jugador1 = pedirRaza();
        separador();
        System.out.println("Jugador 2, escoja una raza");
        jugador2 = pedirRaza();
        separador();
        System.out.println("Jugador 1, vas con: " + jugador1.getNombre_raza());
        System.out.println("Jugador 2, vas con: " + jugador2.getNombre_raza());
        separador();

        do {
            //JUGADOR 1
            separador();
            System.out.println("JUGADOR 1");
            jugador1.mostrarInformacion();
            System.out.println("Jugador 1, que deseas hacer: ");
            System.out.println("1) Generar unidad");
            System.out.println("2) Generar vehiculo");
            System.out.println("3) Atacar");
            System.out.println("4) Recolectar");
            System.out.println("5) Subir de nivel");
            System.out.print("\nDigite opcion: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1: //GENERANDO UNIDAD
                    separador();
                    System.out.println("1) Generar Milicia");
                    System.out.println("2) Generar Especialista");
                    System.out.print("\nDigite opcion: ");
                    opcion = leer.nextInt();
                    switch (opcion) {
                        case 1: //GENERAR MILICIA
                            jugador1.agregarMiembroMilicia(new MiembroMilicia("Milicia " + jugador1.getNombre_raza(), new Vida(1000, "Milicia " + jugador1.getNombre_raza()), 300));
                            jugador1.getMando().getRecurso_a().gastar(200);
                            jugador1.getMando().getRecurso_c().gastar(300);
                            break;
                        case 2: //GENERAR ESPECIALISTA
                            jugador1.agregarMiembroMilicia(new MiembroMilicia("Especialista " + jugador1.getNombre_raza(), new Vida(1500, "Especialista " + jugador1.getNombre_raza()), 400));
                            jugador1.getMando().getRecurso_b().gastar(500);
                            jugador1.getMando().getRecurso_c().gastar(200);
                            break;
                    }
                    break;
                case 2://GENERANDO VEHICULO
                    separador();
                    System.out.println("1) Generar Tanque");
                    System.out.println("2) Generar Avion");
                    System.out.print("\nDigite opcion: ");
                    opcion = leer.nextInt();
                    switch (opcion) {
                        case 1://GENERAR TANQUE
                            jugador1.agregarVehiculo(new Vehiculo("Tanque " + jugador1.getNombre_raza(), new Vida(1000, "Tanque " + jugador1.getNombre_raza()), 500));
                            jugador1.getMando().getRecurso_a().gastar(400);
                            jugador1.getMando().getRecurso_b().gastar(600);
                            break;
                        case 2://GENERAR AVION
                            jugador1.agregarVehiculo(new Vehiculo("Avion " + jugador1.getNombre_raza(), new Vida(1500, "Avion " + jugador1.getNombre_raza()), 600));
                            jugador1.getMando().getRecurso_a().gastar(100);
                            jugador1.getMando().getRecurso_b().gastar(750);
                            break;
                    }
                    break;

                case 3://ATACAR
                    //Escogiendo con quien voy a atacar
                    System.out.println("1) Atacar con un Miembro");
                    System.out.println("2) Atacar con un Vehiculo");
                    System.out.print("\nDigite opcion: ");
                    opcion = leer.nextInt();
                    switch (opcion) {
                        case 1://ATACAR CON MIEMBRO
                            //verificando si hay miembros disponibles para atacar
                            if (jugador1.getMiembros().size() > 0) {
                                System.out.println("Con que miembro quieres atacar");
                                for (int i = 0; i < jugador1.getMiembros().size(); i++) {
                                    System.out.print("\t" + (i + 1) + ") ");
                                    jugador1.getMiembros().get(i).mostrarInformacion();
                                }
                                System.out.print("\nDigite opcion: ");
                                opcion = leer.nextInt();
                                //Luego de mostrar los miembros, el jugador contrario recibe el daño
                                jugador2.recibirDano(jugador1.getMiembros().get(opcion - 1).getAtaque());
                            } else {
                                System.out.println("No tienes miembros disponibles parar atacar");
                            }

                            break;
                        case 2: //ATACAR CON VEHICULO
                            // verficando los vehiculos disponibles para atacar
                            if (jugador1.getVehiculos().size() > 0) {
                                //mostrando vehiculos disponibles para atacar
                                System.out.println("Con que vehiculo quieres atacar");
                                for (int i = 0; i < jugador1.getVehiculos().size(); i++) {
                                    System.out.print("\t" + (i + 1) + ") ");
                                    jugador1.getVehiculos().get(i).mostrarInformacion();
                                }
                                System.out.print("\nDigite opcion: ");
                                opcion = leer.nextInt();
                                //Luego de mostrar los vehiculos, el jugador recibe el daño
                                jugador2.recibirDano(jugador1.getVehiculos().get(opcion - 1).getAtaque());
                            } else {
                                System.out.println("No tienes vehiculos disponibles para atacar");
                            }

                            break;
                    }
                    break;
                case 4: //RECOLECTAR RECURSO
                    System.out.println("1) " + jugador1.getMando().getRecurso_a().getNombre_recurso() + " (100)");
                    System.out.println("2) " + jugador1.getMando().getRecurso_b().getNombre_recurso() + " (130)");
                    System.out.println("3) " + jugador1.getMando().getRecurso_c().getNombre_recurso() + " (150)");
                    System.out.print("\nDigite opcion: ");
                    opcion = leer.nextInt();
                    switch (opcion) {
                        case 1:
                            jugador1.getMando().getRecurso_a().recolectar(100);
                            break;
                        case 2:
                            jugador1.getMando().getRecurso_b().recolectar(130);
                            break;
                        case 3:
                            jugador1.getMando().getRecurso_c().recolectar(150);
                            break;
                    }
                    break;
                case 5: // SUBIR DE NIVEL
                    jugador1.getMando().subirDeNivel();
                    break;
            }

            //JUGADOR 2
            separador();
            System.out.println("JUGADOR 2");
            jugador2.mostrarInformacion();
            System.out.println("Jugador 2, que deseas hacer: ");
            System.out.println("1) Generar unidad");
            System.out.println("2) Generar vehiculo");
            System.out.println("3) Atacar");
            System.out.println("4) Recolectar");
            System.out.println("5) Subir de nivel");
            System.out.print("\nDigite opcion: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1://GENERANDO UNIDAD
                    separador();
                    System.out.println("1) Generar Milicia");
                    System.out.println("2) Generar Especialista");
                    System.out.print("\nDigite opcion: ");
                    opcion = leer.nextInt();
                    switch (opcion) {
                        case 1: //GENERAR MILICIA
                            jugador2.agregarMiembroMilicia(new MiembroMilicia("Milicia " + jugador2.getNombre_raza(), new Vida(2000, "Milicia " + jugador2.getNombre_raza()), 500));
                            jugador2.getMando().getRecurso_a().gastar(350);
                            jugador2.getMando().getRecurso_c().gastar(250);
                            break;
                        case 2: //GENERAR ESPECIALISTA
                            jugador2.agregarMiembroMilicia(new MiembroMilicia("Especialista " + jugador2.getNombre_raza(), new Vida(3000, "Especialista " + jugador2.getNombre_raza()), 200));
                            jugador2.getMando().getRecurso_b().gastar(100);
                            jugador2.getMando().getRecurso_c().gastar(400);
                            break;
                    }
                    break;
                case 2: //GENERANDO VEHICULO
                    separador();
                    System.out.println("1) Generar Tanque");
                    System.out.println("2) Generar Avion");
                    System.out.print("\nDigite opcion: ");
                    opcion = leer.nextInt();
                    switch (opcion) {
                        case 1: //GENERANDO TANQUE
                            jugador2.agregarVehiculo(new Vehiculo("Tanque " + jugador2.getNombre_raza(), new Vida(1700, "Tanque " + jugador2.getNombre_raza()), 550));
                            jugador2.getMando().getRecurso_a().gastar(800);
                            jugador2.getMando().getRecurso_b().gastar(100);
                            break;
                        case 2: //GENERANDO AVION
                            jugador2.agregarVehiculo(new Vehiculo("Avion " + jugador2.getNombre_raza(), new Vida(1300, "Avion " + jugador2.getNombre_raza()), 1000));
                            jugador2.getMando().getRecurso_a().gastar(500);
                            jugador2.getMando().getRecurso_b().gastar(450);
                            break;
                    }
                    break;

                case 3: //ATACAR
                    //Escogiendo con quien voy a atacar
                    System.out.println("1) Atacar con un Miembro");
                    System.out.println("2) Atacar con un Vehiculo");
                    System.out.print("\nDigite opcion: ");
                    opcion = leer.nextInt();
                    switch (opcion) {
                        case 1://ATACAR CON MIEMBRO
                            //verificando si hay miembros disponibles para atacar
                            if (jugador2.getMiembros().size() > 0) {
                                System.out.println("Con que miembro quieres atacar");
                                for (int i = 0; i < jugador2.getMiembros().size(); i++) {
                                    System.out.print("\t" + (i + 1) + ") ");
                                    jugador2.getMiembros().get(i).mostrarInformacion();
                                }
                                System.out.print("\nDigite opcion: ");
                                opcion = leer.nextInt();
                                //Luego de mostrar los miembros, el jugador contrario recibe el daño
                                jugador1.recibirDano(jugador2.getMiembros().get(opcion - 1).getAtaque());
                            } else {
                                System.out.println("No tienes miebros disponibles para atacar");
                            }

                            break;
                        case 2: //ATACAR CON VEHICULO
                            // verficando los vehiculos disponibles para atacar
                            if (jugador2.getVehiculos().size() > 0) {
                                //mostrando vehiculos disponibles para atacar
                                System.out.println("Con que vehiculo quieres atacar");
                                for (int i = 0; i < jugador2.getVehiculos().size(); i++) {
                                    System.out.print("\t" + (i + 1) + ") ");
                                    jugador2.getVehiculos().get(i).mostrarInformacion();
                                }
                                System.out.print("\nDigite opcion: ");
                                opcion = leer.nextInt();
                                //Luego de mostrar los vehiculos, el jugador recibe el daño
                                jugador1.recibirDano(jugador2.getVehiculos().get(opcion - 1).getAtaque());
                            } else {
                                System.out.println("No tienes vehiculos disponibles para atacar");
                            }

                            break;
                    }
                    break;
                case 4: //RECOLECTANDO RECURSOS
                    System.out.println("1) " + jugador2.getMando().getRecurso_a().getNombre_recurso() + " (200)");
                    System.out.println("2) " + jugador2.getMando().getRecurso_b().getNombre_recurso() + " (260)");
                    System.out.println("3) " + jugador2.getMando().getRecurso_c().getNombre_recurso() + " (300)");
                    System.out.print("\nDigite opcion: ");
                    opcion = leer.nextInt();
                    switch (opcion) {
                        case 1: 
                            jugador2.getMando().getRecurso_a().recolectar(200);
                            break;
                        case 2:
                            jugador2.getMando().getRecurso_b().recolectar(260);
                            break;
                        case 3:
                            jugador2.getMando().getRecurso_c().recolectar(300);
                            break;
                    }
                    break;
                case 5: //SUBIR DE NIVEL
                    jugador2.getMando().subirDeNivel();
                    break;
            }

        } while (true);

    }

    public static Raza pedirRaza() {
        Scanner leer = new Scanner(System.in);
        Raza raza = null;
        int opcion;
        System.out.println("1) Alianza");
        System.out.println("2) Lideres");
        System.out.println("3) Horda");
        System.out.print("\nDigite opcion: ");
        opcion = leer.nextInt();
        do {
            switch (opcion) {
                case 1:
                    raza = new Raza("Alianza", "Palacio de Fortaleza", 20000);
                    raza.asignar_recurso_a("Rayo", 10000);
                    raza.asignar_recurso_b("Metal", 5000);
                    raza.asignar_recurso_c("Agua", 3000);
                    break;
                case 2:
                    raza = new Raza("Lideres", "Base Militar", 30000);
                    raza.asignar_recurso_a("Aire", 12000);
                    raza.asignar_recurso_b("Hierro", 5000);
                    raza.asignar_recurso_c("Pieles", 4000);
                    break;
                case 3:
                    raza = new Raza("Horda", "Torre Industrial", 35000);
                    raza.asignar_recurso_a("Piedra", 7000);
                    raza.asignar_recurso_b("Gasolina", 4000);
                    raza.asignar_recurso_c("Aceite", 6500);
                    break;
            }
        } while (opcion < 1 || opcion > 3);

        return raza;
    }

    public static void separador() {
        System.out.println("-------------------------------------------------");
    }

}

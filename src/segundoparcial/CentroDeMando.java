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
    
    private int r_energia_maxima = 10000;
    private int r_hierro_maxima = 5000;
    private int r_agua_maxima = 3000;
    private int r_energia_actual = r_energia_maxima;
    private int r_hierro_actual = r_hierro_maxima;
    private int r_agua_actual = r_agua_maxima;
    private final String nombre_centro;
    private int nivel = 0;
    private int vida_maxima = 20000;
    private int vida_actual = vida_maxima;

//Creando el contructor de la clase centro de mando
    public CentroDeMando(String nombre_centro) {
        this.nombre_centro = nombre_centro;
    }

//Creando el metodo mostrar recursos del centro de mando
    public void mostrarRecursos() {
        System.out.println("Centro de mando: " + nombre_centro);
        System.out.println("\tNivel: " + nivel);
        System.out.println("\tVida: " + vida_actual + "/" + vida_maxima);
        System.out.println("\tEnergia: " + r_energia_actual + "/" + r_energia_maxima);
        System.out.println("\tHierro: " + r_hierro_actual + "/" + r_hierro_maxima);
        System.out.println("\tAgua : " + r_agua_actual + "/" + r_agua_maxima);
    }
    
//Creando el metodo de reducir vida 
    public void reducirVida(int cant){
        if(vida_actual >= cant){
            vida_actual -= cant;
        }
        else{
            System.out.println("El centro de mando "+ nombre_centro + " ha caido");
            vida_actual =0;
        }
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

//Crenado el metodo recolectar energia 
    public void recolectarEnergia(int cant) {
        if ((r_energia_actual + cant) <= r_energia_maxima) {
            r_energia_actual += cant;
        } else {
            System.out.println("Recurso Energia maxima alcanzada");
            r_energia_actual = r_energia_maxima;
        }
    }
//Creando el metodo recolectar hierro

    public void recolectarHierro(int cant) {
        if ((r_hierro_actual + cant) <= r_hierro_maxima) {
            r_hierro_actual += cant;
        } else {
            System.out.println("Recurso Hierro maximo alcanzado");
            r_hierro_actual = r_hierro_maxima;
        }
    }
//Creando el metodo recolecta agua

    public void recolectarAgua(int cant) {
        if ((r_agua_actual + cant) <= r_agua_maxima) {
            r_agua_actual += cant;
        } else {
            System.out.println("Recurso Agua maxima alcanzada");
            r_agua_actual = r_agua_maxima;
        }
    }

//Creando el metodo de subir de nivel
    public void subirDeNivel() {
        int gasto;
        if (nivel < 3) {
            nivel++;
            switch (nivel) {
                case 1:
                    gasto = (int) (0.25 * 1.10 * (r_energia_maxima + r_hierro_maxima + r_agua_maxima) / 3);
                    if (r_energia_actual >= gasto && r_hierro_actual >= gasto && r_agua_actual >= gasto) {
                        r_energia_actual -= gasto;
                        r_hierro_actual -= gasto;
                        r_agua_actual -= gasto;

                        r_energia_maxima *= 1.10;
                        r_hierro_maxima *= 1.10;
                        r_agua_maxima *= 1.10;
                    } else {
                        System.out.println("Error: Recursos insuficientes se necesita " + gasto + " por recurso");
                        nivel--;
                    }
                    break;

                case 2:
                    gasto = (int) (0.25 * 1.30 * (r_energia_maxima + r_hierro_maxima + r_agua_maxima) / 3);
                    if (r_energia_actual >= gasto && r_hierro_actual >= gasto && r_agua_actual >= gasto) {
                        r_energia_actual -= gasto;
                        r_hierro_actual -= gasto;
                        r_agua_actual -= gasto;

                        r_energia_maxima *= 1.30;
                        r_hierro_maxima *= 1.30;
                        r_agua_maxima *= 1.30;
                    } else {
                        System.out.println("Error: Recursos insuficientes se necesita " + gasto + " por recurso");
                        nivel--;
                    }
                    break;
                case 3:
                    gasto = (int) (0.25 * 1.50 * (r_energia_maxima + r_hierro_maxima + r_agua_maxima) / 3);
                    if (r_energia_actual >= gasto && r_hierro_actual >= gasto && r_agua_actual >= gasto) {
                        r_energia_actual -= gasto;
                        r_hierro_actual -= gasto;
                        r_agua_actual -= gasto;

                        r_energia_maxima *= 1.50;
                        r_hierro_maxima *= 1.50;
                        r_agua_maxima *= 1.50;
                    } else {
                        System.out.println("Error: Recursos insuficientes se necesita " + gasto + " por recurso");
                        nivel--;
                    }
                    break;
            }
        } else {
            System.out.println("Error: Nivel maximo de " + nombre_centro + " alcanzado");
        }
    }
}

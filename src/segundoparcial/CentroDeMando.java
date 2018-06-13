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
//Los atributos de la clase centro de mando

    private Recurso recurso_a;
    private Recurso recurso_b;
    private Recurso recurso_c;
    private final String nombre_centro;
    private int nivel = 0;
    private Vida vida;

//Creando el contructor de la clase centro de mando
    public CentroDeMando(String nombre_centro, int vida_maxima) {
        this.nombre_centro = nombre_centro;
        vida = new Vida(vida_maxima, nombre_centro);
    }

//Creando el metodo mostrar recursos del centro de mando
    public void mostrarRecursos() {
        System.out.println("Centro de mando: " + nombre_centro);
        System.out.println("\tNivel: " + nivel);
        System.out.println("\tVida: " + vida.getActual() + "/" + vida.getMaxima());
        recurso_a.mostrarRecurso();
        recurso_b.mostrarRecurso();
        recurso_c.mostrarRecurso();
    }

//Creando el metodo de subir de nivel
    public void subirDeNivel() {
        int gasto;
        if (nivel < 3) {
            nivel++;
            switch (nivel) {
                case 1:
                    gasto = (int) (0.25 * 1.10 * (recurso_a.getVal_maximo() + recurso_b.getVal_maximo() + recurso_c.getVal_maximo()) / 3);
                    if (recurso_a.getVal_actual() >= gasto && recurso_b.getVal_actual() >= gasto && recurso_c.getVal_actual() >= gasto) {
                        recurso_a.gastar(gasto);
                        recurso_b.gastar(gasto);
                        recurso_c.gastar(gasto);

                        recurso_a.setVal_maximo((int) (recurso_a.getVal_maximo() * 1.10));
                        recurso_b.setVal_maximo((int) (recurso_b.getVal_maximo() * 1.10));
                        recurso_c.setVal_maximo((int) (recurso_c.getVal_maximo() * 1.10));
                    } else {
                        System.out.println("Error: Recursos insuficientes se necesita " + gasto + " por recurso");
                        nivel--;
                    }
                    break;

                case 2:
                    gasto = (int) (0.25 * 1.30 * (recurso_a.getVal_maximo() + recurso_b.getVal_maximo() + recurso_c.getVal_maximo()) / 3);
                    if (recurso_a.getVal_actual() >= gasto && recurso_b.getVal_actual() >= gasto && recurso_c.getVal_actual() >= gasto) {
                        recurso_a.gastar(gasto);
                        recurso_b.gastar(gasto);
                        recurso_c.gastar(gasto);

                        recurso_a.setVal_maximo((int) (recurso_a.getVal_maximo() * 1.30));
                        recurso_b.setVal_maximo((int) (recurso_b.getVal_maximo() * 1.30));
                        recurso_c.setVal_maximo((int) (recurso_c.getVal_maximo() * 1.30));
                    } else {
                        System.out.println("Error: Recursos insuficientes se necesita " + gasto + " por recurso");
                        nivel--;
                    }
                    break;
                case 3:
                    gasto = (int) (0.25 * 1.50 * (recurso_a.getVal_maximo() + recurso_b.getVal_maximo() + recurso_c.getVal_maximo()) / 3);
                    if (recurso_a.getVal_actual() >= gasto && recurso_b.getVal_actual() >= gasto && recurso_c.getVal_actual() >= gasto) {
                        recurso_a.gastar(gasto);
                        recurso_b.gastar(gasto);
                        recurso_c.gastar(gasto);

                        recurso_a.setVal_maximo((int) (recurso_a.getVal_maximo() * 1.50));
                        recurso_b.setVal_maximo((int) (recurso_b.getVal_maximo() * 1.50));
                        recurso_c.setVal_maximo((int) (recurso_c.getVal_maximo() * 1.50));
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
//Get y set 

    public Recurso getRecurso_a() {
        return recurso_a;
    }

    public void setRecurso_a(Recurso recurso_a) {
        this.recurso_a = recurso_a;
    }

    public Recurso getRecurso_b() {
        return recurso_b;
    }

    public void setRecurso_b(Recurso recurso_b) {
        this.recurso_b = recurso_b;
    }

    public Recurso getRecurso_c() {
        return recurso_c;
    }

    public void setRecurso_c(Recurso recurso_c) {
        this.recurso_c = recurso_c;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Vida getVida() {
        return this.vida;
    }

}

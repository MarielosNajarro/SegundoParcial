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
public class Recurso {
//Atributos de la clase Recurso

    private String nombre_recurso;
    private int val_maximo;
    private int val_actual;

//Constructor de la clase Recurso
    public Recurso(String nombre_recurso, int valor) {
        this.nombre_recurso = nombre_recurso;
        this.val_maximo = valor;
        this.val_actual = valor;
    }

    public void mostrarRecurso() {
        System.out.println("\t\t" + nombre_recurso + ": " + val_actual + "/" + val_maximo);
    }
//Metodo gastar recurso

    public void gastar(int cant) {
        if (val_actual >= cant) {
            val_actual -= cant;
        } else {
            System.out.println("Recurso " + nombre_recurso
                    + " insuficiente");
        }
    }
//Metodo recolectar recurso  

    public void recolectar(int cant) {
        if ((val_actual + cant) <= val_maximo) {
            val_actual += cant;
        } else {
            System.out.println("El recurso " + nombre_recurso + " ya esta lleno");
            val_actual = val_maximo;
        }

    }
//Get y set de los atributos 

    public String getNombre_recurso() {
        return nombre_recurso;
    }

    public void setNombre_recurso(String nombre_recurso) {
        this.nombre_recurso = nombre_recurso;
    }

    public int getVal_maximo() {
        return val_maximo;
    }

    public void setVal_maximo(int val_maximo) {
        this.val_maximo = val_maximo;
    }

    public int getVal_actual() {
        return val_actual;
    }

    public void setVal_actual(int val_actual) {
        this.val_actual = val_actual;
    }
}

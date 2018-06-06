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
    private String nombre_recurso;
    private int val_maximo;
    private int val_actual;
    
//Constructor de la clase Recurso
    public Recurso(String nombre_recurso, int valor){
        this.nombre_recurso = nombre_recurso;
        this.val_maximo = valor;
        this.val_actual = valor;
    }
    
    
}

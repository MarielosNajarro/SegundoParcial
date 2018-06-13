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
public class EdificioRecurso {

    private String nombre_edificio_recurso;
    private Recurso recurso;
    private Vida vida;
    private int recoleccion_por_turno;

    public EdificioRecurso(Recurso recurso, String nombre_edificio_recurso, int vida_edificio, int recoleccion_por_turno) {
        this.recurso = recurso;
        this.nombre_edificio_recurso = nombre_edificio_recurso;
        vida = new Vida(vida_edificio, nombre_edificio_recurso);
        this.recoleccion_por_turno = recoleccion_por_turno;
    }

    public void recolectar() {
        recurso.recolectar(recoleccion_por_turno);
    }
}

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
public class SegundoParcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Raza alianza = new Raza("Alianza", "Cuartel");
        alianza.asignar_recurso_a("Hielo", 1000);
        alianza.asignar_recurso_b("Fuego", 3000);
        alianza.asignar_recurso_c("Agua", 4000);
        
        alianza.getMando().getRecurso_b().gastar(400);
        alianza.getMando().getRecurso_b().recolectar(100);
        
        alianza.mostrarInformacion();
        
        Raza horda = new Raza("Horda", "Palacio");
        horda.asignar_recurso_a("Tierra", 1000);
        horda.asignar_recurso_b("Energia", 1000);
        horda.asignar_recurso_c("Poder", 1000);
        
        horda.getMando().getRecurso_b().gastar(1);
        horda.getMando().subirDeNivel();
        horda.mostrarInformacion();
    }
    
}

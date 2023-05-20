/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import guarderia.Gato;
import guarderia.Registro;

/**
 *
 * @author Dario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Gato ga = new Gato("luna", "maria", "676245540");
        
        Registro reges = new Registro();
        reges.listarDueño("pepe");
    }
    
}

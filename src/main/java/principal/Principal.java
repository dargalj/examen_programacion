/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

import errores.telefonoIncorrecto;
import guarderia.Gato;
import guarderia.Perro;
import guarderia.Registro;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Gato ga = new Gato("luna", "maria", "123456789");
            Perro pe = new Perro("canela", "marta", "676245540");
        } catch (telefonoIncorrecto ex) {
            System.out.println("El telefono tiene que tener 9 digitos");
        }
        
        Registro reges = new Registro();
        reges.listarDueño("pepe");
    }
    
}

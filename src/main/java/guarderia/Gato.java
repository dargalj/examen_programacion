/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guarderia;

import errores.telefonoIncorrecto;

/**
 *
 * @author Dario
 */
public class Gato extends Animal{

    public Gato() {
    }

    public Gato(String nombreAnimal, String nomnbreDueño, String telefono) throws telefonoIncorrecto {
        super(nombreAnimal, nomnbreDueño, telefono);
    }
    
}

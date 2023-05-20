/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guarderia;

import errores.telefonoIncorrecto;
import java.time.LocalDateTime;

/**
 *
 * @author Dario
 */
public abstract class Animal {
    private String nombreAnimal;
    private String nomnbreDueño;
    private String telefono;
    private final double costePerro = 4.5;
    private final double costeGato = 4;

    public Animal() {
    }

    public Animal(String nombreAnimal, String nomnbreDueño, String telefono) throws telefonoIncorrecto {
        this.nombreAnimal = nombreAnimal;
        this.nomnbreDueño = nomnbreDueño;
        //if(this.telefono.matches("[0-9]{9}")){
        if(this.telefono.matches("[0-9]{9}")){
            throw new telefonoIncorrecto();
        }
        else{
            this.telefono = telefono;
        }

    }
    /**
     * @return the nombreAnimal
     */
    public String getNombreAnimal() {
        return nombreAnimal;
    }

    /**
     * @param nombreAnimal the nombreAnimal to set
     */
    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    /**
     * @return the nomnbreDueño
     */
    public String getNomnbreDueño() {
        return nomnbreDueño;
    }

    /**
     * @param nomnbreDueño the nomnbreDueño to set
     */
    public void setNomnbreDueño(String nomnbreDueño) {
        this.nomnbreDueño = nomnbreDueño;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @author Dario
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        if(this instanceof Perro){
            return "- El perro " + nombreAnimal + " del due\u00f1o" + nomnbreDueño + " con telefono de contacto " + telefono + '}';
        }
        else{
            return "- El gato " + nombreAnimal + " del due\u00f1o" + nomnbreDueño + " con telefono de contacto " + telefono + '}';
        }
    }

    public double calcularCoste(LocalDateTime horaEnt, LocalDateTime horaSal){
        int horas;
        horas = horaSal.getDayOfYear() - horaEnt.getDayOfYear();
        horas += horaSal.getHour() - horaEnt.getHour();
        
        if((horaSal.getMinute() - horaEnt.getMinute()) != 0){
            horas++;
        }
        
        if(this instanceof Perro){
            return horas*costePerro;
        }
        else{
            return horas*costeGato;
        }
    }
}

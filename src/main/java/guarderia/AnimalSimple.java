/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guarderia;

import java.time.LocalDateTime;

/**
 *
 * @author Dario
 */
public class AnimalSimple {
    private String nombreAnimal;
    private String nomnbreDueño;
    private String telefono;
    private final double costePerro = 4.5;
    private final double costeGato = 4;
    boolean esPerro;

    public AnimalSimple() {
    }

    public AnimalSimple(String nombreAnimal, String nomnbreDueño, String telefono) {
        this.nombreAnimal = nombreAnimal;
        this.nomnbreDueño = nomnbreDueño;
        this.telefono = telefono;
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
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "- El animal " + nombreAnimal + " del due\u00f1o" + nomnbreDueño + " con telefono de contacto " + telefono + '}';
    }

    public double calcularCoste(LocalDateTime horaEnt, LocalDateTime horaSal){
        int horas;
        horas = horaSal.getDayOfYear() - horaEnt.getDayOfYear();
        horas += horaSal.getHour() - horaEnt.getHour();
        
        if((horaSal.getMinute() - horaEnt.getMinute()) != 0){
            horas++;
        }
        
        if(esPerro){
            return horas*costePerro;
        }
        else{
            return horas*costeGato;
        }
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guarderia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dario
 */
public class Registro {
    private TreeMap<LocalDateTime, Animal> registro = new TreeMap();

    public Registro() {
    }
    
    public void crearRegistro(LocalDateTime fecha, Animal animal){
        this.registro.put(fecha, animal);
    }
    
    public void listarAnimales(){
        HashSet<Animal> animal = new HashSet();
        for(Map.Entry<LocalDateTime, Animal> entry : registro.entrySet()){
            animal.add(entry.getValue());
        }
        for(Animal a : animal){
            System.out.println(a.toString());
        }
    }
    
    public void listarPerror(){
        HashSet<Animal> animal = new HashSet();
        for(Map.Entry<LocalDateTime, Animal> entry : registro.entrySet()){
            if(entry.getValue() instanceof Perro){
                animal.add(entry.getValue());
            }
        }
        for(Animal a : animal){
            System.out.println(a.toString());
        }
    }
    
    public void listarGatos(){
        HashSet<Animal> animal = new HashSet();
        for(Map.Entry<LocalDateTime, Animal> entry : registro.entrySet()){
            if(entry.getValue() instanceof Gato){
                animal.add(entry.getValue());
            }
        }
        for(Animal a : animal){
            System.out.println(a.toString());
        }
    }
    
    public int contarAnimales(){
        HashSet<Animal> animal = new HashSet();
        for(Map.Entry<LocalDateTime, Animal> entry : registro.entrySet()){
            animal.add(entry.getValue());
        }
        return animal.size();
    }
    
    public void borrarAnimal(Animal animal){
        HashSet<LocalDateTime> horas = new HashSet();
        for(Map.Entry<LocalDateTime, Animal> entry : registro.entrySet()){
            if(entry.getValue().equals(animal)){
                horas.add(entry.getKey());
            }
        }
        for(LocalDateTime hora : horas){
            registro.remove(hora);
        }
    }
    
    public void guardarAnimales(LocalDate dia){
        HashSet<Animal> animal = new HashSet();
        for(Map.Entry<LocalDateTime, Animal> entry : registro.entrySet()){
            if(entry.getKey().toLocalDate().equals(dia)){
                animal.add(entry.getValue());
            }
        }
        try {
            FileWriter fw = new FileWriter(dia.toString() + ".txt");
            PrintWriter pw = new PrintWriter(fw);
            for(Animal a : animal){
                pw.println(a.toString());
            }
            pw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listarDueño(String dueño){
        try {
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/prueba","root", "root");
            PreparedStatement stm = con.prepareStatement("SELECT * FROM animales WHERE dueño = ?");
            stm.setString(1, dueño);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1) + "\t" + rs.getString(2));
            }
            stm.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

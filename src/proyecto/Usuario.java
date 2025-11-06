/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.Objects;

/**
 * Clase usuario que representa un nodo en el grafo
 * @author Kelvin Hurtado
 * @version: 04/11/25
 * 
 */
public class Usuario {
    private String nombre; 
    private int id;

    public Usuario() {
        this.nombre = "";
        this.id = -1;
    }
    
    // Constructor con el parámetro
    
    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    Usuario(String linea) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /** 
     * Getter para el nombre
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**  
     * Setter para el nombre
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**  
     * Getter para el ID
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**  
     * Setter para el ID
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /** 
     * Valida si el nombre es válido, entonces debe empezar con @ y no estar vacío
     * @return true si es válido y false en caso contrario
     */
    
    public boolean esNombreValido() {
        return nombre != null && !nombre.trim().isEmpty() && nombre.startsWith("@");
        
    }
    
    /** 
     * Es para representar en cadena del usuario
     * @return Una cadena con el NOMBRE y el ID
     */
    @Override
    
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
    
    /** 
     * Estoy comparando dos usuarios por nombre
     * @param obj El objeto a comnparar
     * @return true si son iguales, false en caso contrario
     */
    @Override
    
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario =(Usuario) obj;
        return Objects.equals(nombre, usuario.nombre);
    }
    
    /**
     * Es para generar un hashCode basado en el nombre
     * @return El hashCode
     * 
     */
    
    public int hasCode(){
        return Objects.hash(nombre);
    } 

    Object trim() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

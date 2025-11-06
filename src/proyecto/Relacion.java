/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author USUARIO
 */
public class Relacion {
    private Usuario origen;
    private Usuario destino;

    public Relacion(Usuario origen, Usuario destino) {
        this.origen = origen;
        this.destino = destino;
    }
    
    

    /** Getter Origen
     * @return the origen
     */
    public Usuario getOrigen() {
        return origen;
    }

    /** Setter Origen
     * @param origen the origen to set
     */
    public void setOrigen(Usuario origen) {
        this.origen = origen;
    }

    /** Getter para Destino
     * @return the destino
     */
    public Usuario getDestino() {
        return destino;
    }

    /** Setter para Destino
     * @param destino the destino to set
     */
    public void setDestino(Usuario destino) {
        this.destino = destino;
    }
    
 
      
    @Override
    public boolean equals(Object obj) {            // Equals para comparar por origen y destino
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false; 
        Relacion relacion = (Relacion) obj;
        return origen.equals(relacion.origen) && destino.equals(relacion.destino);
    }
    
    
   
    public int HashCode() {                        // HashCode para la Relación como clave en mapas o los sets (es importante)
        return origen.hasCode() * 31 + destino.hasCode();
    }
    
    @Override
    public String toString() {                     // Para mostrar información útil en depuración
        return origen + " -> " + destino;
    }   
}

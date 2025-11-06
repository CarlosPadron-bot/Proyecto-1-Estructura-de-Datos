/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.*;

/**
 *Implementación de la clase grafo dirigido
 * Uso de lista de adyacencia para las relaciones
 * @author Kelvin Hurtado
 * @version: 05/11/25
 * 
 */
public class Grafo {

    public HashMap<String, Usuario> usuarios; //Mapa de nombre a Usuario
    public HashMap<String, ArrayList<String>> adyacencias; //Mapa de nombre a lista de seguidos
    private boolean cambiosPendientes; // Para cualquier alerta de guardado
    private int contadorId; // Asigna Id únicos a los usuarios

    public Grafo() {
        this.usuarios = new HashMap<>();
        this.adyacencias = new HashMap<>();
        this.cambiosPendientes = false;
        this.contadorId = 0;
    }
    
    /**
     * Para agregar un usuario al grafo si no existe
     * @param nombre El nombre del usuario 
     * @return true si se agregó y false si ya existía el usuario
     */
    public boolean agregarUsuario(String nombre) {
        if (!usuarios.containsKey(nombre)) {
            Usuario nuevoUsuario = new Usuario(nombre, contadorId++);
            getUsuarios().put(nombre, nuevoUsuario);
            getAdyacencias().put(nombre, new ArrayList<>());
            cambiosPendientes = true;
            return true;
        }
        return false;
    }
    
    /**
     * Esta parte agrega una relación dirigida de origen a destino 
     * @param nombre del usuario a origen
     * @param nombre del usuario a destino
     * @return true si ya se agregó y false si no existen o ya existe la relación
     */
    
    public boolean agregarRelacion(String origen, String destino) {
        if (getUsuarios().containsKey(origen) && getUsuarios().containsKey(destino)) {
            ArrayList<String> lista = getAdyacencias().get(origen);
            if (getUsuarios().containsKey(destino)) {
                lista.add(destino);
                cambiosPendientes = true;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Verifica si un usuario ya existe
     * @param nombre El nombre del usuario
     * @return true si existe y false en caso contrario
     */
    public boolean existeUsuario(String nombre) {
        return getUsuarios().containsKey(nombre);
    }
    
    /** Aqui se puede obtener el grado de salida de un usuario
     * (que en este caso es el numero de seguidos)
     * @param usuario el nombre del usuario
     * @return el grado de salida, o retorna a -1 si no existe
     */
    
    public int ObtenerGradoSalida(String nombre) {
        if (getAdyacencias().containsKey(nombre)) {
            return getAdyacencias().get(nombre).size();
        }
        return -1;
    }
    
    /**
     * Aqui se puede obtener el grado de entrada de un usuario
     * (numero de seguidores) 
     * @param usuario el nombre del usuario
     * @return el grado de entrada, o retorna a -1 si no existe 
     */
    
     public int obtenerGradoEntrada(String nombre) {
        if (!usuarios.containsKey(nombre)) return -1;
        int grado = 0;
        for (ArrayList<String> lista : getAdyacencias().values()) {
            if (lista.contains(nombre)) {
                grado++;
            }
        }
        return grado;
     }
     
     /**
      * Lista todos los nombres de usuarios
      * @return lista de Strings con los nombres
      */
     
    public List<String> listarUsuarios() {
        return new ArrayList<>(getUsuarios().keySet());
    }
    
    /**
     * Verifica si hay cambios pendientes
     * @return true si hay cambios, false en caso contrario 
     */
    
    public boolean hayCambiosPendientes() {
        return cambiosPendientes;
    }
    
    /**
     * Marca los cambios pendientes
     * @param valor true para marcar como pendientes y false para limpiar
     */
    
     public void marcarCambios(boolean valor) {
        this.cambiosPendientes = valor;
    }
    
    /**
     * Representación en cadena del grafo
     * @return Una cadena con usuarios y relaciones
     */
    
     public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuarios:\n");
        for (Usuario u : getUsuarios().values()) {
            sb.append(u.toString()).append("\n");
        }
        sb.append("Relaciones:\n");
        for (Map.Entry<String, ArrayList<String>> entry : getAdyacencias().entrySet()) {
            sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
    
    void agregarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //***********************************************
    
    /**
     * Realiza una búsqueda en profundidad (DFS) desde un nodo inicial
     * @param inicio El nombre del nodo inicial
     * @return Lista de nodos visitados en orden DFS
     */
    
    public List<String> dfs(String inicio) {
        List<String> visitados = new ArrayList<>();
        Set<String> visitadosSet = new HashSet<>();
        if (!usuarios.containsKey(inicio)) return visitados;
        dfsRecursivo(inicio, visitadosSet, visitados);
        return visitados;
    }
    
    private void dfsRecursivo(String nodo, Set<String> visitadoSet, List<String> visitados) {
        visitadoSet.add(nodo);
        visitados.add(nodo);
        for (String vecino : getAdyacencias().get(nodo)) {
            if(!visitadoSet.contains(vecino)) {
                dfsRecursivo(vecino,visitadoSet, visitados);
            }
        }
    }
    
    /**
     * Realiza una búsqueda en anchura (BFS) desde un nodo inicial
     * @param inicio El nombre del nodo inicial
     * @return Lista de nodos visitados en orden BFS
     */
    
    public List<String> bfs(String inicio) {
        List<String> visitados = new ArrayList<>();
        Set<String> visitadoSet = new HashSet<>();
        Queue<String> cola = new LinkedList<>();
            if (!usuarios.containsKey(inicio)) return visitados;
            cola.add(inicio);
            visitadoSet.add(inicio);
            while (!cola.isEmpty()) {
                String actual = cola.poll();
                visitados.add(actual);
                for (String vecino : getAdyacencias().get(actual)) {
                    if (!visitadoSet.contains(vecino)) {
                        visitadoSet.add(vecino);
                        cola.add(vecino);
                    }
                }
            }
            return visitados;
    }

    /**
     * @return the usuarios
     */
    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @return the adyacencias
     */
    public HashMap<String, ArrayList<String>> getAdyacencias() {
        return adyacencias;
    }

 
    
}

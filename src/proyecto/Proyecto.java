/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import javax.swing.SwingUtilities;

/**
 *
 * @author USUARIO
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        ArchivoManager archivoManager = new ArchivoManager(grafo);
        
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal(grafo, archivoManager);
        });
       
    }
    
}

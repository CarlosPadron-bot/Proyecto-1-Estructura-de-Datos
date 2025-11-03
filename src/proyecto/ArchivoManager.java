/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package proyecto;

        
/**
 * Implemento de JFileChooser para el archivo txt
 * @author Kelvin Hurtado
 * @version: 31/11/25
 */

import javax.swing.JFileChooser;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoManager {
    private JFileChooser fileChooser;
   
// ---> Aquí estoy creando el método para abrir el archivo
    
public String cargarArchivoConJFileChooser() {
    JFileChooser fileChooser = new JFileChooser();
    int resultado = fileChooser.showOpenDialog(null); // ventana para seleccionar el archivo

    if (resultado == JFileChooser.APPROVE_OPTION) {
        File archivo = fileChooser.getSelectedFile();
        return archivo.getAbsolutePath();
    }
    return null;
}

// ---> Con esto se puede acceder a leer el archivo seleccionado

public void leerArchivo(String rutaArchivo) {
    try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            // Procesa cada línea (usuarios o relaciones)
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

// ---> Para llamar desde ArchivoManager
// Permite al usuario seleccionar el archivo necesario y luego leerlo
// para cargar usuarios y relaciones en el grafo

public void cargarArchivo() {
        String file = null;
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        boolean enUsuarios = false;
        boolean enRelaciones = false;
        while ((line = br.readLine()) != null) {
            if (line.equals("usuarios")) {
                enUsuarios = true;
                enRelaciones = false;
            } else if (line.equals("relaciones")) {
                enUsuarios = false;
                enRelaciones = true;
            } else if (enUsuarios && !line.trim().isEmpty()) {
                // Agregar usuario al grafo (nodo)
               
            } else if (enRelaciones && !line.trim().isEmpty()) {
                // Parsear relación
                String[] partes = line.split(",");
                if (partes.length == 2) {
                    String usuario1 = partes[0].trim();
                    String usuario2 = partes[1].trim();
                    // Para recordar agregar las arista al grafo
                    
                }
            }
        }
    } catch (IOException e) {
        // Para Manejar si hay error, ("Error al cargar archivo");
    }
}
        
    }





    
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package proyecto;

        
/**
 * Implemento de JFileChooser para el archivo txt
 * @author Kelvin Hurtado
 * @version: 04/11/25
 */

import javax.swing.JFileChooser;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;


public class ArchivoManager {                       // Para seleccionar el archivo con JFileChooser
    public String seleccionarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            return archivo.getAbsolutePath();
        }
        return null;
    }
   
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

public void leerArchivo(String rutaArchivo, Grafo grafo) {
    try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
        String linea;
        boolean leyendoUsuarios = false;
        boolean leyendoRelaciones = false;
        Map<String, Usuario> mapaUsuarios = new HashMap<>();  // Encontrar usuarios por nombre
        
        while ((linea = br.readLine()) != null) {
            linea=linea.trim();
            // Procesa cada línea (usuarios o relaciones)
            
            if (linea.equalsIgnoreCase("usuarios")) {
                leyendoUsuarios = true;
                leyendoRelaciones = false;
                continue;
            } else if (linea.equalsIgnoreCase("relaciones")) {
                leyendoRelaciones = true;
                leyendoUsuarios = false;
                continue;
            }

            if (leyendoUsuarios && !linea.isEmpty()) {
                Usuario usuario = new Usuario(linea);
                grafo.agregarUsuario(usuario);
                mapaUsuarios.put(linea, usuario);
            }

            if (leyendoRelaciones && !linea.isEmpty()) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    Usuario origen = mapaUsuarios.get(partes[0].trim());
                    Usuario destino = mapaUsuarios.get(partes[1].trim());
                    if (origen != null && destino != null) {
                        mapa.agregarRelacion(origen, destino);
                    }else {
                    
                        System.out.println("No se ha encontrado ningún usuario para la relación: ");
                    }
                }
            }
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

public void guardarGrafoEnArchivo(Grafo grafo, String rutaArchivo) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
        bw.write("usuarios\n");
        for (String usuario : grafo.listarUsuarios()) {
            bw.write(usuario + "\n");
        }
        bw.write("relaciones\n");
        for (String origen : grafo.listarUsuarios()) {
            for (String destino : grafo.getAdyacencias().get(origen)) {
                bw.write(origen + ", " + destino + "\n");
            }
        }
        grafo.marcarCambios(false); // Limpiar cambios pendientes
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    
}
    

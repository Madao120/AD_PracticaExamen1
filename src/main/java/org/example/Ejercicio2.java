package org.example;
/*
Partiendo del alumnos.txt del ejercicio anterior:

Escribe inicialmente:
Juan
María
Pedro
Después añade al final:
Ana
Luis
Finalmente, lee el archivo y muestra todas las líneas por pantalla.

El resultado debería ser:

Juan
María
Pedro
Ana
Luis

Pistas: FileWriter, BufferedWriter, FileReader, BufferedReader.
*/

import java.io.*;

public class Ejercicio2 {
    static String contenido = "Juan\n" +
            "María\n" +
            "Pedro\n" +
            "Ana\n" +
            "Luis";
    static String ruta = "C:\\Users\\DIEGO CURRÁS\\Desktop\\DAM2\\Acceso_Datos\\Trimestre_1\\AD_Practica1_Ex1\\examen\\alumnos.txt";
    static void main() {

    // Añadir Texto

        try (BufferedWriter escritor =
                     new BufferedWriter(new FileWriter(ruta))) {
            escritor.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Añadir texto al archivo, ponemos la misma ruta en el in y en out
        try (BufferedWriter escritor =
                     new BufferedWriter(new FileWriter(ruta, true))) {

            escritor.newLine();
            escritor.write(contenido);

        } catch (IOException e) {
            e.printStackTrace();
        }

    // Leer Texto
        try (BufferedReader lector =
                     new BufferedReader(new FileReader(ruta))) {

            String linea;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



        // Copiar y pegar en nuevo archivo
        String ruta2 = "C:\\Users\\DIEGO CURRÁS\\Desktop\\DAM2\\Acceso_Datos\\Trimestre_1\\AD_Practica1_Ex1\\examen\\alumnos2.txt";
        try (BufferedInputStream in =
                     new BufferedInputStream(new FileInputStream(ruta));
             BufferedOutputStream out =
                     new BufferedOutputStream(new FileOutputStream(ruta2))){
             int b;
             while((b = in.read()) != -1){
                 out.write(b);
             }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Copiar y pegar en nuevo archivo
        String ruta3 = "C:\\Users\\DIEGO CURRÁS\\Desktop\\DAM2\\Acceso_Datos\\Trimestre_1\\AD_Practica1_Ex1\\examen\\alumnos3.txt";

        try (BufferedInputStream in =
                     new BufferedInputStream(new FileInputStream(ruta));
             BufferedOutputStream out =
                     new BufferedOutputStream(new FileOutputStream(ruta3))){
             int b;
             while((b = in.read()) != -1){
                 out.write(b);
             }

            String textoPersonalizado = "\nBien gracias, y tu?";
            out.write(textoPersonalizado.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
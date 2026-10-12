package org.example;

import java.io.*;

/*
* Crea una clase:

Producto

con:
nombre
precio
cantidad

El programa debe:

Crear un objeto Producto.
Guardarlo en un archivo mediante serialización.
Leer posteriormente el objeto del archivo.
Mostrar sus datos por pantalla.

Por ejemplo:

Producto: Teclado
Precio: 25.99
Cantidad: 3

Pistas: Serializable, ObjectOutputStream, ObjectInputStream, writeObject(), readObject().
* */
public class Ejercicio3 {
    static void main() throws IOException, ClassNotFoundException {
        Producto p1 = new Producto("Air Frier", 45.99, 3);
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("serial.txt"));
        oos.writeObject(p1);
        oos.close();

        String rutaObjeto = "C:\\Users\\DIEGO CURRÁS\\Desktop\\DAM2\\Acceso_Datos\\Trimestre_1\\AD_Practica1_Ex1\\serial.txt";

        try (BufferedReader lector =
                     new BufferedReader(new FileReader(rutaObjeto))) {

            String linea;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(p1.toString());

        // Crear un objeto a partir de serial
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serial.txt"));
        Producto p2 = (Producto) ois.readObject();
        ois.close();

        System.out.println(p2.toString());

    }
}

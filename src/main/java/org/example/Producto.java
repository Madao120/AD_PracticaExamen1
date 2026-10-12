package org.example;

import java.io.Serializable;

public class Producto implements Serializable {
    String nombre;
    double precio;
    transient int cantidad = 1;

    public Producto (String nombre, double precio, int cantidad){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto (String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString(){
        return "Producto " + nombre + "\nPrecio: "+ precio + "\nCantidad: " + cantidad;
    }
}

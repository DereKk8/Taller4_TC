package com.example;

import com.example.controladores.ProductoControlador;
import com.example.modelo.Producto;

public class Aplicacion {
    public static void main(String[] args) {
        ProductoControlador controlador = new ProductoControlador();

        System.out.println("Lista inicial de productos:");
        controlador.listarProductos().forEach(System.out::println);

        System.out.println("\nObteniendo producto con ID 1:");
        System.out.println(controlador.obtenerProducto(1L));

        System.out.println("\nActualizando precio del producto ID 1 a 1299.99");
        controlador.actualizarPrecioProducto(1L, 1299.99);

        System.out.println("\nProducto actualizado:");
        System.out.println(controlador.obtenerProducto(1L));

        System.out.println("\nAgregando nuevo producto");
        controlador.agregarProducto(new Producto(4L, "Monitor", 300.00));

        System.out.println("\nLista final de productos:");
        controlador.listarProductos().forEach(System.out::println);

        System.out.println("\nEliminando producto ID 2");
        controlador.eliminarProducto(2L);

        System.out.println("\nLista después de eliminar:");
        controlador.listarProductos().forEach(System.out::println);
    }
}
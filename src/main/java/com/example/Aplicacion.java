package com.example;

import com.example.config.AppConfig; // Importar tu configuración
import com.example.controladores.ProductoControlador;
import com.example.modelo.Producto;
import org.springframework.context.annotation.AnnotationConfigApplicationContext; // Importar

public class Aplicacion {
    public static void main(String[] args) {
        // 1. Inicializar el contexto de Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. Obtener el bean del controlador desde el contexto de Spring
        ProductoControlador controlador = context.getBean(ProductoControlador.class);

        // Ahora, cuando llames a los métodos de 'controlador',
        // los aspectos de logging deberían funcionar porque 'controlador'
        // y sus dependencias (como ProductoRepositorio) son proxies gestionados por
        // Spring.

        System.out.println("Lista inicial de productos:");
        controlador.listarProductos().forEach(System.out::println);

        System.out.println("\nObteniendo producto con ID 1:");
        System.out.println(controlador.obtenerProducto(1L));

        System.out.println("\nActualizando precio del producto ID 1 a 1299.99");
        controlador.actualizarPrecioProducto(1L, 1299.99); // El @Around debería activarse aquí

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

        // 3. Cerrar el contexto (importante para liberar recursos)
        context.close();
    }
}
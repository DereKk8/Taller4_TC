package com.example.repositorio;

import com.example.modelo.Producto;

import java.util.*;

public class ProductoRepositorio {
    private Map<Long, Producto> mapaProductos = new HashMap<>();

    public ProductoRepositorio() {
        mapaProductos.put(1L, new Producto(1L, "Laptop", 1200.00));
        mapaProductos.put(2L, new Producto(2L, "Smartphone", 800.00));
        mapaProductos.put(3L, new Producto(3L, "Tablet", 400.00));
    }

    public Producto buscarPorId(Long id) {
        return mapaProductos.get(id);
    }

    public List<Producto> buscarTodos() {
        return new ArrayList<>(mapaProductos.values());
    }

    public void guardar(Producto producto) {
        mapaProductos.put(producto.getId(), producto);
    }

    public void eliminar(Long id) {
        mapaProductos.remove(id);
    }

    public void actualizarPrecio(Long id, double nuevoPrecio) {
        Producto producto = mapaProductos.get(id);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
            mapaProductos.put(id, producto);
        } else {
            throw new IllegalArgumentException("No existe el producto con id: " + id);
        }
    }
}
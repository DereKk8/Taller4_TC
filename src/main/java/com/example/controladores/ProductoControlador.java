package com.example.controladores;

import com.example.modelo.Producto;
import com.example.servicio.ProductoServicio;
import com.example.servicio.ProductoServicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoControlador {
    private ProductoServicio servicio;

    @Autowired
    public ProductoControlador() {
        this.servicio = new ProductoServicioImpl();
    }

    public List<Producto> listarProductos() {
        return servicio.buscarTodos();
    }

    public Producto obtenerProducto(Long id) {
        return servicio.buscarPorId(id);
    }

    public void agregarProducto(Producto producto) {
        servicio.guardar(producto);
    }

    public void eliminarProducto(Long id) {
        servicio.eliminar(id);
    }

    public void actualizarPrecioProducto(Long id, double nuevoPrecio) {
        servicio.actualizarPrecio(id, nuevoPrecio);
    }
}
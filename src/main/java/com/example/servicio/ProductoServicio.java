package com.example.servicio;

import com.example.modelo.Producto;

import java.util.List;

public interface ProductoServicio {
    Producto buscarPorId(Long id);
    List<Producto> buscarTodos();
    void guardar(Producto producto);
    void eliminar(Long id);
    void actualizarPrecio(Long id, double nuevoPrecio);
}
package com.example.servicio;

import com.example.modelo.Producto;
import com.example.repositorio.ProductoRepositorio;

import java.util.List;

public class ProductoServicioImpl implements ProductoServicio {

    private ProductoRepositorio repositorio;

    public ProductoServicioImpl() {
        this.repositorio = new ProductoRepositorio();
    }

    @Override
    public Producto buscarPorId(Long id) {
        return repositorio.buscarPorId(id);
    }

    @Override
    public List<Producto> buscarTodos() {
        return repositorio.buscarTodos();
    }

    @Override
    public void guardar(Producto producto) {
        repositorio.guardar(producto);
    }

    @Override
    public void eliminar(Long id) {
        repositorio.eliminar(id);
    }

    @Override
    public void actualizarPrecio(Long id, double nuevoPrecio) {
        repositorio.actualizarPrecio(id, nuevoPrecio);
    }
}
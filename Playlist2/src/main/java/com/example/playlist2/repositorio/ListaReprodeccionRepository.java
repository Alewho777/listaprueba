package com.example.playlist2.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.playlist2.entidad.ListaReproduccion;

public interface ListaReprodeccionRepository extends CrudRepository<ListaReproduccion, Long> {
    ListaReproduccion findByNombre(String nombre);
}
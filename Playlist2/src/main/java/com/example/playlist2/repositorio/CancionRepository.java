package com.example.playlist2.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.playlist2.entidad.Cancion;

public interface CancionRepository extends CrudRepository<Cancion, Long> {
}

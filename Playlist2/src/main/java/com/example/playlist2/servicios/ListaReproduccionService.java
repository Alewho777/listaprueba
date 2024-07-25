package com.example.playlist2.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.playlist2.ResourceNotFoundException;
import com.example.playlist2.entidad.ListaReproduccion;
import com.example.playlist2.repositorio.ListaReprodeccionRepository;
@Service
public class ListaReproduccionService {
    
    @Autowired
    private ListaReprodeccionRepository listaReproduccionRepository;

    public ListaReproduccion crearListaReproduccion(ListaReproduccion listaReproduccion) {
        if (listaReproduccion.getNombre() == null) {
            throw new IllegalArgumentException("El nombre de la lista no puede ser nulo");
        }
        return listaReproduccionRepository.save(listaReproduccion);
    }

    public List<ListaReproduccion> obtenerTodasListasReproduccion() {
        return (List<ListaReproduccion>) listaReproduccionRepository.findAll();
    }

    public ListaReproduccion obtenerListaPorNombre(String nombre) {
        ListaReproduccion listaReproduccion = listaReproduccionRepository.findByNombre(nombre);
        if (listaReproduccion == null) {
            throw new ResourceNotFoundException("Lista de reproducción no encontrada");
        }
        return listaReproduccion;
    }

    public void actualizarListaReproduccion(String nombre, ListaReproduccion listaReproduccionActualizada) {
        ListaReproduccion existente = listaReproduccionRepository.findByNombre(nombre);
        if (existente == null) {
            throw new ResourceNotFoundException("Lista de reproducción no encontrada");
        }
        if (!existente.getNombre().equals(listaReproduccionActualizada.getNombre())) {
            throw new IllegalArgumentException("No se puede cambiar el nombre de la lista de reproducción");
        }
        existente.setDescripcion(listaReproduccionActualizada.getDescripcion());
        existente.setCanciones(listaReproduccionActualizada.getCanciones());
        listaReproduccionRepository.save(existente);
    }

    public void eliminarListaReproduccion(String nombre) {
        ListaReproduccion listaReproduccion = listaReproduccionRepository.findByNombre(nombre);
        if (listaReproduccion == null) {
            throw new ResourceNotFoundException("Lista de reproducción no encontrada");
        }
        listaReproduccionRepository.delete(listaReproduccion);
    }
}
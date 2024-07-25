package com.example.playlist2.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.playlist2.ResourceNotFoundException;
import com.example.playlist2.entidad.ListaReproduccion;
import com.example.playlist2.servicios.ListaReproduccionService;

@RestController
@RequestMapping("/playlists")
public class ListaReproduccionController {

    @Autowired
    private ListaReproduccionService listaReproduccionService;

    @PostMapping("/crear")
    public ResponseEntity<ListaReproduccion> crearLista(@RequestBody ListaReproduccion listaReproduccion) {
        try {
            ListaReproduccion creada = listaReproduccionService.crearListaReproduccion(listaReproduccion);
            return ResponseEntity.status(HttpStatus.CREATED).body(creada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/lists")
    public List<ListaReproduccion> obtenerTodasListas() {
        return listaReproduccionService.obtenerTodasListasReproduccion();
    }

    @GetMapping("/{listName}")
    public ResponseEntity<ListaReproduccion> obtenerListaPorNombre(@PathVariable String listName) {
        try {
            ListaReproduccion listaReproduccion = listaReproduccionService.obtenerListaPorNombre(listName);
            return ResponseEntity.ok(listaReproduccion);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{listName}")
    public ResponseEntity<Void> actualizarLista(@PathVariable String listName, @RequestBody ListaReproduccion listaReproduccion) {
        try {
            listaReproduccionService.actualizarListaReproduccion(listName, listaReproduccion);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/{listName}")
    public ResponseEntity<Void> eliminarLista(@PathVariable String listName) {
        try {
            listaReproduccionService.eliminarListaReproduccion(listName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
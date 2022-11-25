package com.inmohernandez.restapiinmohernandez.controllers;

import com.inmohernandez.restapiinmohernandez.entities.Alquiler;
import com.inmohernandez.restapiinmohernandez.entities.AlquilerFiltros;
import com.inmohernandez.restapiinmohernandez.entities.Inmueble;
import com.inmohernandez.restapiinmohernandez.entities.InmuebleFiltros;
import com.inmohernandez.restapiinmohernandez.exceptions.ResourceNotFoundException;
import com.inmohernandez.restapiinmohernandez.repositories.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class AlquileresController {
    @Autowired
    private AlquilerRepository alquilerRepository;

    @PostMapping("/alquileres/filtros")
    public List<Alquiler> getFilteredAlquileres(@RequestBody AlquilerFiltros alquilerFiltros){
        String busqueda = alquilerFiltros.getBusqueda();
        String fechaDesde = alquilerFiltros.getFecha_desde();
        String fechaHasta = alquilerFiltros.getFecha_hasta();
        long idInmueble = alquilerFiltros.getIdInmueble();

        if(busqueda == null){
            busqueda = "";
        }

        if(fechaDesde ==null){
            fechaDesde = "1970-01-01";
        }

        if(fechaHasta == null){
            fechaHasta = "2299-01-01";
        }
        Date dateDesde = Date.valueOf(fechaDesde);
        Date dateHasta = Date.valueOf(fechaHasta);
        
        return alquilerRepository.findAll(busqueda,dateDesde,dateHasta,idInmueble);
    }

    @GetMapping("/alquileres")
    public List<Alquiler> getAllInmuebles(){
        return alquilerRepository.findAll();
    }

    @GetMapping("/alquileres/{id}")
    public ResponseEntity<Alquiler> getAlquilerById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Alquiler alquiler = alquilerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alquiler no encontrado ::" + id));
        return ResponseEntity.ok().body(alquiler);
    }

    @DeleteMapping("/alquileres/{id}")
    public Map< String, Boolean > deleteAlquiler(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Alquiler alquiler = alquilerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alquiler no encontrado :: " + id));

        alquilerRepository.delete(alquiler);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping("/alquileres")
    public Alquiler createAlquiler(@Valid @RequestBody Alquiler alquiler){
        return alquilerRepository.save(alquiler);
    }


    @PostMapping("/alquileres/{id}")
    public ResponseEntity < Alquiler > updateAlquiler(@PathVariable(value = "id") Long id,
                                                      @Valid @RequestBody Alquiler alquilerPost) throws ResourceNotFoundException {
        Alquiler alquiler = alquilerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alquiler no encontrado :: " + id));

        alquiler.setCliente(alquilerPost.getCliente());
        alquiler.setFechaFin(alquilerPost.getFechaFin());
        alquiler.setFechaInicio(alquilerPost.getFechaInicio());
        System.out.println(alquilerPost.getMensualidad());
        alquiler.setMensualidad(alquilerPost.getMensualidad());
        alquiler.setIdInmueble(alquilerPost.getIdInmueble());

        final Alquiler updatedAlquiler = alquilerRepository.save(alquiler);
        return ResponseEntity.ok(updatedAlquiler);
    }
}

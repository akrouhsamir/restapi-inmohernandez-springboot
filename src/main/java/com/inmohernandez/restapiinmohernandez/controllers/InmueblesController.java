package com.inmohernandez.restapiinmohernandez.controllers;

import com.inmohernandez.restapiinmohernandez.entities.Inmueble;
import com.inmohernandez.restapiinmohernandez.entities.InmuebleFiltros;
import com.inmohernandez.restapiinmohernandez.exceptions.ResourceNotFoundException;
import com.inmohernandez.restapiinmohernandez.repositories.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class InmueblesController {
    @Autowired
    private InmuebleRepository inmuebleRepository;

    @PostMapping("/inmuebles/filtros")
    public List<Inmueble> getFilteredInmuebles(@RequestBody InmuebleFiltros inmuebleFiltros){
        String busqueda = inmuebleFiltros.getBusqueda();
        String zona = inmuebleFiltros.getZona();
        float precioDesde = inmuebleFiltros.getPrecio_desde();
        float precioHasta = inmuebleFiltros.getPrecio_hasta();
        String fechaDesde = inmuebleFiltros.getPublicacion_desde();
        String fechaHasta = inmuebleFiltros.getPublicacion_hasta();
        if(precioHasta == 0){
            precioHasta = Float.MAX_VALUE;
        }
        if(zona == null){
            zona = "";
        }
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
        return inmuebleRepository.findAll(busqueda,zona,precioDesde,precioHasta,dateDesde,dateHasta);
    }

    @GetMapping("/inmuebles")
    public List<Inmueble> getAllInmuebles(){
        return inmuebleRepository.findAll();
    }

    @GetMapping("/inmuebles/{id}")
    public ResponseEntity<Inmueble> getInmuebleById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
        Inmueble inmueble = inmuebleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inmueble no encontrado ::" + id));
        return ResponseEntity.ok().body(inmueble);
    }
    @PostMapping("/inmuebles")
    public Inmueble createInmueble(@Valid @RequestBody Inmueble inmueble){
        return inmuebleRepository.save(inmueble);
    }

    @PutMapping("/inmuebles/{id}")
    public ResponseEntity < Inmueble > updateInmueble(@PathVariable(value = "id") Long id,
                                                      @Valid @RequestBody Inmueble inmueblePost) throws ResourceNotFoundException {
        Inmueble inmueble = inmuebleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inmueble no encontrado :: " + id));

        inmueble.setTitulo(inmueblePost.getTitulo());
        inmueble.setPrecio(inmueblePost.getPrecio());
        inmueble.setDescripcion(inmueblePost.getDescripcion());
        inmueble.setMetrosConstruidos(inmueblePost.getMetrosConstruidos());
        inmueble.setMetrosUtiles(inmueblePost.getMetrosUtiles());
        inmueble.setUbicacion(inmueble.getUbicacion());
        inmueble.setZona(inmueblePost.getZona());
        inmueble.setFechaPublicacion(inmueblePost.getFechaPublicacion());
        inmueble.setHabitaciones(inmueblePost.getHabitaciones());
        inmueble.setBannos(inmueblePost.getBannos());

        final Inmueble updatedInmueble = inmuebleRepository.save(inmueble);
        return ResponseEntity.ok(updatedInmueble);
    }

    @DeleteMapping("/inmuebles/{id}")
    public Map< String, Boolean > deleteInmueble(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Inmueble inmueble = inmuebleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inmueble no encontrado :: " + id));

        inmuebleRepository.delete(inmueble);
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

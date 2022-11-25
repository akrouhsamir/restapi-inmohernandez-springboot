package com.inmohernandez.restapiinmohernandez.repositories;

import com.inmohernandez.restapiinmohernandez.entities.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface AlquilerRepository extends JpaRepository<Alquiler,Long> {
    @Query("SELECT a " +
            "FROM Alquiler a " +
            "WHERE (a.cliente LIKE ?1% OR cast(a.id as string) LIKE ?1%) " +
            "AND ( a.fechaInicio BETWEEN ?2 AND ?3 OR a.fechaFin BETWEEN ?2 AND ?3 ) " +
            "AND a.idInmueble = ?4")
    public List<Alquiler> findAll(String busqueda, Date fechaDesde, Date fechaHasta,long idInmueble);
}

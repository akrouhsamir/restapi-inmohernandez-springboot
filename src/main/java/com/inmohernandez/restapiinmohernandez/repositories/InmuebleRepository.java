package com.inmohernandez.restapiinmohernandez.repositories;

import com.inmohernandez.restapiinmohernandez.entities.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble,Long> {
    @Query("SELECT i " +
            "FROM Inmueble i " +
            "WHERE (i.titulo LIKE ?1% OR cast(i.id as string) LIKE ?1%) " +
            "AND i.zona LIKE ?2% " +
            "AND i.precio BETWEEN ?3 AND ?4 " +
            "AND i.fechaPublicacion BETWEEN ?5 AND ?6")
    public List<Inmueble> findAll(String titulo, String zona, float precioDesde, float precioHasta, Date fechaDesde, Date fechaHasta);
}

package com.inmohernandez.restapiinmohernandez.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "alquileres")
public class Alquiler {
    private long id;
    private String cliente;
    private Date fechaInicio;
    private Date fechaFin;
    private float mensualidad;

    private long idInmueble;


    public Alquiler(String cliente, Date fechaInicio, Date fechaFin, float mensualidad, long idInmueble) {
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.mensualidad = mensualidad;
        this.idInmueble = idInmueble;
    }

    public Alquiler(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "cliente", nullable = false)
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    @Column(name = "fechaInicio", nullable = false)
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Column(name = "fechaFin", nullable = false)
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    @Column(name = "mensualidad", nullable = false)
    public float getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(float mensualidad) {
        this.mensualidad = mensualidad;
    }

    @Column(name = "idInmueble", nullable = false)
    public long getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(long idInmueble) {
        this.idInmueble = idInmueble;
    }

}

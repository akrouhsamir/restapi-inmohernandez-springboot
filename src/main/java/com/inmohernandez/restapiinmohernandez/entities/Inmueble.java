package com.inmohernandez.restapiinmohernandez.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "inmuebles")
public class Inmueble{
    private long id;
    private String titulo;
    private float precio;
    private String descripcion;
    private int metrosConstruidos;
    private int metrosUtiles;
    private String ubicacion;
    private String zona;
    private Date fechaPublicacion;
    private int habitaciones;
    private int bannos;

    public Inmueble(){

    }

    public Inmueble(String titulo, float precio,
                    String descripcion, int metrosConstruidos,
                    int metrosUtiles, String ubicacion, String zona,
                    Date fechaPublicacion, int habitaciones, int bannos) {
        this.titulo = titulo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.metrosConstruidos = metrosConstruidos;
        this.metrosUtiles = metrosUtiles;
        this.ubicacion = ubicacion;
        this.zona = zona;
        this.fechaPublicacion = fechaPublicacion;
        this.habitaciones = habitaciones;
        this.bannos = bannos;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdInmueble() {
        return id;
    }
    public void setIdInmueble(long id) {
        this.id = id;
    }

    @Column(name = "titulo", nullable = false)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(name = "precio", nullable = false)
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float pecio) {
        this.precio = pecio;
    }

    @Column(name = "descripcion", nullable = true)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "metrosConstruidos", nullable = false)
    public int getMetrosConstruidos() {
        return metrosConstruidos;
    }

    public void setMetrosConstruidos(int metrosConstruidos) {
        this.metrosConstruidos = metrosConstruidos;
    }

    @Column(name = "metrosUtiles", nullable = true)
    public int getMetrosUtiles() {
        return metrosUtiles;
    }

    public void setMetrosUtiles(int metrosUtiles) {
        this.metrosUtiles = metrosUtiles;
    }

    @Column(name = "ubicacion", nullable = true)
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Column(name = "zona", nullable = false)
    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Column(name = "fechaPublicacion", nullable = false)
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Column(name = "habitaciones", nullable = false)
    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    @Column(name = "bannos", nullable = false)
    public int getBannos() {
        return bannos;
    }

    public void setBannos(int bannos) {
        this.bannos = bannos;
    }


}

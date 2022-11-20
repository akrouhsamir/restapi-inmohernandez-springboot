package com.inmohernandez.restapiinmohernandez.entities;

public class InmuebleFiltros {

    private String busqueda;
    private float precio_desde;
    private float precio_hasta;
    private String publicacion_desde;
    private String publicacion_hasta;
    private String zona;


    public InmuebleFiltros(String busqueda, float precio_desde, float precio_hasta, String publicacion_desde, String publicacion_hasta, String zona) {
        this.busqueda = busqueda;
        this.precio_desde = precio_desde;
        this.precio_hasta = precio_hasta;
        this.publicacion_desde = publicacion_desde;
        this.publicacion_hasta = publicacion_hasta;
        this.zona = zona;
    }

    @Override
    public String toString() {
        return "InmuebleFiltros{" +
                "busqueda='" + busqueda + '\'' +
                ", precio_desde=" + precio_desde +
                ", precio_hasta=" + precio_hasta +
                ", publicacion_desde='" + publicacion_desde + '\'' +
                ", publicacion_hasta='" + publicacion_hasta + '\'' +
                ", zona='" + zona + '\'' +
                '}';
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public float getPrecio_desde() {
        return precio_desde;
    }

    public void setPrecio_desde(float precio_desde) {
        this.precio_desde = precio_desde;
    }

    public float getPrecio_hasta() {
        return precio_hasta;
    }

    public void setPrecio_hasta(float precio_hasta) {
        this.precio_hasta = precio_hasta;
    }

    public String getPublicacion_desde() {
        return publicacion_desde;
    }

    public void setPublicacion_desde(String publicacion_desde) {
        this.publicacion_desde = publicacion_desde;
    }

    public String getPublicacion_hasta() {
        return publicacion_hasta;
    }

    public void setPublicacion_hasta(String publicacion_hasta) {
        this.publicacion_hasta = publicacion_hasta;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
}

package com.inmohernandez.restapiinmohernandez.entities;

public class AlquilerFiltros {
    private String busqueda;
    private String fecha_desde;
    private String fecha_hasta;

    private long idInmueble;




    public AlquilerFiltros(String busqueda, String fecha_desde, String fecha_hasta,long idInmueble) {
        this.busqueda = busqueda;
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
        this.idInmueble = idInmueble;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public String getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(String fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public String getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(String fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    public long getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(long idInmueble) {
        this.idInmueble = idInmueble;
    }
}

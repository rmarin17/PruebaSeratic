package com.seratic.models;

public class Reporte {
    String nombre,apellido,club,cantidad;

    public Reporte() {
    }

    public Reporte(String nombre, String apellido, String club, String cantidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.club = club;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    
    
}

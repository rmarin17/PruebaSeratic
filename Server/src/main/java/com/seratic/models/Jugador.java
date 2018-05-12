package com.seratic.models;

public class Jugador {
    int id;
    String nombre,apellido,club;

    public Jugador() {
    }

    public Jugador(int id,String nombre, String apellido, String club) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.club = club;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    
    
}

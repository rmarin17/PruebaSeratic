
package com.seratic.models;

public class Voto {
    int id, idJugador;
    String idUsuario;

    public Voto() {
    }

    public Voto(int idJugador, String idUsuario) {
        this.idJugador = idJugador;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
}

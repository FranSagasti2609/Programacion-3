package com.truco.model;

import java.util.List;

public class Partida {
    private List<Jugador> jugadores;
    private int puntajeMaximo;

    public Partida(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.puntajeMaximo = 30; // Puntaje máximo por partida
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getPuntajeMaximo() {
        return puntajeMaximo;
    }

    public void setPuntajeMaximo(int puntajeMaximo) {
        this.puntajeMaximo = puntajeMaximo;
    }
}

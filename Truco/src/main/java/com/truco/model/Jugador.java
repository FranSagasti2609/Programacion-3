package com.truco.model;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nick;
    private int puntaje;
    private List<Carta> cartas; // Lista para las cartas en la mano

    public Jugador(String nick) {
        this.nick = nick;
        this.puntaje = 0;
        this.cartas = new ArrayList<>();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void sumarPuntos(int puntos) {
        this.puntaje += puntos;
    }

    public void reiniciarPuntaje() {
        this.puntaje = 0;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }
}

package com.truco.view;

import com.truco.ai.OpenAIClient;
import com.truco.ai.TrucoAI;
import com.truco.controller.JuegoController;
import com.truco.model.Carta;
import com.truco.model.Jugador;
import com.truco.utils.Configuracion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class VentanaPrincipal extends JFrame {
    private JuegoController juegoController;
    private List<Jugador> jugadores;
    private JPanel panelCartasCentro;
    private List<Carta> cartasJugadas;
    private int turnoActual;
    private int rondaActual;
    private JLabel bienvenida;  // Declarar bienvenida como variable de instancia

    public VentanaPrincipal() {
        setTitle("Truco Master!");
        setSize(1280, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        juegoController = new JuegoController();
        cartasJugadas = new ArrayList<>();
        turnoActual = 0;
        rondaActual = 1;

        // Configurar interfaz
        bienvenida = new JLabel("Bienvenido al juego de Truco", SwingConstants.CENTER);  // Asignar bienvenida
        bienvenida.setFont(new Font("Serif", Font.BOLD, 24));
        add(bienvenida, BorderLayout.CENTER);  // Añadir al JFrame

        JButton iniciarButton = new JButton("Iniciar Partida");
        iniciarButton.addActionListener(e -> iniciarPartida());
        add(iniciarButton, BorderLayout.SOUTH);
    }

    private void iniciarPartida() {
        jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Jugador 1"));
        jugadores.add(new Jugador("Jugador 2"));
        juegoController.iniciarPartida(jugadores);

        // Eliminar la bienvenida del JFrame
        remove(bienvenida);  // Ahora podemos eliminar bienvenida al ser una variable de instancia

        mostrarPanelCartas(jugadores);

        panelCartasCentro = new JPanel(new FlowLayout());
        panelCartasCentro.setBorder(BorderFactory.createTitledBorder("Cartas Jugadas"));
        add(panelCartasCentro, BorderLayout.CENTER);

        revalidate();  // Actualizar la interfaz
        repaint();     // Redibujar la ventana
    }

    private void mostrarPanelCartas(List<Jugador> jugadores) {
        JPanel panelCartas = new JPanel(new GridLayout(1, jugadores.size()));
        for (Jugador jugador : jugadores) {
            PanelCartasJugador panelJugador = new PanelCartasJugador(jugador);
            panelCartas.add(panelJugador);
        }
        add(panelCartas, BorderLayout.NORTH);
        revalidate();
        repaint();
    }

    public void jugarCarta(Jugador jugador, Carta carta, JButton cartaButton) {
        // Verifica que sea el turno del jugador
        System.out.println("Jugador: " + jugadores.indexOf(jugador) + "--- turnoActual: " + turnoActual);
        if (jugadores.indexOf(jugador) != turnoActual) {
            JOptionPane.showMessageDialog(this, "No es el turno de " + jugador.getNick());
            return;
        }

        // Ocultar la carta seleccionada y hacerla no clickeable
        cartaButton.setEnabled(false);
        cartaButton.setVisible(false);

        // Añadir la carta al centro
        JLabel cartaLabel = new JLabel(carta.toString());
        cartaLabel.setPreferredSize(new Dimension(80, 120));
        panelCartasCentro.add(cartaLabel);
        cartasJugadas.add(carta);

        // Cambiar turno al siguiente jugador
        turnoActual = (turnoActual + 1) % jugadores.size();
        System.out.println("turnoActual cambio a : " + turnoActual);

        // Si es el turno del jugador 2 (IA), invocar la sugerencia de la IA
        if (turnoActual == 1) {
            jugarCartaIA(jugadores.get(1), jugadores.get(1).getCartas());
        }

        // Si ambos jugadores han jugado una carta, evaluar la mano
        if (cartasJugadas.size() == 2) {
            evaluarGanadorDeMano();
            // Limpiar las cartas jugadas para la próxima ronda
            cartasJugadas.clear();
            panelCartasCentro.removeAll();
            rondaActual++;
        }

        revalidate();
        repaint();
    }

    public void jugarCartaIA(Jugador jugadorIA, List<Carta> cartasIA) {
        String apiKey = Configuracion.obtenerApiKey();
        if (apiKey == null) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la clave de API.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        TrucoAI trucoAI = new TrucoAI(new OpenAIClient(apiKey));
        String cartaSugerida = trucoAI.decidirJugada(cartasIA, cartasJugadas, rondaActual);

        // Mostrar la sugerencia al jugador humano sin jugar la carta automáticamente
        JOptionPane.showMessageDialog(this, "La IA sugiere jugar: " + cartaSugerida + ".", "Sugerencia de IA", JOptionPane.INFORMATION_MESSAGE);

        // El jugador puede decidir qué carta jugar manualmente
        JOptionPane.showMessageDialog(this, "Ahora elige la carta que prefieras jugar manualmente.", "Decisión del Jugador", JOptionPane.INFORMATION_MESSAGE);
    }

    private void evaluarGanadorDeMano() {
        // Determinar el ganador de la mano utilizando el método de JuegoController
        Jugador ganador = juegoController.evaluarGanador(cartasJugadas, jugadores);
        JOptionPane.showMessageDialog(this, "El ganador de la mano " + rondaActual + " es: " + ganador.getNick());

        // El ganador comienza la próxima mano
        turnoActual = jugadores.indexOf(ganador);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}

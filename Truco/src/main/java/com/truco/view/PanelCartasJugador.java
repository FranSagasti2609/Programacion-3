package com.truco.view;

import com.truco.model.Carta;
import com.truco.model.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PanelCartasJugador extends JPanel {
    //atributos del panel
    private Jugador jugador;
    private List<JButton> botonesCartas;

    public PanelCartasJugador(Jugador jugador) {
        this.jugador = jugador;
        this.botonesCartas = new ArrayList<>();
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder(jugador.getNick()));

        // Agregar las cartas como botones ocultos
        for (Carta carta : jugador.getCartas()) {
            JButton cartaButton = new JButton("Dorso"); // Mostramos el dorso para ocultar la carta
            cartaButton.setPreferredSize(new Dimension(80, 120)); //tamaño de la figura
            cartaButton.setToolTipText("Haz clic derecho para ver la carta"); //texto que se muestra al pasar el mouse arriba

            // Configurar eventos de clic derecho e izquierdo
            cartaButton.addMouseListener(new MouseAdapter() {
                @Override
                //Esto es cuando el mouse se clickea, veremos el click derecho e izquierdo
                public void mouseClicked(MouseEvent e) {

                    if (SwingUtilities.isRightMouseButton(e)) { 
                        
                        //al pulsar el botón derecho
                        cartaButton.setText(carta.toString());

                    } else if (SwingUtilities.isLeftMouseButton(e)) { 
                        
                        //click izquierdo
                        VentanaPrincipal ventanaPrincipal = buscarVentanaPrincipal();
                        if (ventanaPrincipal != null) {
                            //si es el turno del jugador correspondiente entonces AHI quito la carta visualmente
                            if(ventanaPrincipal.turnoJugador(jugador)){
        
                            ventanaPrincipal.jugarCarta(jugador, carta, cartaButton);
                            // Ocultar y desactivar la carta seleccionada
                            cartaButton.setEnabled(false);
                            cartaButton.setVisible(false);
                            // Forzar la actualización de la interfaz gráfica
                            revalidate();
                            repaint();
                            } else JOptionPane.showMessageDialog(null, "No es tu turno.");
                            
                        }
                    }
                }
            });

            botonesCartas.add(cartaButton);
            add(cartaButton);
        }
    }

    // Método para buscar la instancia de VentanaPrincipal en la jerarquía de componentes
    private VentanaPrincipal buscarVentanaPrincipal() {
        Component component = this;
        while (component != null && !(component instanceof VentanaPrincipal)) {
            component = component.getParent();
        }
        return (VentanaPrincipal) component;
    }
}

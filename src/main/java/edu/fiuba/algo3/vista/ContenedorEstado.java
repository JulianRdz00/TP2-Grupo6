package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.GestorTurnos;
import edu.fiuba.algo3.controlador.SiguienteTurnoEventHandler;
import edu.fiuba.algo3.controlador.TirarDadoEventHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class ContenedorEstado extends VBox implements Observer {


    private ContenedorTitulo contenedorTitulo;

    private ContenedorEstadoJugador contenedorEstadoJugador;

    private GestorTurnos gestorTurnos;


    public ContenedorEstado(Stage stage, int alto, GestorTurnos gestorTurnos, BotonDado botonDado, Button botonContinuar) {
        this.setPrefWidth(stage.getWidth());
        this.setPrefHeight(stage.getHeight() - (stage.getHeight() / (alto/1.4)) * 200);
        this.setStyle("-fx-background-color: DarkOliveGreen");
        this.gestorTurnos = gestorTurnos;
        this.contenedorTitulo = new ContenedorTitulo();
        contenedorTitulo.setAlignment(Pos.CENTER);

        this.contenedorEstadoJugador = new ContenedorEstadoJugador();
        contenedorEstadoJugador.setAlignment(Pos.CENTER);

        HBox contenedorDadoYJugador = new HBox(botonDado, contenedorEstadoJugador, botonContinuar);
        contenedorDadoYJugador.setAlignment(Pos.CENTER);
        contenedorDadoYJugador.setPadding(new Insets(20));
        contenedorDadoYJugador.setSpacing(250);

        this.getChildren().addAll(contenedorTitulo, contenedorDadoYJugador);
        this.setAlignment(Pos.TOP_CENTER);
    }

    @Override
    public void update(Observable o, Object arg) {
        Jugador jugador = (Jugador) o;
        this.contenedorTitulo.setNombreJugador(jugador.obtenerNombre());
        this.contenedorTitulo.setNumeroRonda(this.gestorTurnos.obtenerRondaActual());

        this.contenedorEstadoJugador.setValorEnergia(jugador.obtenerMovible().calcularEnergia());
        this.contenedorEstadoJugador.setValorEquipamiento(jugador.obtenerMovible().getEquipamiento().getNombre());
        this.contenedorEstadoJugador.setValorSeniority(jugador.obtenerMovible().verSeniority().getClass().getSimpleName());

        jugador.obtenerMovible().verificarEnergiaValida();
    }
}

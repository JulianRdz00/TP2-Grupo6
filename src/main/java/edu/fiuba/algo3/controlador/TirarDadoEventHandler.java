package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.vista.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class TirarDadoEventHandler implements EventHandler<ActionEvent> {

    private BotonDado botonDado;

    private Dado dado;

    private ContenedorPrincipal contenedorPrincipal;

    private Button botonContinuar;



    public TirarDadoEventHandler(BotonDado botonDado, Button botonContinuar, ContenedorPrincipal contenedorPrincipal) {
        this.botonDado = botonDado;
        this.dado = new Dado();
        this.botonContinuar = botonContinuar;
        this.contenedorPrincipal = contenedorPrincipal;

    }
    @Override
    public void handle(ActionEvent actionEvent) {
        int unosPasos = this.dado.tirarDado();
        Image dado = new Image(String.format("file:src/main/resources/dado_%x.jpg", unosPasos));
        BackgroundImage imagenFondoBoton = new BackgroundImage(dado, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(5, 5, true, true, true, false));
        ContenedorMensaje contenedorMensaje;
        this.botonDado.setBackground(new Background(imagenFondoBoton));
        if(!this.contenedorPrincipal.getGestorTurnos().obtenerTurnoActual().movibleLesionado()){
            contenedorMensaje = new ContenedorMensaje(unosPasos, this.contenedorPrincipal.getGestorTurnos(), contenedorPrincipal.getStage());
            this.contenedorPrincipal.getGestorTurnos().obtenerTurnoActual().moverMovible(this.contenedorPrincipal.getTablero(), unosPasos);

        }else{
            this.contenedorPrincipal.getGestorTurnos().obtenerTurnoActual().obtenerMovible().habilitarMovimiento();
            contenedorMensaje = new ContenedorMensaje(0, this.contenedorPrincipal.getGestorTurnos(), contenedorPrincipal.getStage());
        }
        this.contenedorPrincipal.getGestorTurnos().obtenerTurnoActual().notifyObservers();

        this.contenedorPrincipal.getChildren().add(contenedorMensaje);
        Casilla casillaJugador = this.contenedorPrincipal.getTablero().obtenerCasillaDe(this.contenedorPrincipal.getGestorTurnos().obtenerTurnoActual().obtenerMovible());
        casillaJugador.addObserver(contenedorMensaje);
        casillaJugador.notifyObservers();

        this.botonDado.setDisable(true);
        this.botonContinuar.setDisable(false);

    }
}

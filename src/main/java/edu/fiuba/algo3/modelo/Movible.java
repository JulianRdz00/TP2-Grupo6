package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.premio.Premio;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;

public interface Movible {

    public int mover(int unaCantidad);
    public boolean estaCompleto();

    public void vs(Obstaculo obstaculo);
    public void obtenerPremio(Premio premio);

    public Gladiador ganador();

    public boolean sosGanador();
}

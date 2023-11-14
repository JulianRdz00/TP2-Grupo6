package edu.fiuba.algo3.modelo;
import java.util.List;

public class Gladiador {
    private int energia;
    private List<Equipamiento> equipamiento;

    public Gladiador(){
        this.energia = 20;
        this.equipamiento = null;
    }

    public int verEnergia(){
        return (this.energia);
    }

    public List<Equipamiento> verEquipamiento(){
        return (this.equipamiento);
    }

}

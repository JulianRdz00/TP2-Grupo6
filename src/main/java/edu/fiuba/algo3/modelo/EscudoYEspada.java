package edu.fiuba.algo3.modelo;

public class EscudoYEspada implements Equipamiento{
    public int usar(){
        return (2);
    }

    public Equipamiento siguienteEquipamiento() {
        return (new Llave());
    }
}

package edu.fiuba.algo3.modelo.equipamiento;

import java.util.Stack;

public class Llave implements Equipamiento {
    public int usar(){
        return (0);
    }

    public Equipamiento siguienteEquipamiento() {
        return null;
    }

    public Equipamiento equiparProximo(Stack<Equipamiento> equipamiento){
        return this;
    }
}

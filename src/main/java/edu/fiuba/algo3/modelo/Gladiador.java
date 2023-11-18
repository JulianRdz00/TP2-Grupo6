package edu.fiuba.algo3.modelo;
import java.util.Stack;

public class Gladiador implements Movible{
    private Energia energia;
    private Stack<Equipamiento> equipamiento;
    private int pasos;

    public Gladiador(){
        this.energia = new Energia(20);
        this.equipamiento = new Stack<>();
        this.pasos = 0;
    }

    public Gladiador(int energia){
        this.energia = new Energia(energia);
        this.equipamiento = new Stack<>();
        this.pasos = 0;
    }

    public int caclularEnergia(){
        return (this.energia.calcularEnergia());
    }

    public int alimentarse(Comida unaComida){
        return energia.aumentarEnergiaComiendo(unaComida);
    }

    public Stack<Equipamiento> verEquipamiento(){
        return (this.equipamiento);
    }

    public Equipamiento verSiguienteEquipamiento(){
        return (this.equipamiento.peek().siguienteEquipamiento());
    }

    public void equiparse(){
        if (equipamiento.isEmpty()){
            Casco casco = new Casco();
            equipamiento.push(casco);
        }else if(equipamiento.peek().siguienteEquipamiento() != null){
            Equipamiento nuevo = this.verSiguienteEquipamiento();
            equipamiento.push(nuevo);
        }
    }

    public int usarEquipamiento() {return equipamiento.peek().usar();}
    public int pelearContraFiera(){ return energia.gastarEnergiaPeleando(this);}
    public int verPasos(){
        return (this.pasos);
    }

    public void mover(int unaCantidad){
        if(energia.calcularEnergia() > 0) {
            this.pasos = (pasos + unaCantidad);
            energia.disminuirEnergia(1);
        }

    }



}

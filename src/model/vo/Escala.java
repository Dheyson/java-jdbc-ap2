package model.vo;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * 
 */
public class Escala {
    
    private int id;
    private LocalTime tempo;
    private ArrayList<Tecnico> tecnicos;

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalTime tempo) {
        this.tempo = tempo;
    }

    public ArrayList<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(ArrayList<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }
    
}

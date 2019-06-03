package model.vo;

import java.util.ArrayList;
import java.util.Date;


public class Treino {
    
    private int id;
    private Date dia;
    private String turno;
    private int tecnico_id;
    private int esporte_id;
    private ArrayList<Associado> alunos;
    //private ArrayList<Matriculas> matriculas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getTecnico_id() {
        return tecnico_id;
    }

    public void setTecnico_id(int tecnico_id) {
        this.tecnico_id = tecnico_id;
    }

    public int getEsporte_id() {
        return esporte_id;
    }

    public void setEsporte_id(int esporte_id) {
        this.esporte_id = esporte_id;
    }

    public ArrayList<Associado> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Associado> alunos) {
        this.alunos = alunos;
    }
 
}

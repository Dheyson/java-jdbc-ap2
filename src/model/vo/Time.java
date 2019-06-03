package model.vo;

import java.util.ArrayList;

/**
 *
 * @author Eu
 */
public class Time {
    
    private int cod_time;
    private String nome;
    private int camp_id;
    private ArrayList<Associado> jogadores;

    
    
    public int getCod_time() {
        return cod_time;
    }

    public void setCod_time(int cod_time) {
        this.cod_time = cod_time;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCamp_id() {
        return camp_id;
    }

    public void setCamp_id(int camp_id) {
        this.camp_id = camp_id;
    }

    public ArrayList<Associado> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Associado> jogadores) {
        this.jogadores = jogadores;
    }
    
}

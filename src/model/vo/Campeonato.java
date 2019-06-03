package model.vo;

import java.util.ArrayList;
import java.util.Date;
public class Campeonato {
    
    private int id;
    private int edicao;
    private Date data_camp;
    private ArrayList<Jogo> jogos;
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public Date getData_camp() {
        return data_camp;
    }

    public void setData_camp(Date data_camp) {
        this.data_camp = data_camp;
    }

    public ArrayList<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(ArrayList<Jogo> jogos) {
        this.jogos = jogos;
    }
 
}

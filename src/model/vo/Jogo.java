package model.vo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


public class Jogo {
    
    private int id;
    private Date data;
    private Timestamp hora;
    private ArrayList<Time> times;
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Timestamp getHora() {
        return hora;
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }

    public ArrayList<Time> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<Time> times) {
        this.times = times;
    }
         
}

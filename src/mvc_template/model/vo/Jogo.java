package mvc_template.model.vo;

import java.sql.Timestamp;
import java.util.Date;


public class Jogo {
    
    private int id;
    private Date data;
    private Timestamp tempo;
    
    

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

    public Timestamp getTempo() {
        return tempo;
    }

    public void setTempo(Timestamp tempo) {
        this.tempo = tempo;
    }
       
}

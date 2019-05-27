package mvc_template.model.vo;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * 
 */
public class Jogos {
    
    private Date data;
    private LocalTime tempo;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public LocalTime getTempo() {
        return tempo;
    }
    
    
}

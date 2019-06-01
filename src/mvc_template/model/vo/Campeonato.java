package mvc_template.model.vo;

import java.util.Date;

/**
 *
 * 
 */
public class Campeonato {
    
    private int id;
    private int edicao;
    private Date data_camp;

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
    
    
}

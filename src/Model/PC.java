package Model;

import java.io.Serializable;

/**
 * Created by Игорь on 23.07.2017.
 */
public class PC implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String number;
    private int idPC;

    public PC(String number) {
        this.number = number;

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getIdPC() {
        return idPC;
    }

    public void setIdPC(int idPC) {
        this.idPC = idPC;
    }

    @Override
    public String toString() {
        return new String(getNumber()+" ");
    }
}

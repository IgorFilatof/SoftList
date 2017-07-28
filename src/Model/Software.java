package Model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Игорь on 25.07.2017.
 */
public class Software implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String name;
    private String status;
    private String date;

    public Software(String name, String status, String date) {
        this.name = name;
        this.status = status;
        this.date=date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}

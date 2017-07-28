package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Игорь on 25.07.2017.
 */
public class Building implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String name;


    public Building(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return new String(getName());
    }
}

package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Игорь on 23.07.2017.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private String firstName;
    private String lastName;
    private String id;


    public User(String firstName, String lastName,String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id=id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return new String(getFirstName() + " " + getLastName());
    }
}

package Model;

import java.io.Serializable;

/**
 * Created by Игорь on 23.07.2017.
 */
public class Executor implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String firstName;
    private String lastName;
    private String numberNote;
    private int idExecutor;

    public Executor(String firstName,String numberNote) {
        this.firstName = firstName;
        this.numberNote=numberNote;

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

    public int getIdExecutor() {
        return idExecutor;
    }

    public void setIdExecutor(int idExecutor) {
        this.idExecutor = idExecutor;
    }

    public String getNumberNote() {
        return numberNote;
    }

    public void setNumberNote(String numberNote) {
        this.numberNote = numberNote;
    }

    @Override
    public String toString() {
        return new String(getFirstName()+" "+getLastName()+ " ");
    }
}

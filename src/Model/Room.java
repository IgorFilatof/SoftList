package Model;

import java.io.Serializable;

/**
 * Created by Игорь on 23.07.2017.
 */
public class Room implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String nameRoom;
    private int idRoom;

    public Room(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }
}

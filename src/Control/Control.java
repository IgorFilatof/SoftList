package Control;


import Model.*;

import javax.swing.*;
import java.io.*;

/**
 * Created by Игорь on 23.07.2017.
 */
public class Control {

    private Factory factory;
    File file=loadFile();

    public Control() {
        factory = new Factory();
    }

    public void addUser(String firstName, String lastName, String id) {
        int i = factory.getUsers().size();
        i++;
        id = Integer.toString(i);
        factory.getUsers().add(new User(firstName, lastName, id));
    }

    public void addPC(String namePC) {
        factory.getPcs().add(new PC(namePC));
    }

    public void addSoftware(String nameSoftware, String status, String date) {
        factory.getSoftwares().add(new Software(nameSoftware, status, date));
    }


    public void addBuilding(String name) {
        factory.getBuildings().add(new Building(name));
    }

    public void addExecutor(String firstName, String numberNote) {
        factory.getExecutors().add(new Executor(firstName, numberNote));
    }

    public void addRoom(String name) {
        factory.getRooms().add(new Room(name));
    }

    public void setUser(String firstName, String lastName, String id, int i) {
        int j = i;
        j++;
        id = Integer.toString(j);
        factory.getUsers().set(i, new User(firstName, lastName, id));
    }

    public void setPC(String namePC, int i) {
        factory.getPcs().set(i, new PC(namePC));
    }

    public void setRoom(String name, int i) {
        factory.getRooms().set(i, new Room(name));
    }

    public void setSoftware(String nameSoftware, String status, String date, int i) {
        factory.getSoftwares().set(i, new Software(nameSoftware, status, date));
    }


    public void setBuilding(String name, int i) {
        factory.getBuildings().set(i, new Building(name));
    }

    public void setExecutor(String firstName, String numberNote, int i) {
        factory.getExecutors().set(i, new Executor(firstName, numberNote));
    }

    public String getFirstNameUser(int count) {
        String str = "";
        str += factory.getUsers().get(count).getFirstName();
        return str;
    }

    public String getLastNameUser(int count) {
        String str = "";
        str += factory.getUsers().get(count).getLastName();
        return str;
    }

    public String getAllNumber(int count) {
        String str = "";
        str += factory.getUsers().get(count).getId();
        return str;
    }

    public String getAllUser(int count) {
        String str = "";
        str += factory.getUsers().get(count).getFirstName() + " " + factory.getUsers().get(count).getLastName();
        return str;
    }

    public String getAllDate(int count) {
        String str = "";
        str += factory.getSoftwares().get(count).getDate();
        return str;
    }


    public String getAllBuilding(int count) {
        String str = "";
        str += factory.getBuildings().get(count).getName();
        return str;
    }

    public String getAllExecutor(int count) {
        String str = "";
        str += factory.getExecutors().get(count).getFirstName();
        return str;
    }

    public String getAllRoom(int count) {
        String str = "";
        str += factory.getRooms().get(count).getNameRoom();
        return str;
    }

    public String getAllPC(int count) {
        String str = "";
        str += factory.getPcs().get(count).getNumber();
        return str;
    }

    public String getAllSoftware(int count) {
        String str = "";
        str += factory.getSoftwares().get(count).getName();
        return str;
    }

    public String getAllStatus(int count) {
        String str = "";
        str += factory.getSoftwares().get(count).getStatus();
        return str;
    }

    public String getAllNumberNote(int count) {
        String str = "";
        str += factory.getExecutors().get(count).getNumberNote();
        return str;
    }

    public int getRows() {
        int i = 0;
        i = factory.getUsers().size();
        return i;
    }

    public File loadFile() {
        JFileChooser jFileChooser = new JFileChooser();
        File file = null;
        int ret = jFileChooser.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = jFileChooser.getSelectedFile();
        }
        return file;
    }

    public void save() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(factory);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() throws FileNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {

            factory = (Factory) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

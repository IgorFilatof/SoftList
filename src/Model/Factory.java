package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Игорь on 23.07.2017.
 */
public class Factory implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private int id;
    private ArrayList<User> users;
    private ArrayList<Executor> executors;
    private ArrayList<PC> pcs;
    private ArrayList<Room> rooms;
    private ArrayList<Software> softwares;
    private ArrayList<Building> buildings;
    private ArrayList<Integer>number;



    public Factory() {
        users = new ArrayList<>();
        executors = new ArrayList<>();
        pcs = new ArrayList<>();
        rooms = new ArrayList<>();
        softwares = new ArrayList<>();
        buildings = new ArrayList<>();
        number=new ArrayList<>();

    }

    public ArrayList<Integer> getNumber() {
        return number;
    }

    public void setNumber(ArrayList<Integer> number) {
        this.number = number;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Executor> getExecutors() {
        return executors;
    }

    public void setExecutors(ArrayList<Executor> executors) {
        this.executors = executors;
    }

    public ArrayList<PC> getPcs() {
        return pcs;
    }

    public void setPcs(ArrayList<PC> pcs) {
        this.pcs = pcs;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Software> getSoftwares() {
        return softwares;
    }

    public void setSoftwares(ArrayList<Software> softwares) {
        this.softwares = softwares;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public int incrementID() {
        id++;
        return id;
    }
}

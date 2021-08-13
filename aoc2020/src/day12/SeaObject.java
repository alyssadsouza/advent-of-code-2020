package day12;

import java.util.ArrayList;
import java.util.List;

public class SeaObject {

    private int north;
    private int east;
    private String direction;

    public SeaObject(int east, int north) {
        
        this.north = north;
        this.east = east;
        this.direction = "E";

    }

    public String toString() {

        String eastStatement;
        String northStatement;

        if (this.east < 0) {
            eastStatement = "west: " + (-this.east);
        } else {
            eastStatement = "east: " + this.east;
        }

        if (this.north < 0) {
            northStatement = "south: " + (-this.north);
        } else {
            northStatement = "north: " + this.north;
        }

        return eastStatement + ", " + northStatement;
    }

    public int getNorth() {
        return this.north;
    }

    public int getEast() {
        return this.east;
    }

    public void setNorth(int value) {
        this.north = value;
    }

    public void setEast(int value) {
        this.east = value;
    }

    public void north(int value) {
        this.north += value;
    }

    public void south(int value) {
        this.north -= value;
    }

    public void east(int value) {
        this.east += value;
    }

    public void west(int value) {
        this.east -= value;
    }

    public void forward(int value) {
        if (this.direction.equals("N")) {
            north(value);
        } else if (this.direction.equals("S")) {
            south(value);
        } else if (this.direction.equals("E")) {
            east(value);
        } else {
            west(value);
        }
    }

    public void left(int degrees) {

        int turns = degrees / 90;
        List<String> directions = new ArrayList<String>(List.of("N", "E", "S", "W"));
        int start = directions.indexOf(this.direction);

        int newIndex = start - turns;

        while (newIndex < 0) {
            newIndex += directions.size();
        }

        this.direction = directions.get(newIndex);

    }

    public void right(int degrees) {

        int turns = degrees / 90;
        List<String> directions = new ArrayList<String>(List.of("N", "E", "S", "W"));
        int start = directions.indexOf(this.direction);

        int newIndex = start + turns;

        while (newIndex >= directions.size()) {
            newIndex -= directions.size();
        }

        this.direction = directions.get(newIndex);

    }
    
}

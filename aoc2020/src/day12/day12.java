package day12;

import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.lang.Math;

public class day12 {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(Paths.get("aoc2020/src/day12/input.txt"));

        // Get input as list
        ArrayList<String> actions = new ArrayList<>();

        // part 1:

        SeaObject ship = new SeaObject(0,0);

        while (input.hasNextLine()) {

            String action = input.nextLine();
            actions.add(action);

            Character direction = action.charAt(0);
            Integer value = Integer.valueOf(action.substring(1));

            if (direction == 'N') {
                ship.north(value);
            } else if (direction == 'S') {
                ship.south(value);
            } else if (direction == 'E') {
                ship.east(value);
            } else if (direction == 'W') {
                ship.west(value);
            } else if (direction == 'L') {
                ship.left(value);
            } else if (direction == 'R') {
                ship.right(value);
            } else {
                ship.forward(value);
            }

        }

        System.out.println(Math.abs(ship.getNorth()) + Math.abs(ship.getEast()));

        // part 2:

        SeaObject newShip = new SeaObject(0,0);
        Waypoint waypoint = new Waypoint(10,1);

        for (String action : actions) {

            Character direction = action.charAt(0);
            Integer value = Integer.valueOf(action.substring(1));

            if (direction == 'N') {
                waypoint.north(value);
            } else if (direction == 'S') {
                waypoint.south(value);
            } else if (direction == 'E') {
                waypoint.east(value);
            } else if (direction == 'W') {
                waypoint.west(value);
            } else if (direction == 'L') {
                waypoint.left(value);
            } else if (direction == 'R') {
                waypoint.right(value);
            } else {
                newShip.north(value*waypoint.getNorth());
                newShip.east(value*waypoint.getEast());
            }

        }

        System.out.println(Math.abs(newShip.getNorth()) + Math.abs(newShip.getEast()));

    }
    
}

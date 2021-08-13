package day11;

import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;

public class day11 {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(Paths.get("aoc2020/src/day11/input.txt"));

        // Get input as list
        ArrayList<String> seats = new ArrayList<>();

        while (input.hasNextLine()) {

            seats.add(input.nextLine());

        }

        SeatPlan seatPlan = new SeatPlan(seats);
        int rowLen = seats.get(0).length();

        // // part 1:

        // while (true) {
        //     SeatPlan seatPlanCopy = new SeatPlan(seatPlan.seats());
        //     ArrayList<String> seatsCopy = seatPlanCopy.seats();
    
        //     int seatsCopySize = seatsCopy.size();
    
        //     for (int row = 0; row < seatsCopySize; row++) {
    
        //         for (int column = 0; column < rowLen; column++) {
    
        //             String seat = seatPlanCopy.seat(row, column);
                    
        //             if (seat.equals("L") && seatPlanCopy.occupy(row, column)) {
        //                 seatPlan.setSeat(row, column, "#");
        //             }
    
        //             if (seat.equals("#") && seatPlanCopy.vacate(row, column)) {
        //                 seatPlan.setSeat(row, column, "L");
        //             }
                    
        //         }
    
        //     }

        //     if (seatPlan.seats().equals(seatPlanCopy.seats())) {
        //         break;
        //     }
        // }

        // // count occupied in final seat plan

        // int occupied = 0;

        // ArrayList<String> finalSeats = seatPlan.seats();

        // for (String seat : finalSeats) {

        //     for (int column = 0; column < rowLen; column++) {
        //         if (String.valueOf(seat.charAt(column)).equals("#")) {
        //             occupied++;
        //         }
        //     }
        // }

        // System.out.println(occupied);

        
        // part 2:


        while (true) {
            SeatPlan seatPlanCopy = new SeatPlan(seatPlan.seats());
            ArrayList<String> seatsCopy = seatPlanCopy.seats();
    
            int seatsCopySize = seatsCopy.size();
    
            for (int row = 0; row < seatsCopySize; row++) {
    
                for (int column = 0; column < rowLen; column++) {
    
                    String seat = seatPlanCopy.seat(row, column);
                    
                    if (seat.equals("L") && seatPlanCopy.pickyOccupy(row, column)) {
                        seatPlan.setSeat(row, column, "#");
                    }
    
                    if (seat.equals("#") && seatPlanCopy.pickyVacate(row, column)) {
                        seatPlan.setSeat(row, column, "L");
                    }
                    
                }
    
            }

            if (seatPlan.seats().equals(seatPlanCopy.seats())) {
                break;
            }
        }

        // count occupied in final seat plan

        int occupied = 0;

        ArrayList<String> finalSeats = seatPlan.seats();

        for (String seat : finalSeats) {

            for (int column = 0; column < rowLen; column++) {
                if (String.valueOf(seat.charAt(column)).equals("#")) {
                    occupied++;
                }
            }
        }

        System.out.println(occupied);
    }
    
}

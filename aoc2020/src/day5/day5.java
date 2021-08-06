package day5;

import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class day5 {
    
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(Paths.get("aoc2020/src/day5/input.txt"));

        // part 1:

        ArrayList<Integer> seatIDs = new ArrayList<>();

        int highestID = 0;

        while (input.hasNextLine()) {

            String pass = input.nextLine();

            int row = 0;
            int col = 0;

            int upperRow = 128;
            int lowerRow = 0;

            int upperCol = 8;
            int lowerCol = 0;

            for (int i=0; i < 10; i++) {

                String letter = String.valueOf(pass.charAt(i));

                if (letter.equals("F")) {
                    upperRow -= (upperRow - lowerRow) / 2;
                    row = lowerRow + (upperRow - lowerRow) / 2;
                }

                if (letter.equals("B")) {
                    lowerRow += (upperRow - lowerRow) / 2;
                    row = lowerRow + (upperRow - lowerRow) / 2;
                }

                if (letter.equals("L")) {
                    upperCol -= (upperCol - lowerCol) / 2;
                    col = lowerCol + (upperCol - lowerCol) / 2;
                }

                if (letter.equals("R")) {
                    lowerCol += (upperCol - lowerCol) / 2;
                    col = lowerCol + (upperCol - lowerCol) / 2;
                }

            }

            int id = row * 8 + col;

            seatIDs.add(id);

            if (id > highestID) {
                highestID = id;
            }

        }

        System.out.println(highestID);

        // part 2:

        ArrayList<Integer> sortedIDs = seatIDs.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
        
        for (int i = 1; i < sortedIDs.size(); i++) {

            if (sortedIDs.get(i) - sortedIDs.get(i-1) == 2) {
                System.out.println(sortedIDs.get(i)-1);
                break;
            }

        }

    }

}

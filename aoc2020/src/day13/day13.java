package day13;

import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;

public class day13 {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(Paths.get("aoc2020/src/day13/input.txt"));

        // Get input

        int earliest = Integer.valueOf(input.nextLine());

        String[] times = input.nextLine().split(",");


        // part 1:

        int time = earliest;
        boolean end = false;

        while (!end) {

            for (String departure : times) {
                try {
                    if (time % Integer.valueOf(departure) == 0) {
                        System.out.println(Integer.valueOf(departure)*(time - earliest));
                        end = true;
                        break;
                    }
                } catch (Exception e) {}
            }

            time++;

        }
        
    }
    
}

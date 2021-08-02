package day1;

import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;

public class day1 {
    public static void main(String[] args) throws Exception {

        ArrayList<Integer> nums = new ArrayList<>();

        Scanner input = new Scanner(Paths.get("aoc2020/src/day1/1.txt"));

        // Convert input into list of ints
        while (input.hasNextLine()) {
            nums.add(Integer.valueOf(input.nextLine()));
        }

        // part 1:

        boolean done = false;

        for (int num1 : nums) {
    
            for (int num2 : nums) {

                if (num1 + num2 == 2020) {
                    System.out.println(num1*num2);
                    done = true;
                    break;
                }

            }

            if (done) {
                break;
            }

        }

        done = false;

        // part 2:

        for (int num1 : nums) {

            for (int num2 : nums) {

                for (int num3: nums) {

                    if (num1 + num2 + num3 == 2020) {

                        System.out.println(num1*num2*num3);
                        done = true;
                        break;

                    }
                }

                if (done) {
                    break;
                }

            }

            if (done) {
                break;
            }
            
        }
        
    }
}

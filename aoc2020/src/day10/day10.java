package day10;

import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class day10 {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(Paths.get("aoc2020/src/day10/test.txt"));

        // Get input as list
        ArrayList<Integer> jolts = new ArrayList<>();
        jolts.add(0);

        while (input.hasNextLine()) {

            jolts.add(Integer.valueOf(input.nextLine()));

        }

        // part 1:

        int ones = 0;
        int threes = 0;

        Collections.sort(jolts);
        jolts.add(jolts.get(jolts.size()-1)+3);

        int len = jolts.size();

        for (int i = 1; i < len; i++) {

            int thisNum = jolts.get(i);
            int prevNum = jolts.get(i-1);

            if (thisNum - prevNum == 1) {

                ones++;

            } else if (thisNum - prevNum == 3) {

                threes++;

            }

        }

        System.out.println(ones * threes);

        // part 2:

        int removable = 0;
        ArrayList<Integer> removables = new ArrayList<>();

        for (int i = 1; i < len - 1; i++) {

            int prevNum = jolts.get(i-1);
            int nextNum = jolts.get(i+1);

            if (nextNum - prevNum < 4) {
                removable++;
                removables.add(jolts.get(i));
            }

        }

        System.out.println(jolts);
        System.out.println(removables);
        System.out.println(removable);

        // come back to part 2

        //System.out.println(factorial(removable) + 2);

    }

    public static int factorial(int n) {
        
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);

    }
    
}

package day9;

import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class day9 {
    
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(Paths.get("aoc2020/src/day9/input.txt"));

        // Get input as list
        ArrayList<Long> nums = new ArrayList<>();

        while (input.hasNextLine()) {

            nums.add(Long.valueOf(input.nextLine()));

        }

        // part 1:

        int len = nums.size();
        int preamble = 25;
        boolean valid = false;
        long invalid = 0;

        for (int i = preamble; i < len; i++) {

            valid = false;

            long thisNum = nums.get(i);

            List<Long> range = nums.subList(i-preamble, i);

            for (long num : range) {

                long difference = thisNum - num;
                
                if (thisNum - difference != difference && range.contains(difference)) {

                    invalid = thisNum;
                    valid = true;
                    break;
    
                }
            }

            if (!valid) {
                invalid = thisNum;
                break;
            }

        }

        System.out.println(invalid);

        // part 2:

        boolean listFound = false;

        int start = 0;
        int end = 0;

        while (!listFound) {

            long sum = nums.get(start);

            while (true) {
                
                end++;

                sum += nums.get(end);

                if (sum == invalid) {

                    listFound = true;
                    break;

                } else if (sum > invalid) {

                    start++;
                    end = start;
                    break;

                }

            }

        }

        List<Long> list = nums.subList(start, end + 1);

        Collections.sort(list);

        long min = list.get(0);
        long max = list.get(list.size()-1);

        System.out.println(min + max);
    }

}

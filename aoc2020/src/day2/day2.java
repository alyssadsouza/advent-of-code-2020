package day2;

import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;

public class day2 {
    public static void main(String[] args) throws Exception {

        ArrayList<String> passwords = new ArrayList<>();

        Scanner input = new Scanner(Paths.get("aoc2020/src/day2/input.txt"));

        // Convert input into list of ints
        while (input.hasNextLine()) {
            passwords.add(input.nextLine());
        }

        // part 1:

        int valid = 0;

        for (String line : passwords) {

            String[] rulesAndPassword = line.split(": ");
            String password = rulesAndPassword[1];
            
            String[] numsAndChar = rulesAndPassword[0].split(" ");
            String letter = numsAndChar[1];

            String[] minAndMax = numsAndChar[0].split("-");

            int min = Integer.valueOf(minAndMax[0]);
            int max = Integer.valueOf(minAndMax[1]);

            int occurence = 0;

            for (int i=0; i < password.length(); i++) {

                if (String.valueOf(password.charAt(i)).equals(letter)) {
                    occurence++;
                }

            }

            if (occurence >= min && occurence <= max) {
                valid++;
            }

        }

        System.out.println(valid);


        // part 2:

        valid = 0;

        for (String line : passwords) {

            String[] rulesAndPassword = line.split(": ");
            String password = rulesAndPassword[1];
            
            String[] numsAndChar = rulesAndPassword[0].split(" ");
            String letter = numsAndChar[1];

            String[] minAndMax = numsAndChar[0].split("-");

            int pos1 = Integer.valueOf(minAndMax[0])-1;
            int pos2 = Integer.valueOf(minAndMax[1])-1;

            int occurence = 0;

            if (String.valueOf(password.charAt(pos1)).equals(letter)) {
                occurence++;
            }

            if (String.valueOf(password.charAt(pos2)).equals(letter)) {
                occurence++;
            }

            if (occurence == 1) {
                valid++;
            }

        }

        System.out.println(valid);

        
    }
}

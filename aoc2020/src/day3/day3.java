package day3;

import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;

public class day3 {

    public static void main(String[] args) throws Exception {

        ArrayList<String> map = new ArrayList<>();

        Scanner input = new Scanner(Paths.get("aoc2020/src/day3/input.txt"));

        // Convert input into list
        while (input.hasNextLine()) {
            map.add(input.nextLine());
        }

        // part 1:

        long trees = countTrees(3,1,map);

        System.out.println(trees);

        // part 2:

        trees *= countTrees(1,1,map);
        trees *= countTrees(5,1,map);
        trees *= countTrees(7,1,map);
        trees *= countTrees(1,2,map);

        System.out.println(trees);
        

    }
    
    public static int countTrees(int right, int down, ArrayList<String> map) {

        int col = 0;
        int trees = 0;

        for (int row=0; row < map.size(); row += down) {

            if (String.valueOf(map.get(row).charAt(col)).equals("#")) {

                trees++;

            }

            col += right;

            if (col >= map.get(row).length()) {
                col -= map.get(row).length();
            }

        }

        return trees;

    }

}

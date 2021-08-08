package day8;

import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;

public class day8 {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(Paths.get("aoc2020/src/day8/input.txt"));

        // Get input as list
        ArrayList<String> instructions = new ArrayList<>();

        while (input.hasNextLine()) {

            instructions.add(input.nextLine());

        }


        // part 1:

        int acc = 0;
        int index = 0;
        ArrayList<Integer> visitedIndex = new ArrayList<>();

        // (for part 2, keep list of indices with jmp and nop)
        ArrayList<Integer> jmps = new ArrayList<>();
        ArrayList<Integer> nops = new ArrayList<>();

        while (!visitedIndex.contains(index)) {

            visitedIndex.add(index);

            String[] line = instructions.get(index).split(" ");
            String command = line[0];
            int num = Integer.valueOf(line[1]);

            if (command.equals("jmp")) {

                jmps.add(index);
                index += num;

            } else {

                if (command.equals("acc")) {
                    acc += num;
                } else {
                    nops.add(index);
                }

                index++;
            }

        }

        System.out.println(acc);


        // part 2:

        boolean next = true;

        for (int jmpIndex : jmps) {

            if (swapIndex(jmpIndex, instructions)) {

                next = false;
                break;

            }

        }

        if (next) {
            for (int nopIndex : jmps) {

                if (swapIndex(nopIndex, instructions)) {
    
                    break;
    
                }
    
            }
        }

    }

    public static boolean swapIndex(int swap, ArrayList<String> instructions) {

        int acc = 0;
        int index = 0;
        ArrayList<Integer> visitedIndex = new ArrayList<>();
        int len = instructions.size();

        while (!visitedIndex.contains(index)) {

            if (index >= len) {
                System.out.println(acc);
                return true;
            }

            visitedIndex.add(index);

            String[] line = instructions.get(index).split(" ");
            String command = line[0];
            int num = Integer.valueOf(line[1]);

            if (index == swap) {

                if (command.equals("jmp")) {
                    command = "nop";
                } else {
                    command = "jmp";
                }

            }

            if (command.equals("jmp")) {

                index += num;

            } else {

                if (command.equals("acc")) {
                    acc += num;
                }

                index++;
            }

        }

        return false;

    }
    
}

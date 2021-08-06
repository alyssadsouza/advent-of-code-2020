package day6;

import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class day6 {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(Paths.get("aoc2020/src/day6/input.txt"));

        ArrayList<HashMap<String, Integer>> groups = new ArrayList<>();
        HashMap<String, Integer> questions = new HashMap<>();
        int groupSize = 0;
        int sum = 0;

        // part 1:

        while (input.hasNextLine()) {

            String line = input.nextLine();

            if (line.isBlank()) {

                questions.put("Group size", groupSize);
                groups.add(questions);

                questions = new HashMap<>();
                groupSize = 0;

            } else {

                groupSize++;

                for (int i = 0; i < line.length(); i++) {

                    String question = String.valueOf(line.charAt(i));

                    int count = questions.getOrDefault(question, 0);

                    if (count == 0) {

                        questions.put(question, 1);
                        sum++;

                    } else {

                        count++;

                        questions.put(question, count);

                    }

                }

            }

        }

        System.out.println(sum);

        // part 2:

        sum = 0;

        for (HashMap<String, Integer> group : groups) {
            
            int groupLen = group.get("Group size");

            for (String key : group.keySet()) {

                if (!key.equals("Group size")) {

                    if (group.get(key) == groupLen) {

                        sum++;
                
                    }

                }
                
            }
        }

        System.out.println(sum);

    }
    
}

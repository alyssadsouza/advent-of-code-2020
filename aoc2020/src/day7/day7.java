package day7;

import java.util.Scanner;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class day7 {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(Paths.get("aoc2020/src/day7/input.txt"));
        
        // Get input as Map

        // Each type of bag has its own hashmap for each type of other bag it contains and the quantity
        Map<String, Map<String, Integer>> bags = new HashMap<>();

        while (input.hasNextLine()) {

            String line = input.nextLine();

            String[] firstSplit = line.split(" bags contain ");
            
            String bag = firstSplit[0];

            if (!firstSplit[1].contains("no other")) {

                Map<String, Integer> bagContent = new HashMap<>();

                String[] contents = firstSplit[1].split(", ");

                for (String content : contents) {

                    String[] bagAndNum = content.split(" ");

                    String bagType = bagAndNum[1] + " " + bagAndNum[2];
                    int num = Integer.valueOf(bagAndNum[0]);

                    bagContent.put(bagType, num);

                }

                bags.put(bag, bagContent);

            } else {
                
                bags.put(bag, null);
            }

        }


        // part 1:

        // Keep a list of all the bags needed - shiny gold AND all other bags that contain shiny gold directly or indirectly
        Set<String> bagList = new HashSet<>();
        bagList.add("shiny gold");

        Set<String> keys = bags.keySet();

        boolean end = false;

        while (!end) {

            end = true;
            Set<String> newBags = new HashSet<>();

            for (String bag : keys) {

                for (String neededBag : bagList) {

                    if (bags.get(bag) != null && bags.get(bag).keySet().contains(neededBag) && !(bagList.contains(bag))) {

                        newBags.add(bag);
                        end = false;

                    }
    
                }
    
            }

            bagList.addAll(newBags);

        }

        System.out.println(bagList.size()-1);



        // part 2:

        System.out.println(countBags("shiny gold", bags));



    }

    public static int countBags(String bag, Map<String, Map<String, Integer>> bags) {

        if (bags.get(bag) == null) {

            return 0;

        }

        int count = 0;

        for (Map.Entry<String, Integer> nestedBag : bags.get(bag).entrySet()) {

            int n = nestedBag.getValue();

            count += n + n * countBags(nestedBag.getKey(), bags);
        }

        return count;

    }
    
}

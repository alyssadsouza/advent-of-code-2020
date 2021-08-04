package day4;

import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class day4 {

    public static void main(String[] args) throws Exception {

        ArrayList<HashMap<String, String>> passports = new ArrayList<>();

        Scanner input = new Scanner(Paths.get("aoc2020/src/day4/input.txt"));

        // Convert input into list with hash maps for each field
        HashMap<String, String> passport = new HashMap<>();

        while (input.hasNextLine()) {

            String nextLine = input.nextLine();

            if (nextLine.isBlank()) {

                passports.add(passport);
                passport = new HashMap<>();

            } else {

                String[] line = nextLine.strip().split(" ");

                for (String field : line) {

                    String[] keyValue = field.split(":");
                    passport.put(keyValue[0], keyValue[1]);

                }
            
            }
        }

        // part 1:
        
        int valid = 0;
        List<String> validFields = new ArrayList<>(Arrays.asList("hcl", "iyr", "hgt", "pid", "byr", "ecl", "eyr"));
        ArrayList<HashMap<String,String>> validPassports = new ArrayList<>();

        for (HashMap<String, String> pass : passports) {

            boolean isValid = true;

            for (String field : validFields) {


                if (!(pass.keySet().contains(field))) {

                    isValid = false;
                    break;

                }

            }

            if (isValid) {

                valid++;
                validPassports.add(pass);

            }

        }

        System.out.println(valid);
        
        // part 2:

        valid = 0;

        for (HashMap<String,String> pass : validPassports) {

            boolean isValid = true;

            for (String key : pass.keySet()) {
                if (key.equals("byr")) {
                    isValid = validByr(Integer.valueOf(pass.get("byr")));
                }
                
                if (key.equals("iyr")) {
                    isValid = validIyr(Integer.valueOf(pass.get("iyr")));
                }

                if (key.equals("eyr")) {
                    isValid = validEyr(Integer.valueOf(pass.get("eyr")));
                }

                if (key.equals("hgt")) {
                    isValid = validHgt(pass.get("hgt"));
                }

                if (key.equals("hcl")) {
                    isValid = validHcl(pass.get("hcl"));
                }

                if (key.equals("ecl")) {
                    isValid = validEcl(pass.get("ecl"));
                }

                if (key.equals("pid")) {
                    isValid = validPid(pass.get("pid"));
                }

                if (!isValid) {
                    break;
                }

            }

            if (isValid) {
                valid++;
            }

        }

        System.out.println(valid);

        
    }

    public static boolean validByr(int byr) {

        return byr >= 1920 && byr <= 2002;

    }

    public static boolean validIyr(int iyr) {


        return iyr >= 2010 && iyr <= 2020;

    }

    public static boolean validEyr(int eyr) {


        return eyr >= 2020 && eyr <= 2030;

    }

    public static boolean validHgt(String hgt) {


        int len = hgt.length();
        String lastTwo = hgt.substring(len-2, len);
        boolean isNum = hgt.substring(0, len-2).matches("\\d+");

        if (!isNum) {
            return false;
        }

        int num = Integer.valueOf(hgt.substring(0, len-2));

        if (lastTwo.equals("cm")) {
            return num >= 150 && num <= 193;
        }

        if (lastTwo.equals("in")) {
            return num >= 59 && num <= 76;
        }

        return false;

    }

    public static boolean validHcl(String hcl) {

        return hcl.matches("#[0-9a-f]{6}");

    }

    public static boolean validEcl(String ecl) {

        List<String> valid = new ArrayList<>(Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth"));
        return valid.contains(ecl);

    }

    public static boolean validPid(String pid) {

        return pid.matches("[0-9]{9}");

    }

}

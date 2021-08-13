package day11;

import java.util.ArrayList;

public class SeatPlan {

    private ArrayList<String> seats;

    public SeatPlan(ArrayList<String> seats) {

        this.seats = (ArrayList<String>)seats.clone();

    }

    public String seat(int row, int column) {

        return String.valueOf(this.seats.get(row).charAt(column));

    }

    public void setSeat(int row, int column, String value) {

        String oldRow = this.seats.get(row);
        String newRow = oldRow.substring(0, column) + value + oldRow.substring(column + 1, oldRow.length());

        this.seats.set(row, newRow);

    }

    public ArrayList<String> seats() {
        return this.seats;
    }

    public boolean occupy(int row, int column) {

        if (seat(row, column).equals("#")) {
            return false;
        }

        ArrayList<String> adjacent = adjacent(row, column);

        return !(adjacent.contains("#"));

    }

    public boolean vacate(int row, int column) {

        if (seat(row, column).equals("L")) {
            return false;
        }

        int occupied = 0;
        ArrayList<String> adjacent = adjacent(row, column);

        for (String seat : adjacent) {
            if (seat.equals("#")) {
                occupied++;
            }
        }

        return occupied > 3;

    }

    public ArrayList<String> adjacent(int row, int column) {

        ArrayList<String> adjacent = new ArrayList<>();

        try {
            adjacent.add(String.valueOf(this.seats.get(row-1).charAt(column)));
        } catch (Exception e) {}
        
        try {
            adjacent.add(String.valueOf(this.seats.get(row+1).charAt(column)));
        } catch (Exception e) {}
        
        try {
            adjacent.add(String.valueOf(this.seats.get(row).charAt(column-1)));
        } catch (Exception e) {}
        
        try {
            adjacent.add(String.valueOf(this.seats.get(row).charAt(column+1)));
        } catch (Exception e) {}
        
        try {
            adjacent.add(String.valueOf(this.seats.get(row-1).charAt(column-1)));
        } catch (Exception e) {}
        
        try {
            adjacent.add(String.valueOf(this.seats.get(row-1).charAt(column+1)));
        } catch (Exception e) {}
        
        try {
            adjacent.add(String.valueOf(this.seats.get(row+1).charAt(column-1)));
        } catch (Exception e) {}
        
        try {
            adjacent.add(String.valueOf(this.seats.get(row+1).charAt(column+1)));
        } catch (Exception e) {}

        return adjacent;

    }

    // part 2 methods:

    public String firstUpperSeat(int row, int column) {
        
        try {
            while (true) {

                row--;
                String seat = seat(row, column);
    
                if (seat.equals("L")) {
                    return "L";
                } else if (seat.equals("#")) {
                    return "#";
                }
    
            }
        } catch (Exception e) {
            return ".";
        }

    }

    public String firstLowerSeat(int row, int column) {
        
        try {
            while (true) {

                row++;
                String seat = seat(row, column);
    
                if (seat.equals("L")) {
                    return "L";
                } else if (seat.equals("#")) {
                    return "#";
                }
    
            }
        } catch (Exception e) {
            return ".";
        }

    }

    public String firstLeftSeat(int row, int column) {
        
        try {
            while (true) {

                column--;
                String seat = seat(row, column);
    
                if (seat.equals("L")) {
                    return "L";
                } else if (seat.equals("#")) {
                    return "#";
                }
    
            }
        } catch (Exception e) {
            return ".";
        }

    }
    
    public String firstRightSeat(int row, int column) {
        
        try {
            while (true) {

                column++;
                String seat = seat(row, column);
    
                if (seat.equals("L")) {
                    return "L";
                } else if (seat.equals("#")) {
                    return "#";
                }
    
            }
        } catch (Exception e) {
            return ".";
        }

    }

    public String firstUpperLeftSeat(int row, int column) {
        
        try {
            while (true) {

                row--;
                column--;
                String seat = seat(row, column);
    
                if (seat.equals("L")) {
                    return "L";
                } else if (seat.equals("#")) {
                    return "#";
                }
    
            }
        } catch (Exception e) {
            return ".";
        }

    }
    
    public String firstUpperRightSeat(int row, int column) {
        
        try {
            while (true) {

                row--;
                column++;
                String seat = seat(row, column);
    
                if (seat.equals("L")) {
                    return "L";
                } else if (seat.equals("#")) {
                    return "#";
                }
    
            }
        } catch (Exception e) {
            return ".";
        }

    }
    
    public String firstLowerLeftSeat(int row, int column) {
        
        try {
            while (true) {

                row++;
                column--;
                String seat = seat(row, column);
    
                if (seat.equals("L")) {
                    return "L";
                } else if (seat.equals("#")) {
                    return "#";
                }
    
            }
        } catch (Exception e) {
            return ".";
        }

    }
    
    public String firstLowerRightSeat(int row, int column) {
        
        try {
            while (true) {

                row++;
                column++;
                String seat = seat(row, column);
    
                if (seat.equals("L")) {
                    return "L";
                } else if (seat.equals("#")) {
                    return "#";
                }
    
            }
        } catch (Exception e) {
            return ".";
        }

    }

    public boolean pickyOccupy(int row, int column) {

        if (seat(row, column).equals("#")) {
            return false;
        }
        
        if (firstUpperSeat(row, column).equals("#") || firstLowerSeat(row, column).equals("#") || firstLeftSeat(row, column).equals("#") || firstRightSeat(row, column).equals("#") || firstUpperLeftSeat(row, column).equals("#") || firstUpperRightSeat(row, column).equals("#") || firstLowerLeftSeat(row, column).equals("#") || firstLowerRightSeat(row, column).equals("#")) {
            return false;
        }
        
        return true;

    }

    public boolean pickyVacate(int row, int column) {

        if (seat(row, column).equals("L")) {
            return false;
        }

        int occupied = 0;
        
        if (firstUpperSeat(row, column).equals("#")) {
            occupied++;
        }

        if (firstLowerSeat(row, column).equals("#")) {
            occupied++;
        }
        
        if (firstLeftSeat(row, column).equals("#")) {
            occupied++;
        }

        if (firstRightSeat(row, column).equals("#")) {
            occupied++;
        }

        if (firstUpperLeftSeat(row, column).equals("#")) {
            occupied++;
        }

        if (firstUpperRightSeat(row, column).equals("#")) {
            occupied++;
        }

        if (firstLowerLeftSeat(row, column).equals("#")) {
            occupied++;
        }

        if (firstLowerRightSeat(row, column).equals("#")) {
            occupied++;
        }

        return occupied > 4;

    }
    
}

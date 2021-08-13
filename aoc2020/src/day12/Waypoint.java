package day12;

public class Waypoint extends SeaObject {
    
    public Waypoint(int east, int north) {
        super(east, north);
    }

    @Override
    public void right(int degrees) {

        int turns = degrees / 90;
        
        for (int i = 0; i < turns; i++) {

            int prevNorth = super.getNorth();
            super.setNorth(-super.getEast());
            super.setEast(prevNorth);

        }

    }

    @Override
    public void left(int degrees) {

        int turns = degrees / 90;
        
        for (int i = 0; i < turns; i++) {

            int prevEast = super.getEast();
            super.setEast(-super.getNorth());
            super.setNorth(prevEast);

        }

    }

}

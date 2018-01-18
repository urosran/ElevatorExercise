import java.util.Arrays;

public class Floor {

    // Note: you may assume that the capacity won't be surpassed.
    private static final int FLOOR_CAPACITY = 100;
    private int floorNumber;
    private Person[] peoplePresent;


    // Constructor

    /**
     * Make sure to instantiate the required fields.
     */
    public Floor(int floorNumber) {
        // TODO: implement me!
        this.floorNumber = floorNumber;
        peoplePresent = new Person[FLOOR_CAPACITY];
    }

    // Methods

    /**
     * This method should save a reference to the person.
     *
     * @param person the person to enter the floor.
     */
    public boolean enterFloor(Person person) {
        // TODO: implement me!
        //since the cap will never be exceeded the people will always be
        //allowed to enter
        peoplePresent[getEmptyPosition()] = person;
        return true;
    }

    /**
     * The string should be informative yet clean and concise
     */
    public String toString() {
        return Arrays.toString(peoplePresent);

    }
    //returns the empty position in the array that holds people
    private int getEmptyPosition() {
        int index = 0;
        for (Person human : peoplePresent) {
            if (human == null) {
                return index;
            }
            index++;
        }
        return index;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}

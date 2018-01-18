public class Person {

    // Fields
    // TODO: what object instances should you keep track of?
    private String nameFirst;
    private String nameLast;
    private int goToFloor;
    private int currentFloor = 0;
    private String name;

    // Constructor

    /**
     * Make sure to pass as parameter the necessary information to
     * initialize the object with a name and a last name.
     */
    public Person(String nameFirst, String nameLast, int goToFloor, int currentFloor) {
        // TODO: implement me!
        this.goToFloor = goToFloor;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.name = nameFirst + " " + nameLast;
        this.currentFloor = currentFloor;
    }

    // Methods

    /**
     * This method will simply call the appropriate method from the
     * building instance to enter the elevator and request a job.
     *
     * @param building the building to be entered
     * @param floor    the floor requested
     */
    public boolean enterBuilding(Building building, int floor) {
        // TODO: implement me!
        //this person requests to go to the certain floor - why we are making this i don't know when you can
        //call the method below on it's own anywhere
        building.enterElevator(this, this.goToFloor);
        return true;
    }

    /**
     * You should hold a variable (that you will need to update at certain
     * moments) that will say the location of a person. You can choose how
     * to implement this, but you should return strings like "In lobby",
     * "In Elevator", or "In floor 4", etc...
     */
    public String getLocation() {
        //returning strings based on the location of the person
        if (currentFloor == 0) {
            return "My name is: " + name + " and I am in the lobby";
        } else if (currentFloor >= 1) {
            return "My name is: " + name + " and I am on floor " + currentFloor;
        }
        return "In the elevator";
    }

    /**
     * The string should be informative yet clean and concise
     */
    public String toString() {
        //TODO: change this maybe if it doesn't make sense
        return name + " and I am going to floor " + goToFloor;
    }

    public String getName() {
        return name;
    }

    public int getGoToFloor() {
        return goToFloor;
    }

    public void setCurrentFloor(int floor) {
        currentFloor = floor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}

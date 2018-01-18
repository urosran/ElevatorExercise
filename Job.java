public class Job {

    // Fields
    // TODO: what object instances should you keep track of?
    private Person person;
    private int goToFloor;


    // Constructor

    /**
     * Make sure to pass the necessary parameters in order to
     * instantiate a Job object that holds a person and a floor.
     */
    public Job(Person person, int floor) {
        // TODO: implement me!
        this.person = person;
        this.goToFloor = floor;
    }

    // Methods

    /**
     * The string should be informative yet clean and concise
     */
    public String toString() {
        return "Person: " + person.getName() + " is going to floor: " + goToFloor;
    }

    public int getGoToFloor() {
        return goToFloor;
    }

    public Person getPerson() {
        return person;
    }
}

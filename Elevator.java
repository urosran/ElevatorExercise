import java.util.Arrays;

public class Elevator {

    // Fields
    // TODO: what object instances should you keep track of?
    /* Note:    You need to keep track of the current floor
                at which the elevator is at. Every time the
                elevator moves, a line should be printed to
                indicate the current floor of the elevator,
                which should change a floor at a time. */
    private Person personInTheElevator;
    private int currentFloor;
    private int indexJob = 0;
    private Job[] jobs;
    Building building;
    // Constructor

    /**
     * Make sure to instantiate the required objects, such as the array
     * of jobs that the elevator needs to have.
     */
    public Elevator(Building building) {
        // TODO: implement me!
        //i keep track of jobs outside of this so no need to instantiate
        this.building = building;
        jobs = new Job[10];
        currentFloor = 0;
    }

    // Methods

    /**
     * This method should simply add, in the right place, a new job
     * to be completed by the elevator.
     *
     * @param person the person that requested the elevator
     * @param floor  the desired floor number
     */
    /* Note:    In order to add jobs to the array you will
    need to have a variable that will keep track
    of the index of the job added last, this way
    you will be able to add a job at the next
    position in the array. */
    //why is this a boolean should be void - practically a setter
    public boolean createJob(Person person, int floor) {
        // TODO: implement me!
        //creating a job
        Job job = new Job(person, floor);
        jobs[indexJob] = job;
        indexJob++;
        return true;
    }


    /**
     * This method should remove jobs one by one (in the right order)
     * and process them individually.
     */
    public void processAllJobs() {
        // TODO: implement me!
        while (jobs[0] != null) {
            personInTheElevator = jobs[0].getPerson();
            processJob(jobs[0]);

            //completed job
            jobs[0] = null;
            cleanUpJobs();
        }
    }

    /**
     * This method should process a job, and move the elevator floor
     * by floor (while printing updates) in order to reach the desired
     * floor. Then, the exit method should be called, simulating the exit
     * of a person (if necessary).
     *
     * @param job the job to be processed
     */
    public boolean processJob(Job job) {
        //elevator goes to the floor (where the next person wants to be picked up at)
        System.out.println(job.getPerson().toString());
        goToBottomFloor(job.getPerson().getCurrentFloor());
        //taking a person to the desired floor
        for (int i = currentFloor; i <= job.getGoToFloor(); i++) {
            //update the current floor as the elevator goes
            currentFloor = i;
            //print where the elevator is
            System.out.println("Taking a person to floor: " + job.getGoToFloor() + " Floor " + i);
        }
        //finished one job
        indexJob--;
        //person exits the elevator
        exit(personInTheElevator, personInTheElevator.getGoToFloor());
        System.out.println(job.getPerson().getLocation());
        System.out.println("\t\t\t\t...");
        //elevator is now empty
        return true;
    }

    /**
     * This method will be used after completing (and removing) a job.
     * The use of this method should guarantee that the jobs array is
     * in a valid state.
     */

    public void cleanUpJobs() {
        // TODO: implement me!
        //moves all the jobs to the left
        for (int i = 0; i < jobs.length - 1; i++) {
            jobs[i] = jobs[i + 1];
        }
    }

    /**
     * This method should call a method on the building for a person
     * to enter a given floor (hold a reference to the person in the given
     * floor).
     *
     * @param person the person exiting at a given floor
     * @param floor  the floor at which the person is exiting
     */
    public boolean exit(Person person, int floor) {
        // TODO: implement me!
        personInTheElevator = null;
        //update the count on the floor that it's at
        building.enterFloor(person, floor);
        //set persons current floor of existence
        person.setCurrentFloor(currentFloor);
        return true;

    }

    /**
     * The string should be informative yet clean and concise
     */
    public String toString() {
        // TODO: implement me!
        return "I am an elevator";
    }
    //helper methods
    public int getCurrentFloor() {
        return currentFloor;
    }

    public Person getPersonInTheElevator() {
        return personInTheElevator;
    }
    //this method moves the elevator to the floor that the person called it from
    private void goToBottomFloor(int currentFloorPerson) {
        //depending on the where person is elevator will go in that direction
        int constantFloor = this.currentFloor;
        //goes down
        if (this.currentFloor > currentFloorPerson) {
            for (int i = constantFloor; i >= 0; i--) {
                this.currentFloor = i;
                System.out.println("Elevator is at floor: " + i + " Going to: " + currentFloorPerson);
            }
            //goes up
        } else {
            for (int i = this.currentFloor; i <= currentFloorPerson; i++) {
                this.currentFloor = i;
                System.out.println("Elevator is at floor: " + i + " Going to: " + currentFloorPerson);
            }
        }


    }
}

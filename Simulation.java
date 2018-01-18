import java.util.Arrays;

public class Simulation {

    /* Note: use additional methods as you see fit. */

    public static void main(String[] args) {
        // TODO: implement me!
        //instantiating building
        Building building = new Building();
        //creating the people
        Person people[] = {
                new Person("Uros", "Randelovic", 4, 0),
                new Person("Jana", "Randelovic", 2, 0),
                new Person("Goran", "Randelovic", 4, 2),
                new Person("Mila", "Randelovic", 4, 0)
        };

        //the person enters the building and the elevator takes it to the desired floor
        //some people are assumed as already in the building just for fun
        for (Person person : people) {
            //people arrive one by one and say where they wanna go
            building.enterElevator(person, person.getGoToFloor());
        }
        //array of jobs has been created start processing them
        building.startElevator();
        //final state of the building
        System.out.println("\nAntonella's building:");
        for (Floor floor: building.getFloors()
             ) {
            System.out.println("Floor: " + floor.getFloorNumber() + floor.toString());
        }
    }
}

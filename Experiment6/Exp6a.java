class Vehicle {

    String name;
    String model;

    Vehicle(String name, String model) {
        this.name = name;
        this.model = model;
    }

    // Inner Class
    class VehicleDetails {

        void displayDetails() {
            System.out.println("---- Vehicle Details ----");
            System.out.println("Vehicle Name: " + name);
            System.out.println("Vehicle Model: " + model);
        }
    }

    // Interface for Anonymous Class
    interface Action {
        void performAction();
    }

    void performVehicleAction() {

        // Anonymous Class
        Action a = new Action() {
            public void performAction() {
                System.out.println("Vehicle is starting.");
            }
        };

        a.performAction();
    }
}

public class Exp6a {

    public static void main(String[] args) {

        Vehicle v = new Vehicle("Toyota", "Fortuner");

        // Creating Inner Class Object
        Vehicle.VehicleDetails details = v.new VehicleDetails();

        // Display vehicle details
        details.displayDetails();

        // Anonymous Class Action
        v.performVehicleAction();
    }
}
class Vehicle {

    String vehicleNumber;
    String vehicleModel;

    Vehicle(String vehicleNumber, String vehicleModel) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleModel = vehicleModel;
    }

    void displayVehicle() {
        System.out.println("----- Vehicle Details -----");
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Model: " + vehicleModel);
    }
}

class CarInsurance extends Vehicle {

    double premium;

    CarInsurance(String vehicleNumber, String vehicleModel, double premium) {
        super(vehicleNumber, vehicleModel);
        this.premium = premium;
    }

    void displayInsurance() {
        System.out.println("----- Car Insurance Details -----");
        System.out.println("Vehicle Number: " + super.vehicleNumber);
        System.out.println("Vehicle Model: " + super.vehicleModel);
        System.out.println("Insurance Premium: " + premium);
    }
}

class BikeInsurance extends Vehicle {

    double premium;

    BikeInsurance(String vehicleNumber, String vehicleModel, double premium) {
        super(vehicleNumber, vehicleModel);
        this.premium = premium;
    }

    void displayInsurance() {
        System.out.println("----- Bike Insurance Details -----");
        System.out.println("Vehicle Number: " + super.vehicleNumber);
        System.out.println("Vehicle Model: " + super.vehicleModel);
        System.out.println("Insurance Premium: " + premium);
    }
}

public class Exp8b {

    public static void main(String[] args) {

        CarInsurance car = new CarInsurance("MH12AB1234", "Toyota Fortuner", 25000);

        BikeInsurance bike = new BikeInsurance("MH12XY5678", "Royal Enfield", 10000);

        car.displayVehicle();
        car.displayInsurance();

        System.out.println();

        bike.displayVehicle();
        bike.displayInsurance();
    }
}
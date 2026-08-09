interface Switchable {

    void turnOn();
}

class Light implements Switchable {

    public void turnOn() {
        System.out.println("Light is turned ON.");
    }
}

class Fan implements Switchable {

    public void turnOn() {
        System.out.println("Fan is turned ON.");
    }
}

public class Exp11b {

    public static void main(String[] args) {

        Switchable light = new Light();
        Switchable fan = new Fan();

        System.out.println("----- Device Status -----");

        light.turnOn();
        fan.turnOn();
    }
}
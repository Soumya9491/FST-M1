package activities;

public class Car {

    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    public Car()
    {
        this.tyres = 4;
        this.doors = 4;
    }

    public void displayCharacteristics()
    {
        System.out.println("Car Color is :" + color);
        System.out.println("Transmission type of car is :" + transmission);
        System.out.println("Make year of car is :" + make);
        System.out.println("Number of doors in the car : "+ doors);
        System.out.println("Number of tyres in the car : "+ tyres);
    }

    public void accelerate()
    {
        System.out.println("Car is moving forward");
    }

    public void brake()
    {
        System.out.println("Car has stopped");
    }
}

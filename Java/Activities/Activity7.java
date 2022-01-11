package activities;

public class Activity7 {
    public static void main(String[] args) {
        MountainBike mb = new MountainBike(5,5,5);
        System.out.println(mb.bicycleDesc());
        mb.applyBrake(5);
        mb.speedUp(7);

    }
}

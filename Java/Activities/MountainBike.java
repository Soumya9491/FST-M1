package activities;

public class MountainBike extends Bicycle{
    int seatHeight;

    public MountainBike(int gears, int speed, int height)
    {
        super(gears, speed);
        this.seatHeight = height;
    }

    public void setHeight (int value)
    {
        seatHeight = value;
    }

    @Override
    public String bicycleDesc()
    {
        return "No of gears are : " + gears + "\nSpeed of bicycle is : " + currentSpeed + "\nSeat height is : " + seatHeight;
    }
}

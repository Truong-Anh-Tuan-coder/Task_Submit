public class Car extends Vehicle{
    int speed = 60;

    @Override
    public void speedUp(){
        System.out.println("Car speed: " + speed);
    }
}

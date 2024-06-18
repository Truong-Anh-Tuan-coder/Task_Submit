public class HelloWorld {
    /*
    Author: Truong Anh Tuan
    DateTime: 17/6/2024
    Function: print hello world
     */
    public static void main(String[] args){
        System.out.println("Hello World");

        int[] array = {1,2,3};
        for( var element : array){
            System.out.println(element + " " );
        }

        // OOP
        // task1
        Vehicle vehicle = new Vehicle();
        Car car = new Car();
        Bicycle bicycle = new Bicycle();

        vehicle.speedUp();
        car.speedUp();
        bicycle.speedUp();
    }

}
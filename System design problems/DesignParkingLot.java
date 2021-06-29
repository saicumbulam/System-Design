package Design;

/*
Shorten: use array to represent different vehical size and decrement their count
 */
/*

ParkingSystem(int big, int medium, int small)
Initializes object of the ParkingSystem class.
The number of slots for each parking space are given as part of the constructor.
bool addCar(int carType) Checks whether there is
a parking space of carType for the car that wants to
get into the parking lot. carType can be of three kinds:
big, medium, or small, which are represented by 1, 2, and 3
respectively. A car can only park in a parking space of its carType.
If there is no space available, return false, else park the car in
that size space and return true.

* */
public class DesignParkingLot {

    int[] count;

    public DesignParkingLot(int big, int medium, int small) {
        count = new int[] { big, medium, small };
    }

    public boolean addCar(int carType) {
        if (count[carType - 1] == 0)
            return false;
        count[carType - 1]--;
        return true;
    }
}

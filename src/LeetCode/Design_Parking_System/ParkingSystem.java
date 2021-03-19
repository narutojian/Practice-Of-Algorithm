package LeetCode.Design_Parking_System;

/**
 * 1603. Design Parking System
 */
public class ParkingSystem {
    private int[] carTypeNum;

    public ParkingSystem(int big, int medium, int small) {
        carTypeNum = new int[3];
        carTypeNum[0] = big;
        carTypeNum[1] = medium;
        carTypeNum[2] = small;
    }

    public boolean addCar(int carType) {
        if (carTypeNum[carType-1] > 0) {
            carTypeNum[carType-1]--;
            return true;
        }
        return false;
    }
}

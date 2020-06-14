package Algorithm;

import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
    public int[] arr = new int[100000];
    public int n;
    int temp,tempIndex;

    public void selectionSort() {

        for (int i = 0; i < n - 1; i++) {
            temp = arr[i];
            for (int j = i+1; j < n; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    tempIndex = j;
                }
            }
            arr[tempIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Random random = new Random();
        SelectionSort sort = new SelectionSort();
        sort.n = cin.nextInt();

        for (int i = 0; i < sort.n; i++) {
            sort.arr[i] = random.nextInt(sort.n);
        }

        sort.selectionSort();

        for (int i = 0; i < 100; i++) {
//            System.out.println(sort.arr[i]);
            System.out.println(sort.arr[49900+i]);
        }
    }
}

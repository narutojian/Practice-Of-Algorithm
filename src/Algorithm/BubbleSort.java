package Algorithm;

import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    public int[] arr = new int[100000];
    public int n,temp;

    public void bubbleSort() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j+1])
                {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }    
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Random random = new Random();
        BubbleSort sort = new BubbleSort();
        sort.n = cin.nextInt();

        for (int i = 0; i < sort.n; i++) {
            sort.arr[i] = random.nextInt(sort.n);
        }

        sort.bubbleSort();

        for (int i = 0; i < 100; i++) {
//            System.out.println(sort.arr[i]);
            System.out.println(sort.arr[49900+i]);
        }
    }
}

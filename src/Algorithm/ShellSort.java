package Algorithm;

import java.util.Random;
import java.util.Scanner;

public class ShellSort {
    public int[] arr = new int[100000];
    public int n;

    public void shellSort() {
        int incre = n/2;
        int i,j,k,key;
        while (incre > 0) {
            i = 0;
            while (i < incre) {
                for (k = i+incre; k < n; k += incre) {
                    key = arr[k];
                    j = k - incre;
                    while (j >= 0 && key < arr[j]) {
                        arr[j+incre] = arr[j];
                        j -= incre;
                    }
                    arr[j+incre] = key;
                }
                i++;
            }
            incre /= 2;
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Random random = new Random();
        ShellSort sort = new ShellSort();
        sort.n = cin.nextInt();

        for (int i = 0; i < sort.n; i++) {
            sort.arr[i] = random.nextInt(sort.n);
        }

        sort.shellSort();

        for (int i = 0; i < 100; i++) {
            System.out.println(sort.arr[i]);
//            System.out.println(sort.arr[49900+i]);
        }
    }
}

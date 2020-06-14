package Algorithm;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public int[] arr = new int[100000];
    public int n;

    public void quickSort(int low, int high){

        if (low >= high) return;

        int basicPoint = arr[low];
        int i = low,j = high;

        while (i<j){
            while(i < j && arr[j] >= basicPoint) j--;
            if (i < j) arr[i++] = arr[j];
            while(i < j && arr[i] <= basicPoint) i++;
            if (i < j) arr[j--] = arr[i];
        }
        arr[i] = basicPoint;

        quickSort(low,i-1);
        quickSort(i+1,high);
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Random random = new Random();
        QuickSort sort = new QuickSort();
        sort.n = cin.nextInt();

        for (int i = 0; i < sort.n; i++) {
            sort.arr[i] = random.nextInt(sort.n);
        }

        sort.quickSort(0,sort.n-1);
    }
}

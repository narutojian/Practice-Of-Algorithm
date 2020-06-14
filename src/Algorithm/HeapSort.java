package Algorithm;

import java.util.Random;
import java.util.Scanner;

public class HeapSort {
    public int n;
    int temp,son,right;
    public int[] arr = new int[1000000];

    public void heapSort(){
        int i;
        for (i = n/2 -1;i >= 0;i--)
            adjustHeapNode(i,n);
        for (i = n-1;i >= 0;i--){
            swap(0,i);
            adjustHeapNode(0,i);
        }
    }

    public void adjustHeapNode(int i, int length){

        temp = arr[i];

        for(son = 2*i+1;son <length; son = son*2+1){

            if (son+1 <length && arr[son] < arr[son+1])
                son++;
            if (arr[son] > temp){
                arr[i] = arr[son];
                i = son;
            }
            else break;
        }
        arr[i] = temp;
    }

    public void swap(int i, int j){
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){

        Scanner cin = new Scanner(System.in);
        Random random = new Random();
        HeapSort h = new HeapSort();

//        while ((h.n = cin.nextInt()) != 0){
//
//            for (int i = 0;i<h.n;i++)
//                h.a[i] = cin.nextInt();
//            h.heapSort();
//
//            for(int i = 0;i<h.n-1;i++)
//                System.out.print(h.a[i]+" ");
//            System.out.println(h.a[h.n-1]);
//        }
//        cin.close();
        while ((h.n = cin.nextInt()) != 0) {
            for (int i = 0; i < h.n; i++) {
                h.arr[i] = random.nextInt(h.n);
            }
            h.heapSort();
            for (int i = 0; i < 100; i++) {
                System.out.println(h.arr[i]);
            }
//            for (int i = 0; i < 100; i++) {
//                System.out.println(h.a[49900+i]);
//            }
        }
    }
}

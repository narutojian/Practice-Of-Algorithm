package Algorithm;

import java.util.Random;

public class HeapSort_2 {
    int[] arr = new int[100000];
    int length;

    void heapSort() {
        int index = length - 1;
        int node = length/2 -1;
        while (node >= 0)
        {
            if (2*node+1 == length-1)
            {
                if (arr[node] < arr[2*node+1])
                    swap(node,2*node+1);
            }
            else
            {
                if (arr[2*node+1] > arr[2*node+2] && arr[node] < arr[2*node+1])
                {
                    swap(node,2*node+1);
                    adjustNode(length,2*node+1);
                }
                else if (arr[2*node+1] <= arr[2*node+2] && arr[node] < arr[2*node+2])
                {
                    swap(node,2*node+2);
                    adjustNode(length,2*node+2);
                }
            }
            node--;
        }

        while (index != 0)
        {
            swap(index,0);
            adjustNode(index,0);
            index--;
        }
    }

    void swap(int i,int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    void adjustNode(int length,int node) {
        if (2*node+1 >= length)
            return;
        if (2*node+1 == length - 1)
        {
            if (arr[node] < arr[2*node+1])
                swap(node,2*node+1);
            return;
        }
        boolean flag = false;
        int position = 0;
        if (arr[2*node+1] > arr[2*node+2] && arr[node] < arr[2*node+1])
        {
            swap(node,2*node+1);
            flag = true;
            position = 2*node+1;
//            adjustNode(length,2*node+1);
        }
        else if (arr[2*node+1] <= arr[2*node+2] && arr[node] < arr[2*node+2])
        {
            swap(node,2*node+2);
            flag = true;
            position = 2*node+2;
//            adjustNode(length,2*node+2);
        }
        if (flag)
            adjustNode(length,position);
    }

    public static void main(String[] args) {
        HeapSort_2 h = new HeapSort_2();
        h.length = 50000;
        Random random = new Random();

        for (int i = 0; i < h.length; i++) {
            h.arr[i] = random.nextInt(h.length);
        }

        h.heapSort();
        for (int i = 0; i < 100; i++) {
            System.out.println(h.arr[i]);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(h.arr[49900+i]);
        }
    }
}

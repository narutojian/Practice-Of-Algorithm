package Algorithm;

public class InsertSort {
    int[] arr = new int[100000];
    int n;

    public void insertSort() {
        int i,j,key;
        for (i = 1; i < n; i++) {
            key = arr[i];
            j = i-1;
            while (j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}

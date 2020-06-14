package Algorithm;

public class MergeSort {

    public int[] mergeSort(int[] arr) {
        int[] ans = new int[arr.length];
        sort(arr,0,arr.length-1,ans);
        return arr;
    }

    public void sort(int[] arr,int left,int right,int[] temp) {
        if (left >= right) return;
        int mid = (left+right)/2;
        sort(arr,left,mid,temp);
        sort(arr,mid+1,right,temp);
        merge(arr,left,mid,right,temp);
    }

    public void merge(int[] arr,int left,int mid,int right,int[] temp) {
        int first = left,second = mid+1;
        int index = 0;
        while (first <= mid && second <= right) {
            if (arr[first] < arr[second]) temp[index++] = arr[first++];
            else temp[index++] = arr[second++];
        }
        while (first <= mid) {
            temp[index++] = arr[first++];
        }
        while (second <= right) {
            temp[index++] = arr[second++];
        }
        index = 0;
        while (left <= right) {
            arr[left++] = temp[index++];
        }
    }

    public static void main(String[] args) {
        MergeSort h = new MergeSort();

        int[] arr = {9,8,7,6,5,4,3,2,1};
        int[] ans = h.mergeSort(arr);

        for (int i :
                ans) {
            System.out.print(i+"    ");
        }
        System.out.println();
    }
}

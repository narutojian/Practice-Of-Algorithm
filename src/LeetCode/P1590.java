package LeetCode;

/**
 * 面试题51. 数组中的逆序对
 */
public class P1590 {
    private int ans = 0;
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums,0,nums.length-1,temp);
        return ans;
    }
    public void sort(int[] arr,int left,int right,int[] temp) {
        if (left >= right) return;
        int mid = (left+right)/2;
        sort(arr,left,mid,temp);
        sort(arr,mid+1,right,temp);
        merge(arr,left,mid,right,temp);
    }

    private void merge(int[] arr,int left,int mid,int right,int[] temp) {
        int first = left,second = mid+1;
        int index = 0;

        while (first <= mid && second <= right) {
            if (arr[first] <= arr[second]) {
                ans += second-mid-1;
                temp[index++] = arr[first++];
            }
            else temp[index++] = arr[second++];
        }
        while (first <= mid) {
            ans += right-mid;
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
        P1590 h = new P1590();

        int[] nums = {7,5,6,4};
//        int[] nums = {3,4,11,7,1,5,6,4};
        System.out.println(h.reversePairs(nums));
    }
}

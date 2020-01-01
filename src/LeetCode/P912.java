package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 升序排列数组
 * 我用的是快排（温故了一下）
 */
public class P912 {

    public List<Integer> sortArray(int[] nums){
        quickSort(nums,0,nums.length-1);
        List<Integer> ans = new ArrayList<>();
        for (int i :
                nums) {
            ans.add(i);
        }
        return ans;
    }

    public void quickSort(int[] nums,int low,int high){
        if (low >= high) return;
        int startPoint = nums[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i < j && nums[j] >= startPoint) j--;
            if (i < j) nums[i++] = nums[j];
            while (i < j && nums[i] <= startPoint) i++;
            if (i < j) nums[j--] = nums[i];
        }
        nums[i] = startPoint;
        quickSort(nums,low,i-1);
        quickSort(nums,i+1,high);
    }

    public static void main(String[] args) {

        int[] nums = {5,2,3,1};
        P912 h = new P912();
        h.sortArray(nums);
        for (int i :
                nums) {
            System.out.print(i+"    ");
        }
        System.out.println();
    }
}

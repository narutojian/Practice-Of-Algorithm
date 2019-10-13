package LeetCode;

public class P912 {

    public int[] sortArray(int[] nums){

        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums,int low,int high){

        if (low < high) {
            int index = getIndex(nums,low,high);
            quickSort(nums,0,index-1);
            quickSort(nums,index+1,high);
        }
    }

    public int getIndex(int[] nums,int low,int high){

        int temp = nums[low];

        while (low < high){

            while (low < high && nums[high] >= temp)
                high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= temp)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }

    public static void main(String[] args) {

        int[] nums = {5,2,3,1};
        System.out.println(new P912().sortArray(nums));
    }
}

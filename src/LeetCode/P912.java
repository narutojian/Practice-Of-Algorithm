package LeetCode;

/**
 * 升序排列数组
 * 我用的是快排（温故了一下）
 */
public class P912 {
    /**
     * 快排
     * @param nums 给定的数组
     * @return 升序排列的数组
     */
    public int[] sortArray(int[] nums){
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    /**
     * 快排 分治思想
     * 双指针和递归
     * @param nums 给定的数组
     * @param low 第一个指针
     * @param high 第二个指针
     */
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

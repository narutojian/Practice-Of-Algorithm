package LeetCode;

public class P31 {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        if (nums.length == 2) {
            swap(nums,0,1);
            return;
        }

        int i = nums.length-2;
        int max = nums[i+1],min= Integer.MAX_VALUE,minOfIndex = 0;
        for (;i>=0;i--) {
            if (nums[i] > max) max = nums[i];
            else if (nums[i] == max) continue;
            else break;
        }

        if (i == -1) {
            reverseArray(nums,0,nums.length-1);
            return;
        }
        for (int j = i+1; j < nums.length; j++) {
            if (nums[j] > nums[i] && nums[j] <= min) {
                min = nums[j];
                minOfIndex = j;
            }
        }
        swap(nums,i,minOfIndex);
        if (i == nums.length-2) return;
        reverseArray(nums,i+1,nums.length-1);
    }

    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverseArray(int[] nums,int start,int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        P31 h = new P31();
//        int[] nums = new int[] {3,2,1};
//        int[] nums = new int[] {1,1,5};
//        int[] nums = new int[] {1,5,1};
//        int[] nums = new int[] {1,3,2,4};
//        int[] nums = new int[] {1,3,2};
        int[] nums = new int[] {2,3,1,3,3};
//        int[] nums = new int[] {1,3,2,3,4,3};
        h.nextPermutation(nums);

        for (int i :
                nums) {
            System.out.print(i+"    ");
        }
        System.out.println();
    }
}

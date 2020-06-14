package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FullPermutation {
    String[] nums;
    boolean[] visit;
    int n;
    List<String> ans = new ArrayList<>();

    public FullPermutation(int n) {
        this.n = n;
        nums = new String[n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = ""+(i+1);
        }
    }

    /*
    回溯全排列，用visit数组判断节点是否访问过,此排列只针对无重复的序列；
     */
    public void fullPermutation_BackTrack(String s,int length) {

        if (length == n) {
            ans.add(s);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;

            s += nums[i];
            visit[i] = true;
            fullPermutation_BackTrack(s,length+1);

            //回溯
            s = s.substring(0,s.length()-1);
            visit[i] = false;
        }
    }

    public void fullPermutation_BackTrack_Modified(int start) {
        if (start == nums.length -1) {
            String temp = "";
            for (int i = 0; i < nums.length; i++) {
                temp += nums[i];
            }
            ans.add(temp);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i == start) {
                fullPermutation_BackTrack_Modified(start+1);
            }
            else {
                if (nums[i].equals(nums[start])) continue;
                while ((i+1) < nums.length && nums[i+1].equals(nums[i])) i++;
                swap(i,start);
                fullPermutation_BackTrack_Modified(start+1);
                swap(i,start);
            }
//            if (i == start || !nums[i].equals(nums[start])) {
//                swap(i,start);
//                fullPermutation_BackTrack_Modified(start+1);
//                swap(i,start);
//            }
        }
    }

    public void swap(int i,int j) {
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        FullPermutation fullPermutation = new FullPermutation(4);
//        fullPermutation.nums = new String[]{"1", "2", "2"};
//        fullPermutation.nums = new String[] {"1","2","3","3"};
//        fullPermutation.nums = new String[] {"1","1","3","3"};
//        fullPermutation.nums = new String[] {"1","3","1","3"};
        fullPermutation.nums = new String[] {"-1","-1","1","2","2"};
//        fullPermutation.nums = new String[] {"1","1","2"};
//        fullPermutation.fullPermutation_BackTrack("",0);
        fullPermutation.fullPermutation_BackTrack_Modified(0);
        HashMap<List<Integer>,Integer> map = new HashMap<>();

         for (String i :
                fullPermutation.ans) {
            System.out.println(i);
        }
        System.out.println(fullPermutation.ans.size());
    }
}

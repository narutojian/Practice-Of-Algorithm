package LeetCode.Leetcode2020春季个人赛;

import java.util.Arrays;

public class P3 {

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int n = requirements.length;
        int[] storeIndex = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            storeIndex[i] = i;
            ans[i] = -1;
        }
        quickSort(n,requirements,storeIndex,0,n-1);
        int[] val = new int[3];
        int index = 0;
        for (int i = 0; i < increase.length; i++) {
            val[0] += increase[i][0];
            val[1] += increase[i][1];
            val[2] += increase[i][2];
            if (val[0] >= requirements[index][0] && val[1] >= requirements[index][1] && val[2] >= requirements[index][2]) {
                ans[storeIndex[index]] = i+1;
                index++;
            }
        }
        return ans;
    }

    private void quickSort(int n,int[][] requirements, int[] storeIndex,int left, int right) {
        if (left >= right) return;
        int[] start = Arrays.copyOf(requirements[left],requirements[left].length);
        int index = storeIndex[left];
        int low = left,high = right;
        while (low < high) {

            while (low < high && isTrue(start,requirements[high])) high--;
            if (low < high) {
                requirements[low] = Arrays.copyOf(requirements[high],3);
                storeIndex[low] = storeIndex[high];
                low++;
            }

            while (low < high && isTrue(requirements[low],start)) low++;
            if (low < high) {
                requirements[high] = Arrays.copyOf(requirements[low],3);
                storeIndex[high] = storeIndex[low];
                high--;
            }
        }

        requirements[low] = Arrays.copyOf(start,3);
        storeIndex[low] = index;
        quickSort(n,requirements,storeIndex,left,low-1);
        quickSort(n,requirements,storeIndex,low+1,right);
    }

    private boolean isTrue(int[] a,int[] b) {
        if (a[0] < b[0] || (a[0] == b[0] && a[1] < b[1]) ||
                (a[0] == b[0] && a[1] == b[1] && a[2] < b[2]))
            return true;
        return false;
    }

    public static void main(String[] args) {
        P3 h = new P3();
        int[][] increase = {{2,8,4},{2,5,0},{10,9,8}};
        int[][] requirements = {{2,11,3},{15,10,7},{9,17,12},{8,1,14}};

        int[] ans = h.getTriggerTime(increase,requirements);

        for (int i :
                ans) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }
}

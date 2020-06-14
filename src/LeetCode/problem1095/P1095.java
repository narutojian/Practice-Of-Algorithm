package LeetCode.problem1095;

import java.util.HashMap;
import java.util.Map;

public class P1095 {
    private Map<Integer,Integer> map = new HashMap<>();

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int root = getRoot(mountainArr,0,n-1);
        int rootV = findStoreMap(mountainArr,root);

        if (target > rootV) return -1;
        if (target == rootV) return root;
        int left = 0,right = root-1,mid,cur;

        while (left <= right) {
            mid = (left+right)/2;
            cur = findStoreMap(mountainArr,mid);
            if (cur == target) return mid;
            if (cur < target) left = mid+1;
            else right = mid-1;
        }
        left = root+1;
        right = n-1;

        while (left <= right) {
            mid = (left+right)/2;
            cur = findStoreMap(mountainArr,mid);
            if (cur == target) return mid;
            if (cur < target) right = mid-1;
            else left = mid+1;
        }

        return -1;
    }

    private int getRoot(MountainArray mountainArray,int left,int right) {
        int mid,prev,next,cur;
        while (left < right) {
            mid = left+(right-left)/2;// 数据量大的时候，left+right可能会溢出
//            mid = (left+right)/2;
            if (mid == 0) return 1;
            cur = findStoreMap(mountainArray,mid);
            prev = findStoreMap(mountainArray,mid-1);
            next = findStoreMap(mountainArray,mid+1);
            if (cur > prev && cur > next) return mid;
            if (cur > prev) left = mid+1;
            if (cur > next) right = mid-1;
        }

        return left;
    }

    private int findStoreMap(MountainArray mountainArray,int index) {
        int value;
        if (map.containsKey(index)) return map.get(index);
        else {
            value = mountainArray.get(index);
            map.put(index,value);
            return value;
        }
    }

    public static void main(String[] args) {
        P1095 h = new P1095();

//        int[] array = {1,2,3,4,5,3,1};
//        int target = 3;

        int[] array = {3,5,3,2,0};
        int target = 0;

        MountainArray mountainArray = new MountainArrayImpl(array);
        System.out.println(h.findInMountainArray(target,mountainArray));
    }
}

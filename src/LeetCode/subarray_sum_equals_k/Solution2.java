package LeetCode.subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    /**
     * ǰ׺��+��ϣ�Ż�
     * @param nums ����
     * @param k Ŀ��ֵ
     * @return �����������Ϊk�ĸ���
     */
    public int subarraySum(int[] nums, int k) {
        int pre = 0,ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
//            ������map.put(pre,map.getOrDefault(pre,0)+1); ����������Ӳ���
//            ��pre����map�У��ж��Ƿ��Ѿ�����pre
//            if (map.containsKey(pre)) {
//                map.put(pre,map.get(pre)+1);
//            }
//            else {
//                map.put(pre,1);
//            }
//            ʹ��map.put(0,1) �Ϳ��������������ж�
//            ���pre[i]��i��β������֮�͵�ֵΪk����ans++
//            if (pre == k) {
//                ans++;
//            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution2 h = new Solution2();

        int[] nums = {1,1,1};
        int k = 2;

        System.out.println(h.subarraySum(nums,k));
    }
}
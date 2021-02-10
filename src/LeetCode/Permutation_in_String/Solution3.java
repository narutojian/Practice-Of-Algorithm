package LeetCode.Permutation_in_String;

public class Solution3 {

    /**
     * 这个是优化版本 但代码写的不怎么好理解
     * 不需要每次都比较完整的mapS1和mapS2 只要考虑不同的个数
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n2 < n1) return false;
        int[] mapS1 = new int[26];// 记录s1的字符
        int[] mapS2 = new int[26];// 记录s2的字符
        for (int i = 0; i < n1; i++) {
            mapS1[s1.charAt(i)-'a']++;
        }
        int diff = n1;
        int index;
        for (int i = 0; i <n1 ; i++) {
            index = s2.charAt(i)-'a';
            mapS2[index]++;
            if (mapS1[index] >= mapS2[index]) {
                diff--;
            }
            else diff++;
        }
        if (diff == 0) return true;
        for (int i = n1; i < n2; i++) {
            index = s2.charAt(i)-'a';
            mapS2[index]++;
            if (mapS1[index] >= mapS2[index]) {
                diff--;
            }
            else diff++;
            index = s2.charAt(i-n1)-'a';
            mapS2[index]--;
            if (mapS1[index] <= mapS2[index]) {
                diff--;
            }
            else diff++;
            if (diff == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(solution3.checkInclusion(s1,s2));
    }
}

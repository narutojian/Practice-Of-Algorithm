package LeetCode.problem1143;

/**
 *  递归进行求解
 */
public class P1143_Solution1 {

    String s1;
    String s2;

    public int LCS(int x, int y) {
        if (x < 0 || y < 0)
            return 0;
        if (x == 0 || y == 0) {
            if (s1.charAt(x) == s2.charAt(y))
                return 1;
            else return 0;
        }
        if (s1.charAt(x) == s2.charAt(y)) {
            return LCS(x-1,y-1)+1;
        }
        return Math.max(LCS(x-1,y),LCS(x,y-1));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        s1 = text1;
        s2 = text2;

        return LCS(s1.length()-1,s2.length()-1);
    }

    public static void main(String[] args) {
        //        String text1 = "abcde";
//        String text2 = "ace";
//        String text1 = "abc";
//        String text2 = "abc";
//        String text1 = "abc";
//        String text2 = "def";
        String text1 = "yzebsbuxmtcfmtodclszgh";
        String text2 = "ejevmhcvshclydqrulwbyha";
//        String text1 = "mhunuzqrkzsnidwbun";
//        String text2 = "szulspmhwpazoxijwbq";

        System.out.println(new P1143_Solution1().longestCommonSubsequence(text1,text2));
    }
}

package LeetCode;

public class P1394 {

    /**
     * 枚举+记录
     * @param S
     * @return
     */
    public String compressString(String S) {
        if (S.length() <=2) return S;
        StringBuilder ans = new StringBuilder();
        char curChar = S.charAt(0);
        int num = 1;
        for (int i = 1; i < S.length(); i++) {
            if (curChar == S.charAt(i))
                num++;
            else {
                ans.append(curChar);
                ans.append(num);
                curChar = S.charAt(i);
                num = 1;
            }
        }
        ans.append(curChar);
        ans.append(num);
        return ans.length() < S.length() ? ans.toString() : S;
    }
}

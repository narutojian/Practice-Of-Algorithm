package LeetCode;

public class P10 {

    public boolean isMatch(String s, String p) {

        if (s.matches(p))
            return true;
        return false;
    }

    public static void main(String[] args) {

//        String s = "aa";
//        String p = "a";

//        String s = "aab";
//        String p = "c*a*b";

//        String s = "aa";
//        String p = "a*";

//        String s = "ab";
//        String p = ".*";

        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(new P10().isMatch(s,p));
    }
}

package LeetCode;

public class P91 {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int[] map = new int[27];
        int i,j;
        for (i = 1; i <= 9; i++) {
            map[i] = 1;
            map[i+10] = 2;
        }
        for (i = 21; i < 27; i++) map[i] = 2;
        map[10] = 1;
        map[20] = 1;
//        StringBuilder temp = new StringBuilder(s.replaceAll("[1-2]0","9"));
        StringBuilder temp = new StringBuilder(s);
        for (i = 0;i< temp.length()-1;i++) {
            if (temp.substring(i,i+2).equals("10") || temp.substring(i,i+2).equals("20")) {
                temp.replace(i,i+2,"9");
                if (i-1 >= 0 && temp.charAt(i-1) == '1') temp.replace(i-1,i,"2");
            }
        }
        if (temp.indexOf("0") >= 0) return 0;
        if (temp.length() <= 2) {
            j = Integer.parseInt(temp.toString());
            if (j < 27) return map[j];
            return 1;
        }

        int cur = 0,pre,prePre;
        j = Integer.parseInt(temp.substring(temp.length()-2));
        if (j < 27) pre = map[j];
        else pre = 1;
        prePre = 1;

        for (i = temp.length()-3;i >= 0;i--) {
            cur = 0;
            j = Integer.parseInt(temp.substring(i,i+2));
            if (j < 27)
                cur += prePre;
            cur += pre;
            prePre = pre;
            pre = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        P91 h = new P91();
//        String s = "101";
        String s = "1104";
        System.out.println(h.numDecodings(s));
    }
}

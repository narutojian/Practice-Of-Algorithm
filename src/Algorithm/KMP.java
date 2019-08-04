package Algorithm;

/**
 * KMP 用来解决字符串匹配问题的算法，由三位科学家的名字命名
 *
 * 求解过程：
 * 1. 求出next数组
 * 2. 用next数组进行匹配
 */
public class KMP {

    int[] next;

    /**
     * 求next数组
     * @param t 模式串
     */
    public void setNext(String t) {

        next = new int[t.length()];
        next[0] = -1;
        int k = -1, j = 0;
        // j 必须要小于 t.length() -1, 因为这个next数组是在j++后再赋值的。
        while (j < t.length()-1){

            // 如果 t[k] == t[j], 那么next[j+1] = next[k]+1;
            // 或者 k == -1, 表示递归前缀到next[0], 说明这个next[j+1] = 0;
            if (k == -1 || t.charAt(j) == t.charAt(k)){
                k++;j++;
                next[j] = k;
            }
            //如果 t[k] != t[j]；
            else k = next[k];
        }
    }

    /**
     * KMP算法
     * @param origin
     * @param match
     * @return 模式串第一个匹配到的字串的第一个字符的位置
     */
    public int KMPSearch(String origin, String match){

        this.setNext(match);

        int i = 0, j = 0;
        while (i < origin.length()) {

            if (origin.charAt(i) != match.charAt(j)){

                if (j != 0)
                    j = next[j];
                else i++;
            }
            else {
                i++;
                j++;
            }

            if (j == match.length())
                return i-j;
        }
        return i-j;
    }

    public static void main(String[] args) {

        KMP kmp = new KMP();
//        kmp.setNext("ABCDABD");
//        kmp.setNext("ABCDABCE");

        String origin = "BBC ABCDAB ABCDABCDABDE";
        String match = "ABCDABD";
        System.out.println(kmp.KMPSearch(origin,match));
//        for (int i :
//                kmp.next) {
//            System.out.print(i+" ");
//        }
    }
}

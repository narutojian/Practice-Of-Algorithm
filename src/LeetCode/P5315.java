package LeetCode;

public class P5315 {
    public int maximum69Number (int num) {
        StringBuilder s = new StringBuilder(""+num);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '6') {
                s.replace(i,i+1,"9");
                break;
            }
        }

        return Integer.parseInt(s.toString());
    }

    public static void main(String[] args) {
        P5315 h = new P5315();
//        int num = 9669;
//        int num = 9996;
        int num = 9999;
        System.out.println(h.maximum69Number(num));
    }
}

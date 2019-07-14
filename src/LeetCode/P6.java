package LeetCode;

public class P6 {

    /**
     * 找规律
     * z字形的周期为cycle = (numRows-1)*2
     * 在每个周期上，第一行只有一个字符，最后一行至多只有一个字符(也可能没有)，其余的行中可能会有0、1、2个字符。
     * 所以只要遍历numRows*s.length()/cycle次即可得出字符串。
     * 特殊情况：
     * numRows为1时，直接输出。
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {

        if (numRows == 1)
            return s;

        StringBuilder stringBuilder = new StringBuilder();

        int cycle = (numRows -1)*2;
        int length = s.length();
        int temp1,temp2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < length; j += cycle) {

                if (i == 0)
                    stringBuilder.append(s.charAt(j));
                else if (i == numRows -1) {
                    if ((j+i) < length)
                        stringBuilder.append(s.charAt(j+i));
                }
                else {
                    temp1 = j+i;
                    temp2 = j+cycle-i;

                    if (temp1 < length)
                        stringBuilder.append(s.charAt(temp1));
                    if (temp2 < length)
                        stringBuilder.append(s.charAt(temp2));
                }
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

//        String s = "PAYPALISHIRING";
//        int numRows = 3;
        String s = "A";
        int numRows = 1;
        System.out.println(new P6().convert(s,numRows));
    }
}

package LeetCode;

public class P1071 {
    /**
     * 
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        String commonStr,temp;
        boolean shortStr = false;
        if (str1.length() < str2.length()) {
            if (isGcd(str1,str2))
                return str1;
            commonStr = str1.substring(0,str1.length()/2);
            shortStr = true;
        }
        else {
            if (isGcd(str2,str1))
                return str2;
            commonStr = str2.substring(0,str2.length()/2);
        }

        for (int i = commonStr.length(); i > 0; i--) {
            temp = commonStr.substring(0,i);
            if (shortStr) {
                if (isGcd(temp,str1) && isGcd(temp,str2))
                    return temp;
            }
            else {
                if (isGcd(temp,str2) && isGcd(temp,str1))
                    return temp;
            }
        }
        return "";
    }

    private boolean isGcd(String divisor,String target) {
        if (target.length()%divisor.length() != 0)
            return false;
        for (int i = 0; i <= target.length() - divisor.length(); i += divisor.length()) {
            if (!divisor.equals(target.substring(i,i+divisor.length())))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        P1071 h = new P1071();
//        String str1 = "ABABABAB";
//        String str2 = "ABABAB";
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println(h.gcdOfStrings(str1,str2));
    }
}

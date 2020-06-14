package LeetCode;

public class P409 {

    public int longestPalindrome(String s) {
        int[] capitalCase = new int[26];
        int[] lowerCase = new int[26];
        int ans = 0;
        boolean flag = false;
        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (temp > 'Z')
                lowerCase[temp - 'a']++;
            else capitalCase[temp - 'A']++;
        }
        for (int i = 0; i < capitalCase.length; i++) {
            if (!flag && capitalCase[i]%2 != 0)
                flag = true;
            ans += capitalCase[i]/2;
        }
        for (int i = 0; i < lowerCase.length; i++) {
            if (!flag && lowerCase[i]%2 != 0)
                flag = true;
            ans += lowerCase[i]/2;
        }
        ans *= 2;
        if (flag) ans++;
        return ans;
    }

    public int longestPalindrome_Solution2(String s) {
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }

        int ans = 0;
        for (int x: cnt) {
            // 字符出现的次数最多用偶数次。
            ans += x - (x & 1);
        }
        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return ans < s.length() ? ans + 1 : ans;
    }
}

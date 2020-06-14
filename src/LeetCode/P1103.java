package LeetCode;

public class P1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int publicValue = num_people*(num_people+1)/2;
        int diff = num_people*num_people;
        int round = 0,temp;

        //确定有几轮
        for (;candies >= 0;round++) {
            temp = publicValue+round*diff;
            if (temp > candies) break;
            else candies -= temp;
        }

        publicValue = round * (round - 1) / 2 * num_people;
        // 写入值
        for (int i = 0; i < num_people; i++) {
            ans[i] += round * (i+1) + publicValue;
        }

        //加上剩余的值
        if (candies > 0) {
            for (int i = 0; i < num_people && candies > 0; i++) {
                temp = round*num_people+(i+1);
                if (temp > candies) {
                    ans[i] += candies;
                    candies = 0;
                }
                else {
                    ans[i] += temp;
                    candies -= temp;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        P1103 h = new P1103();
        int candies = 7;
        int num_people = 4;
//        int candies = 10;
//        int num_people = 3;
        int[] ans = h.distributeCandies(candies,num_people);
        for (int i :
                ans) {
            System.out.println(i);
        }
    }
}

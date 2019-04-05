package HDU;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 使用jdk自带的HashMap类。
 */
public class P1004 {

    public static void main(String[] args){

        Scanner cin = new Scanner(System.in);
        HashMap<String,Integer> map = new HashMap<>();
        int n,i,maxValue;
        String s = null;

        while ((n = cin.nextInt()) != 0){

            cin.nextLine();
            for (i = 0;i<n;i++){

                s = cin.nextLine();
                if (map.containsKey(s))
                    map.replace(s,map.get(s)+1);
                else map.put(s,1);
            }

            maxValue = 0;
            for (String a :
                    map.keySet()) {
                i = map.get(a);
                if (i > maxValue){
                    maxValue = i;
                    s = a;
                }
            }

            System.out.println(s);
            map.clear();
        }

        cin.close();
    }
}

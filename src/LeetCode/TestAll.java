package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TestAll {

    @Test
    public void testP3(){

        String s = "abc";
        String regx = ".*a.*";

        if (s.matches(regx))
            System.out.println("correct");
        else System.out.println("error");
    }

    @Test
    public void testP4(){

//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        PriorityQueue<Integer> queue1 = new PriorityQueue<>(
//                (o1, o2) -> o2-o1
//        );
//
//        for (int i = 6; i >= 0; i--) {
//            queue.add(i);
//            queue1.add(i);
//        }
//        System.out.println(queue.poll()+"   "+queue1.poll());

        P4 p4 = new P4();
        int[] nums1 = {1,3};
        int[] nums2 = {2};

//        System.out.println(p4.findM(nums1,nums2));
    }

    @Test
    public void testP7(){

        int a = -768;
        int b = a%10;
        System.out.println(b);
    }

    @Test
    public void testP310(){

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i += 2) {
            list.add(i);
        }

        list.remove((Integer)4);

        for (int i :
                list) {
            System.out.println(i);
        }

        System.out.println(list.size() <= 5);
    }

    @Test
    public void testP8() {
//        String s = "123";
//        int a = Integer.parseInt(s);
//        System.out.println(a);
//
//        String regx = "[0-9]";
//
//        if ("3".matches(regx))
//            System.out.println("3 is in the regx.");
//        String space = "  ";
//        space = space.trim();
//        System.out.println(space.length());
//
//        String mutiRegx = "[0-9+-]";
//
//        if ("-".matches(mutiRegx))
//            System.out.println("it is ok!");
//        if ("1".matches(mutiRegx))
//            System.out.println("number is ok!");
//        if ("+".matches(mutiRegx))
//            System.out.println("+ is ok!");
//        int i = 0;
//        for (; i < 3; i++) {
//
//            if (true)
//                break;
//        }
//        System.out.println(i);
//        String number = "-123";
//        int a = Integer.parseInt(number);
//        number = ""+a;
//        System.out.println(number.length());

        char a = '0';
        char b = '9';
        System.out.println(b - a);
    }
}

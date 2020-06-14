package LeetCode;

import Algorithm.*;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public void testIntegerParseInt() {
        // 只能解析在Integer的范围内的值 超出会有NumberFormatException
//        String str = "+0000012345678";
//        String str = " +42";
//        System.out.println(Integer.parseInt(str));
    }

    @Test
    public void testSort() {
        Random random = new Random();
        int n = 50000;
        int[] arr = new int[100000];
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        QuickSort quickSort = new QuickSort();
        ShellSort shellSort = new ShellSort();
        HeapSort heapSort = new HeapSort();

        bubbleSort.n = n;
        selectionSort.n = n;
        quickSort.n = n;
        shellSort.n = n;
        heapSort.n = n;

        long bubbleSortTime = 0,selectionSortTime = 0,quickSortTime = 0,shellSortTime = 0,heapSortTime = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }
        long a,b;
        for (int i = 0; i < 100; i++) {
            bubbleSort.arr = arr.clone();
            selectionSort.arr = arr.clone();
            quickSort.arr = arr.clone();
            shellSort.arr = arr.clone();
            heapSort.arr = arr.clone();

            a = System.nanoTime();
            bubbleSort.bubbleSort();
            b = System.nanoTime();
            bubbleSortTime += b - a;

            a = System.nanoTime();
            selectionSort.selectionSort();
            b = System.nanoTime();
            selectionSortTime += b - a;

            a = System.nanoTime();
            quickSort.quickSort(0,n-1);
            b = System.nanoTime();
            quickSortTime += b - a;

            a = System.nanoTime();
            shellSort.shellSort();
            b = System.nanoTime();
            shellSortTime += b - a;

            a = System.nanoTime();
            heapSort.heapSort();
            b = System.nanoTime();
            heapSortTime += b - a;
        }

        System.out.println("bubbleSort: "+bubbleSortTime/(100.0) /1000);
        System.out.println("selectionSort: "+selectionSortTime/(100.0) /1000);
        System.out.println("quickSort: "+quickSortTime/(100.0) /1000);
        System.out.println("shellSort: "+shellSortTime/(100.0) /1000);
        System.out.println("heapSort: "+heapSortTime/(100.0) /1000);
    }

    @Test
    public void testMapCopy() {
        Map<Integer,Boolean> map = new HashMap<>();
        map.put(1,true);
        Map<Integer,Boolean> map1 = new HashMap<>();
        Map<Integer,Boolean> map2 = map;
        map1.putAll(map);
        map1.put(2,false);
        map2.put(3,true);
        System.out.println(map);
        System.out.println(map1);
        System.out.println(map2);
    }

    @Test
    public void testSetContainsList() {
        Set<List<Integer>> set = new HashSet<>();
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        list2.add(2);
//        list2.add(1);
//
//        set.add(list1);
//        System.out.println(set.contains(list2));
//        System.out.println(set);
//
//        set.add(list2);
//        System.out.println(set);
        set.add(Arrays.asList(1,2));
        set.add(Arrays.asList(2,1));
        set.add(Arrays.asList(1,2));
        System.out.println(set);
    }

    @Test
    public void testDeque() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(3);
        deque.add(2);
        while (!deque.isEmpty()) {
            System.out.println(deque.remove());
        }
    }

    @Test
    public void testListToArray() {
        ArrayList<Integer[]> temp = new ArrayList<>();
        temp.add(new Integer[] {1,2,3});
        temp.add(new Integer[] {3,4});
        temp.add(new Integer[] {7,8});
        Integer[][] ans = temp.toArray(new Integer[0][]);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1,2,3,4));
//        int[] arr = list.toArray(new int[0]); // 错误，不能传入int[]
        Integer[] arr = list.toArray(new Integer[0]);
    }

    @Test
    public void testStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('a');
        stringBuilder.append(3);
//        System.out.println(stringBuilder);

        /*
        test stringBuilder insert function
        offset : 0 插入到字符串索引为0的位置
        offset : stringBuilder.length() 插入到字符串的末尾
         */
        stringBuilder.insert(0,'b');
        stringBuilder.insert(stringBuilder.length(),'c');
        System.out.println(stringBuilder);
    }

    @Test
    public void testASCII() {
        char c1 = 'a';
        char c2 = 'z';
        char c3 = 'A';
        char c4 = 'Z';
        System.out.println("A:"+(int)c3+"\nZ:"+(int)c4+"\na:"+(int)c1+"\nz:"+(int)c2);
        System.out.println((char)(c4+1));
    }

    @Test
    public void testHashMapContainsHashSet() {
        HashMap<HashSet, Boolean> hashMap = new HashMap<>();
        HashSet<Integer> [] hashSets = new HashSet[3];
        for (int i = 0; i < 3; i++) {
            hashSets[i] = new HashSet<>();
        }

        hashSets[0].add(1);
        hashSets[0].add(2);
        hashSets[1].add(2);
        hashSets[1].add(1);
        hashSets[2].add(1);
        hashSets[2].add(1);

        for (int i = 0; i < 3; i++) {
            hashMap.put(hashSets[i],true);
        }
        System.out.println(hashMap.size());
    }

    @Test
    public void testIntegerOperation() {
        Integer a = 3;
        Integer b = 3;
        if (a == b)
            System.out.println("a == b: true");
        else System.out.println("a == b: false");
        System.out.println("a.equals(b): "+ (a.equals(b)));

        a = 2;
        b = 3;
        Integer c = 5;
        if (c - b >= a) {
            b += a;
            a = 0;
        }
        else {
            a -= ( c - b);
            b = c;
        }

        System.out.println("a: "+a+"\nb: "+b+"\nc: "+c);
    }

    @Test
    public void testHashSetContainsHashMap() {
        HashSet<HashMap<Integer,Integer>> hashSet = new HashSet<>();
        HashMap<Integer,Integer> [] hashMaps = new HashMap[3];
        for (int i = 0; i < 3; i++) {
            hashMaps[i] = new HashMap<>();
        }
        hashMaps[0].put(1,2);
        hashMaps[1].put(2,1);
        hashMaps[2].put(1,2);

        for (int i = 0; i < 3; i++) {
            hashSet.add(hashMaps[i]);
        }

        System.out.println(hashSet.size());
        // hashSet会深拷贝加入的元素到set里
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(1,3);
        hashSet.add(hashMap);
        hashMap = new HashMap<>();
        System.out.println(hashSet.size());
    }

    @Test
    public void testSetContainsArray() {
        // hashSet不能筛除数组
        HashSet<int[]> hashSet = new HashSet<>();
        int[] a1 = {1,2};
        int[] a2 = {1,2};
        int[] a3 = {2,1};

        hashSet.add(a1);
        hashSet.add(a2);
        hashSet.add(a3);
        System.out.println(hashSet.size());
    }

    @Test
    public void testSetToArray() {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('b');
        set.add('c');
        Character[] chars = set.toArray(new Character[]{});
        for (char i :
                chars) {
            System.out.println(i);
        }
    }

    @Test
    public void testArrayCopy() {
        int[] a = {1,2,3};
        int[] b = a;
        int[] c = Arrays.copyOf(a,a.length);
        b[0] = -1;

        System.out.print("a: ");
        for (int i :
                a) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.print("b: ");
        for (int i :
                b) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.print("c: ");
        for (int i :
                c) {
            System.out.print(i+" ");
        }
        System.out.println();

        int[][] d = {
                {1,2,3},
                {4,5,6},
        };
        // 这个依旧为浅拷贝
        int[][] e = Arrays.copyOf(d,d.length);
        // 这个为深拷贝
        int[][] f = new int[d.length][];
        for (int i = 0; i < d.length; i++) {
            f[i] = Arrays.copyOf(d[i],d[i].length);
        }
        d[0][0] = -1;

        System.out.print("d: ");
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                System.out.print(d[i][j]+" ");
            }
        }
        System.out.println();
        System.out.print("e: ");
        for (int i = 0; i < e.length; i++) {
            for (int j = 0; j < e[i].length; j++) {
                System.out.print(e[i][j]+" ");
            }
        }
        System.out.println();
        System.out.print("f: ");
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                System.out.print(f[i][j]+" ");
            }
        }
        System.out.println();
    }

    @Test
    public void testDoubleSpecifyPrecision() {
        double a = 1;
//        double a = 1.355;
//        double a = 1.13457890983;
        String precision = String.format("%.6f",a);
        double b = Double.parseDouble(precision);
        System.out.println("double string format: "+precision);
        System.out.println("doulbe parse String: "+b);
    }
    
    @Test
    public void testForeachToEmptyList() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for (int i :
                list) {
            priorityQueue.add(i);
        }
        priorityQueue.addAll(list);
    }

    @Test
    public void testBitwiseOperation() {
//        int a = 3;
//        int b = 3;

        int a = 5;
        int b = 4;

        System.out.println((a & b));
    }

    @Test
    public void testRegex() {
//        String regex = "\\d+";
//        String regex = "(\\+|-)?[0-9]+";
        String regex = "(\\w+)(\\s+)([.,])";
//        String content = "123hhh";
//        String content = "+0001234";
        String content = "Hello , World .";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);

//        System.out.println(m.matches());
        while (m.find()) {
//            System.out.println(m.group());
            System.out.println("group 1: "+m.group(1)+"\ngroup 2: "+m.group(2)+"\ngroup 3: "+m.group(3));
        }
//        System.out.println(m.replaceAll(""));
//        if (m.find())
//            System.out.println(m.group());
//        System.out.println(m.replaceAll("$1$3"));
//        if (m.matches())
//            System.out.println("group 1: "+m.group(1)+"\n group 2: "+m.group(2)+"\n group 3: "+m.group(3));
    }

    @Test
    public void testStringContainsSubString() {
        String str = "woainiya";
        String subStr = "ainiya";
        System.out.println(str.contains(subStr));
    }
}

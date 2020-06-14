package LeetCode;

import java.util.Arrays;

/**
 * 面试题 16.03.交点
 */
public class P1476 {

    /**
     * 纯数学法 参数方程求解
     * @param start1
     * @param end1
     * @param start2
     * @param end2
     * @return
     */
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1 = Math.min(start1[0],end1[0]);
        int x2 = Math.max(start1[0],end1[0]);
        int x3 = Math.min(start2[0],end2[0]);
        int x4 = Math.max(start2[0],end2[0]);
        int y1 = Math.min(start1[1],end1[1]);
        int y2 = Math.max(start1[1],end1[1]);
        int y3 = Math.min(start2[1],end2[1]);
        int y4 = Math.max(start2[1],end2[1]);

        if (x2 < x3 || x1 > x4 || y1 > y4 || y2 < y3) return new double[]{};
        int[] row = {x1,x2,x3,x4};
        int[] column = {y1,y2,y3,y4};
        Arrays.sort(row);
        Arrays.sort(column);
        int[] borderX = {row[1],row[2]};
        int[] borderY = {column[1],column[2]};

        int a1,a2,b1,a3,a4,b2;
        a1 = end1[1] - start1[1];
        a2 = end1[0] - start1[0];
        b1 = end1[1]*start1[0] - start1[1]*end1[0];
        a3 = end2[1] - start2[1];
        a4 = end2[0] - start2[0];
        b2 = end2[1]*start2[0] - start2[1]*end2[0];

        int k1 = 0,k2 = 0;
        if (a2 == 0) k1 = Integer.MAX_VALUE;
        if (a4 == 0) k2 = Integer.MAX_VALUE;
        double x,y;
        // 平行
        if (a1*a4 == a2*a3) {
            // 特殊情况 垂直x抽的直线
            if (k1 == Integer.MAX_VALUE && k2 == Integer.MAX_VALUE) {
                // 重叠
                if (x1 == x3) return new double[] {x1,borderY[0]};
            }
            else {
                // 重叠
                if (b1*a4 == a2*b2) {
                    if (a1*a2 >=0) return new double[] {borderX[0],borderY[0]};
                    return new double[] {borderX[0],borderY[1]};
                }
            }
            return new double[] {};
        }
        // 不平行
        else {
            if (k1 == Integer.MAX_VALUE) {
                x = x1;
                y = (a3*x - b2)/a4;
            }
            else if (k2 == Integer.MAX_VALUE) {
                x = x3;
                y = (a1*x - b1)/a2;
            }
            else {
                x = (a2*b2 - a4*b1)*1.0/(a3*a2 - a1*a4);
                y = (b1*a3 - b2*a1)*1.0/(a1*a4 - a3*a2);
            }
            if (x < borderX[0] || x > borderX[1] || y < borderY[0] || y > borderY[1]) return new double[] {};
            return new double[] {Double.parseDouble(String.format("%.5f",x)),Double.parseDouble(String.format("%.5f",y))};
        }
    }

    public static void main(String[] args) {
        P1476 h = new P1476();
//        int[] start1 = {0,0};
//        int[] end1 = {1,0};
//        int[] start2 = {1,1};
//        int[] end2 = {0,-1};

//        int[] start1 = {0,0};
//        int[] end1 = {3,3};
//        int[] start2 = {1,1};
//        int[] end2 = {2,2};

//        int[] start1 = {0,0};
//        int[] end1 = {1,1};
//        int[] start2 = {1,0};
//        int[] end2 = {2,1};

//        int[] start1 = {13,17};
//        int[] end1 = {3,11};
//        int[] start2 = {7,31};
//        int[] end2 = {4,9};

//        int[] start1 = {3,3};
//        int[] end1 = {3,11};
//        int[] start2 = {4,8};
//        int[] end2 = {4,2};

//        int[] start1 = {3,3};
//        int[] end1 = {3,11};
//        int[] start2 = {3,4};
//        int[] end2 = {3,9};

//        int[] start1 = {3,3};
//        int[] end1 = {3,11};
//        int[] start2 = {3,0};
//        int[] end2 = {7,17};

        int[] start1 = {3,3};
        int[] end1 = {3,11};
        int[] start2 = {-2,0};
        int[] end2 = {7,8};

        double[] ans = h.intersection(start1,end1,start2,end2);
        for (double i :
                ans) {
            System.out.println(i);
        }
    }
}

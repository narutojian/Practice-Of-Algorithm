package Algorithm;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class QuickSort {

    public static FileWriter writer;

    static {
        try {
            writer = new FileWriter("quickSort");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        int[] array = {2,4,1,5,67,2,45,78,3,9};
        int[] array = {57, 92, 91, 98, 95, 45, 47, 29, 86, 54, 73, 86, 80, 65, 35, 65, 50, 35, 72, 63, 93, 57, 92, 52, 64, 30, 85, 51, 56, 55, 34, 48, 77, 50};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array,int low,int high){
        if(low < high){
            int index = getIndex(array,low,high);

//            try {
//                writer.write(Arrays.toString(array));
//                writer.write("\n");
//                writer.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            System.out.println(Arrays.toString(array));
            quickSort(array,0,index-1);
            quickSort(array,index+1,high);
        }
    }

    //获取基准数据位置
    public static int getIndex(int[] array,int low,int high){
        int tmp = array[low];
        while(low < high){
            while(low < high && array[high] >= tmp){
                high--;
            }
            array[low] = array[high];
            while(low < high && array[low] <= tmp){
                low++;
            }
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }
}

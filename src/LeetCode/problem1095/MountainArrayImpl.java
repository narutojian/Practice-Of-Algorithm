package LeetCode.problem1095;

public class MountainArrayImpl implements MountainArray{
    private int[] array;

    public MountainArrayImpl(int[] array) {
        this.array = array;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public int length() {
        return array.length;
    }
}

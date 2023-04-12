package gb.hw01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort {
    private static void heapSortInplace(List<Integer> list) {
        buildMaxHeap(list);
        int size = list.size();
        for (int i = size - 1; i > 0; i--) {
            int temp = list.get(size - 1);
            list.set(size - 1, list.get(0));
            list.set(0, temp);
            size--;
            siftDown(list, 0, size);
        }
    }

    private static void buildMaxHeap(List<Integer> list) {
        int n = list.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(list, i, n);
        }
    }

    private static void siftDown(List<Integer> list, int current, int size) {
        int currentValue = list.get(current);
        int leftChild = 2 * current + 1;

        while (leftChild < size) {
            int rightChild = leftChild + 1;
            if (rightChild < size && list.get(leftChild) < list.get(rightChild)) {
                leftChild = rightChild;
            }
            if (currentValue >= list.get(leftChild)) {
                break;
            }

            list.set(current, list.get(leftChild));
            current = leftChild;
            leftChild = 2 * current + 1;
        }
        list.set(current, currentValue);
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{80, 53, 48, 32, 88, 66, 64, 67, 36, 59};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println(list);

        heapSortInplace(list);
        System.out.println(list);
    }
}

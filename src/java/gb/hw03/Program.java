package gb.hw03;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{37, 56, 31, 58, 58, 53, 79, 26, 16, 81};
        DoublyLinkedList list = new DoublyLinkedList(List.of(array));
        System.out.println("Original list: ");
        System.out.println(list);

        list.reverse();
        System.out.println();
        System.out.println("Reversed list: ");
        System.out.println(list);
    }
}

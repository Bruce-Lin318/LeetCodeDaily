package util;

import java.util.Arrays;

/**
 * @author Lin
 * @date 2023/1/4
 */
public class AlgorithmUtil {
    public static int[] generateArray(int size, int max) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

    public static Node generateLinkedList(int size, int max) {
        Node head = new Node();
        Node cur = head;
        while (size != 0) {
            cur.next = new Node((int) (Math.random() * max));
            cur = cur.next;
            size--;
        }
        return head.next;
    }


    public static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printNode(Node head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.print("null");
    }
}

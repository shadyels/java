import java.util.Arrays;
import java.util.Random;

public class FirstListSorter {
    public static void main(String[] args) {

        Random rand = new Random();
        int[] lstArg = new int[10];
        for (int i = 0; i < lstArg.length; i++) {
            lstArg[i] = rand.nextInt(100);
        }

        int[] test = {4, 9, 7, 1, 3, 6, 5};

        System.out.println(selectionSort(lstArg));
        System.out.println(bubbleSort(lstArg));
        System.out.println(Arrays.toString(mergeSort(lstArg)));
    }

    static String selectionSort(int[] lst) {
        for (int i = 0; i < lst.length; i++) {
            int temp;
            int smallest = lst[i];

            for (int j = i; j < lst.length; j++) {
                if (lst[j] < smallest) {
                    smallest = lst[j];
                    temp = lst[i];
                } else {
                    temp = lst[j];
                }

                lst[i] = smallest;
                lst[j] = temp;
            }
        }
        return Arrays.toString(lst);
    }

    static String bubbleSort(int[] lst) {
        boolean swapped;
        do {
            swapped = false;

            for (int i = 0; i < lst.length - 1; i++) {
                if (lst[i] > lst[i + 1]) {
                    int temp = lst[i];
                    lst[i] = lst[i + 1];
                    lst[i + 1] = temp;

                    swapped = true;
                }
            }
        } while (swapped);
        return Arrays.toString(lst);
    }

    static int[] mergeSort(int[] lst) {
        int n = lst.length;
        int[] left;
        int[] right;

        if (lst.length == 1) {
            return lst;
        }

        //split arrays
        left = new int[n / 2];
        if (n % 2 == 0) {
            right = new int[n / 2];
        } else {
            right = new int[n / 2 + 1];
        }

        //fill arrays
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                left[i] = lst[i];
            } else {
                right[i - n / 2] = lst[i];
            }
        }

        //recursion
        left = mergeSort(left);
        right = mergeSort(right);

        //merge sorted
        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;

        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }
}
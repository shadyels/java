import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        //int[] array = {1, 3, 4, 5, 7, 9, 13, 15, 16, 17, 19};
        int[] array = {1, 3, 4, 5, 7};

        binarySearch(3,array,0,(array.length-1));
    }

    public static boolean binarySearch(int s, int[] arr, int low, int high) {
        if (low > high) {
            System.out.println("not found");
            return false;
        }

        int median = (low + high) / 2;

        if (arr[median] == s) {
            System.out.println("found at " + median);
            return true;
        } else if (s > median) {
            low = median +1;
            return binarySearch(s, arr, low, high);
        } else {
            high = median -1;
            return binarySearch(s, arr, low, high);
        }
    }
}

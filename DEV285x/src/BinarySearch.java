public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 7, 9, 13, 15, 16, 17, 19};

        int first = 0;
        int last = array.length - 1;

        if (binarySearch(1, array, first, last)) {
            System.out.println("found 3");
        } else {
            System.out.println("not found");
        }
    }

    public static boolean binarySearch(int search, int[] array, int first, int last) {
        int middle = (first + last) / 2;

        if(first > last){
            return false;
        }

        if (array[middle] == search) {
            System.out.println("is at " + middle);
            return true;

        } else if (array[middle] < search) {
            first = middle + 1;
            return binarySearch(search, array, first, last);

        } else {
            last = middle - 1;
            return binarySearch(search, array, first, last);
        }
    }
}

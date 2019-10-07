public class DoubleArrays {
    public static void main(String[] args) {
        arrayMap();
        System.out.println(countPlaceArray());
    }

    public static void arrayMap() {
        String[][] myArr = new String[3][3];
        for(int i = 0; i < myArr.length; i++){
            for(int j = 0; j < myArr[i].length; j++){
                myArr[i][j] = "["+i+";"+j+"]";
                //myArr[i][j] = "["+(i+j)+"]";
                System.out.print(myArr[i][j]);
            }
            System.out.println("");
        }
    }

    public static int countPlaceArray() {
        int [][] myArr2 = new int[4][4];

        int count = 0;
        for(int row = 0; row < myArr2.length; row++) {
            for (int col = 0; col < myArr2[row].length; col++){
                myArr2[row][col] = count;
                ++count;
            }
        }
    return count;
    }
}

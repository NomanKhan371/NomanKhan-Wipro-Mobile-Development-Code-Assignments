public class sorting {
    public static void main(String[] args) {
        int[] arr = {9,8,6,5,4,3,2,1};
        printArray(sort(arr));
    }

    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    //swap
                    int temp = arr[i];
                    arr[i]= arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}

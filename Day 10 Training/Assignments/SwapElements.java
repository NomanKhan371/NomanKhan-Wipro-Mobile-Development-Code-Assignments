public class SwapElements {

    public static <T> void swapElements(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        // Integer Array
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Before swap (Integer array):");
        printArray(intArray);
        swapElements(intArray, 0, 4);
        System.out.println("After swap (Integer array):");
        printArray(intArray);

        // String Array
        String[] strArray = {"A", "B", "C", "D", "E"};
        System.out.println("\nBefore swap (String array):");
        printArray(strArray);
        swapElements(strArray, 1, 3);
        System.out.println("After swap (String array):");
        printArray(strArray);

        // Double Array
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        System.out.println("\nBefore swap (Double array):");
        printArray(doubleArray);
        swapElements(doubleArray, 2, 4);
        System.out.println("After swap (Double array):");
        printArray(doubleArray);
    }

    // Helper method to print array
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

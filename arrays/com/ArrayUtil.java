package arrays.com;

import java.util.Random;

public class ArrayUtil {
    public static void main(String[] args) {
        arrayDemo();
    }

    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void arrayDemo() {
        Random rand = new Random();
        int[] myArray = new int[5];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = rand.nextInt(5);
        }
        System.out.print("the array: ");
        printArray(myArray);
        System.out.println("last element : " + myArray[myArray.length - 1]);
    }

    static int[] removeEven(int[] arr) {
        int len = arr.length;
        int counterOdd = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] % 2 != 0) {
                counterOdd++;
            }
        }
        int[] newArray = new int[counterOdd];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] != 0) {
                newArray[index] = arr[i];
                index++;
            }
        }
        return newArray;
    }

}

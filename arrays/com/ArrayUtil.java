package arrays.com;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtil {

    public static void main(String[] args) {
        // arrayDemo();
        int[] arr = {1, 2, 3, 4, 5, 6};
        // printArray(reverseArray(arr));
        //System.out.println(findMin(null));
        //printArray(allZerosToEnd(arr));
        //System.out.println(findMissingNumber(arr));
        System.out.println(isPalindrome("KCTCKA"));
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

    static int[] reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    static int findMin(int[] arr) {
        int len = arr.length;
        if (arr == null || len == 0) {
            throw new IllegalArgumentException();
        }
        int min = arr[0];
        for (int i = 1; i < len; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    static int[] allZerosToEnd(int[] arr) {
        int len = arr.length;
        int[] newArray = new int[len];
        int index = 0;

        for (int i = 0; i < len; i++) {
            if (arr[i] != 0) {
                newArray[index] = arr[i];
                index++;
            }
        }
        // we dont need to assign zeros because default value is zero
        return newArray;
    }

    static int[] resize(int[] arr, int newCapacity) {
        int len = arr.length;
        int[] newArray = new int[newCapacity];

        for (int i = 0; i < len; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }

    static int findMissingNumber(int[] arr) {
        int len = arr.length;
        int sumOfArray = 0;
        int sumOfRange = (len + 1) * (len + 1 + 1) / 2; // math formula
        for (int j : arr) {
            sumOfArray += j;
        }
        return sumOfRange - sumOfArray;
    }

    static boolean isPalindrome(String word) {
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    static void insertionSort(char[] arr) {
        int len = arr.length;

        for (int i = 1; i < len; i++) {
            char current = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > current) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = current;
        }
    }
}

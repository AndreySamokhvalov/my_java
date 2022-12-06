package lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class homeTask1 {
    public static void main(String[] args) {
        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("Добро пожаловать!%n");
        // mergeSort(createArr());
        int[] tmp = createArr();
        int n = tmp.length;
        mergeSort(tmp, n);
        



    }

    // создаем массив
    public static int[] createArr() {

        int n, arr[];
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        n = in.nextInt();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 99);

        System.out.printf("Заданный массив: %s", (Arrays.toString(arr)));

        return arr;
    }

    // сортировка Массива который передается в функцию
    public static Object mergeSort(int[] array, int n) {

        int[] arr = array;

        // проверяем не нулевой ли он?
        if (arr == null) {
            return null;
        }
        // проверяем не 1 ли элемент в массиве?
        if (arr.length < 2) {
            return arr; 
        }

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = array[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(array, l, r, mid, n - mid);

        return r;
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }

        

    }

}

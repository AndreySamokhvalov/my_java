// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

package lesson3;

import java.util.ArrayList;
import java.util.Scanner;

public class homeTask3 {
    public static void main(String[] args) {
        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("Добро пожаловать!%n");

        int n;
        Scanner in = new Scanner(System.in);
        System.out.printf("%nВведите размер массива: ");
        n = in.nextInt();

        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // создаем ArrayList
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            arr.add(createNum());
        }
        System.out.printf("Массив из %S псевдослучайных чисел:%S%n ", n, arr);

        // выстраиваем массив по убыванию
        arr.sort(null);
        // System.out.printf("Массив из %S псевдослучайных чисел по убыванию:%S%n ", n, arr);

        // находим искомые велечины
        int minNum = arr.get(0);
        int maxNum = arr.get(arr.size()-1);
        float srdn = (minNum+maxNum)/2;

        System.out.printf("Максимальное значение: %s%n Минимальное значение: %S%n Среднее значение: %s%n", maxNum ,minNum ,srdn );

    }
    public static int createNum() {
        int num = (int) (Math.random() * 100);
        return num;
    }

        





}
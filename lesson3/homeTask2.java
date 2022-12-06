// Пусть дан произвольный список целых чисел, удалить из него четные числа

package lesson3;

import java.util.ArrayList;
import java.util.Scanner;

public class homeTask2 {
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
        System.out.printf("Массив из %S псевдослучайных чисел:%S%n ",n,arr);

        for (int i = 0; i < arr.size(); i++) {
            Integer item = arr.get(i);
            if (item % 2 == 0) {
                arr.remove(i);
                i--;
                
            }
        }
        System.out.printf("%nТот же массив, но без четных элементоы: %s%n",arr);

    }
    // метод генераци псевдослучайных чисел
    public static int createNum() {
        int num = (int) (Math.random() * 100);
        return num;
    }
}

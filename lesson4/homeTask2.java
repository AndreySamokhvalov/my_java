
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class homeTask2 {
    public static void main(String[] args) {
        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("Добро пожаловать!%n");

        Queue<Integer> queueBase = createQueue();
        System.out.printf("%nОчередь:%s%n", queueBase);
        queueMethAdd(queueBase);
        queueMethShowAndDell(queueBase);
        queueMethShowNotDell(queueBase);

    }

    // создаем массив
    public static int[] createArr() {

        int n, arr[];
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");

        n = Math.abs(in.nextInt());
        arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 99);

        System.out.printf("Заданный массив: %s", (Arrays.toString(arr)));

        return arr;
    }

    // метод создания очереди(массив на вход)
    public static Queue<Integer> createQueue() {
        int[] arr = createArr();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        // System.out.printf("%nОчередь:%s%n", queue);
        return queue;
    }

    // добавляет новый элемент в конец очереди
    public static void queueMethAdd(Queue<Integer> inQueue) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите элемент для добавления в конец очереди: ");
        int n = in.nextInt();

        Queue<Integer> queue = inQueue;
        queue.add(n);
        System.out.printf("%nОбновленная очередь:%s%n", queue);

    }

    // показывает первый элемент и удаляет его
    public static void queueMethShowAndDell(Queue<Integer> inQueue) {
        Queue<Integer> queue = inQueue;

        if (queue.size() != 0) {
            System.out.printf("Первый элемент очереди: %s", queue.poll());
            System.out.printf("%nОбновленная очередь:%s%n", queue);
        } else {
            System.out.println("Очередь пуста");
        }

    }

    // показывает первый элемент и НЕ удаляет его
    public static void queueMethShowNotDell(Queue<Integer> inQueue) {
        Queue<Integer> queue = inQueue;
        if (queue.size() != 0) {
            System.out.printf("Первый элемент обнавленной очереди:%s%n", queue.peek());
        } else {
            System.out.println("Очередь пуста");
        }
    }

}
package lesson2;

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;
import java.io.IOException;
import java.util.Arrays;

public class homeTask2 {
    public static int[] createArr() {

        int n, arr[];
        Scanner in = new Scanner(System.in);
        System.out.print("Введите желаемый размер массива: ");

        n = in.nextInt();

        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();

        arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 100);
        System.out.printf("Заданный рандомный массив из %s элемментов: %s%n", n, (Arrays.toString(arr)));
        return arr;
    }

    public static void main(String[] args) throws SecurityException, IOException {

        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("Добро пожаловать!%n");

        int[] arr = createArr();
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;

                    buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;

                    Logger logger = Logger.getLogger(homeTask2.class.getName());
                    FileHandler fh = new FileHandler("log.xml");
                    logger.addHandler(fh);

                    XMLFormatter xml = new XMLFormatter();
                    fh.setFormatter(xml);
                    logger.info("Пересортровка");
                }
            }
        }
        System.out.printf("%nОтсортированный массив: %s", (Arrays.toString(arr)));

    }

}

import java.util.Scanner;

public class hometask3 {
    public static void main(String[] args) {

        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // получение данных от пользователя
        System.out.println("Добро пожаловать!");
        Scanner in = new Scanner(System.in);
        System.out.print("Задайте N: ");
        int num = in.nextInt();

        // находим простые числа
        String str = new String();
        for (int j = 1; j <= num; j++) {
            int count = 0;
            for (int i = 2; i < j; i++) {
                if (j % i == 0) {
                    count += 1;
                }

            }
            if (count == 0) {
                str = str + j + " ";
            }

        }

        // вывод результата
        System.out.printf("Простые числа от 1 до %d \n", num);
        System.out.println(str);
    }
}

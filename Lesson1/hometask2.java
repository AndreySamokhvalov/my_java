import java.io.*;
import java.util.Scanner;

public class hometask2 {
    public static void main(String[] args) {

        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // получение данных от пользователя
        System.out.println("Добро пожаловать!");
        Scanner in = new Scanner(System.in);
        System.out.print("Задайте N: ");
        int num = in.nextInt();

        
        for (int j=1; j<= num; j++) {
            for (int i = 2; i < j; i++) {
                if (j % i != 0) {
            System.out.println(j);
                }
            }
        }
    }
}

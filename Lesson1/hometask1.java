import java.util.Scanner;
public class hometask1 {
    public static void main(String[] args) {
        
        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        // получение данных от пользователя
        System.out.println("Добро пожаловать!");
        Scanner in = new Scanner(System.in);
        System.out.print("Задайте N: ");
        int num = in.nextInt();

        int i = 1;
        int sum = 0;
        
        // нахождение треугольного числа
        while (i <= num) {
            sum = sum +i;
            i += 1;
        }

        int j = 1;
        long fact = 1;

        // нахождение факториала   
        while (j <= num) {
            fact = fact *j;
            j += 1;
        }

        // вывод результата
        System.out.printf("Сумма равна: %d \n", sum);
        System.out.printf("Факториал равен: %d \n", fact);
        in.close();
    }
}

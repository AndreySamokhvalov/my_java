// Пусть дан LinkedList с несколькими элементами.
// Реализуйте метод, который вернет “перевернутый” список.
import java.util.LinkedList;
import java.util.Scanner;

public class homeTask1 {

    public static void main(String[] args) {

        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("Добро пожаловать!%n");

        upheaval();

    }

    // метод создания рандомного LinkedList
    public static LinkedList<Integer> createLinkedList() {

        // запрашиваем размер
        int n;
        Scanner in = new Scanner(System.in);
        System.out.printf("%nВведите размер LinkedList: ");
        n = in.nextInt();

        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();
        

        // создаем LinkedList
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            int num = (int) (Math.random() * 100);
            nums.add(num);
        }


        System.out.printf("LinkedList из %S псевдослучайных чисел:%S%n ", n, nums);

        // System.out.println(nums);

        return nums;
    }

    // переворачиваем LinkedList
    public static void upheaval() {

        LinkedList<Integer> upNums = new LinkedList<Integer>();
        LinkedList<Integer> inNums = createLinkedList();

        for (int i = 0; i < inNums.size(); i++) {
            int tmp = inNums.get(i);
            upNums.addFirst(tmp);
        }
        System.out.printf("%nПеревернутый LinkedLis:%s%n",upNums);
    }
}